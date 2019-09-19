package com.lsg.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.lsg.domain.MemberVo;

public class MemberDaoImpl implements MemberDao{
	
	@Inject
	private SqlSession sql;
	
	//����
	private static String namespace = "v";
	
	//ȸ������
	@Override
	public void signup(MemberVo vo)throws Exception{
		sql.insert(namespace + ".signup",vo);
	}
	
	//�α���
	@Override
	public MemberVo signin(MemberVo vo)throws Exception{
		return sql.selectOne(namespace+".signin",vo);
	}

}
