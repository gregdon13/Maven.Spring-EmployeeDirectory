-- DROP TABLE PERSON;
--
-- CREATE TABLE PERSON (
--   ID NUMBER(10,0) NOT NULL AUTO_INCREMENT,
--   FIRST_NAME VARCHAR2(255) NOT NULL DEFAULT '',
--   LAST_NAME VARCHAR2(255) NOT NULL DEFAULT '',
--   MOBILE VARCHAR2(20) NOT NULL DEFAULT '',
--   BIRTHDAY DATE DEFAULT NULL,
--   PRIMARY KEY (ID));
--
-- DROP TABLE HOME;
--
-- CREATE TABLE HOME (
--   ID NUMBER(10,0) NOT NULL AUTO_INCREMENT,
--   ADDRESS VARCHAR2(255) not null default '',
--   HOME_NUMBER varchar2(255) NOT NULL DEFAULT '',
--   PRIMARY KEY (ID)
-- );
--
--
-- DROP TABLE CAR;
--
-- CREATE TABLE CAR (
--   ID NUMBER(10,0) NOT NULL AUTO_INCREMENT,
--   MAKE VARCHAR2(255) not null default '',
--   MODEL varchar2(255) NOT NULL DEFAULT '',
--   YEAR VARCHAR2(5) NOT NULL DEFAULT '01907',
--   PRIMARY KEY (ID)
-- );

DROP TABLE EMPLOYEE;

CREATE TABLE EMPLOYEE (
    EMPLOYEE_ID LONG NOT NULL AUTO_INCREMENT,
    FIRST_NAME VARCHAR(255) NOT NULL DEFAULT '',
    LAST_NAME VARCHAR(255) NOT NULL DEFAULT '',
    TITLE VARCHAR(255) NOT NULL DEFAULT '',
    PHONE_NUMBER VARCHAR(255) NOT NULL DEFAULT '',
    EMAIL VARCHAR(255) NOT NULL DEFAULT '',
    HIRE_DATE DATE NOT NULL,
    MANAGER_ID LONG,
    DEPARTMENT_NUMBER INTEGER NOT NULL,
    PRIMARY KEY (EMPLOYEE_ID)
);

INSERT INTO EMPLOYEE (FIRST_NAME, LAST_NAME, TITLE, PHONE_NUMBER, EMAIL, HIRE_DATE, MANAGER_ID, DEPARTMENT_NUMBER)
VALUES ('Ben', 'duPont', 'Owner', '100-100-1000', 'bendupont@zipcode.com', '2015-01-01', null, 1),
       ('Desa', 'Burton', 'Executive Director', '111-111-1111', 'desaburtion@zipcode.com', '2018-01-01', 1, 2),
       ('Kris', 'Younger', 'Lead Technical Instructor', '222-222-2222', 'krisyounger@zipcode.com', '2018-06-15', 2, 3),
       ('Dolio', 'Durant', 'Technical Instructor', '333-333-3333', 'doliodurant@zipcode.com', '2018-06-15', 2, 4),
       ('Xiong', 'Yuan', 'Junior Software Dev', '267-111-111', 'xiongyuan@zipcode.com', '2021-02-22', 3, 3),
       ('Mike', 'Ninh', 'Junior Software Dev', '267-111-1112', 'mikeninh@zipcode.com', '2021-02-22', 3, 3),
       ('Ryan', 'Hufford', 'Junior Software Dev', '215-111-111', 'ryanhufford@zipcode.com', '2021-02-22', 3, 3),
       ('Kelly', 'Porter', 'Junior Software Dev', '215-000-1110', 'kellyporter@zipcode.com', '2021-02-22', 3, 3),
       ('Greg', 'Don', 'Junior Software Dev', '267-222-1112', 'gregdon@zipcode.com', '2021-02-22', 4, 4),
       ('Ashley', 'Smart', 'Junior Software Dev', '267-555-1115', 'ashleysmart@zipcode.com', '2021-02-22', 4, 4),
       ('Chris', 'Allen', 'Junior Software Dev', '777-111-1117', 'chrisallen@zipcode.com', '2021-02-22', 4, 4),
       ('Chris', 'Nobles', 'Senior Software Dev', '777-777-7777', 'chrisnobles@villain.com', '2018-02-22', null, 420);

DROP TABLE DEPARTMENT;

CREATE TABLE DEPARTMENT (
    DEPARTMENT_NUMBER LONG NOT NULL AUTO_INCREMENT,
    DEPARTMENT_NAME VARCHAR(255) NOT NULL DEFAULT '',
    MANAGER LONG,
    PRIMARY KEY (DEPARTMENT_NUMBER)
);

DROP SEQUENCE hibernate_sequence;

CREATE SEQUENCE hibernate_sequence;