package com.yedam.customer;

import java.util.Scanner;

public class CustomerService {

	//로그인 정보
	public static Customer customerInfo = null;
	Scanner sc = new Scanner(System.in);
	
	//로그인
	public void login() {
		Customer customer = new Customer();
		
		System.out.print("ID > ");
		int id = Integer.parseInt(sc.nextLine());
		
		System.out.print("PW > ");
		String pw = sc.nextLine();
		
		customer = CustomerDAO.getInstance().login(id);
		
		if(customer != null) {
			if(pw.equals(customer.getCustomerPw())) {
				System.out.println("로그인 성공");
				customerInfo = customer;
			}else {
				System.out.println("패스워드 오류");
			}
		}else {
			System.out.println("아이디 오류");
		}
	}
	
	
	public void logout() {
		if(customerInfo != null) {
			customerInfo = null;
			System.out.println("로그아웃되었습니다.");
		}
	}
	
	
	public void customerAdd() {
//		CUSTOMER_ID    NOT NULL NUMBER       
//		CUSTOMER_PW             VARCHAR2(20) 
//		CUSTOMER_NAME           VARCHAR2(12) 
//		ACCOUNT_ID              NUMBER       > 은행원
//		CUSTOMER_GRADE          CHAR(1)      > SQL
		
		System.out.print("ID > ");
		int customerId = Integer.parseInt(sc.nextLine());
		
		System.out.print("PW > ");
		String customerPw = sc.nextLine();
		
		System.out.print("이름 > ");
		String customerName = sc.nextLine();
		
		Customer customer = new Customer();
		
		customer.setCustomerId(customerId);
		customer.setCustomerPw(customerPw);
		customer.setCustomerName(customerName);
		
		CustomerDAO.getInstance().customerAdd(customer);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
