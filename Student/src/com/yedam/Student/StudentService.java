package com.yedam.Student;

public class StudentService {

	
//	Scanner sc = new Scanner(System.in);
//	public void getStdList() {
//		int sum = 0;
//		List<Student> list = StudentDAO.getInstance().getStdList();
//		for(int i = 0; i<list.size(); i++) {
//			System.out.println("▷학번 : "+ list.get(i).getStdId());
//			System.out.println("▶이름 : "+list.get(i).getStdName());
//			System.out.println("▷전공 : "+list.get(i).getStdMajor());
//			System.out.println("▶점수 : "+list.get(i).getStdPoint());
//			sum += list.get(i).getStdPoint();
//			System.out.println("====================================");
//		}
//		System.out.println("☆★☆★총 점☆★☆★");
//		System.out.println(sum);
//		System.out.println("☆★☆★평 균☆★☆★");
//		System.out.println((double)sum/list.size());
//	}
//	
//	public void stdInsert() {
//		Student std = new Student();
//		System.out.println("학번>");
//		std.setStdId(Integer.parseInt(sc.nextLine()));
//		System.out.println("이름>");
//		std.setStdName(sc.nextLine());
//		System.out.println("전공>");
//		std.setStdMajor(sc.nextLine());
//		System.out.println("점수>");
//		std.setStdPoint(Integer.parseInt(sc.nextLine()));
//		
//		int result = StudentDAO.getInstance().stdInsert(std);
//		
//		if(result > 0 ) {
//			System.out.println("학생 정보 입력 성공");
//		}else {
//			System.out.println("학생 정보 입력 실패");
//		}
//	}
//	
//	public void stdUpdate() {
//		Student std = new Student();
//		System.out.println("학번>");
//		std.setStdId(Integer.parseInt(sc.nextLine()));
//		System.out.println("전공>");
//		std.setStdMajor(sc.nextLine());
//		int result = StudentDAO.getInstance().stdUpdate(std);
//		
//		if(result > 0 ) {
//			System.out.println("학생 전공 수정 성공");
//		}else {
//			System.out.println("학생 전공 수정 실패");
//		}
//	}
//	
//	public void stdDelete() {
//		int stdId = 0;
//		System.out.println("학번>");
//		stdId = Integer.parseInt(sc.nextLine());
//		
//
//		int result = StudentDAO.getInstance().stdDelete(stdId);
//		
//		if(result > 0 ) {
//			System.out.println("학생 정보 삭제 성공");
//		}else {
//			System.out.println("학생 정보 삭제 실패");
//		}
//	}
	
	
}
