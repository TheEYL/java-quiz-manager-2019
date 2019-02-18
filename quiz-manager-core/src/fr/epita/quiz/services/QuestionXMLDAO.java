//package fr.epita.quiz.services;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerConfigurationException;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.TransformerFactoryConfigurationError;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import javax.xml.xpath.XPath;
//import javax.xml.xpath.XPathConstants;
//import javax.xml.xpath.XPathExpression;
//import javax.xml.xpath.XPathExpressionException;
//import javax.xml.xpath.XPathFactory;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//import fr.epita.quiz.datamodel.Question;
//
//public class QuestionXMLDAO {
//
//	private static final String XML_FILENAME_KEY = "xml.filename";
//	private static final XPathFactory xpathFactory = XPathFactory.newInstance();
//	private static final XPath xpath = xpathFactory.newXPath();
//	private static XPathExpression expression;
//	
//	//only to demonstrate how to compile and store an xpath expression
//	static {
//		try {
//			expression = xpath.compile("//question");
//		} catch (XPathExpressionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public Document parseFile() throws SAXException, IOException, ParserConfigurationException {
//		Configuration config = Configuration.getInstance();
//		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder = fact.newDocumentBuilder();
//		return builder.parse(new File(config.getConfigurationValue(XML_FILENAME_KEY)));
//
//	}
//
//	public List<Question> search(Question question) {
//		List<Question> results = new ArrayList<>();
//		try {
//			Document doc = parseFile();
//			NodeList nodeList = (NodeList) xpath.evaluate("//question[contains(label/text(), '" + question.getQuestion() +"')]", doc, XPathConstants.NODESET);
//			for (int i = 0; i < nodeList.getLength() ; i ++) {
//				Node item = nodeList.item(i);
//				String label = evaluateXpathAsString("label/text()",item);
//				int difficulty = evaluateXpathAsInteger("difficulty/text()", item);
//				List<String> topicsList = evaluateXpathAsStringList("topics//topic",item);
//				Question currentQuestion = new Question(label, topicsList, difficulty);
//				results.add(currentQuestion);
//			}
//		} catch (SAXException | IOException | ParserConfigurationException | XPathExpressionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return results;
//
//	}
//
//	private List<String> evaluateXpathAsStringList(String xpathExpr,Node item) throws XPathExpressionException {
//		List<String> topicsList = new ArrayList<String>();
//		NodeList topics = (NodeList) xpath.evaluate(xpathExpr, item, XPathConstants.NODESET);
//		
//		for (int j = 0; j < topics.getLength(); j ++) {
//			topicsList.add(topics.item(j).getTextContent());
//		}
//		return topicsList;
//	}
//
//	private String evaluateXpathAsString(String xpathExpr, Node item) throws XPathExpressionException {
//		return (String) xpath.evaluate(xpathExpr, item, XPathConstants.STRING);
//	}
//	private Integer evaluateXpathAsInteger(String xpathExpr, Node item) throws XPathExpressionException {
//		return Integer.valueOf((String) xpath.evaluate(xpathExpr, item, XPathConstants.STRING));
//	}
//	
//	
//
////	public List<Question> search(Question criteria){
////		
////		List<Question> results = new ArrayList<>();
////		try {
////			List<Question> allQuestions = getAllQuestions();
////			for (Question question : allQuestions) {
////				boolean difficultyMatching = question.getDifficulty() == criteria.getDifficulty();
////				boolean topicsMatching = false;
////				for (String topic : question.getTopics()) {
////					if (criteria.getTopics().contains(topic)) {
////						topicsMatching = true;
////						break;
////					}
////				}
////				boolean questionContentMatching = question.getQuestion().contains(criteria.getQuestion());
////				
////				boolean test = difficultyMatching || topicsMatching || questionContentMatching;
////				if (test) {
////					results.add(question);
////				}
////			}
////			results = allQuestions
////					.stream()
////					.filter(q -> q.getDifficulty() == criteria.getDifficulty() && q.getQuestion().contains(criteria.getQuestion()))
////					.collect(Collectors.toList());
////			
////			results = allQuestions
////					.stream()
////					.filter(new Predicate<Question>() {
////
////						@Override
////						public boolean test(Question q) {
////							 return q.getDifficulty() == criteria.getDifficulty() && q.getQuestion().contains(criteria.getQuestion());
////						}
////					})
////					.collect(Collectors.toList());
////			
////			
////			
////		} catch (SAXException | IOException | ParserConfigurationException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		
////		
////		return results;
////		
////		
////	}
//
//	public List<Question> getAllQuestions() throws SAXException, IOException, ParserConfigurationException {
//		Document doc = parseFile(); // file parsing
//		List<Question> listQuestions = new ArrayList<>();
//		NodeList list = doc.getElementsByTagName("question");
//		for (int i = 0; i < list.getLength(); i++) {
//			Question question = new Question();
//			Element questionXML = (Element) list.item(i);
//			int order = Integer.valueOf(questionXML.getAttribute("order")); // getting order attribute from question
//																			// element
//			String label = questionXML.getElementsByTagName("label").item(0).getTextContent(); // getting label element
//																								// (then text content)
//																								// from question element
//			int difficulty = Integer.valueOf(questionXML.getElementsByTagName("difficulty").item(0).getTextContent()); // getting
//																														// difficulty
//																														// element
//																														// (then
//																														// text
//																														// content)
//																														// from
//																														// question
//																														// element
//			question.setQuestion(label);
//			question.setDifficulty(difficulty);
//
//			List<String> topics = getAllTopicsFromQuestion(questionXML);
//			question.setTopics(topics);
//
//			listQuestions.add(question);
//		}
//
//		return listQuestions;
//	}
//
//	private List<String> getAllTopicsFromQuestion(Element question) {
//		// get element of tag name "topics"
//		Element topicsElement = (Element) question.getElementsByTagName("topics").item(0);
//
//		// extract all elements of tag name "topic" within the last
//		NodeList topicsList = topicsElement.getElementsByTagName("topic");
//
//		// init array size with lenght of list of topics
//		List<String> result = new ArrayList<>();
//
//		// loop on each topic
//		for (int i = 0; i < topicsList.getLength(); i++) {
//			Element topic = (Element) topicsList.item(i);
//			result.add(topic.getTextContent()); // add topic text content to array
//		}
//		return result;
//	}
//
//	public void create(Question question)
//			throws SAXException, IOException, ParserConfigurationException, TransformerException {
//		Document doc = parseFile();
//
//		Element newQuestion = doc.createElement("question");
//		newQuestion.setAttribute("id", String.valueOf(question.getId()));
//
//		Element label = doc.createElement("label");
//		label.setTextContent(question.getQuestion());
//		newQuestion.appendChild(label);
//
//		Element difficulty = doc.createElement("difficulty");
//		difficulty.setTextContent(String.valueOf(question.getDifficulty()));
//		newQuestion.appendChild(difficulty);
//
//		Element topics = doc.createElement("topics"); // creation of a single "topics" element
//														// which will contain all the "topic" elements
//		for (String topic : question.getTopics()) { // for each topic in the java object
//			Element xmlTopic = doc.createElement("topic"); // creation of an xml element "topic"
//			xmlTopic.setTextContent(topic); // setting text content
//			topics.appendChild(xmlTopic); // .. and append to the "topics" element
//		}
//		newQuestion.appendChild(topics);
//		doc.getDocumentElement().appendChild(newQuestion);
//
//		transformXMLFile(doc);
//	}
//
//	public void update(Question question) throws SAXException, IOException, ParserConfigurationException {
//		// TODO parse file
//		Document doc = parseFile();
//
//		// TODO get question element in xml file through question id
//		NodeList listQuestions = doc.getElementsByTagName("question");
//		for (int i = 0; i < listQuestions.getLength(); i++) {
//			Element questionXML = (Element) listQuestions.item(i);
//			int idXML = Integer.valueOf(questionXML.getAttribute("id")); // !! Assuming id is in the attributes
//			if (question.getId() == idXML) {
//				// label modification
//				Element label = (Element) questionXML.getElementsByTagName("label").item(0);
//				label.setTextContent(question.getQuestion());
//
//				// difficulty modification
//				Element difficulty = (Element) questionXML.getElementsByTagName("difficulty").item(0);
//				difficulty.setTextContent(String.valueOf(question.getDifficulty()));
//
//				// topics modification
//				Element topics = (Element) questionXML.getElementsByTagName("topics").item(0);
//				NodeList topicList = topics.getElementsByTagName("topic");
//
//				// loop on the old topic list of the xml element to delete them
//				for (int j = 0; j < topicList.getLength(); j++) {
//					topics.removeChild(topicList.item(j));
//				}
//
//				// loop on the new topic list of the java object to add them to the xml
//				for (String topic : question.getTopics()) {
//					Element xmlTopic = doc.createElement("topic"); // creation of an xml element "topic"
//					xmlTopic.setTextContent(topic); // setting text content
//					topics.appendChild(xmlTopic); // .. and append to the "topics" element
//				}
//			}
//
//		}
//
//		// TODO propagate transformation to xml file
//	}
//
//	public void delete(Question question) {
//		// TODO parse file
//		// TODO get question to delete with id
//		// TODO use "remove child" to root element
//		// TODO propagate transformation to xml file
//	}
//
//	private void transformXMLFile(Document doc)
//			throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
//
//		Configuration config = Configuration.getInstance();
//		TransformerFactory fact = TransformerFactory.newInstance();
//		Transformer transformer = fact.newTransformer();
//		transformer.transform(new DOMSource(doc), new StreamResult(config.getConfigurationValue(XML_FILENAME_KEY)));
//	}
//
//}
