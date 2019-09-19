package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVo;

public class VisitDao {
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession s) {
		sqlSession = s;
	}
	
	public List<VisitVo> selectList(){
		return sqlSession.selectList("v.visit_list");
	}
	public int insert(VisitVo vo) {
		int result = sqlSession.insert("v.visit_insert",vo);
		return result;
	}
	public VisitVo selectOne(int idx) {
		return sqlSession.selectOne("v.visit_one", idx);
	}

	public int update(VisitVo vo) {
		return sqlSession.update("v.visit_update",vo);
		 
	}

	public int delete(int idx) {
		return sqlSession.delete("v.visit_delete",idx);
		
	}

	
	

	
}
