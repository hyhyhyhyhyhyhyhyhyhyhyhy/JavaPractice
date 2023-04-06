package com.yedam.departments;

import java.util.List;
import java.util.Scanner;

public class DeptImpl {
	Scanner sc = new Scanner(System.in);
	//1. 전체 조회
	public void getDepartmentList() {
		List<DeptDTO> list = DeptDAO.getInstance().getDepartmentsList();
		
		System.out.println("부서번호 \t 부서명 \t 관리자ID \t 위치정보");
		for(int i = 0; i<list.size(); i++) {
			System.out.print(list.get(i).getDepartmentId() + " \t " + list.get(i).getDepartmentName() + 
					" \t " + list.get(i).getManagerId() + " \t " + list.get(i).getLocationId());
		}
	}
			
	//2. 단건 조회
	public void getDepartment() {
		System.out.print ("조회할 부서번호 > ");
		int departmentId = Integer.parseInt(sc.nextLine());
		DeptDTO dept = DeptDAO.getInstance().getDepartment(departmentId);
		
		if(dept == null) {
			System.out.println("해당 부서는 존재하지 않습니다.");
		}else {
			System.out.print("부서번호 \t 부서명");
			System.out.print(dept.getDepartmentId() + " \t " + dept.getDepartmentName());
		}
	}
	
	
	//3. 추가
	public void deptAdd() {
		DeptDTO dept = new DeptDTO();
		
		System.out.print("부서번호 > ");
		int deptId = Integer.parseInt(sc.nextLine());
		
		System.out.print("부서명 > ");
		String deptName = sc.nextLine();
		
		dept.setDepartmentId(deptId);
		dept.setDepartmentName(deptName);
		
		int result = DeptDAO.getInstance().deptAdd(dept);
		
		if(result == 1) {
			System.out.println("데이터 입력 성공");
		}else {
			System.out.println("데이터 입력 실패");
		}
	}
			
			
	//4. 수정
			
			
			
	
		
}

