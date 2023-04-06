package com.yedam.departments;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class DeptDAO extends DAO{
	
	//싱글톤 - 인스턴스가 필요할 때, 똑같은 인스턴스를 만들지 않고 기존의 인스턴스를 활용하는 것!
	//생성자가 여러번 호출되도, 실제로 생성되는 객체는 하나이며 최초로 생성된 이후에 호출된 생성자는 이미 생성한 객체를 반환시키도록 만드는 것이다
	//(java에서는 생성자를 private으로 선언해 다른 곳에서 생성하지 못하도록 만들고, 
	//getInstance() 메소드를 통해 받아서 사용하도록 구현한다)
	//한번의 new를 통해 객체를 생성한다면 메모리 낭비를 방지할 수 있고, 전역 객체로, 다른 클래스의 인스턴스가 데이터를 공유하는 것이 가능하다.
	private static DeptDAO deptDao = null;
	
	private DeptDAO() {
		
	}
	
	public static DeptDAO getInstance() {
		if(deptDao == null) {
			deptDao = new DeptDAO();
		}
		return deptDao;
	}
	
	//-------------------------------------------------------------
	
	//1. 전체 조회
	
	public List<DeptDTO> getDepartmentsList(){
		
		List<DeptDTO> list = new ArrayList<>();
		DeptDTO dept = null;
		
		try {
			conn();
			String sql = "SELECT * FROM departments";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				dept = new DeptDTO();
				
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
				
				list.add(dept);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
		}
	
	
	//------------------------------------------------------------------
	
	//2. 단건 조회 (부서 정보)
	
	public DeptDTO getDepartment(int departmentId) {
		DeptDTO dept = null;
		try {
			conn();
			
			String sql = "SELECT * FROM departments "
					+ "WHERE department_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departmentId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dept = new DeptDTO();
				
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return dept;
	}
	
	
	//3. 부서 생성
	public int deptAdd(DeptDTO dept) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO departments"
					+ "(department_id, department_name)"
					+ "VALUES (?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDepartmentId());
			pstmt.setString(2, dept.getDepartmentName());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//4. 부서 수정
	
	//5. 부서 삭제
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
