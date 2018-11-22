INSERT INTO IDENTITY
	VALUES(1, '2018-11-01', '2018-11-01', 'Admin', 'admin@email.com', 'ADMIN@EMAIL.COM', '$2a$10$0J2aOmp.TkDLpMX8SpRNH.D171jC8i02Zcalng6QtfCGlM/y1luSG');
INSERT INTO IDENTITY
	VALUES(2, '2018-11-01', '2018-11-01', 'Mr. Teacher', 'teacher@email.com', 'TEACHER@EMAIL.COM', '$2a$10$0J2aOmp.TkDLpMX8SpRNH.D171jC8i02Zcalng6QtfCGlM/y1luSG');

INSERT INTO QUIZ(QUIZ_ID, CREATED_AT, UPDATED_AT, DURATION, TEACHER_ID, TITLE)
  VALUES (1, '2018-11-01', '2018-11-01', 20, 1, 'Java Language Basics Quiz');

INSERT INTO QUESTION(QUESTION_ID, CREATED_AT, UPDATED_AT, ANSWER, CONTENT, SCORE, SCORING_TYPE, TITLE, TYPE_ID, QUIZ_ID)
  VALUES (1, '2018-11-01', '2018-11-01', '',
  '    public class Test{
        public static void main(String[] args) {
            int i = 0;
            int j = i++ + ++i;
            System.out.println( j );
        }
    }', 1.0, 0, 'What will happen when you compile and run the following code?', 1, 1);
INSERT INTO QUESTION(QUESTION_ID, CREATED_AT, UPDATED_AT, ANSWER, CONTENT, SCORE, SCORING_TYPE, TITLE, TYPE_ID, QUIZ_ID)
  VALUES (2, '2018-11-01', '2018-11-01', '',
  '    public class Test{
        public static void main(String[] args) {
            int[] intArray;
            System.out.println(intArray[0]);
        }
    }', 1.0, 0, 'What will happen when you compile and run the following code?', 1, 1);

INSERT INTO QUESTION_CHOICE(QUESTION_CHOICE_ID, CREATED_AT, UPDATED_AT, CHOICE_NUMBER, CORRECT_CHOICE, DESCRIPTION, SCORE, QUESTION_ID)
  VALUES (1, '2018-11-01', '2018-11-01', 1, 1, 'Parent Hello', 0, 1);
INSERT INTO QUESTION_CHOICE(QUESTION_CHOICE_ID, CREATED_AT, UPDATED_AT, CHOICE_NUMBER, CORRECT_CHOICE, DESCRIPTION, SCORE, QUESTION_ID)
  VALUES (2, '2018-11-01', '2018-11-01', 2, 0, 'Child Hello', 0, 1);

INSERT INTO EXAM(EXAM_ID, CREATED_AT, UPDATED_AT, EXAM_DESC, EXAM_ROOM, EXAM_STATUS, SHUFFLE_TYPE, QUIZ_ID)
  VALUES (1, '2018-11-01', '2018-11-01', 'Java basic quiz', 'JAVA', 0, 1, 1);