package com.lsg.persistence;

import com.lsg.domain.MemberVo;

public interface MemberDao {
	
	//ȸ������
	public void signup(MemberVo vo) throws Exception;
	
	//�α���
	public MemberVo signin(MemberVo vo) throws Exception;

}
