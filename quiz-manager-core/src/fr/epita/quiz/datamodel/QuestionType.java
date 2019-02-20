package fr.epita.quiz.datamodel;

/**
 * @author leo
 * defines the different types of questions
 */
public enum QuestionType {
 MCQ("mcq") , OPEN("open"), ASSOCIATIVE("associative");
	
	private String name;
	
	private QuestionType(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name; 
	}
}
