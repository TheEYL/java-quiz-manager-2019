package fr.epita.quiz.datamodel;


public class MCQ_Choice {
 
//	private Map <Integer, String> mcq_choice = new HashMap();	

	private String[] choice ;
//	private String choice2 ;
	private String answer;
//	private String choice3 ;
//	private String choice4 ;
//	
	public MCQ_Choice(String[] choice) {
//		Random r = new Random();
//	    String randomNumber = String.format("%04d", r.nextInt(1001)); 
		this.setChoice(choice);
	}
	
	public MCQ_Choice(String answer) {
		// TODO Auto-generated constructor stub
		this.answer = answer;
	}

	public String[] getChoice() {
		return choice;
	}
	public void setChoice(String[] choice) {
		this.choice = choice;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		int i =1;
		for (String string : choice) {
			if (string!= null) {
			 sb.append("\n("+i+") " +  this.getChoice()[i-1]);
			 i++;
			}
		}
			return sb.toString();
		}
}
