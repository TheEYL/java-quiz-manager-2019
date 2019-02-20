package fr.epita.quiz.datamodel;

/**
 * @author leo
 * pojo for the various topics
 */
public class Topic {

	private String topic = "";

	public Topic(String topic) {
		this.topic = topic;
	}

	public String getTopic() {
		return topic;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  getTopic();
	}






}
