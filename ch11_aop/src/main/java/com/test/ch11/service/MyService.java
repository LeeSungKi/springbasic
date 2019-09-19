package com.test.ch11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MyDao;

@Service
public class MyService {
	@Autowired
	private MyDao dao;
	public void setDao(MyDao d) {
		dao = d;
		
	}
	public void test() {
		System.out.println("MyService¿« test()∞° Ω««‡µ !");
	}

}
