package com.yedam.extension;

import com.yedam.common.DAO;

public class ExtensionDAO extends DAO{
	private static ExtensionDAO memberDao = new ExtensionDAO();
	
	private ExtensionDAO() {
		
	}
	
	public static ExtensionDAO getInstance() {
		ExtensionDAO extensionDao = null;
		return extensionDao;
	}
	
	
	//관리자 - 재등록 회원 수정
	
	public int memberReregi(Extension regi) {
		 int result = 0;
		 try {
			 conn();
			 String sql = "UPDATE extension\r\n"
			 		+ "set start_date = TO_DATE('?') , expire_date = ADD_months(TO_DATE(?), ?), "
			 		+ "regi_month = ?  where name = ?";
			 
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setDate(1, regi.getStartDate());
			 pstmt.setDate(2, regi.getStartDate());
			 pstmt.setInt(3, regi.getRegiMonth());
			 pstmt.setInt(3, regi.getRegiMonth());
			 pstmt.setString(5, regi.getName());
			 
			 result = pstmt.executeUpdate();
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 disconn();
		 }
		 return result;
	 }
	
	
	
	
}
