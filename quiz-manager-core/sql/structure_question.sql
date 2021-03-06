--CREATE TABLE QUESTION(ID INT AUTO_INCREMENT PRIMARY KEY, DIFFICULTY INT);
--ALTER TABLE QUESTION ADD COLUMN QUESTION VARCHAR(1024);

CREATE TABLE ADMIN(ID INT AUTO_INCREMENT PRIMARY KEY,  NAME VARCHAR(1024), PASSWORD);
CREATE TABLE STUDENTS(ID INT AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(1024));

CREATE TABLE STUDENT_ANSWER (ID INT AUTO_INCREMENT PRIMARY KEY, Q_ID INT, ANSWER VARCHAR(1024),S_ID INT,
					foreign key (Q_ID) references QUESTIONS(ID),
					foreign key (S_ID) references STUDENTS(ID)
);

CREATE TABLE QUESTIONS(ID INT AUTO_INCREMENT PRIMARY KEY, 
					QUESTION VARCHAR(1024), TOPICS VARCHAR(1024), Q_TYPE VARCHAR(1024), DIFFICULTY INT);
CREATE TABLE MCQ_QUESTION(ID INT AUTO_INCREMENT PRIMARY KEY, Q_ID INT, ANSWER VARCHAR(1024), 
					CHOICE1 VARCHAR(1024), CHOICE2 VARCHAR(1024), 
					CHOICE3 VARCHAR(1024),
					foreign key (Q_ID) references QUESTIONS(ID)
);
--ALTER TABLE MCQ_QUESTION
--    ADD FOREIGN KEY (Q_ID) 
--    REFERENCES Q_ID(ID)
CREATE TABLE OPEN_QUESTION(ID INT AUTO_INCREMENT PRIMARY KEY,Q_ID INT,  ANSWER VARCHAR(1024),
 foreign key (Q_ID) references QUESTIONS(ID)
);