package fr.epita.quiz.services;

import static fr.epita.logger.Logger.logMessage;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.h2.tools.RunScript;

public class JDBC {
	public static Connection getConnection() throws SQLException {
		Configuration conf = Configuration.getInstance();
		String jdbcUrl = conf.getConfigurationValue("jdbc.url");
		String user = conf.getConfigurationValue("jdbc.user");
		String password = conf.getConfigurationValue("jdbc.password");
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		return connection;
	}
	 public static void firstLoad() {
		 try (Connection connection = JDBC.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) from ADMIN;");
					) { 
	                     preparedStatement.executeQuery();
			 
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			 
			 logMessage("This seems to be the first time you are running the application:");
			 logMessage("Creating and inserting sample questions.");
				try {
					RunScript.execute(JDBC.getConnection(), new FileReader("sql/quiz_schema.sql"));
					RunScript.execute(JDBC.getConnection(), new FileReader("sql/insert_statements.sql"));
				} catch (Exception ex) {
					System.err.println("could not create tables and sambple questions");
					ex.printStackTrace();
				} 
		}
	 }
}
