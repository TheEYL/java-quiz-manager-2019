--SELECT * from ADMIN;
--INSERT INTO QUESTIONS (QUESTION, TOPICS, DIFFICULTY, Q_TYPE) 
--				values ('hat does the fox say?', 
--				'fox', 1, 'mcq');
--INSERT INTO MCQ_QUESTIONS (Q_ID, ANSWER, CHOICE1, CHOICE2) 
--				values (1, 
--				'higa', 'pain', 'kon');

SELECT ID from QUESTIONS WHERE QUESTION LIKE '%fox%';
SELECT a.Q_TYPE , a.QUESTION, a.TOPICS, b.* 
FROM QUESTIONS AS a 
JOIN MCQ_QUESTIONS AS b
ON a.id = b.Q_id where a.topics LIKE '%fox%';


SELECT a.Q_TYPE , a.QUESTION, a.TOPICS, b.*, c.ANSWER AS CORRECT_ANSWER 
FROM QUESTIONS AS a 
JOIN STUDENTS_ANSWERS AS b
ON a.id = b.Q_id
JOIN MCQ_QUESTIONS AS c 
ON a.id = c.Q_id;
 where b.S_NAME LIKE '%%';