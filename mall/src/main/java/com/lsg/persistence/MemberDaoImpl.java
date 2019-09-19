package com.lsg.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.lsg.domain.MemberVo;

public class MemberDaoImpl implements MemberDao{
	
	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "v";
	
	//회원가입
	@Override
	public void signup(MemberVo vo)throws Exception{
		sql.insert(namespace + ".signup",vo);
	}
	
	//로그인
	@Override
	public MemberVo signin(MemberVo vo)throws Exception{
		return sql.selectOne(namespace+".signin",vo);
	}

}
