package fr.epita.quiz.launcher;

import java.util.Scanner;

import fr.epita.logger.Logger;
import fr.epita.quiz.authentication.Authenticate;

public class Launcher {
	
		private static Scanner scan = new Scanner(System.in);
		private static String userName ="";
		private static String password="";
		public static void main (String[] args) {
		Logger.logMessage("Welcome to the Quiz manager app");
		Logger.logMessage(" Choose option:");
		Logger.logMessage(" 1.Take a test. \n 2.Login as admin");

		while(scan.hasNextLine()) {
			switch (scan.nextLine()) {
			case "1":
				
			Logger.logMessage("You are about to take a test.");	
			Logger.logMessage("Please enter your name:");	
				break;

			case "2":
			Logger.logMessage("Please enter your admin credentials:");	
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

private static void showAdminMenu(String userName, String password) {
	if (Authenticate.authenticate(userName, password)) {
		Logger.logMessage("user " + userName + "authenticated succesfully");
		Logger.logMessage("Welcome " + userName);
		boolean exit = false;
		do {
			Logger.logMessage("Please choose one action");
			Logger.logMessage("1. Create question");
			Logger.logMessage("2. Search questions");
			Logger.logMessage("3. Update questions");
			Logger.logMessage("4. Delete questions");
			Logger.logMessage("5. Exit");
			String answer = getAnswer(scan, "Please input your choice (1|2|3|4)");
			switch (answer) {
			case "1":
				break;
			case "2":
				Logger.logMessage("Sub Menu: enter your search keyword: ");
				break;
			case "3":
				Logger.logMessage("Sub Menu: enter the ID of the question you want to update: ");
				break;
			case "4":
				Logger.logMessage("Sub Menu: enter the ID of the question you want to delete: ");
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
		Logger.logMessage("not authenticated, exiting");
		Logger.logMessage("authentication failure for the user: " + userName);
	}	
	
}

private static String getAnswer(Scanner scanner, String question) {
		Logger.logMessage(question);
		return scanner.nextLine();
	}

}
