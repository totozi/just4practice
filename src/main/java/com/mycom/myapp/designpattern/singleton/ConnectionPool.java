package com.mycom.myapp.designpattern.singleton;

public class ConnectionPool {
	
	private static ConnectionPool instance = new ConnectionPool();
	
	private ConnectionPool() {}
	
	public static ConnectionPool getInstance() {
		if(instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

}
