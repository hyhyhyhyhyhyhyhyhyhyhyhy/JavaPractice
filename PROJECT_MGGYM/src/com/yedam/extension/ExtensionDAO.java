package com.yedam.extension;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.MemberService;

public class ExtensionDAO extends DAO{
	private static ExtensionDAO extensionDao = new ExtensionDAO();
	
	private ExtensionDAO() {
		
	}
	
	public static ExtensionDAO getInstance() {
		return extensionDao;
	}
	
	
	//관리자 - 재등록 회원 수정
	
	public int memberReregi(Extension regi) {
		 int result = 0;
		 try {
			 conn();
			 String sql = "UPDATE extension\r\n"
			 		+ "set start_date = TO_DATE(?) , expire_date = ADD_months(TO_DATE(?), ?), "
			 		+ "regi_month = ?  where name = ?";
			 
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setDate(1, regi.getStartDate());
			 pstmt.setDate(2, regi.getStartDate());
			 pstmt.setInt(3, regi.getRegiMonth());
			 pstmt.setInt(4, regi.getRegiMonth());
			 pstmt.setString(5, regi.getName());
			 
			 result = pstmt.executeUpdate();
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 disconn();
		 }
		 return result;
	 }
	
	
	// + 연장가능일수 조회 메소드
	public int searchExtendDay() {
		int extension = 0;
		try {
			conn();
			String sql = "SELECT extend_left\r\n"
					+ "FROM extension\r\n"
					+ "WHERE name = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberState.getName());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
			extension = rs.getInt("extend_left");
		}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return extension;
	}
	
	
	// 연장 관련 전체 조회
	public Extension getExtendList(){

		Extension extend = null;
		try {
			conn();
			String sql = "SELECT * FROM extension WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberState.getId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				extend = new Extension();
				
				extend.setId(rs.getString("id"));
				extend.setName(rs.getString("name"));
				extend.setRegiMonth(rs.getInt("regi_month"));
				extend.setStartDate(rs.getDate("start_date"));
				extend.setExpireDate(rs.getDate("expire_date"));
				extend.setAvaExtendDay(rs.getInt("ava_extend_day"));
				extend.setAppliedDay(rs.getInt("applied_Day"));
				extend.setExtendLeft(rs.getInt("extend_left"));
				extend.setGrade(rs.getString("grade"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return extend;
	}
	
	

	
	
	
	
	
	
	
}
