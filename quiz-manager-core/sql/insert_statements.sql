INSERT INTO	ADMIN (NAME, PASSWORD) VALUES ('admin', 'admin');


INSERT INTO QUESTIONS (QUESTION, TOPICS, DIFFICULTY, Q_TYPE) values ('main is a keyword in Java', 'java', 1, 'mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) values (1,'False','True','False');


INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('A transient variable can be static', 1 ,'variable','mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) values (2,'True','True','False');



INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('The && operator always evaluates both operands',1,'operator','mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) values (3,'False','True','False');



INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('Running a java program with -enableassertions switch will enable assertion for your program',2,'java','mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (4,'True','True','False,only -ea switch can be used',null);




INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('Which of the following classes define the toString() method?', 2 ,'class','mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (5,'All of the above','String','Object','All of the above');



INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('Which of the following are NOT Java keywords?', 2 ,'java,keyword','mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (6,'extend','extend','class','import');




INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('null is a valid keyword in Java', 1 ,'java' ,'mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) values (7,'False','True','False');



INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('Which of the following is Java keywords?', 1 ,'keyword','mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) values (8,'int','int','long');


INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('Will this code compile without any errors?
public class Test{
	public static void main(String[] args){			
		int main = 0;	
	}		
}', 2 ,'code','mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) values (9,'Yes','Yes','No');



INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('What will happen when you compile and run the following code?
public class Test{
	public static void main(String[] args){			
		int main = 0;	
	}		
}', 2 ,'code','mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (10,'Compilation Error','0',null,'Compilation Error');

INSERT INTO QUESTIONS (QUESTION, TOPICS, DIFFICULTY, Q_TYPE) values ('Can you declare a static method final?', 'java', 1, 'mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) values (11,'Yes','Yes','No');


INSERT INTO QUESTIONS (QUESTION, TOPICS, DIFFICULTY, Q_TYPE) values ('Can you override public constructor declared in a base class to private in a child class?', 'java,class', 1, 'mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) values (12,'No','Yes','No');


INSERT INTO QUESTIONS (QUESTION, TOPICS, DIFFICULTY, Q_TYPE) values ('All the methods declared in an interface are implicitly public.', 'java,public', 1, 'mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) values (13,'True','True','False');

INSERT INTO QUESTIONS (QUESTION, TOPICS, DIFFICULTY, Q_TYPE) values ('Will this code compile?
public class Test{	
	final int i;
}', 'code,compile', 1, 'mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) values (14,'No','Yes','No');


INSERT INTO QUESTIONS (QUESTION, TOPICS, DIFFICULTY, Q_TYPE) values ('Will this code compile?
public class Test{	
	static final int i;	
	static{
		i = 5;
	}
}', 'code,compile', 1, 'mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) values (15,'Yes','Yes','No');


INSERT INTO QUESTIONS (QUESTION, TOPICS, DIFFICULTY, Q_TYPE) values ('Running a java program with -ea switch will enable assertion in system classes.', 'java', 1, 'mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) values (16,'False','True','False');


INSERT INTO QUESTIONS (QUESTION, TOPICS, DIFFICULTY, Q_TYPE) values ('Will this code compile?
public class Test{
	public void count(){		
	}
}
class TestChild extends Test{
	public void count(int i) throws Exception{
	}
}
', 'code,compile', 2, 'mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) values (17,'Yes','Yes','No');




INSERT INTO QUESTIONS (QUESTION, TOPICS, DIFFICULTY, Q_TYPE) values ('What will happen when you compile and run the following code?
public class Test{
	public static void main(String[] args){		
		int i = 2;
		System.out.println(i << 3);
	}		
}

', 'code,compile', 3, 'mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (18,16,8,5,16);


INSERT INTO QUESTIONS (QUESTION, TOPICS, DIFFICULTY, Q_TYPE) values ('Will this code compile without error?
interface Test {
	abstract public void someMethod() throws Exception;
}', 'code,compile', 3, 'mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) values (19,'Yes','Yes','No');

INSERT INTO QUESTIONS (QUESTION, TOPICS, DIFFICULTY, Q_TYPE) values ('Which class has defined the equals(Object o) method?', 'class,java', 3, 'mcq');
INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (20,'Object','String','Main','Object');
