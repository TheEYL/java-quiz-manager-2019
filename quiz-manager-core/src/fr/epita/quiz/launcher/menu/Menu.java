package fr.epita.quiz.launcher.menu;

import static fr.epita.logger.Logger.logMessage;

import java.io.FileReader;
import java.sql.SQLException;
import java.util.Scanner;

import org.h2.jdbc.JdbcSQLException;
import org.h2.message.DbException;
import org.h2.tools.RunScript;

import fr.epita.logger.Logger;
import fr.epita.quiz.authentication.Authenticate;
import fr.epita.quiz.datamodel.ASS_Question;
import fr.epita.quiz.datamodel.MCQ_Question;
import fr.epita.quiz.datamodel.OPEN_Question;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.JDBC;
import fr.epita.quiz.services.JDBCADMIN;

public class Menu {
	private static Scanner scan = new Scanner(System.in);
	private static String userName ="";
	private static String password="";
	public static void launcherMenu() {
		importSchema();
		logMessage("Welcome to the Quiz manager app");
		logMessage("Choose option:");
		logMessage("1.Take a test. \n 2.Login as admin");

		while(scan.hasNextLine()) {
			switch (scan.nextLine()) {
			case "1":
				logMessage("You are about to take a test.");	

				showStudentMenu();
				break;

			case "2":
				logMessage("Please enter your admin credentials:");	
				password  = getAnswer(scan, "Enter your username");
				userName = getAnswer(scan, "Enter your password");
				showAdminMenu(userName, password);
				break;
			case "3":
				//TODO:exit app fxn
				break;
			default:
				break;
			}
		}
		//		scan.close();
	}


	private static void showStudentMenu() {
		// TODO Auto-generated method stub
		boolean exit = false;
		do {
			String name = getAnswer(scan, "Please enter your name");
			logMessage("Here's the list of topics:");
			logMessage("Choose quiz topics: (comma seperated values");
			showTopics();
			selectDifficulty();
			String answer = getAnswer(scan,"Setup Complete. Press (s) to start quiz. (q) to exit");
			switch (answer) {
			case "s":
				showQuiz();
				break;
			case "2":
				System.out.println("Sub Menu: enter your search keyword: ");
				//TODO program update and delete after displaying the list
				break;
			case "q":
				name = getAnswer(scan, "do you confirm you want to exit the student menu? (y/N)?");

				exit = "y".equals(name);
				launcherMenu();
				break;
			default:
				break;
			}
		} while (!exit);	

	}


	private static void showQuiz() {
		// TODO Auto-generated method stub

	}


	private static void selectDifficulty() {
		// TODO Auto-generated method stub

	}


	/**
	 * Shows users the list of topics in the database
	 * Allows users to select topics for the quiz
	 */
	private static void showTopics() {
		// TODO Auto-generated method stub

	}


	/**
	 * Creates quiz tables and inserts default admin user 
	 */
	private static void importSchema() {
		JDBCADMIN.firstLoad();
		
	}

	/**
	 * @param userName
	 * @param password
	 * 
	 * Show administrator menu to allow CRUD operations on Questions
	 */
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
					Question question = null;
					chooseQuestionType(question, getAnswer(scan, "Enter type: (m -> MCQ| o -> open | a -> associative"));
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
					answer = getAnswer(scan, "do you confirm you want to exit the admin menu(y/N)?");

					exit = "y".equals(answer);
					launcherMenu();
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


	private static void chooseQuestionType(Question question,String type ) {

		switch (type.toLowerCase()) {
		case "m":
			question = new MCQ_Question();
			question.setType(type);
			question.setQuestion(getAnswer(scan, "Enter MCQ question: "));
			question.setAnswer(getAnswer(scan, "Enter answer: "));
			question.setChoice1(getAnswer(scan, "Enter choice1: "));
			question.setChoice2(getAnswer(scan, "Enter choice2: "));
			question.setChoice3(getAnswer(scan, "Enter choice3: "));
			question.setDifficulty(Integer.parseInt(getAnswer(scan, "Enter difficulty: ")));
			question.setTopics(getAnswer(scan, "Enter topics: (comma seperated)"));
			JDBCADMIN.createMCQ(question);
			break;
		case "o":
			question = new OPEN_Question();	
			question.setType(type);
			question.setQuestion(getAnswer(scan, "Enter OPEN question: "));
			JDBCADMIN.createOPEN(question);
			break;
		case "a":
			question = new ASS_Question();
			question.setType(type);
			question.setQuestion(getAnswer(scan, "Enter ASSOCIATIVE question: "));

			JDBCADMIN.createASS(question);
			break;
		default:
			break;
		}
	}

	public static String getAnswer(Scanner scanner, String question) {
		logMessage(question);
		return scanner.nextLine();
	}
}
