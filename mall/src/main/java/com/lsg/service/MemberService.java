package com.lsg.service;

import javax.servlet.http.HttpSession;

import com.lsg.domain.MemberVo;

public interface MemberService {
	//ȸ������
	public void signup(MemberVo vo) throws Exception;
	//�α���
	public MemberVo signin(MemberVo vo)throws Exception;
	//�α׾ƿ�
	public void signout(HttpSession session)throws Exception;

}
