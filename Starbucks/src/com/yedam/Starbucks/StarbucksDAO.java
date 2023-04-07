package com.yedam.Starbucks;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class StarbucksDAO extends DAO{
	
	private static StarbucksDAO starbucksDao = new StarbucksDAO();
	
	private StarbucksDAO() {
		
	}
	
	public static StarbucksDAO getInstance() {
		return starbucksDao;
	}
	
	
	//1. 메뉴 조회
	public List<Starbucks> getMenuList(){
		List<Starbucks> list = new ArrayList<>();
		Starbucks menu = null;
		
		try {
			conn();
			String sql = "SELECT * FROM starbucks";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				menu = new Starbucks();
				
				menu.setCoffeeMenu(rs.getString("coffee_menu"));
				menu.setCoffeePrice(rs.getInt("coffee_price"));
				
				list.add(menu);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	
	//2. 상세 조회
	public Starbucks getMenuInfo(String coffeeMenu) {
		Starbucks menu = null;
		try {
			conn();
			String sql = "SELECT * FROM starbucks "
					+ "WHERE coffee_menu = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffeeMenu);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				menu = new Starbucks();
				menu.setCoffeeMenu(rs.getString("coffee_menu"));
				menu.setCoffeePrice(rs.getInt("coffee_price"));
				menu.setCoffeeExplain(rs.getString("coffee_explain"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return menu;
	}
	
	
	//3. 메뉴 등록
	public int addMenu(Starbucks menu) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO starbucks (coffee_menu, coffee_price, coffee_explain)\r\n"
					+ "VALUES (?,?,?)";
					
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, menu.getCoffeeMenu());
			pstmt.setInt(2, menu.getCoffeePrice());
			pstmt.setString(3, menu.getCoffeeExplain());
			
			result = pstmt.executeUpdate();
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//4. 판매
	public int sellMenu(String coffeeMenu) {
		int result = 0;
		
		return result;
	}
	
	
	//5. 메뉴 삭제
	
	public int deleteMenu(String coffeeMenu) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM starbucks WHERE coffee_menu = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffeeMenu);
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//6. 매출
	

	
	
	
	
	
	
	
	
}
