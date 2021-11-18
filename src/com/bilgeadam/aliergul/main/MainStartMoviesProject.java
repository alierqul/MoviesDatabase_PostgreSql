package com.bilgeadam.aliergul.main;

import com.bilgeadam.aliergul.server.MyServerStart;

public class MainStartMoviesProject {
	public static void main(String[] args) {
		
		MyServerStart.getInstance.startServerThread();
		
		MainPage.getInstance.showMenu();
	}
}
