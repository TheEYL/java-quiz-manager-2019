//package fr.epita.quiz.services;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import fr.epita.quiz.datamodel.Question;
//
//public class QuestionJDBCDAO {
//	
//	
///*
//
//
//DELETE FROM QUESTION WHERE ID = 3;
//
//
//
//select * from question;*/
//   private static final String INSERT_STATEMENT = "INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS,TYPE) VALUES (?,? ?,?)";
//   private static final String SEARCH_STATEMENT = "SELECT * FROM QUESTION";
//   private static final String UPDATE_STATEMENT = "UPDATE QUESTION SET QUESTION=?, DIFFICULTY=? WHERE ID=?";
//   private static final String DELETE_STATEMENT = "DELETE FROM QUESTION WHERE ID = ?";
//	
//	
//	
//	public void create(Question question) {
//		
//		try (Connection connection = JDBC.getConnection();
//				PreparedStatement insertStatement = connection.prepareStatement(INSERT_STATEMENT);) {
//			
//			insertStatement.setString(1, question.getQuestion());
//			insertStatement.setInt(2, question.getDifficulty());
//			
//			insertStatement.setString(3, question.getTopics().toString());
//			insertStatement.setString(4, question.getType().toString());
//			insertStatement.execute();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public void update(Question question) {
//		
//		try (Connection connection = JDBC.getConnection();
//			PreparedStatement updateStatement = connection.prepareStatement(UPDATE_STATEMENT)){
//			updateStatement.setString(1, question.getQuestion());
//			updateStatement.setInt(2, question.getDifficulty());
//			updateStatement.setInt(3, question.getId());
//			updateStatement.executeQuery();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	
//
//	public void delete(Question question) {
//		
//		try (Connection connection = JDBC.getConnection();
//			PreparedStatement deleteStatement = connection.prepareStatement(DELETE_STATEMENT)){
//			deleteStatement.setInt(1, question.getId());
//			deleteStatement.executeQuery();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public List<Question> search(Question question) {
//		List<Question> resultList = new ArrayList<Question>();
//		
//		/*SELECT 
//	    ID,DIFFICULTY,QUESTION 
//	    FROM QUESTION 
//	    WHERE
//	       DIFFICULTY = 1
//	    and 
//	      QUESTION LIKE '%JV%'
//	      
//	      */
//		String selectQuery = "select  from QUESTION WHERE ";
//		try (Connection connection = JDBC.getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
//				) {
//
//		
//			ResultSet results = preparedStatement.executeQuery();
//			while (results.next()) {
//
//				Question currentQuestion = new Question();
//				resultList.add(currentQuestion);
//			}
//			results.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return resultList;
//	}
//
//}
