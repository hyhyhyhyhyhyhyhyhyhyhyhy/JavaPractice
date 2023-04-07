package com.yedam.account;

import com.yedam.common.DAO;
import com.yedam.customer.CustomerService;

public class AccountDAO extends DAO{

	private static AccountDAO accountDao = null;
	
	private AccountDAO() {
		
	}
	
	public static AccountDAO getInstance() {
		if(accountDao == null) {
			accountDao = new AccountDAO();
		}
		return accountDao;
	}
	
	
	//계좌 개설 - insert
	public int accountAdd(Account account) {
		int result = 0;
		try {
			conn();
			//시퀀스
			String sql = "INSERT INTO account VALUES (?,?,?,sysdate)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, account.getAccountId());
			pstmt.setInt(2, account.getCustomerId());
			pstmt.setInt(3, account.getBalance());
			
			result = pstmt.executeUpdate();
			
//			//sql 하나 더
//			if(result == 1) {
//				String sql2 = "UPDATE customer SET account_id = ? where customer_id = ?";
//				pstmt = conn.prepareStatement(sql2);
//				pstmt.setInt(1, account.getAccountId());
//				pstmt.setInt(2, account.getCustomerId());
//				
//				int result2 = pstmt.executeUpdate();
//				if(result2 == 1) {
//					System.out.println("고객 계좌 등록 완료");
//				}else {
//					System.out.println("고객 계좌 등록 실패");
//				}
//			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	
	
	//계좌 해지 (2가지 방법으로 가능)
	//- update : 계좌를 당장 삭제 x  > 3개월 뒤에 삭제 또는 해지한 히스토리 관리 필요할 때 
	//         > column '활성화/사용유무'을 만들어 ex) Y,N,L or 활성화,비활성화 등으로 표기 가능
	//- delete (v)
	
	
	public int accountDelete(int accountId) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM account WHERE account_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accountId);
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//JOIN 테이블 사용
	//1) Join 용 클래스 만들기
	//2) 기준 클래스 설정 (데이터 조회 시 좀 더 데이터가 많이 나오는 column) 
//		> join 했을 때 합쳐지는 데이터를 기준 클래스 DTO에 필드 추가하기
//	 	example ) 계좌 조회 시 고객 정보 같이 나오도록
	
	//계좌 조회 - JOIN 활용
	
	public Account getAccount() {
		Account account = null;
		try {
			conn();
			String sql = "select c.customer_id, c.customer_name, a.account_id, a.balance, a.credate\r\n"
					+ "from customer c Join account a \r\n"
					+ "on(c.customer_id = a.customer_id)\r\n"
					+ "WHERE c.customer_id = ?"; 
					// developer에서 조회하고 복사, 복사할 때 ; 복사하면 안됨, 
					// 조건 값에는 우리가 customerId를 변수로 받을거라 물음표 처리! - 은행원의 경우,
					// 본인 계좌를 조회할 때는 로그인한 사람의 정보를 가져오는 걸로 처리
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, CustomerService.customerInfo.getCustomerId()); // 로그인한 정보 가져오기
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				account = new Account();
				account.setAccountId(rs.getInt("customer_Id"));
				account.setCustomerId(rs.getInt("customer_id"));
				account.setCustomerName(rs.getString("customer_name"));
				account.setBalance(rs.getInt("balance"));
				account.setCredate(rs.getDate("credate"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return account;
	}
	
	
	
	//입출금 
	public int updateMoney (Account account, int cmd) { //cmd가 의미하는 것은 1. 입금 2. 출금의 1,2번이다.
		int result = 0;
		int balance = 0;
		try {
			conn();
			//현재 잔고를 가져오는 sql
			String sql = "SELECT balance FROM account WHERE account_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, account.getAccountId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				balance = rs.getInt("balance");
			}
			
			//1: 입금
			//2: 출금
			if(cmd == 1) {
				//현재 잔고 + 입금 금액 = 통장잔고
				//account.getbalance() + balance => 통장잔고
				account.setBalance(balance+account.getBalance()); //if절 결과값 balance 와 account 객체의 잔고
				
				String sql2 = "update account set balance = balance + ? where account_id = ?";
				pstmt = conn.prepareStatement(sql2);
				
				pstmt.setInt(1, account.getBalance());
				pstmt.setInt(2, account.getAccountId());
				
				result = pstmt.executeUpdate();
			}else if(cmd == 2) {
				//잔고 >= 출금액 일때만 실행하도록
				if(balance - account.getBalance() >= 0) {
					String sql2 = "update account set balance = balance - ? where account_id = ?";
					pstmt = conn.prepareStatement(sql2);
					
					pstmt.setInt(1, account.getBalance());
					pstmt.setInt(2, account.getAccountId());
					
					result = pstmt.executeUpdate();
					
				}else {
					System.out.println("잔고보다 출금액이 많습니다.");
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
