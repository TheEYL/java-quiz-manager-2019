package fr.epita.quiz.launcher;

import java.io.FileReader;
import java.util.Scanner;

import org.h2.tools.RunScript;

import static fr.epita.logger.Logger.*;

import fr.epita.quiz.authentication.Authenticate;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.JDBC;
import fr.epita.quiz.services.JDBCADMIN;

public class Launcher {
	
		private static Scanner scan = new Scanner(System.in);
		private static String userName ="";
		private static String password="";
		public static void main (String[] args) {

//		importSchema();
		logMessage("Welcome to the Quiz manager app");
		logMessage(" Choose option:");
		logMessage(" 1.Take a test. \n 2.Login as admin");

		while(scan.hasNextLine()) {
			switch (scan.nextLine()) {
			case "1":
				
			logMessage("You are about to take a test.");	
			logMessage("Please enter your name:");	
				break;

			case "2":
			logMessage("Please enter your admin credentials:");	
			password  = getAnswer(scan, "Enter your username");
			userName = getAnswer(scan, "Enter your password");
			showAdminMenu(userName, password);
				break;
			case "3":
			 //TODO:	exit app fxn
				break;
			default:
				break;
			}
		}
		scan.close();
}

		private static void importSchema() {
			try {
					
					RunScript.execute(JDBC.getConnection(), new FileReader("sql/quiz_schema.sql"));
			} catch (Exception e) {
				System.out.println(e);
			}
		}

private static void showAdminMenu(String userName, String password) {
	if (Authenticate.authenticate(userName, password)) {
		logMessage("user " + userName + "authenticated succesfully");
		logMessage("Welcome " + userName);
		boolean exit = false;
		do {
			logMessage("Please choose one action");
			logMessage("1. Create question");
			logMessage("2. Search questions");
			logMessage("3. Update questions");
			logMessage("4. Delete questions");
			logMessage("5. Exit");
			String answer = getAnswer(scan, "Please input your choice (1|2|3|4)");
			switch (answer) {
			case "1":
				logMessage("Sub Menu: Creating questions:");
				Question question = new Question();
				question.setType(getAnswer(scan, "Enter type: (m -> MCQ| o -> open | a -> associative"));
				question.setQuestion(getAnswer(scan, "Enter question: "));
				question.setDifficulty(Integer.parseInt(getAnswer(scan, "Enter difficulty: ")));
				question.setTopics(getAnswer(scan, "Enter topics: (comma seperated)"));
				JDBCADMIN.create(question);
				break;
			case "2":
				logMessage("Sub Menu: enter your search keyword: ");
				break;
			case "3":
				logMessage("Sub Menu: enter the ID of the question you want to update: ");
				break;
			case "4":
				logMessage("Sub Menu: enter the ID of the question you want to delete: ");
				break;
			case "5":
				answer = getAnswer(scan, "do you confirm you want to exit the application (y/N)?");

				exit = "y".equals(answer);

				break;
			default:
				break;
			}
		} while (!exit);
	}else {
		logMessage("not authenticated, exiting");
		logMessage("authentication failure for the user: " + userName);
	}	
	
}

private static String getAnswer(Scanner scanner, String question) {
		logMessage(question);
		return scanner.nextLine();
	}

}
