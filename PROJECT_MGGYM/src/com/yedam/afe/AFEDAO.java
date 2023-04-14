package com.yedam.afe;

import java.util.ArrayList;
import java.util.List;

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
					+ "VALUES (apply_seq.nextval, ?, ?, TO_DATE(?, 'YY/MM/DD'), TO_DATE(?, 'YY/MM/DD') + ?)";
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, applyExtend.getApplyerName());
				pstmt.setInt(2, applyExtend.getExtendPeriod());
				pstmt.setDate(3, applyExtend.getAppliedDate());
				pstmt.setDate(4, applyExtend.getAppliedDate());
				pstmt.setInt(5, applyExtend.getExtendPeriod());
				
				result = pstmt.executeUpdate();
				
				String sql2 = "UPDATE extension SET expire_date = expire_date + ?, "
						+ "applied_day = applied_day + ?, extend_left = extend_left - ? "
						+ "WHERE name = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, applyExtend.getExtendPeriod());
				pstmt.setInt(2, applyExtend.getExtendPeriod());
				pstmt.setInt(3, applyExtend.getExtendPeriod());
				pstmt.setString(4, applyExtend.getApplyerName());
				
				result = pstmt.executeUpdate();
				
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
	
	//관리자 - 연장 신청 조회
	public List<AFE> viewExtendList(){
		List<AFE> list = new ArrayList<AFE>();
		
		AFE afe = null;
		try {
			conn();
			String sql= "SELECT * FROM applyforExtend ORDER BY apply_no DESC";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				afe = new AFE();
				
				afe.setApplyNo(rs.getInt("apply_no"));
				afe.setApplyerName(rs.getString("applyer_name"));
				afe.setExtendPeriod(rs.getInt("extend_period"));
				afe.setAppliedDate(rs.getDate("applied_date"));
				afe.setExpectedDate(rs.getDate("expected_date"));
				
				list.add(afe);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	
	
	
	
	
	
}
