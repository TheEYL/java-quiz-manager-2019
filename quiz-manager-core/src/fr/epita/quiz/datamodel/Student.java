package fr.epita.quiz.datamodel;

/**
 * @author leo
 * STUDENT POJO CLASS. Gets and sets the attributes of the student.
 */
public class Student {
	private int id;
	private String name;
	private MCQ_Choice mcq_Choice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MCQ_Choice getMcq_Choice() {
		return mcq_Choice;
	}
	public void setMcq_Choice(String answer) {
		this.mcq_Choice = new MCQ_Choice(answer);
	}
	
}
