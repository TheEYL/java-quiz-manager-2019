package fr.epita.quiz.tests.topics;

import fr.epita.quiz.datamodel.Topic;
import fr.epita.quiz.datamodel.TopicsList;

public class TopicsLauncher {

	public static void main(String[] args) {

		Topic topic = new Topic("java");
//		Topic topic2 = new Topic("c++");
//		Topic topic3 = new Topic("sql");

        TopicsList list = new TopicsList();
	list.getTopicsList().add(topic);
		
	    System.out.println(list);	
		
	}


}
