package fr.epita.quiz.datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo
 * defines list of students
 */
public class StudentList {

private List<Student> studentList;
public StudentList() {
	studentList = new ArrayList<>();

}
public List<Student> getStudentList() {
	return studentList;
}

public void setStudentList(List<Student> studentList) {
	this.studentList = studentList;
}
}
