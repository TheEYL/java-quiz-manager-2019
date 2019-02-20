package fr.epita.quiz.datamodel;

import fr.epita.logger.Logger;

public class MCQ_Question extends Question {

	private String choice1;
	private String choice2;
	private String choice3;
	private String Answer;
	private MCQ_Choice mcq_Choice;
	public String getAnswer() {
		return Answer;
	}
	@Override
	public void setAnswer(String answer) {
		Answer = answer;
	}

	@Override
	public String getChoice1() {
		return choice1;
	}

	@Override
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	@Override
	public String getChoice2() {
		return choice2;
	}
	@Override
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	@Override
	public String getChoice3() {
		return choice3;

	}
	@Override
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}
	@Override
	public MCQ_Choice getMcq_Choice() {
		return mcq_Choice;
	}
	@Override
	public void setMcq_Choice() {
		String [] choice = new String[]{this.Answer,this.choice1,this.choice2,this.choice3};
		this.mcq_Choice = new MCQ_Choice(choice);
	}
	@Override
	public String toString() {
		StringBuilder sb  = new StringBuilder();
		
//		sb.append("[Id: " + this.getId())
		sb.append(" ")
		.append(this.getQuestion().toUpperCase())
		.append("\n")
		.append("\n")
		.append("----------------------------")
		;
		return sb.toString();
	}
	 
}
