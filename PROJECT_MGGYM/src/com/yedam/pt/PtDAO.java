package com.yedam.pt;

import com.yedam.common.DAO;
import com.yedam.member.MemberDAO;
import com.yedam.member.MemberService;

public class PtDAO extends DAO{

	public static PtDAO ptDao = new PtDAO();
	
	private PtDAO() {
		
	}
	
	public static PtDAO getInstance() {
		return ptDao;
	}
	
	
	//관리자 - PT 회원 수정
	
	public int ptMemberUpdate(Pt ptUpdate) {
		 int result = 0;
		 try {
			 conn();
			 String sql = "UPDATE pt\r\n"
			 		+ "SET grade = ?, pt_trainer = ?, pt_total = ?, pt_ing = ?, pt_left = pt_total - pt_ing\r\n"
			 		+ "WHERE id = (SELECT id FROM member WHERE name = ?)";
			 
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, ptUpdate.getGrade());
			 pstmt.setString(2, ptUpdate.getPtTrainer());
			 pstmt.setInt(3, ptUpdate.getPtTotal());
			 pstmt.setInt(4, ptUpdate.getPtIng());
			 pstmt.setString(5, ptUpdate.getName());
			 
			 result = pstmt.executeUpdate();
			 
			 String sql2 = "UPDATE member\r\n"
			 		+ "SET grade = ?\r\n"
			 		+ "WHERE name = ?";
			 
			 pstmt = conn.prepareStatement(sql2);
			 pstmt.setString(1, ptUpdate.getGrade());
			 pstmt.setString(2, ptUpdate.getName());
			 
			 result = pstmt.executeUpdate();
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 disconn();
		 }
		 return result;
	 }
	
	
	
	
	
	
	
	
}
