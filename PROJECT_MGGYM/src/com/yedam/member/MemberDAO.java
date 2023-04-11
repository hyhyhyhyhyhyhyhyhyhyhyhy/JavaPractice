package com.yedam.member;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class MemberDAO extends DAO{

	private static MemberDAO memberDao = new MemberDAO();
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		return memberDao;
	}
	
	//회원가입
	
	public int memberJoin(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO member VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPw());
			pstmt.setInt(4, member.getMobile());
//			pstmt.setDate(5, member.getSignDate());
			
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("회원가입이 완료되었습니다.");
			}else {
				System.out.println("가입이 정상적으로 완료되지 않았습니다. 다시 한번 진행해주세요.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//로그인
	
	public Member login (String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setName(rs.getString("member_name"));
				member.setId(rs.getString("member_id"));
				member.setPw(rs.getString("member_pw"));
				member.setSignDate(rs.getDate("sign_date"));
				member.setStartDate(rs.getDate("start_date"));
				member.setExpireDate(rs.getDate("expire_date"));
				member.setGrade(rs.getString("member_type"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
	}
	
	
	//전체 조회
	public List<Member> getMemberList(){
		List<Member> list = new ArrayList();
		Member member = null;
		try {
			conn();
			String sql = "SELECT m.id, m.name, mobile, start_date, expire_date, \r\n"
					+ "p.grade, pt_trainer, pt_total, pt_left FROM member m JOIN pt p \r\n"
					+ "ON(m.id = p.id) \r\n";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				member = new Member();
				
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setMobile(rs.getInt("mobile"));
				member.setStartDate(rs.getDate("start_date"));
				member.setExpireDate(rs.getDate("expire_date"));
				member.setGrade(rs.getString("grade"));
				member.setPtTrainer(rs.getString("pt_trainer"));				
				member.setPtTotal(rs.getInt("pt_total"));
				member.setPtLeft(rs.getInt("pt_left"));
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	
	//회원명 조회(단건)
	public Member getSearchMember(String name) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT m.name, mobile, m.id, pw, start_date, expire_date, \r\n"
					+ "p.grade, pt_trainer, pt_left, extend_apply, extend_left"
					+ "FROM member m JOIN pt p \r\n"
					+ "ON(m.id = p.id) \r\n"
					+ "JOIN extention t \r\n"
					+ "ON(p.id = t.id)"
					+ "WHERE m.id = ? \r\n";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setName(rs.getString("name"));
				member.setMobile(rs.getInt("mobile"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setStartDate(rs.getDate("start_Date"));
				member.setExpireDate(rs.getDate("expire_date"));
				member.setGrade(rs.getString("grade"));
				member.setPtTrainer(rs.getString("pt_trainer"));
				member.setPtLeft(rs.getInt("pt_left"));
				member.setExtendApply(rs.getString("extend_apply"));
				member.setExtendLeft(rs.getInt("extend_left"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
	}
	
	
	//등급별 조회(단건)
	public Member getSearcGrade(String grade) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT m.name, mobile, start_date, expire_date, \r\n"
					+ "pt_trainer, pt_left"
					+ "FROM member m JOIN pt p \r\n"
					+ "ON(m.id = p.id) \r\n"
					+ "WHERE m.grade = ? \r\n";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, grade);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setName(rs.getString("name"));
				member.setMobile(rs.getInt("mobile"));
				member.setStartDate(rs.getDate("start_Date"));
				member.setExpireDate(rs.getDate("expire_date"));
				member.setPtTrainer(rs.getString("pt_trainer"));
				member.setPtLeft(rs.getInt("pt_left"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
