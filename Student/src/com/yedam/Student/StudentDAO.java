package com.yedam.Student;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class StudentDAO extends DAO{

	
	//싱글톤
	private static StudentDAO studentDao = new StudentDAO();
	
	private StudentDAO() {
		
	}
	
	public static StudentDAO getInstance() {
		return studentDao;
	}
	
	
	//회원 조회
	public List<Student> getStudentlist(){
		List<Student> list = new ArrayList<>();
		Student student = null;
		try {
			conn();
			String sql = "SELECT * FROM student";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				student = new Student();
				
				student.setStudentID(rs.getInt("id"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	

//	
//	
//	private static CoffeDAO cofDao = null;
//	
//	private CoffeDAO() {
//		
//	}
//	
//	public static CoffeDAO getInstance() {
//		if(cofDao == null) {
//			cofDao = new CoffeDAO();
//		}
//		return cofDao;
//	}
//	
////	1. 학생 정보 조회(전체 조회)
//	public List<Coffe> getCofList(){
//		List<Coffe> list = new ArrayList<>();
//		Coffe cof = null;
//		try {
//			conn();
//			String sql = "select * from coffe";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				cof = new Coffe();
//				cof.setCofName(rs.getInt("coffe_name"));
//				cof.setCofDetail(rs.getString("coffe_detail"));
//				list.add(cof);
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			disconn();
//		}
//		return list;
//	}
//
//	
////	- 정보 조회의 경우에는 모든 학생의 점수의 총합 + 평균까지 구할 것
////	2. 학생 등록
//	public int cofInsert(Coffe cof) {
//		int result = 0;
//		try {
//			conn();
//			String sql = "insert into coffe values (?,?,?,?)";
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, cof.getCofName());
//			pstmt.setString(2, cof.getCofDetail());
//			
//			result = pstmt.executeUpdate();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			disconn();
//		}
//		return result;
//	}
//	
//	
////	3. 학생 정보 삭제
//	public int cofDelete(int cofName) {
//		int result = 0;
//		try {
//			conn();
//			String sql = "delete from coffe where coffe_name = ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, coffeName);
//			result = pstmt.executeUpdate();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			disconn();
//		}
//		return result;
//	}
//	
////	4. 전공 변경
//	public int stdUpdate(Coffe cof) {
//		int result = 0;
//		try {
//			conn();
//			String sql = "update coffe set cof_Detail =? where coffe_Name = ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, cof.getCofName());
//			pstmt.setInt(2, cof.getCofDetial());
//			
//			result = pstmt.executeUpdate();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			disconn();
//		}
//		return result;
//	}
//	
	
	
	
}
