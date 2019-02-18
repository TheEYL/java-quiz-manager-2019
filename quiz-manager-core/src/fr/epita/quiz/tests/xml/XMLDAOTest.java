//package fr.epita.quiz.tests.xml;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.TransformerException;
//
//import org.xml.sax.SAXException;
//
//import fr.epita.quiz.datamodel.Question;
//import fr.epita.quiz.datamodel.Topic;
//import fr.epita.quiz.datamodel.TopicsList;
//import fr.epita.quiz.services.QuestionXMLDAO;
//
//public class XMLDAOTest {
//
//	
//	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
//		//read();
//		
//		
////		create();
//		QuestionXMLDAO dao = new QuestionXMLDAO();
//		System.out.println(dao.search(new Question("java", null, null)));
//	}
//
//	private static void read() throws SAXException, IOException, ParserConfigurationException {
//		QuestionXMLDAO dao = new QuestionXMLDAO();
//		List<Question> listQuestions = dao.getAllQuestions();
//		for (Question question : listQuestions) {
//			System.out.println("Question : " + question.getQuestion());
//			System.out.println("Difficulty : " + question.getDifficulty());
//		}
//	}
//
//	private static void create() throws SAXException, IOException, ParserConfigurationException, TransformerException {
//		Question question = new Question();
//		question.setQuestion("What are the main differences between Java and C++ ?");
//		question.setDifficulty(8);
//	
//		TopicsList list = new TopicsList();
//		list.getTopicsList().add(new Topic("Java"));
//		list.getTopicsList().add(new Topic("c++"));
//		question.setTopics(list);
//		QuestionXMLDAO xmldao = new QuestionXMLDAO();
//		xmldao.create(question);
//	}
//
//}
