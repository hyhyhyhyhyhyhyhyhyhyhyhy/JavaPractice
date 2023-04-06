package com.yedam.employees;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EmpImpl {
	Scanner sc = new Scanner(System.in); //단건 조회시 입력 받은 걸 조회하기 위해

	//EmpDAO에서 실행한 쿼리문을 Java에서 활용하는 부분
	
	//1.전체 조회
	public void getEmployeesList() {
		//싱글톤을 활용해 getEmployeesList 사용
		List<EmpDTO> list = EmpDAO.getInstance().getEmployeesList();
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println("사번 : " + list.get(i).getEmployeeId());
			System.out.println("이름 : " + list.get(i).getLastName());
			System.out.println("급여 : " + list.get(i).getSalary());
			System.out.println("입사일 : " + list.get(i).getHireDate());
			
		}
	}
	
	//2. 단건 조회
	public void getEmployee() {
		System.out.print("조회할 사번> ");
		int employeeId = Integer.parseInt(sc.nextLine());
		EmpDTO emp = EmpDAO.getInstance().getEmployee(employeeId);
		
		if(emp == null) {
			System.out.println("해당 사번은 존재하지 않습니다."); //예외처리하지 않으면, 실행이 되지 않고 컴파일러 오류로 뜸 EmpDAO 에서 null로 설정했기 때문에
		}else {
		System.out.println("사번 : " + emp.getEmployeeId());
		System.out.println("이름 : " + emp.getLastName());
		System.out.println("급여 : " + emp.getSalary());
		System.out.println("입사일 : " + emp.getHireDate());
		}
	}
	
	
	//3. 추가
	public void empAdd() {
		EmpDTO emp = new EmpDTO();
		
		System.out.print("사번 > ");
		int empId = Integer.parseInt(sc.nextLine());
		
		System.out.print("이름 > ");
		String empName = sc.nextLine();
		
		System.out.print("이메일 > ");
		String empEmail = sc.nextLine();
		
		System.out.print("입사일 > ");
		Date empDate = Date.valueOf(sc.nextLine()); //내가 입력한 문자열을 날짜로 바꿔주는 것
		
		System.out.print("직책 > ");
		String empJob = sc.nextLine();
		
		emp.setEmployeeId(empId);
		emp.setLastName(empName);
		emp.setEmail(empEmail);
		emp.setHireDate(empDate);
		emp.setJobId(empJob);	
		
		int result = EmpDAO.getInstance().empAdd(emp);
		
		if(result == 1) {
			System.out.println("데이터 입력 성공");
		}else {
			System.out.println("데이터 입력 실패");
		}
	}
	
	
	//4. 수정
	public void empUpdate() {
		EmpDTO emp = new EmpDTO();
		System.out.print("사번 > ");
		int empId = Integer.parseInt(sc.nextLine());
		System.out.print("수정 급여 > ");
		double empSalary = Double.parseDouble(sc.nextLine());
		
		emp.setEmployeeId(empId);
		emp.setSalary(empSalary);
		
		int result = EmpDAO.getInstance().empUpdate(emp);
		
		if(result > 0) {
			System.out.println("내용 수정 성공");
		}else {
			System.out.println("내용 수정 실패");
		}
	}
	
	
	//5. 삭제
	public void empDelete() {
		System.out.print("삭제 사번 > ");
		int empId = Integer.parseInt(sc.nextLine());
		
		int result = EmpDAO.getInstance().empDelete(empId);
		
		if(result > 0) {
			System.out.println("정상 삭제");
		}else {
			System.out.println("삭제 실패");
		}
	}
	
	
	
	
	
	
	
}
