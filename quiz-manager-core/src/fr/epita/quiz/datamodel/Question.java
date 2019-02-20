package fr.epita.quiz.datamodel;

/**
 * @author leo
 * This class serves to define the other question types.
 */
public abstract class Question {

	private int id;
	
	private String question; 
	private TopicList topics;	 
	private Integer difficulty;
	private QuestionType type;

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}
	public void setType(String q_type) {
		switch (q_type.toLowerCase()) {
		case "m":
			
		this.type = QuestionType.MCQ;
			break;
		case "o":
			
		this.type = QuestionType.OPEN;
			break;
		case "a":
		this.type = QuestionType.ASSOCIATIVE;
			break;

		default:

			break;
		}
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", topics=" + topics + ", difficulty=" + difficulty
				+ "]";
	}

	public Question() {
		this.question = null;
		this.topics = null;
		this.difficulty = null;
		this.type = null;

	}
	
	public Question(String question, TopicList topics, Integer difficulty, QuestionType type) {
		this.question = question;
		this.topics = topics;
		this.difficulty = difficulty;
		this.type = type;
	}
	
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public TopicList getTopics() {
		return topics;
	}
	public void setTopics(TopicList topics) {
		this.topics = topics;
	}
	public void setTopics( String list) {
		TopicList tlist= new TopicList();
		 tlist.setTopicList(list);
         this.topics =tlist;
	}
	public Integer getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public abstract String getChoice1() ;
	

	public abstract void setChoice1(String choice1) ;
	

	public abstract String getChoice2() ;
	

	public abstract void setChoice2(String choice2) ;
	

	public abstract String getAnswer() ;
	

	public abstract void setAnswer(String answer);

	public void setChoice3(String choice3) {
		// TODO Auto-generated method stub
		
	}

	public String getChoice3() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMatch_string() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setMatch_string(String match_string) {
		// TODO Auto-generated method stub
		
	}

	public MCQ_Choice getMcq_Choice() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setMcq_Choice() {
		// TODO Auto-generated method stub
		
	}
	
	 
	


}
