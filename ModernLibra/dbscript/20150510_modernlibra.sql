--<ScriptOptions statementTerminator=";"/>

CREATE TABLE student (
	ID BIGINT UNSIGNED NOT NULL,
	FIRST_NAME VARCHAR(45) NOT NULL,
	MIDDLE_NAME VARCHAR(45),
	LAST_NAME VARCHAR(45) NOT NULL,
	GENDER VARCHAR(6) NOT NULL,
	DATE_OF_BIRTH DATE NOT NULL,
	COURSE_ID INTEGER UNSIGNED NOT NULL,
	ADDMISSION_YEAR VARCHAR(4) NOT NULL,
	CHALLAN_NO VARCHAR(10) NOT NULL,
	EMAIL_ID VARCHAR(50) NOT NULL,
	MOBILE_NO VARCHAR(10) NOT NULL,
	UNIQUE_ID VARCHAR(30) NOT NULL,
	STATUS VARCHAR(8) NOT NULL,
	PASSWORD VARCHAR(45) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE=InnoDB;

CREATE TABLE course (
	ID INTEGER UNSIGNED NOT NULL,
	COURSE_NAME VARCHAR(45) NOT NULL,
	DURATION VARCHAR(2) NOT NULL,
	NUMBER_OF_SEMESTER VARCHAR(2) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE=InnoDB;

CREATE INDEX COURSE_ID ON student (COURSE_ID ASC);

ALTER TABLE course ADD PRIMARY KEY (ID);

ALTER TABLE student ADD CONSTRAINT COURSE_ID FOREIGN KEY (COURSE_ID)
	REFERENCES course (ID)
	ON DELETE CASCADE
	ON UPDATE CASCADE;

