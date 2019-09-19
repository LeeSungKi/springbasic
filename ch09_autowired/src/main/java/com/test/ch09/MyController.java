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
	HttpServletRequest request; // 이 컨트롤러에게 전달된 요청메시지 (request 객체)
	
	@Autowired
	HttpSession session; // 이 컨트롤러를 요청한 클라이언트의 session 객체
	
	
	public MyController() {
		System.out.println("MyController 생성됨!");
	}
}



