package fr.epita.quiz.launcher.menu;

import static fr.epita.logger.Logger.logMessage;

import java.io.FileReader;
import java.io.IOException;
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
import fr.epita.quiz.datamodel.QuestionList;
import fr.epita.quiz.datamodel.Student;
import fr.epita.quiz.services.JDBC;
import fr.epita.quiz.services.JDBCADMIN;
import fr.epita.quiz.services.JDBCSTUDENT;

/**
 * @author leo
 * This class shows and handles the various menus shown in the application
 */
public class Menu {
	private static Scanner scan = new Scanner(System.in);
	private static String userName ="";
	private static String password ="";
	private static int score =0;
	public static void launcherMenu() {
		importSchema();
		logMessage("Welcome to the Quiz manager app");
		logMessage("Choose option:");
		logMessage("1.Take a test. \n 2.Login as admin. ");

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
				String exit= getAnswer(scan,"Are you sure you want to exit? (y|n)");
				boolean b =  "y".equals(exit);
				if (b) return;
				break;
			default:
				break;
			}
		}
		//		scan.close();
	}


	/**
	 * Show student Menu.
	 * "You are about to take a test"
	 *  "Choose the topics"
	 *  "Select the difficulty"
	 *  
	 */
	private static void showStudentMenu() {
		// TODO Auto-generated method stub
		boolean exit = false;
		do {
			String topicList = "";
			int difficulty =0;
			Student student = new Student();
			String exit_string = "";
			boolean user_already_exist=false;
			do {
				user_already_exist = createNewStudent(student);
			}while(!user_already_exist);
			logMessage("Here's the list of topics:");
			logMessage("Choose quiz topics: (comma seperated values)");
			topicList = showTopics();
			difficulty = selectDifficulty();
			QuestionList questionList = new QuestionList(); 
			questionList = JDBCSTUDENT.LoadStudentQuestions(topicList, difficulty);
			String answer = getAnswer(scan," Press (s) to start quiz. (q) to exit");
			switch (answer) {
			case "s":
				showQuiz(questionList, student);
				exit_string = getAnswer(scan, "do you want to exit the student menu? (y/N)?");
				exit = "y".equals(exit_string);
				break;
			case "q":
				exit_string = getAnswer(scan, "do you confirm you want to exit the student menu? (y/N)?");
				exit = "y".equals(exit_string);
				clearScreen();
				break;
			default:
				break;
			}
		} while (!exit);	
		launcherMenu();
	}


	private static boolean createNewStudent(Student student) {
		student.setName(getAnswer(scan, "Please enter your name: "));
		
			return JDBCSTUDENT.createStudent(student);
		
		
	}


	/**
	 * @param questionList
	 * @param student
	 * shows the quiz and gets the answers from the user
	 * then saves the quiz to the database and creates a
	 *  file with the questions answered
	 */
	private static void showQuiz(QuestionList questionList, Student student) {
		// TODO Auto-generated method stub

		//		logMessage("Loaded Questions");
		clearScreen();
		for (Question question : questionList.getQuestionList() ) {
			String[] choices_array = question.getMcq_Choice().getChoice();
			String[] shuffled_choices =  question.getMcq_Choice().shuffledChoices();
			logMessage(question.toString());
			StringBuilder sb = new StringBuilder();

			int i = 1;
			for (String string : shuffled_choices) {
				if (string!= null ) {
					sb.append("\n("+i+") " + question.getMcq_Choice().getChoice()[i-1]);
					i++;
				}
			}

			logMessage(sb.toString());
			getStudentAnswer(student, choices_array[0], shuffled_choices, question.getId());

		}	

		logMessage("You scored " + score + " out of" + questionList.getQuestionList().size());
		logMessage("Saving responses...");
		logMessage("Quiz done");
		try {
			JDBCSTUDENT.exportResultsToFile(student, score, questionList.getQuestionList().size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clearScreen();
	}


	/**
	 * @param student
	 * @param choices_array
	 * @param shuffled_choices
	 * @param question_id
	 * @return index array that corresponds to the user choice
	 */
	private static int getStudentAnswer(Student student, String choices_array, String[] shuffled_choices, int question_id) {
		// TODO Auto-generated method stub
		int choice ;
		String selection = "";
		boolean answered = false;
		do {
			choice = getInt(scan, "Choose answer: (type number)") ;
			if (! (choice > shuffled_choices.length) && ! (choice <= 0)) {
				selection   = shuffled_choices[choice - 1];
				logMessage("You selected: " + selection);
				student.setMcq_Choice(selection);
				if (selection == choices_array) {
					student.getMcq_Choice().setIs_valid(true);
					score++;
					//					System.out.println("Answer is valid");
				}
				//				System.err.println("Answer is not valid");
				JDBCSTUDENT.saveAnswer(student, question_id);
				answered = true;
			}else {
				logMessage("wrong choice. try again.");
			}
		} while(!answered);

		return score;
	}


	/**
	 * @return difficulty choosen by the user
	 */
	private static int selectDifficulty() {

		// TODO Auto-generated method stub
		boolean ran = false;

		do {
			try {

				return Integer.parseInt(getAnswer(scan, "Choose MAX difficulty:"));
			} catch (Exception e) {
				System.err.println("what did you insert?!. Try again with a number."); 
			}	

		}while(!ran);


		return 0;
	}


	/**
	 * Shows users the list of topics in the database
	 * Allows users to select topics for the quiz
	 */
	private static String showTopics() {
		// TODO Auto-generated method stub
		String topicList = "";
		boolean correct_topic = false;
		try {
			logMessage(JDBCSTUDENT.getTopics().toString());
			do {
				topicList = getAnswer(scan, "Enter topics:");
				if (!topicList.isEmpty())
					correct_topic = true;
			} while (!correct_topic);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return topicList;

	}


	/**
	 * Creates quiz tables and inserts default admin user 
	 */
	private static void importSchema() {
		JDBC.firstLoad();

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
					clearScreen();
					break;
				default:
					break;
				}
			} while (!exit);

			launcherMenu();
		}else {
			logMessage("not authenticated, exiting");
			logMessage("authentication failure for the user: " + userName);
		}	

	}


	/**
	 * @param question
	 * @param type
	 * 
	 * Creates the correct object based on the type given.
	 */
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

	/**
	 * @param scanner
	 * @param question
	 * @return string from the console
	 */
	public static String getAnswer(Scanner scanner, String question) {
		logMessage(question);
		return scanner.nextLine();
	}
	/**
	 * @param scanner
	 * @param question
	 * @return number from the console
	 */
	public static int getInt(Scanner scanner, String question) {
		logMessage(question);
		return scanner.nextInt();
	}
	/**
	 * Clears the console
	 */
	public static void clearScreen() {  
		logMessage("--------------------------------------------------------->");
	}	
}
