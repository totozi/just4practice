package com.mycom.myapp.designpattern.singleton;

import java.util.Calendar;

public class Test {
	public static void main(String[] args) {
		ConnectionPool instance1 = ConnectionPool.getInstance();
		ConnectionPool instance2 = ConnectionPool.getInstance();
		
		// 여러개를 가져와도 같음 
		System.out.println(instance1 == instance2);
		
//		Calendar calendar = new Calendar(); // error
		Calendar calendar = Calendar.getInstance(); // singleton
		
	}

}
