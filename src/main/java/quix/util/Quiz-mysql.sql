USE Quiz;

drop table if exists Choice; 
CREATE TABLE Choice (
	CHOICE_ID int PRIMARY KEY NOT NULL auto_increment,
	CHOICE_STRING varchar(255) NOT NULL,
	IF_CORRECT bit NOT NULL,
	QUESTION_ID int NOT NULL
);

drop table if exists Feedback;
CREATE TABLE Feedback(
	FEEDBACK_ID int PRIMARY KEY NOT NULL auto_increment,
	RATING int NULL,
	FEEDBACK_STRING varchar(30) NULL,
	QUIZ_ID int NOT NULL
);

drop table if exists Question;
CREATE TABLE Question(
	QUESTION_ID int PRIMARY KEY NOT NULL auto_increment,
	QUESTION_TYPE varchar(5) NOT NULL,
	QUESTION_STRING varchar(255) NOT NULL,
	QUIZ_ID int NOT NULL,
	MODIFIED_TIME varchar(100) NULL,
	STATUS int NULL
);

drop table if exists QuizInfo;
CREATE TABLE QuizInfo(
	QUIZ_ID int PRIMARY KEY NOT NULL auto_increment,
	QUIZ_NAME varchar(30) NOT NULL,
	QUIZ_IMG varchar(30) NOT NULL,
	Quiz_DESC varchar(500) NOT NULL,
	QUIZ_COUNT int NOT NULL,
	MODIFIED_TIME varchar(100) NULL
);

drop table if exists UserAnswer;
CREATE TABLE UserAnswer(
	ANSWER_ID int PRIMARY KEY NOT NULL auto_increment,
	ANSWER_STRING varchar(255) NOT NULL,
	IF_CORRECT bit NOT NULL,
	QUESTION_ID int NOT NULL,
	SUBMISSION_ID int NOT NULL
);

drop table if exists UserGroup;
CREATE TABLE UserGroup(
	GROUP_ID int PRIMARY KEY NOT NULL auto_increment,
	GROUP_NAME varchar(30) NULL,
	GROUP_DESC varchar(30) NULL,
	GROUP_LEVEL int NOT NULL
);

drop table if exists UserInfo;
CREATE TABLE UserInfo(
	USER_ID int PRIMARY KEY NOT NULL auto_increment,
	USER_NAME varchar(30) NULL,
	USER_PASSWORD varchar(30) NULL,
	USER_STATUS int NOT NULL,
	FIRST_NAME varchar(30) NULL,
	LAST_NAME varchar(30) NULL,
	EMAIL varchar(30) NULL,
	BIRTH_DATE varchar(30) NULL,
	GROUP_ID int NOT NULL,
	ADDRESS varchar(100) NULL,
	PHONE varchar(30) NULL
);

drop table if exists UserSubmission;
CREATE TABLE UserSubmission(
	SUBMISSION_ID int PRIMARY KEY NOT NULL auto_increment,
	START_TIME varchar(100) NOT NULL,
	END_TIME varchar(100) NOT NULL,
	USER_ID int NOT NULL,
	CORRECT_COUNT int NULL,
	TOTAL_COUNT int NULL,
	QUIZ_ID int NULL
);



ALTER TABLE Choice ADD CONSTRAINT Choice_Question_QUESTION_ID_fk FOREIGN KEY(QUESTION_ID)
REFERENCES Question (QUESTION_ID);

ALTER TABLE Question ADD  CONSTRAINT Question_QuizInfo_QUIZ_ID_fk FOREIGN KEY(QUIZ_ID)
REFERENCES QuizInfo (QUIZ_ID);

ALTER TABLE UserAnswer  ADD  CONSTRAINT UserAnswer_Question_QUESTION_ID_fk FOREIGN KEY(QUESTION_ID)
REFERENCES Question (QUESTION_ID);

ALTER TABLE UserAnswer ADD  CONSTRAINT UserAnswer_UserSubmission_SUBMISSION_ID_fk FOREIGN KEY(SUBMISSION_ID)
REFERENCES UserSubmission (SUBMISSION_ID);

ALTER TABLE UserSubmission ADD  CONSTRAINT UserSubmission_QuizInfo_QUIZ_ID_fk FOREIGN KEY(QUIZ_ID)
REFERENCES QuizInfo (QUIZ_ID);

ALTER TABLE UserSubmission ADD  CONSTRAINT UserSubmission_UserInfo_USER_ID_fk FOREIGN KEY(USER_ID)
REFERENCES UserInfo (USER_ID);