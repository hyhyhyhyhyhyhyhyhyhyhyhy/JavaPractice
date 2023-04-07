package com.yedam.Student;

import lombok.Data;

@Data

public class Student {
	
//	STUDENT_ID   NOT NULL NUMBER       
//	STUDENT_NAME          VARCHAR2(12) 
//	MAJOR                 VARCHAR2(50) 
//	GRADE                 NUMBER  s
	
	private int studentID;
	private String studentName;
	private String major;
	private int grade;
	
	
	
}
