package fr.epita.quiz.services;

import static fr.epita.logger.Logger.logMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.h2.jdbc.JdbcSQLException;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.Student;
import fr.epita.quiz.datamodel.StudentList;
import fr.epita.quiz.datamodel.TopicList;

public class JDBCSTUDENT {
	
private static final String SEARCH_STUDENT_STATEMENT = "SELECT * FROM STUDENTS" ;
private static final String SEARCH_TOPIC_STATEMENT = "SELECT TOPICS FROM QUESTIONS" ;
private static final String INSERT_STATEMENT = "INSERT INTO STUDENTS (NAME) values (?);" ;
	
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
}

