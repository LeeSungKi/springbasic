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

	//ȸ������
	@Override
	public void signup(MemberVo vo) throws Exception {
		dao.signup(vo);
		
	}
	//�α���
	@Override
	public MemberVo signin(MemberVo vo) throws Exception {
		
		return dao.signin(vo);
	}
	//�α׾ƿ�
	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate(); //���� ������ �����ϴ� �޼���
		
	}
	
	

}
