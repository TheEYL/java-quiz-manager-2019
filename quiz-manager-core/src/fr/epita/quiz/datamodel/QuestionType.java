package fr.epita.quiz.datamodel;

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
