package fr.epita.quiz.tests.JDBC;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;

import org.h2.tools.RunScript;

import fr.epita.quiz.datamodel.MCQ_Question;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.JDBC;
import fr.epita.quiz.services.JDBCADMIN;

public class CreateLauncher {

	public static void main (String[] args) {


		MCQ_Question question = new MCQ_Question();
		question.setType("m");
		question.setTopics("blue,berries");
		question.setDifficulty(1);
		question.setQuestion("Where orange berries coming from?");
		
		question.setAnswer("kon");
		question.setChoice1("on");
		question.setChoice2("kon");
		question.setChoice3("pon");
		JDBCADMIN.createMCQ(question);
	}
}
