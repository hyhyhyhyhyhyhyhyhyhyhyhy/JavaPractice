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
			String sql = "INSERT INTO member VALUES (?,?,?,?,sysdate,null)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPw());
			pstmt.setInt(4, member.getMobile());
			
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("!!WELCOME TO 믓GYM!! \n 회원가입이 완료되었습니다. 로그인 후 이용하세요.");
				System.out.println();
			}else {
				System.out.println("가입이 정상적으로 완료되지 않았습니다. 다시 한번 진행해주세요.");
				System.out.println();
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
			String sql = "SELECT * FROM member WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setName(rs.getString("name"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setSignDate(rs.getDate("sign_date"));
//				member.setStartDate(rs.getDate("start_date"));
//				member.setExpireDate(rs.getDate("expire_date"));
				member.setGrade(rs.getString("grade"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
	}
	
	
	//관리자 - 전체 조회
	public List<Member> getMemberList(){
		List<Member> list = new ArrayList<Member>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT m.id, m.name, mobile, start_date, expire_date, m.grade, pt_trainer, pt_total, pt_left\r\n"
					+ "FROM member m LEFT OUTER JOIN pt p\r\n"
					+ "ON m.id = p.id\r\n"
					+ "JOIN extension e\r\n"
					+ "On p.id = e.id;";
			
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
				
				list.add(member);
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	
	//관리자 - 회원명 조회(단건)
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
				member.setExtendLeft(rs.getInt("extend_left"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
	}
	
	
	//관리자 - 등급별 조회(단건)
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
	
	
	//관리자 - 회원추가
	public int memberAdd(Member member) {
		int resultM = 0;
		int resultP = 0;
		try {
			conn();
			String sql = "INSERT INTO member(id, pw, name, mobile, sign_date, regi_month, start_date, grade)"
					+ "VALUES (?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getMobile());
			pstmt.setDate(5, member.getSignDate());
			pstmt.setInt(6, member.getRegiMonth());
			pstmt.setDate(7, member.getStartDate());
			pstmt.setString(8, member.getGrade());
			
			resultM = pstmt.executeUpdate();
			
			if(member.getGrade().equals("P")) {
				String sql2 = "INSERT INTO pt (pt_trainer, pt_total, pt_ing)"
						+ "VALUES(?,?,?)";
				
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, member.getPtTrainer());
				pstmt.setInt(2, member.getPtTotal());
				pstmt.setInt(3, member.getPtIng());
				
				resultP = pstmt.executeUpdate();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return resultM + resultP;
	}
	
	
	//관리자 - 회원 삭제
	
	public int memberDelete(String name) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM member WHERE name = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//사용자 - 비밀번호 수정
	
	 public int userPwUpdate(Member member) {
		 int result = 0;
		 try {
			 conn();
			 String sql = "UPDATE member set pw = ? where id = ?";
			 
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, member.getPw());
			 pstmt.setString(2, member.getId());
			 
			 result = pstmt.executeUpdate();
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 disconn();
		 }
		 return result;
	 }
	
	
	//사용자 - 연락처 수정
	 
	 public int userMobileUpdate(Member member) {
		 int result = 0;
		 try {
			 conn();
			 String sql = "UPDATE member set mobile = ? where id = ?";
			 
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, member.getMobile());
			 pstmt.setString(2, member.getId());
			 
			 result = pstmt.executeUpdate();
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 disconn();
		 }
		 return result;
	 }
	
	
	
	
}
