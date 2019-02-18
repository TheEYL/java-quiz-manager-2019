package fr.epita.quiz.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.epita.quiz.datamodel.ASS_Question;
import fr.epita.quiz.datamodel.Admin;
import fr.epita.quiz.datamodel.AdminList;
import fr.epita.quiz.datamodel.MCQ_Question;
import fr.epita.quiz.datamodel.OPEN_Question;
import fr.epita.quiz.datamodel.Question;
import static fr.epita.logger.Logger.*;

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
            logMessage("Question created successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} 
 
 /**
 * @param question
 * This method first populates the question table and then 
 * gets the ID from that table as Foreign key to populate the MCQ_Question table 
 */
public static void createMCQ(MCQ_Question question) {
	final String search_query ="SELECT ID from QUESTIONS WHERE QUESTION = ? AND DIFFICULTY = ?  AND TOPICS = ? AND Q_TYPE = ?";
	final String insert_mcq_statement = "INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (?,?,?,?,?);";
	int id = 0 ;
	try (Connection connection = JDBC.getConnection();
			PreparedStatement insertStatement = connection.prepareStatement(INSERT_STATEMENT);
		    PreparedStatement searchQuery =  connection.prepareStatement(search_query);	
			PreparedStatement insertMcq  = connection.prepareStatement(insert_mcq_statement);
			) {
		
		insertStatement.setString(1, question.getQuestion());
		insertStatement.setInt(2, question.getDifficulty());
		insertStatement.setString(3, question.getTopics().toString());
		insertStatement.setString(4, question.getType().toString());
		insertStatement.execute();
        logMessage("Question created successfully");
        try {
        	searchQuery.setString(1, question.getQuestion());
			searchQuery.setInt(2, question.getDifficulty());
			searchQuery.setString(3, question.getTopics().toString());
			searchQuery.setString(4, question.getType().toString());
			ResultSet results =	searchQuery.executeQuery();

		while (results.next()) {
				id = results.getInt(1);
		}

		results.close();        
        } catch (Exception e) {
        	e.printStackTrace();
		}	
		
		
        try {
        	insertMcq.setInt(1, id); 
        	insertMcq.setString(2, question.getAnswer()); 
        	insertMcq.setString(3, question.getChoice1() ); 
        	insertMcq.setString(4, question.getChoice2() ); 
        	insertMcq.setString(5, question.getChoice3() ); 
        	insertMcq.execute();
        	logMessage("created MCQ question");
        }catch (Exception e) {
        	// TODO: handle exception
        	logMessage("Failed to create MCQ question");
        	logMessage(e.toString());


        }

	} catch (SQLException e) {
		e.printStackTrace();
	} 
 }
 /**
 * @param question
 * This method first populates the question table and then 
 * gets the ID from that table as Foreign key to populate the OPEN_Question table 
 */
 public static void createOPEN(OPEN_Question question) {
	 
 }
 /**
 * @param question
 * This method first populates the question table and then 
 * gets the ID from that table as Foreign key to populate the ASS_Question table 
 */
 public static void createASS(ASS_Question question) {
	 
 }
}