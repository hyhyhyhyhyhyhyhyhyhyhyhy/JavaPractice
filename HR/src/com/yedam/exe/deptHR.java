package com.yedam.exe;

import java.util.Scanner;

import com.yedam.departments.DeptImpl;

public class deptHR {

	DeptImpl di = new DeptImpl();
	
	Scanner sc = new Scanner(System.in);
	
	public deptHR() {
		run();
	}
	
	private void run() {
		while(true) {
			System.out.println("1. 전체 조회 | 2. 부서 정보 조회 | 3. 부서 생성 | 4. 부서 수정 | 5. 부서 삭제 | 9. 프로그램 종료");
			System.out.print("메뉴 > ");
			int select = Integer.parseInt(sc.nextLine());
			
			if(select == 1) {
				di.getDepartmentList();
			}else if(select == 2) {
				di.getDepartment();
			}else if(select == 3) {
				di.deptAdd();
			}else if(select == 99) {
				System.out.println("end of prog");
				break;
			}
		}
	}
	
	
}
