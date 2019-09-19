package com.lsg.persistence;

import com.lsg.domain.MemberVo;

public interface MemberDao {
	
	//회원가입
	public void signup(MemberVo vo) throws Exception;
	
	//로그인
	public MemberVo signin(MemberVo vo) throws Exception;

}
