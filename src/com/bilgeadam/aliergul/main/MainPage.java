package com.bilgeadam.aliergul.main;

import com.bilgeadam.aliergul.controller.ControllerCSVTransfer;
import com.bilgeadam.aliergul.language.ChooseLanguage;
import com.bilgeadam.aliergul.main.menuartistbysearch.MenuArtistBySearch;
import com.bilgeadam.aliergul.main.menucategorybysearch.MenuCategoryBySearch;
import com.bilgeadam.aliergul.main.menutitlebysearch.MenuTitleBySearch;
import com.bilgeadam.aliergul.main.menuyearsbysearch.MenuYearsBySearch;
import com.bilgeadam.aliergul.server.ClientTSV;
import com.bilgeadam.aliergul.server.MyServer;
import com.bilgeadam.aliergul.util.helper.MenuBuilder;

public enum MainPage {
	getInstance;
	
	private ChooseLanguage language = ChooseLanguage.getInstance;
	
	public void showMenu() {
		MenuBuilder mainMenu = mainMenuCreated();
		ControllerCSVTransfer csv = new ControllerCSVTransfer();
		if (!csv.isThereDatabase()) {
			System.err.println(language.LOG_READABLE_DATABASE_NOT_FOUND());
			csv.transferCsvoDatabase();
		} else {
			System.out.println(language.LOG_READABLE_DATABASE_FOUND());
		}
		int choose = -1;
		while ((choose = mainMenu.show().readInteger()) != 0) {
			switch (choose) {
				case 1:
					MenuYearsBySearch.getInstance.searchByYears();
					break;
				case 2:
					MenuCategoryBySearch.getInstance.searchCategory();
					break;
				case 3:
					MenuTitleBySearch.getInstance.searchByTitleName();
					break;
				case 4:
					MenuArtistBySearch.getInstance.searchByArtistName();
					break;
				case 5:
					language.changeLanguage();
					mainMenu = mainMenuCreated();
					break;
				case 6:
					csv.transferCsvoDatabase();
					break;
				case 0:
					
					break;
				
				default:
					break;
			}
		}
		ClientTSV client = new ClientTSV();
		client.requestArtistSearch(MyServer.EXIT);
	}
	
	private MenuBuilder mainMenuCreated() {
		
		return new MenuBuilder.Builder().title(language.APP_NAME()).body(language.APP_NAME_BODY())
				.addMenu(1, language.MENU_SEARCH_BY_YEAR()).addMenu(2, language.MENU_SEARCH_BY_CATEGORY())
				.addMenu(3, language.MENU_SEARCH_BY_NAME()).addMenu(4, language.MENU_SEARCH_BY_ARTIST_NAME())
				.addMenu(5, language.MENU_LANGUAGE(5)).addMenu(6, language.MENU_RELOAD_DATABASE())
				.selectMessage(language.MENU_EXIT()).build();
	}
	
}
