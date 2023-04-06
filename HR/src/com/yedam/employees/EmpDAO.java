package com.yedam.employees;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class EmpDAO extends DAO{ //접속정보는 DAO에 있기 때문에 상속 받기
	//java -> JDBC -> DB -> Employees Table 에 접근
	//Employees 조회, 추가, 수정, 삭제 (CRUD)
	
	//SingleTon 테이블에 많은 관리자가 접근하면 과부하가 걸리기 때문에 싱글톤을 사용해서 하나의 관리자가 테이블에 접근할 수 있도록
	private static EmpDAO empDao = null; // static을 쓰는 이유, employees 테이블에 접근할 때만 
	
	private EmpDAO() {
		
	}
	
	public static EmpDAO getInstance() {
		if(empDao == null) { //empDao를 한 번이라도 조회하면
			empDao = new EmpDAO(); //CRUD를 쓰기 위해 객체를 생성
		}
		return empDao; //필드와 메소드(CRUD를 할 수 있는) 사용 가능
	}
	
	
	//CRUD
	
	//1. 전체 조회
	//SELECT * FROM employees;
	//EmpDTO 객체 1개 = 1개의 row
	//list => empDTO 객체를 담아서 사용 => 전체 row를 조회
	
	public List<EmpDTO> getEmployeesList(){
		//list, set, map
		//list -> 순서
		
		List<EmpDTO> list = new ArrayList<>();
		//list[0] -> 첫번째 row
		//list[1] -> 두번째 row...
		EmpDTO emp = null;
		
		//DB 연결 후 
		try {
			conn();
			String sql = "SELECT * FROM employees";
			//Select문 사용시
			//1. statement => where 조건이 없으면 쓰기 편함
				//"SELECT * FROM employees where hire_date" + data
			//2. preparedStatement => where 조건이 있어도 쓰기 편함
			
			stmt = conn.createStatement();
			
			//SQL 실행
			rs = stmt.executeQuery(sql); //조회 결과를 rs에 넣어줘라
			
			//sql 결과 조회
			//ResultSet -> next() - 다음 row가 존재하면 true, 아니면 false
			while(rs.next()) {
				//List에 서로 다른 사원들의 정보, 즉 서로 다른 객체를 계속 생성해서 넣어주기 위해 = 서로다른 row를 서로 다른 객체에 저장하기 위해서
				emp = new EmpDTO();
				
				emp.setEmployeeId(rs.getInt("employee_id")); // ★★★ ""안에는 테이블의 내용이 아닌 무!조!건! 조회된 결과에 있는 column 명을 써야함
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setHireDate(rs.getDate("hire_date")); // 필요하면 employees 테이블의 데이터 추가로 더 넣어서 조회하면 됨
				
				// + 한가지 문자는 따로 getChar 가 없어서 문자열로 받아야함 
				
				list.add(emp); //리스트에 조회한 데이터를 넣어줌
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn(); // query문 실행 후 무조건 닫아줘야함, 문제가 생겨도 생긴대로 접속 해제됨
		}
		
		return list; // 조회된 결과 반환
	}
	
	
	//-------------------------------------------------------------------------------------------------------------
	
	//2. 단건 조회
	public EmpDTO getEmployee(int employeeId) {
		EmpDTO emp = null; //null로 하는 이유?
		try {
			conn();
			
			String sql = "SELECT * FROM employees "
					+ "WHERE employee_id = ?"; // 연결할 때 이 쿼리문을 넣어서 준비
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employeeId); //(물음표가 있는 순서, 숫자넣고 실행시켰을 때 매개변수)
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp = new EmpDTO();
				
				emp.setEmployeeId(rs.getInt("employee_id")); 
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setHireDate(rs.getDate("hire_date"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			disconn();
		}
		//emp == null -> rs.next() == false -> 데이터 조회 X
		//emp != null -> rs.next() == true -> 데이터 조회 O
		return emp;
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------
	
	//3. 추가
	public int empAdd(EmpDTO emp) { //int인 이유는 developer에서 수정이 되면 1행이 삭제, 업데이트 등 숫자를 반환함 이 숫자를 사용해서 만드는 것
		//데이터 입력 후 제대로 들어갔는지 사용하기 위한 용도
		//1행이 입력되었습니다.
		//result = 1; 이렇게 들어가는 것
//					EMPLOYEE_ID    NOT NULL NUMBER(6)    
//					LAST_NAME      NOT NULL VARCHAR2(25) 
//					EMAIL          NOT NULL VARCHAR2(25) 
//					HIRE_DATE      NOT NULL DATE         
//					JOB_ID         NOT NULL VARCHAR2(10)    
		int result = 0;
		try {
			conn();
			
			String sql = "INSERT INTO employees"
					+ "(employee_id, last_name, email, hire_date, job_id)"
					+ "VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getLastName());
			pstmt.setString(3, emp.getEmail());
			pstmt.setDate(4, emp.getHireDate());
			pstmt.setString(5, emp.getJobId());
			
			//DML 사용할 때 쓰는 메소드
			//반환 1 또는 0
			//1 : 데이터 정상 입력
			//0 : 데이터 입력 안됨
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result; 
		}
	
	
	//-------------------------------------------------------------------------------------------------------------------
	
	//4. 수정
	public int empUpdate(EmpDTO emp) {
		int result = 0;
		try {
			conn();
			
			String sql = "UPDATE employees SET salary = ? where employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDouble(1, emp.getSalary());
			pstmt.setInt(2, emp.getEmployeeId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	
	//-------------------------------------------------------------------------------------------------------------------
	
	//5. 삭제
	//데이터 하나만 지우고 싶을 땐 중복값이 없는 데이터를 지워야 함 > 프라이머리키 또는 유니크 (중복을 허용하지 않음)
	public int empDelete(int employeeId) {
		int result = 0;
		try {
			conn();
			
			String sql = "DELETE FROM employees WHERE employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
