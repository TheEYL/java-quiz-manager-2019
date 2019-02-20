package fr.epita.quiz.services;

import static fr.epita.logger.Logger.logMessage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.standard.NumberOfDocuments;

import org.h2.jdbc.JdbcSQLException;

import fr.epita.quiz.datamodel.ASS_Question;
import fr.epita.quiz.datamodel.MCQ_Question;
import fr.epita.quiz.datamodel.OPEN_Question;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.QuestionList;
import fr.epita.quiz.datamodel.QuestionType;
import fr.epita.quiz.datamodel.Student;
import fr.epita.quiz.datamodel.StudentList;
import fr.epita.quiz.datamodel.TopicList;
import static fr.epita.quiz.datamodel.QuestionType.*;

public class JDBCSTUDENT {

//	private static final String SEARCH_STUDENT_STATEMENT = "SELECT * FROM STUDENTS" ;
	private static final String SEARCH_TOPIC_STATEMENT = "SELECT TOPICS FROM QUESTIONS" ;
	private static final String INSERT_STATEMENT = "INSERT INTO STUDENTS (NAME) values (?);" ;
	private static final String INSERT_ANSWER_STATEMENT = "INSERT INTO STUDENTS_ANSWERS (Q_ID, S_NAME, ANSWER, IS_CORRECT) values (?,?,?,?);" ;
	private static final String QUESTION_QUERY_BUILDER = "SELECT a.Q_TYPE , a.QUESTION, a.TOPICS, b.* , a.DIFFICULTY " + 
			"FROM QUESTIONS AS a " + 
			"JOIN MCQ_QUESTIONS AS b " + 
			"ON a.id = b.Q_id WHERE " ;

	private static final String RESULTS_QUERY_BUILDER = "SELECT a.Q_TYPE , a.QUESTION, "
			+ "a.TOPICS, b.*, c.ANSWER AS CORRECT_ANSWER "
			+ " FROM QUESTIONS AS a  "
			+ "JOIN STUDENTS_ANSWERS AS b "
			+ "ON a.id = b.Q_id JOIN MCQ_QUESTIONS "
			+ "AS c  ON a.id = c.Q_id"
			+ " where b.S_NAME LIKE "; 
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
	public static void saveAnswer(Student student, int question_id) {

		try (Connection connection = JDBC.getConnection();
				PreparedStatement insertStatement = connection.prepareStatement(INSERT_ANSWER_STATEMENT);) {

			insertStatement.setInt(1, question_id);
			insertStatement.setString(2, student.getName());
			insertStatement.setString(3, student.getMcq_Choice().getStud_answer());
			insertStatement.setString(4, String.valueOf(student.getMcq_Choice().Is_valid()));

			insertStatement.execute();
			logMessage("save complete");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void exportResultsToFile(Student student, int score, int total) throws IOException {
		StringBuilder sb = new StringBuilder(RESULTS_QUERY_BUILDER);
		File tmp =  new File(  student.getName()+"_responses.txt");				
		tmp.createNewFile();
		sb.append("'%")
		.append(student.getName())
		.append("%';");
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
				ResultSet results = preparedStatement.executeQuery();
				FileWriter fstream = new FileWriter(tmp);
				BufferedWriter out = new BufferedWriter(fstream);
				){
					
			 while(results.next()) {
				 out.write("_______________________________________\n");
				 out.write("QUESTION TYPE: ");
				 out.write((results.getString("Q_TYPE")) + ", ");
				 out.newLine(); 
				 out.write("QUESTION: ");
				 out.newLine(); 
			     out.write((results.getString("QUESTION")).toUpperCase() + ", ");
			     out.newLine(); 

				 out.write("TOPICS: ");
			     out.write(results.getString("TOPICS") + ", ");

			     out.newLine(); 
			     out.write("You answered: ");
			     out.write(results.getString("ANSWER") + ", ");
			     out.write("Your answer was:" );
			     out.write((results.getString("IS_CORRECT")) + ", ");
			     out.write("The correct answer was: ");
			     out.write(results.getString("CORRECT_ANSWER").toUpperCase() + ", ");
			     out.newLine(); 
			     out.write("Your score was " + score + " out of "+ total);
			     out.newLine(); 
			     out.write("-----------------------------------------\n");
			 }


		}catch (Exception e) {
			// TODO: handle exceptiono
			logMessage(e.toString());
		}
	}
	public static QuestionList LoadStudentQuestions (String topicList, int difficulty) {
		StringBuilder sb = questionQueryBuilder(topicList, difficulty);

		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
				ResultSet results = preparedStatement.executeQuery();
				) {
			//			 logMessage(results.toString());	
			int number_of_questions = 0;
			Question question = null;

			QuestionList questionList = new QuestionList();
			while (results.next()) {
				//				results.getString(1); // question type
				//				results.getString(2); // question details
				//				results.getString(3); // topics
				//				results.getInt(4); // mcq id
				//				results.getInt(5); // question id
				//				results.getString(6); //answer
				//				results.getString(7); //choice 1
				//				results.getString(8); //choice 2
				//				results.getString(9); //choice 3
				question  = chooseQuestionType(question, results.getString(1), results);
				question.setMcq_Choice();
				questionList.getQuestionList().add(question);
				number_of_questions++;

			}


			logMessage("Loaded "+ number_of_questions+ " questions.");
		
			return questionList;
		}catch (Exception e) {
			// TODO: handle exception
			logMessage(e.getMessage());
		}
		 return null;
	}


	private static StringBuilder questionQueryBuilder(String topicList, int difficulty) {
		final String  where_clause	 = " a.TOPICS LIKE ";
		StringBuilder sb = new StringBuilder(QUESTION_QUERY_BUILDER);
		String[] parts = topicList.split(",");		 
		int i = 0; 
		for (String string : parts) {
			sb.append(where_clause);
			sb.append("'%" +string +"%'");
			if (i < parts.length -1) {
				sb.append(" OR");
			}
			i++;
		}

		if (difficulty > 0)
			//			sb.append("AND a.DIFFICULTY LIKE" + " '%" + difficulty + "%'");
			sb.append("AND a.DIFFICULTY <=" + difficulty );
		return sb;

	}
	private static Question chooseQuestionType(Question question,String type, ResultSet results ) throws SQLException, NullPointerException{
		//results.getString(1)// is ttype
		switch (type) {
		case  "mcq":
			question = new MCQ_Question();
			question.setType(type);
			question.setQuestion(results.getString(2));
			question.setAnswer(results.getString(6));
			question.setId(results.getInt(5));
			question.setChoice1(results.getString(7));
			question.setChoice2(results.getString(8));
			question.setChoice3(results.getString(9));
			question.setDifficulty(results.getInt(10));
			question.setTopics(results.getString(3));
			return question;
			//			break;
		case "open":
			question = new OPEN_Question();	
			question.setType(type);
			question.setQuestion(results.getString(2));
			return (question);
			//			break;
		case "associative":
			question = new ASS_Question();
			question.setType(type);
			question.setQuestion(results.getString(2));

			return question;
			//			break;
		default:
			break;
		}
		return question;
	}


}

