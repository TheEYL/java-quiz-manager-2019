package fr.epita.quiz.authentication;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import fr.epita.logger.Logger;
import fr.epita.quiz.datamodel.Admin;
import fr.epita.quiz.datamodel.AdminList;
import fr.epita.quiz.services.JDBCADMIN;

public class Authenticate {



	//	private static Scanner scanner ;

	//	private static	String userName = getAnswer(scanner, "User name :");
	//	private	static String password = getAnswer(scanner, "Password :");

	//	public static void setScanner(Scanner scan) {

	//		scanner = scan;
	//	}


	public static boolean authenticate(String userName, String password) {
		AdminList admins = null;
		try {
//			Logger.logMessage("getting admins");
			admins = JDBCADMIN.getAdmins();	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		for (Admin admin : admins.getAdminList()) {
			System.out.print(" " + userName + "==  ");
			System.out.print(admin.getUserName());
			if (userName.equals(admin.getUserName())) {
				//
				Logger.logMessage("iterating over admins");
				//				Logger.logMessage(admin.getUserName());
								return (userName.equals( admin.getUserName()) && password.equals( admin.getPassword()));
			}
			else return false;
		}
		
		
		return false;
	}	


















}
