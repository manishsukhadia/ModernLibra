--<ScriptOptions statementTerminator=";"/>

CREATE TABLE student (
	ID BIGINT UNSIGNED NOT NULL,
	FIRST_NAME VARCHAR(45) NOT NULL,
	MIDDLE_NAME VARCHAR(45),
	LAST_NAME VARCHAR(45) NOT NULL,
	GENDER VARCHAR(6) NOT NULL,
	DATE_OF_BIRTH DATE NOT NULL,
	BRANCH VARCHAR(45) NOT NULL,
	ADDMISSION_YEAR VARCHAR(4) NOT NULL,
	CHALLAN_NO VARCHAR(10) NOT NULL,
	EMAIL_ID VARCHAR(50) NOT NULL,
	MOBILE_NO VARCHAR(10) NOT NULL,
	UNIQUE_ID VARCHAR(20) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE=MyISAM;

CREATE TABLE branch (
	ID INTEGER UNSIGNED NOT NULL,
	BRANCH_NAME VARCHAR(45) NOT NULL,
	DURATION VARCHAR(2) NOT NULL,
	NUMBER_OF_SEMESTER VARCHAR(2) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE=InnoDB;

