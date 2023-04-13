package com.yedam.afe;

import com.yedam.common.DAO;

public class AFEDAO extends DAO{

	public static AFEDAO afeDao = new AFEDAO();
	
	private AFEDAO() {
		
	}
	
	public static AFEDAO getInstance() {
		return afeDao;
	}
	
	
	//사용자 - 연장 신청(업데이트)
	
	public int extendApplyUpdate(AFE applyExtend) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO applyforExtend (apply_no, applyer_name, extend_period, applied_date, expected_date)\r\n"
					+ "VALUES (apply_seq.nextval, ?, ?, TO_DATE(?), ADD_months(TO_DATE(?), ?))";
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, applyExtend.getApplyerName());
				pstmt.setInt(2, applyExtend.getExtendPeriod());
				pstmt.setDate(3, applyExtend.getAppliedDate());
				pstmt.setDate(4, applyExtend.getAppliedDate());
				pstmt.setInt(5, applyExtend.getExtendPeriod());
				
				result = pstmt.executeUpdate();
				
				String sql2 = "UPDATE extension SET extend_left = extend_left - ? WHERE name = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, applyExtend.getExtendPeriod());
				pstmt.setString(2, applyExtend.getApplyerName());
				
				int result2 = pstmt.executeUpdate();
				
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
//	//연장 종료 시점 조회
//	public int expectedDate(AFE expectedDate) {
//		int result = 0;
//		try {
//			conn();
//			String sql = SELECT
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			disconn();
//		}
//		return result;
//	}
	
	
	
	
	
}
