package fr.epita.quiz.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.epita.quiz.datamodel.Admin;
import fr.epita.quiz.datamodel.AdminList;


public class JDBCADMIN {
 static final String SEARCH_STATEMENT = "SELECT * FROM ADMIN" ;
 
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
 
 
}
