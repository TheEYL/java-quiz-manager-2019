package fr.epita.quiz.datamodel;

import java.util.ArrayList;

public class Question {

	private int id;
	
	private String question; 
	private TopicsList topics;	 
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
	
	public Question(String question, TopicsList topics, Integer difficulty, QuestionType type) {
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
	public TopicsList getTopics() {
		return topics;
	}
	public void setTopics(TopicsList topics) {
		this.topics = topics;
	}
	public void setTopics( String list) {
		TopicsList tlist= new TopicsList();
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
}
