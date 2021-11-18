package com.bilgeadam.aliergul.server;

public enum MyServerStart {
	getInstance;
	
	private MyServer myServer = new MyServer();
	
	public void startServerThread() {
		
		Thread serverThread = new Thread(myServer);
		serverThread.start();
	}
}
