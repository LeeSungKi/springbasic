package com.test.ch09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("my_service")
public class MyService {
	@Autowired
	MyDao my_dao; // �ݵ�� @Repository("my_dao") �̸��� ���� ����� �ڵ� �����
	
	
	public MyService() {
		System.out.println("MyService ������!");
	}
}
