package com.lsg.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.lsg.domain.MemberVo;
import com.lsg.persistence.MemberDao;
@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDao dao;

	//회원가입
	@Override
	public void signup(MemberVo vo) throws Exception {
		dao.signup(vo);
		
	}
	//로그인
	@Override
	public MemberVo signin(MemberVo vo) throws Exception {
		
		return dao.signin(vo);
	}
	//로그아웃
	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate(); //세션 정보를 제거하는 메서드
		
	}
	
	

}
