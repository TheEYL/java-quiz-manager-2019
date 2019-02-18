--SELECT * from ADMIN;
--INSERT INTO QUESTIONS (QUESTION, TOPICS, DIFFICULTY, Q_TYPE) 
--				values ('hat does the fox say?', 
--				'fox', 1, 'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) 
--				values (1, 
--				'higa', 'pain', 'kon');

SELECT ID from QUESTIONS WHERE QUESTION LIKE '%fox%';