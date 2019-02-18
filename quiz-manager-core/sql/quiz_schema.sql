CREATE TABLE IF NOT EXISTS ADMIN(
					ID INT AUTO_INCREMENT PRIMARY KEY, 
					NAME VARCHAR(1024),
					PASSWORD VARCHAR(1024)
					);

INSERT INTO	ADMIN (NAME, PASSWORD) VALUES ('admin', 'admin');
CREATE TABLE IF NOT EXISTS STUDENTS(
			ID INT AUTO_INCREMENT PRIMARY KEY, 
			NAME VARCHAR(1024)
			);


CREATE TABLE IF NOT EXISTS QUESTIONS(
					ID INT AUTO_INCREMENT PRIMARY KEY, 
					QUESTION VARCHAR(1024) UNIQUE,
					TOPICS VARCHAR(1024),
					Q_TYPE VARCHAR(1024),
					DIFFICULTY INT);

CREATE TABLE IF NOT EXISTS STUDENTS_ANSWERS (
					ID INT AUTO_INCREMENT PRIMARY KEY,
					Q_ID INT,
					ANSWER VARCHAR(1024),
					S_ID INT,
					foreign key (Q_ID) references QUESTIONS(ID),
					foreign key (S_ID) references STUDENTS(ID)
);

CREATE TABLE IF NOT EXISTS  MCQ_QUESTIONS(
					ID INT AUTO_INCREMENT PRIMARY KEY,
					Q_ID INT,
					ANSWER VARCHAR(1024), 
					CHOICE1 VARCHAR(1024),
					CHOICE2 VARCHAR(1024), 
					CHOICE3 VARCHAR(1024),
					foreign key (Q_ID) references QUESTIONS(ID)
);

CREATE TABLE IF NOT EXISTS  ASS_QUESTIONS(
					ID INT AUTO_INCREMENT PRIMARY KEY,
					Q_ID INT,
					KEY_PAIR VARCHAR(1024),
					foreign key (Q_ID) references QUESTIONS(ID)
);
--ALTER TABLE MCQ_QUESTION
--    ADD FOREIGN KEY (Q_ID) 
--    REFERENCES Q_ID(ID)
CREATE TABLE IF NOT EXISTS OPEN_QUESTIONS(ID INT AUTO_INCREMENT PRIMARY KEY,Q_ID INT,  ANSWER VARCHAR(1024),
 foreign key (Q_ID) references QUESTIONS(ID)
);