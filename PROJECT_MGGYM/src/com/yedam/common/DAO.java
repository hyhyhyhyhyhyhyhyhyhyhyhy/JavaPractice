package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	//DAO -> Data Access Object (DB에 연결)
	//JDBC를 연결할 예정
	//1) ojdbc를 추가 (build path로)
	//2) DAO
	
	//java -> DB 연결할 때 쓰는 객체
	protected Connection conn = null;
	
	//Select(조회) 결과값을 반환 받는 객체
	//Select한 결과를 Java로 전달
	protected ResultSet rs = null;
	
	//Query문을(Sql) 가지고 실행하는 객체
	//1) sql문 실행해주는 객체
	protected PreparedStatement pstmt = null;
	
	//2) sql문 실행해주는 객체
	protected Statement stmt = null;
	
	//DB 접속 정보 (구글에 JDBC 연결치면 코드 나옴)
	String driver = "oracle.jdbc.driver.OracleDriver"; //연결할때 어떤 드라이브로 연결할 건지 도구 선택
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Java와 오라클연결
														// localhost(means 접속 IP = 127.0.0.1 내 아이피): 1521(means DB서버로 연결할 포트 번호): xe(어떤 DB를 쓸 건지 DB 설정(SID)을 나타냄 xe는 DB이름이다.)
														// developer에서 인사관리 속성을 들어가면 확인 가능
														// 네트워크가 같을 경우 방화벽만 잘 해제되어 있다면, 아이피, 포트번호, DB 정보만 알고 있으면, 다른 사람의 데이터를 가져와서 공유해 쓸 수 있음
														// IP, PORT 개념을 중요하게 알고 있어야 함! >> 1. 연결(접속) 2.보안(특정 아이피 차단 등) 을 할 수 있음
	String id = "mggym";
	String pw = "mggym"; //developer의 테이블에 연결할 user 로그인 정보 입력
	
	//DB 연결
	public void conn() { //내가 설정한 경로를 못 찾을까봐 예외 처리문을 써야함
		try {
			//1. 드라이버 로딩 (읽어오기)
			Class.forName(driver);
			//2. DB 연결
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//DB 연결 해제
	public void disconn() { //실행 할 때, 연결 > Select > 결과 였기 때문에, 해제 할 때는 역순으로 연결 해제 하면 됨.
		try {
			//결과 조회 하는 객체 (!= null 의 뜻은 한번이라도 실행했을 때 연결 해제 해라 라는 것임)
			if(rs != null) {
				rs.close();
			}
			//sql 실행하는 객체
			if(stmt != null) {
				stmt.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			//DB 연결 객체
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
