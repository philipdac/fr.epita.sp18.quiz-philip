INSERT INTO IDENTITY
	VALUES(1, 'Admin', 'admin@email.com', 'ADMIN@EMAIL.COM', '$2a$10$0J2aOmp.TkDLpMX8SpRNH.D171jC8i02Zcalng6QtfCGlM/y1luSG');
INSERT INTO IDENTITY
	VALUES(2, 'Mr. Teacher', 'teacher@email.com', 'TEACHER@EMAIL.COM', '$2a$10$0J2aOmp.TkDLpMX8SpRNH.D171jC8i02Zcalng6QtfCGlM/y1luSG');

INSERT INTO QUIZ(QUIZ_ID, DURATION, TEACHER_ID, TITLE)
  VALUES (1, 20, 1, 'Java Language Basics Quiz');

INSERT INTO QUESTION
  VALUES (1, '', 'public class Test{}', 1.0, 0, 'What will happen when you compile and run the following code?', 1, 1);
INSERT INTO QUESTION
  VALUES (2, '', 'public class Test{}', 1.0, 0, 'What will happen when you compile and run the following code?', 1, 1);

INSERT INTO QUESTION_CHOICE(QUESTION_CHOICE_ID, CHOICE_NUMBER, CORRECT_CHOICE, DESCRIPTION, SCORE, QUESTION_ID)
  VALUES (1, 1, 0, 'Parent Hello', 0, 1);
INSERT INTO QUESTION_CHOICE(QUESTION_CHOICE_ID, CHOICE_NUMBER, CORRECT_CHOICE, DESCRIPTION, SCORE, QUESTION_ID)
  VALUES (2, 2, 0, 'Child Hello', 0, 1);

INSERT INTO EXAM(EXAM_ID, EXAM_DESC, EXAM_ROOM, EXAM_STATUS, SHUFFLE_TYPE, QUIZ_ID)
  VALUES (1, 'Java basic quiz', 'JAVA', 0, 0, 1);