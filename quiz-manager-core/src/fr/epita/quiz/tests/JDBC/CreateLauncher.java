package fr.epita.quiz.tests.JDBC;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.JDBCADMIN;

public class CreateLauncher {

	public static void main (String[] args) {
			
		Question question = new Question();
		
		question.setType("m");
		question.setTopics("blue,berries");
		question.setDifficulty(1);
		question.setQuestion("What are blue berries?");
		
		JDBCADMIN.create(question);
	}
}
