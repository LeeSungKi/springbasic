package dao;

import org.springframework.stereotype.Repository;

@Repository 
//데이터 관리 객체 : Repository어노테이션이 있어야 추후에 현재 클래스의 자동생성이 가능.
public class DeptDAO {
	
	public DeptDAO() {
		
		System.out.println("--DeptDAO의 생성자--");
	}

}
