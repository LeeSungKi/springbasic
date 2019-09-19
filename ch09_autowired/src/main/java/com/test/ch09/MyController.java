package com.test.ch09;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
	
	@Autowired
	MyService my_service; // @Service("my_service")
//	MyService service;    // @Service 
	
	@Autowired
	HttpServletRequest request; // �� ��Ʈ�ѷ����� ���޵� ��û�޽��� (request ��ü)
	
	@Autowired
	HttpSession session; // �� ��Ʈ�ѷ��� ��û�� Ŭ���̾�Ʈ�� session ��ü
	
	
	public MyController() {
		System.out.println("MyController ������!");
	}
}



