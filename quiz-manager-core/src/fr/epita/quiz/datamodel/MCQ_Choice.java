package fr.epita.quiz.datamodel;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author leo
 *  MCQ choice class
 *  stores the choices
 *  shuffles the choices
 *  gets the student answer
 */
public class MCQ_Choice {
 
//	private Map <Integer, String> mcq_choice = new HashMap();	

	private String[] choice ; // the correct answer is always the first element of this array
//	private String choice2 ;
	private String stud_answer; // the answer given by the student
	private boolean is_valid; // is the answer valid?
	private  String[] shuffled_choice =null;
//	private String choice3 ;
//	private String choice4 ;
//	
	/**
	 * @param choice
	 * Initialize the MCQ_Choices
	 */
	public MCQ_Choice(String[] choice) {
//		Random r = new Random();
//	    String randomNumber = String.format("%04d", r.nextInt(1001)); 
		this.setChoice(choice);
	}
	
	public MCQ_Choice(String answer) {
		// TODO Auto-generated constructor stub
		this.setStud_answer(answer);
		
	}

	public String[] getChoice() {
		return choice;
	}
	public void setChoice(String[] choice) {
		this.choice = choice;
	}
	
	/**
	 * @return
	 * This method shuffles the mcq questions to make sure that student can't guess the right answers
	 */
	public final String[] shuffledChoices() {
		java.util.List<String> strList = Arrays.asList(choice);
		Collections.shuffle(strList);
		this.shuffled_choice = strList.toArray(new String[strList.size()]);	
		return this.shuffled_choice;
	}

//	@Override
//		public String toString() {	
			// TODO Auto-generated method stub
//		StringBuilder sb = new StringBuilder();
//		int i = 1;
//		for (String string : shuffledChoices()) {
//			if (string!= null ) {
//			 sb.append("\n("+i+") " +  this.getChoice()[i-1]);
//			 i++;
//			}
//		}
//			return sb.toString();
//		}

	public String getStud_answer() {
		return stud_answer;
	}

	public void setStud_answer(String stud_answer) {
		this.stud_answer = stud_answer;
	}

	public boolean Is_valid() {
		return is_valid;
	}

	public void setIs_valid(boolean is_valid) {
		this.is_valid = is_valid;
	}
}
