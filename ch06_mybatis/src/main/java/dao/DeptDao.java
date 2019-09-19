package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVo;

public class DeptDao {
	SqlSession sqlSession;
	//SqlSession == SqlTemplate 클래스도 사용 가능
	
	//SqlSession : 인터페이스
	//SqlTemplate : SqlSession 의 구현글래스
	
	public void setSqlSession(SqlSession s) {
		sqlSession = s;
	}
	
	public List<DeptVo> selectList(){
									//id값
		return sqlSession.selectList("dept.dept_list");
	}
	public int insert(DeptVo vo) {
		int result = sqlSession.insert("dept.dept_insert",vo);
		System.out.println("추가된 행 개수 : " +result);
		return result;
	}
	public int delete(int idx) {
		return sqlSession.delete("dept.dept_delete",idx);
	}

}