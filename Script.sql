--2. 테이블을 만들고 JDBC 이용하여 연결하기
--	테이블명		tbl_department
--	컬럼		department_id(pk)	department_name(unique)
CREATE SEQUENCE SEQ_DEPARTMENT;
CREATE TABLE TBL_DEPARTMENT (
	department_id NUMBER PRIMARY KEY,
	department_name VARCHAR2(100) UNIQUE
);

SELECT * FROM TBL_DEPARTMENT;

----	테이블명		tbl_address
----	컬럼		address_id(pk)	address_postal_code	
----			address_line1	address link2
CREATE SEQUENCE SEQ_ADDRESS;
CREATE TABLE TBL_ADDRESS (
	address_id NUMBER PRIMARY KEY,
	address_postal_code NUMBER NOT NULL,
	address_line1 VARCHAR2(100) NOT NULL,
	address_line2 VARCHAR2(100) NOT NULL
);
SELECT * FROM TBL_ADDRESS;

--	테이블명		tbl_student
--	컬럼		student_id(pk)	student_name	student_age
--			department_id(fk)	address_id(fk)
CREATE SEQUENCE SEQ_STUDENT;
CREATE TABLE TBL_STUDENT (
	student_id NUMBER PRIMARY KEY,
	student_name VARCHAR2(20) NOT NULL,
	student_age NUMBER,
	department_id NUMBER NOT NULL,
	address_id NUMBER NOT NULL,
	CONSTRAINT FK_STUDENT_DEPARTMENT_ID FOREIGN KEY(department_id) REFERENCES TBL_DEPARTMENT(department_id),
	CONSTRAINT FK_STUDENT_ADDRESS_ID FOREIGN KEY(address_id) REFERENCES TBL_ADDRESS(address_id)
);
SELECT * FROM TBL_STUDENT;

