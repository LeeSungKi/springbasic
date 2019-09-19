package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import vo.ImageVo;

public class ImageDao {
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession s) {
		sqlSession = s;
	}
	
	public int insert(ImageVo vo) {
		return sqlSession.insert("i.image_insert", vo);
	}
	
	public List<ImageVo> selectList() {
		return sqlSession.selectList("i.image_list");
	}
}
