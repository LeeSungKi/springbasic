package com.lsg.service;

import javax.servlet.http.HttpSession;

import com.lsg.domain.MemberVo;

public interface MemberService {
	//회원가입
	public void signup(MemberVo vo) throws Exception;
	//로그인
	public MemberVo signin(MemberVo vo)throws Exception;
	//로그아웃
	public void signout(HttpSession session)throws Exception;

}
