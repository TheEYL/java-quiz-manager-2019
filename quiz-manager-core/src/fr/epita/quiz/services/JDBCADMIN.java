package fr.epita.quiz.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fr.epita.quiz.datamodel.Admin;
import fr.epita.quiz.datamodel.AdminList;
import fr.epita.quiz.datamodel.Question;


public class JDBCADMIN {
private static final String SEARCH_STATEMENT = "SELECT * FROM ADMIN" ;
private static final String INSERT_STATEMENT = "INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values (?, ? ,? ,?);" ;
 
 public static AdminList getAdmins() {
		AdminList resultList = new AdminList();
		
		/*SELECT 
	    ID,DIFFICULTY,QUESTION 
	    FROM QUESTION 
	    WHEREkk
	       DIFFICULTY = 1
	    and 
	      QUESTION LIKE '%JV%'
	      
	      */
//		String selectQuery = "select  from ADMIN where ";
		try (Connection connection = JDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STATEMENT);
				) {

		
			ResultSet results = preparedStatement.executeQuery();
			while (results.next()) {

				Admin currentAdmin = new Admin();
				currentAdmin.setUserName(results.getString(2));
				currentAdmin.setPassword(results.getString(3));
				resultList.getAdminList().add(currentAdmin);
			}
			results.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
  
 public static void create(Question question) {
		
		try (Connection connection = JDBC.getConnection();
				PreparedStatement insertStatement = connection.prepareStatement(INSERT_STATEMENT);) {
			
			insertStatement.setString(1, question.getQuestion());
			insertStatement.setInt(2, question.getDifficulty());
			
			insertStatement.setString(3, question.getTopics().toString());
			insertStatement.setString(4, question.getType().toString());
			insertStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	} 
}
