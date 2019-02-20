package fr.epita.quiz.datamodel;

import java.util.ArrayList;
import java.util.List;

public class QuestionList {
	private List<Question> questionList;
	public QuestionList() {
		questionList = new ArrayList<>();
	}
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
}
