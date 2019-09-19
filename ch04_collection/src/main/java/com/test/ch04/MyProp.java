package com.test.ch04;

import java.util.Properties;

public class MyProp {
	private Properties testProp;
	/*
	 * < Properties 클래스 >
	 * - HashMap과 동일 형태의 Map 계열 클래스 
	 * - 파일입출력을 지원함 
	 * - 프로퍼티 파일 (.properties)
	 * 
	 */
	public Properties getTestProp() {
		return testProp;
	}

	public void setTestProp(Properties testProp) {
		this.testProp = testProp;
	}
	
}
