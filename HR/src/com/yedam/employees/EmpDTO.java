package com.yedam.employees;

import java.sql.Date;

public class EmpDTO {
	//어떤 테이블을 연결할 건지!!
	//EmployeesTable에 대한 정보를 담는 객체로 사용
	//DTO = Data Transfer Object (순수 정보)
	//VO = Value Object (정보 + 기능 조금)
	//Beans = DTO, VO
	
	
	//Developer 에서 employees DESC 조회
	
//	EMPLOYEE_ID    NOT NULL NUMBER(6)
	private int employeeId; //NUMBER 타입이라 int + 합성어의 경우 _를 쓰지 않고 대문자로 구분 > 관례임
//	FIRST_NAME              VARCHAR2(20) 
	private String firstName;
//	LAST_NAME      NOT NULL VARCHAR2(25)
	private String lastName;
//	EMAIL          NOT NULL VARCHAR2(25)
	private String email;
//	PHONE_NUMBER            VARCHAR2(20)
	private String phoneNumber;
//	HIRE_DATE      NOT NULL DATE
	private Date hireDate; //Date 오류나면 java.sql로 적용
//	JOB_ID         NOT NULL VARCHAR2(10) 
	private String jobId;
//	SALARY                  NUMBER(8,2)
	private double salary;
//	COMMISSION_PCT          NUMBER(2,2)
	private double commissionPct;
//	MANAGER_ID              NUMBER(6)
	private int managerId;
//	DEPARTMENT_ID           NUMBER(4)  
	private int departmentId;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommissionPct() {
		return commissionPct;
	}
	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	
	
}
