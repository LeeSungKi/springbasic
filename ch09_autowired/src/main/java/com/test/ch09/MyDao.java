package com.test.ch09;

import org.springframework.stereotype.Repository;

@Repository("my_dao") 
public class MyDao {
	public MyDao() {
		System.out.println("MyDao »ý¼ºµÊ!");
	}
}
