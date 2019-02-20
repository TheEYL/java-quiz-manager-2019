INSERT INTO	ADMIN (NAME, PASSWORD) VALUES ('admin', 'admin');
--INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('Another valentine', 1 ,'valantine,love,lonliness' ,'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (1,'no','jonny','i hate lonliness but lonliness loves me',null);
--
--INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('cheap deeds meet dirty tricks', 1 ,'jojo, stand' ,'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (2,'queen','killer','josuke','is that a jojos reference');
--
--INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('what is java', 1 ,'jojo, stand' ,'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (3,'queen','killer','josuke','is that a jojos reference');
--INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('what is python', 1 ,'jojo, stand' ,'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (4,'queen','killer','josuke','is that a jojos reference');
--INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('who is the mystery man', 1 ,'jojo, stand' ,'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (5,'queen','killer','josuke','is that a jojos reference');
--INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('what are these questions?', 1 ,'jojo, stand' ,'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (6,'queen','killer','josuke','is that a jojos reference');
--INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('computer geeks are immune to what?', 1 ,'jojo, stand' ,'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (7,'queen','killer','josuke','is that a jojos reference');
--INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('what is the base of blue', 1 ,'jojo, stand' ,'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (8,'queen','killer','josuke','is that a jojos reference');
--INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('where are my blue berries', 1 ,'jojo, stand' ,'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (9,'queen','killer','josuke','is that a jojos reference');
--INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('but did you die?', 1 ,'jojo, stand' ,'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (10,'I am sorry','killer','josuke','is that a jojos reference');
--INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('who is that again?', 1 ,'jojo, stand' ,'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (11,'paris','killer','josuke','is that a jojos reference');
--INSERT INTO QUESTIONS (QUESTION, DIFFICULTY, TOPICS, Q_TYPE) values ('did you watch the x files', 1 ,'jojo, stand' ,'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2,CHOICE3) values (12,'yes','killer','josuke','is that a jojos reference');
--INSERT INTO QUESTIONS (QUESTION, TOPICS, DIFFICULTY, Q_TYPE) 
--				values ('what does the fox say?', 
--				'fox', 13, 'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) 
--				values (13, 
--				'higa', 'pain', 'kon');



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
