package com.yedam.member;

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
			
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getMemberId());
			pstmt.setString(3, member.getMemberPw());
			pstmt.setInt(4, member.getMemberMobile());
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
	
	public Member login (String memberId) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMemberName(rs.getString("member_name"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setSignDate(rs.getDate("sign_date"));
				member.setStartDate(rs.getDate("start_date"));
				member.setExpireDate(rs.getDate("expire_date"));
				member.setMemberType(rs.getString("member_type"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
	}
	
	
	//회원 등록(매니저 권한)
	
	
	
	
	
	
	
	
}
