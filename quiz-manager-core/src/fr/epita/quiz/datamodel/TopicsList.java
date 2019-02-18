package fr.epita.quiz.datamodel;

import java.util.ArrayList;
import java.util.List;

public class TopicsList{

	private  List<Topic> topicsList = null;

	public void setTopicList(List<Topic> topicsList) {
		this.topicsList = topicsList;
	}
	public void setTopicList(String list) {
		this.topicsList =  new ArrayList<Topic>();
		String[] parts = list.split(",");
		for (String string : parts) {
			  topicsList.add(new Topic(string));
		}
	}

	public List<Topic> getTopicsList() {
		return this.topicsList;
	}

	public TopicsList () {
			this.topicsList = new ArrayList<>() ;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i  = 0;
		for (Topic topic : topicsList) {
				
			if (i < topicsList.size() -1)
					{
						sb.append(topic);
						sb.append(",");
					}
			else sb.append(topic);
				i++;
		}
		return sb.toString();
	}

}
