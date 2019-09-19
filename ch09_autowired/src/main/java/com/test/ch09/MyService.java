package com.test.ch09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("my_service")
public class MyService {
	@Autowired
	MyDao my_dao; // 반드시 @Repository("my_dao") 이름을 같게 해줘야 자동 연결됨
	
	
	public MyService() {
		System.out.println("MyService 생성됨!");
	}
}
