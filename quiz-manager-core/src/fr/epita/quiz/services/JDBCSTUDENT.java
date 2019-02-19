package fr.epita.quiz.services;

import static fr.epita.logger.Logger.logMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.standard.NumberOfDocuments;

import org.h2.jdbc.JdbcSQLException;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.Student;
import fr.epita.quiz.datamodel.StudentList;
import fr.epita.quiz.datamodel.TopicList;

public class JDBCSTUDENT {

	private static final String SEARCH_STUDENT_STATEMENT = "SELECT * FROM STUDENTS" ;
	private static final String SEARCH_TOPIC_STATEMENT = "SELECT TOPICS FROM QUESTIONS" ;
	private static final String INSERT_STATEMENT = "INSERT INTO STUDENTS (NAME) values (?);" ;
	private static final String QUESTION_QUERY_BUILDER = "SELECT a.Q_TYPE , a.QUESTION, a.TOPICS, b.* " + 
			"FROM QUESTIONS AS a " + 
			"JOIN MCQ_QUESTIONS AS b " + 
			"ON a.id = b.Q_id WHERE " ;

	public static StudentList getStudents() throws JdbcSQLException, SQLException {
		StudentList resultList = new StudentList();

		/*SELECT 
	    ID,DIFFICULTY,QUESTION 
	    FROM QUESTION 
	    WHERE
	       DIFFICULTY = 1
	    and 
	      QUESTION LIKE '%JV%'

		 */
		//		String selectQuery = "select  from ADMIN where ";
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_TOPIC_STATEMENT);
				) {


			ResultSet results = preparedStatement.executeQuery();
			while (results.next()) {

				Student currentStudent = new Student();
				currentStudent.setId(results.getInt(2));
				currentStudent.setName(results.getString(2));
				resultList.getStudentList().add(currentStudent);
			}
			results.close();
		} catch (Exception e) {
			logMessage("could not get admin list");
		}		

		return resultList;
	}


	public static TopicList getTopics() throws JdbcSQLException, SQLException {
		TopicList resultList = new TopicList();

		/*SELECT 
	    ID,DIFFICULTY,QUESTION 
	    FROM QUESTION 
	    WHERE
	       DIFFICULTY = 1
	    and 
	      QUESTION LIKE '%JV%'

		 */
		//		String selectQuery = "select  from ADMIN where ";
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_TOPIC_STATEMENT);
				) {


			ResultSet results = preparedStatement.executeQuery();
			StringBuilder sb = new StringBuilder();
			while (results.next()) {
				sb.append(results.getString(1));	
				sb.append(",");
			}

			resultList.setUniqueTopicList(sb.toString().trim().replace(" ", ""));


			results.close();
		} catch (Exception e) {
			logMessage("could not get topic list");
		}		

		return resultList;
	}

	public static void createStudent(Student student) {

		try (Connection connection = JDBC.getConnection();
				PreparedStatement insertStatement = connection.prepareStatement(INSERT_STATEMENT);) {

			insertStatement.setString(1, student.getName());

			insertStatement.execute();
			logMessage(" Student successfully created");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void LoadStudentQuestions (String topicList, int difficulty) {
		StringBuilder sb = questionQueryBuilder(topicList, difficulty);

		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
					ResultSet results = preparedStatement.executeQuery();
				) {
			
//			 logMessage(results.toString());	
			 int number_of_questions = 0;
			while (results.next()) {
				results.getString(1); // question type
				results.getString(2); // question details
				results.getString(3); // topics
				results.getInt(4); // mcq id
				results.getInt(5); // question id
				results.getString(6); //answer
				results.getString(7); //choice 1
				results.getString(8); //choice 2
				results.getString(9); //choice 3
				number_of_questions++;

			}

			
			 logMessage("Loaded "+ number_of_questions+ "questions");

	}catch (Exception e) {
		// TODO: handle exception
		logMessage(e.getMessage());
	}
}


	private static StringBuilder questionQueryBuilder(String topicList, int difficulty) {
		final String  where_clause	 = "a.TOPICS LIKE ";
		StringBuilder sb = new StringBuilder(QUESTION_QUERY_BUILDER);
		String[] parts = topicList.split(",");		 
		int i = 0; 
		for (String string : parts) {
			sb.append(where_clause);
			sb.append("'%" +string +"%'");
			if (i < parts.length -1)
				sb.append("OR");
			i++;
		}
		
		if (difficulty > 0)
//			sb.append("AND a.DIFFICULTY LIKE" + " '%" + difficulty + "%'");
			sb.append("AND a.DIFFICULTY <=" + difficulty );
		return sb;

	}
	
}

