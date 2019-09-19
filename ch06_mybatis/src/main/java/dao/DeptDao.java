package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVo;

public class DeptDao {
	SqlSession sqlSession;
	//SqlSession == SqlTemplate Ŭ������ ��� ����
	
	//SqlSession : �������̽�
	//SqlTemplate : SqlSession �� �����۷���
	
	public void setSqlSession(SqlSession s) {
		sqlSession = s;
	}
	
	public List<DeptVo> selectList(){
									//id��
		return sqlSession.selectList("dept.dept_list");
	}
	public int insert(DeptVo vo) {
		int result = sqlSession.insert("dept.dept_insert",vo);
		System.out.println("�߰��� �� ���� : " +result);
		return result;
	}
	public int delete(int idx) {
		return sqlSession.delete("dept.dept_delete",idx);
	}

}