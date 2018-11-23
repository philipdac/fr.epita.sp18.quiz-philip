INSERT INTO IDENTITY
	VALUES(1, '2018-11-01', '2018-11-01', 'Admin', 'admin@email.com', 'ADMIN@EMAIL.COM', '$2a$10$0J2aOmp.TkDLpMX8SpRNH.D171jC8i02Zcalng6QtfCGlM/y1luSG');
INSERT INTO IDENTITY
	VALUES(2, '2018-11-01', '2018-11-01', 'Mr. Teacher', 'teacher@email.com', 'TEACHER@EMAIL.COM', '$2a$10$0J2aOmp.TkDLpMX8SpRNH.D171jC8i02Zcalng6QtfCGlM/y1luSG');

INSERT INTO QUIZ(QUIZ_ID, CREATED_AT, UPDATED_AT, DURATION, TEACHER_ID, TITLE)
  VALUES (1, '2018-11-01', '2018-11-01', 30, 1, 'Java Language Basics Quiz');

INSERT INTO QUESTION(QUESTION_ID, CREATED_AT, UPDATED_AT, ANSWER, CONTENT, SCORE, SCORING_TYPE, TITLE, TYPE_ID, QUIZ_ID)
  VALUES (1, '2018-11-01', '2018-11-01', 'The code will throw run time error. The code does not declare main method using correct syntax. Correct syntax of the main method is,

public static void main(String[] args)

The code has method named main but the argument is of type String instead of String array. Hence, the code will throw “Error: Main method not found in class Test, please define the main method as: public static void main(String[] args)” when run.',
  '    public class Test{

        public static void main(String args) {
        int i = 5, j = 2;
        System.out.println( i % j );
        }
    }', 1.0, 0, 'What will happen when you compile and run the following code?', 1, 1);
INSERT INTO QUESTION(QUESTION_ID, CREATED_AT, UPDATED_AT, ANSWER, CONTENT, SCORE, SCORING_TYPE, TITLE, TYPE_ID, QUIZ_ID)
  VALUES (2, '2018-11-01', '2018-11-01', 'exit() is not a flow control statement in Java. exit() terminates the currently running JVM.
   goto is marked as not used in Java.',
  '1. exit()
2. break
3. continue
4. goto', 1.0, 0, 'Which of the following is not a valid flow control statement?', 2, 1);

INSERT INTO QUESTION(QUESTION_ID, CREATED_AT, UPDATED_AT, ANSWER, CONTENT, SCORE, SCORING_TYPE, TITLE, TYPE_ID, QUIZ_ID)
  VALUES (3, '2018-11-01', '2018-11-01',
  'In general, String s = "Test" is more efficient to use than String s = new String("Test").

In the case of String s = "Test", a String with the value “Test” will be created in the String pool. If another String with the same value is then created (e.g., String s2 = "Test"), it will reference this same object in the String pool.

However, if you use String s = new String("Test"), in addition to creating a String with the value “Test” in the String pool, that String object will then be passed to the constructor of the String Object (i.e., new String("Test")) and will create another String object (not in the String pool) with that value. Each such call will therefore create an additional String object (e.g., String s2 = new String("Test") would create an addition String object, rather than just reusing the same String object from the String pool).',
  'What is the difference between  ___String s = "Test"___  and  ___String s = new String("Test")___ ?  ' ||
  'Which is better and why?',
   1.0, 0, 'Type your answer to the below open question:', 0, 1);

INSERT INTO QUESTION_CHOICE(QUESTION_CHOICE_ID, CREATED_AT, UPDATED_AT, CHOICE_NUMBER, CORRECT_CHOICE, DESCRIPTION, SCORE, QUESTION_ID)
  VALUES (1, '2018-11-01', '2018-11-01', 1, 1, '1', 0, 1);
INSERT INTO QUESTION_CHOICE(QUESTION_CHOICE_ID, CREATED_AT, UPDATED_AT, CHOICE_NUMBER, CORRECT_CHOICE, DESCRIPTION, SCORE, QUESTION_ID)
  VALUES (2, '2018-11-01', '2018-11-01', 2, 0, '2', 0, 1);
INSERT INTO QUESTION_CHOICE(QUESTION_CHOICE_ID, CREATED_AT, UPDATED_AT, CHOICE_NUMBER, CORRECT_CHOICE, DESCRIPTION, SCORE, QUESTION_ID)
  VALUES (3, '2018-11-01', '2018-11-01', 2, 0, 'Compilation error', 0, 1);
INSERT INTO QUESTION_CHOICE(QUESTION_CHOICE_ID, CREATED_AT, UPDATED_AT, CHOICE_NUMBER, CORRECT_CHOICE, DESCRIPTION, SCORE, QUESTION_ID)
  VALUES (4, '2018-11-01', '2018-11-01', 2, 0, 'Run time error', 0, 1);

INSERT INTO QUESTION_CHOICE(QUESTION_CHOICE_ID, CREATED_AT, UPDATED_AT, CHOICE_NUMBER, CORRECT_CHOICE, DESCRIPTION, SCORE, QUESTION_ID)
  VALUES (5, '2018-11-01', '2018-11-01', 1, 1, 'exit()', 0, 2);
INSERT INTO QUESTION_CHOICE(QUESTION_CHOICE_ID, CREATED_AT, UPDATED_AT, CHOICE_NUMBER, CORRECT_CHOICE, DESCRIPTION, SCORE, QUESTION_ID)
  VALUES (6, '2018-11-01', '2018-11-01', 2, 0, 'break', 0, 2);
INSERT INTO QUESTION_CHOICE(QUESTION_CHOICE_ID, CREATED_AT, UPDATED_AT, CHOICE_NUMBER, CORRECT_CHOICE, DESCRIPTION, SCORE, QUESTION_ID)
  VALUES (7, '2018-11-01', '2018-11-01', 2, 0, 'continue', 0, 2);
INSERT INTO QUESTION_CHOICE(QUESTION_CHOICE_ID, CREATED_AT, UPDATED_AT, CHOICE_NUMBER, CORRECT_CHOICE, DESCRIPTION, SCORE, QUESTION_ID)
  VALUES (8, '2018-11-01', '2018-11-01', 2, 1, 'goto', 0, 2);

INSERT INTO EXAM(EXAM_ID, CREATED_AT, UPDATED_AT, EXAM_DESC, EXAM_ROOM, EXAM_STATUS, SHUFFLE_TYPE, QUIZ_ID)
  VALUES (1, '2018-11-01', '2018-11-01', 'Java basic quiz', 'JAVA', 0, 1, 1);