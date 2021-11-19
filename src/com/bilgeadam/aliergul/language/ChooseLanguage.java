package com.bilgeadam.aliergul.language;

import java.util.Arrays;
import java.util.List;

public enum ChooseLanguage {
	getInstance;
	
	private GlobalStrings defaultLanguage = new GlobalStrings("tr");
	private GlobalStrings en = new GlobalStrings("en");
	private GlobalStrings tr = new GlobalStrings("tr");
	private List<String> listCategory_tr = Arrays.asList(tr.getString("Globalization.GENRES_ACTION"),
			tr.getString("Globalization.GENRES_ADVENTURE"), tr.getString("Globalization.GENRES_ANIMATION"),
			tr.getString("Globalization.GENRES_CHILDRENS"), tr.getString("Globalization.GENRES_COMEDY"),
			tr.getString("Globalization.GENRES_CRIME"), tr.getString("Globalization.GENRES_DOCUMENTARY"),
			tr.getString("Globalization.GENRES_DRAMA"), tr.getString("Globalization.GENRES_FANTASY"),
			tr.getString("Globalization.GENRES_HORROR"), tr.getString("Globalization.GENRES_MUSICAL"),
			tr.getString("Globalization.GENRES_MYSTERY"), tr.getString("Globalization.GENRES_ROMANCE"),
			tr.getString("Globalization.GENRES_SCI_SCI"), tr.getString("Globalization.GENRES_MUSICAL"),
			tr.getString("Globalization.GENRES_THRILLER"), tr.getString("Globalization.GENRES_WAR"),
			tr.getString("Globalization.GENRES_WESTERN"), tr.getString("Globalization.GENRES_NO_GENRES_LISTED"));
	private List<String> listCategory_en = Arrays.asList(en.getString("Globalization.GENRES_ACTION"),
			en.getString("Globalization.GENRES_ADVENTURE"), en.getString("Globalization.GENRES_ANIMATION"),
			en.getString("Globalization.GENRES_CHILDRENS"), en.getString("Globalization.GENRES_COMEDY"),
			en.getString("Globalization.GENRES_CRIME"), en.getString("Globalization.GENRES_DOCUMENTARY"),
			en.getString("Globalization.GENRES_DRAMA"), en.getString("Globalization.GENRES_FANTASY"),
			en.getString("Globalization.GENRES_HORROR"), en.getString("Globalization.GENRES_MUSICAL"),
			en.getString("Globalization.GENRES_MYSTERY"), en.getString("Globalization.GENRES_ROMANCE"),
			en.getString("Globalization.GENRES_SCI_SCI"), en.getString("Globalization.GENRES_MUSICAL"),
			en.getString("Globalization.GENRES_THRILLER"), en.getString("Globalization.GENRES_WAR"),
			en.getString("Globalization.GENRES_WESTERN"), en.getString("Globalization.GENRES_NO_GENRES_LISTED"));
	
	public void changeLanguage() {
		if (defaultLanguage.getLeangue().equals("tr")) {
			this.defaultLanguage = en;
		} else {
			this.defaultLanguage = tr;
		}
		
	}
	
	public String ERR_OPEN_DATABASE() {
		return defaultLanguage.getString("Globalization.ERR_OPEN_DATABASE");
	}
	
	public String ERR_LONGER_SEARCH_KEY() {
		return defaultLanguage.getString("Globalization.ERR_LONGER_SEARCH_KEY");
	}
	
	public String LOG_IS_SUCCESSFUL() {
		return defaultLanguage.getString("Globalization.LOG_IS_SUCCESSFUL");
	}
	
	public String LOG_NOT_FOUND() {
		return defaultLanguage.getString("Globalization.LOG_NOT_FOUND");
	}
	
	public String LOG_IS_NOT_SUCCESSFUL() {
		return defaultLanguage.getString("Globalization.LOG_IS_NOT_SUCCESSFUL");
	}
	
	public String LOG_CREATE_DATABASE_SUCCESSFUL() {
		return defaultLanguage.getString("Globalization.LOG_CREATE_DATABASE") + " "
				+ defaultLanguage.getString("Globalization.LOG_IS_SUCCESSFUL");
	}
	
	public String LOG_CREATE_TABLE_SUCCESSFUL() {
		return defaultLanguage.getString("Globalization.LOG_CREATE_TABLE") + " "
				+ defaultLanguage.getString("Globalization.LOG_IS_SUCCESSFUL");
	}
	
	public String LOG_ERROR() {
		return defaultLanguage.getString("Globalization.LOG_ERROR");
		
	}
	
	public String LOG_DELETE() {
		return defaultLanguage.getString("Globalization.LOG_DELETE");
		
	}
	
	public String STAR_NULL() {
		return defaultLanguage.getString("Globalization.STAR_NULL");
		
	}
	
	public String STAR_FULL() {
		return defaultLanguage.getString("Globalization.STAR_FULL");
		
	}
	
	public String ICON_TABLE() {
		return defaultLanguage.getString("Globalization.ICON_TABLE");
		
	}
	
	public String NOTICE_FOR_THE_NEXT_PRESS_BUTTON() {
		return defaultLanguage.getString("Globalization.NOTICE_FOR_THE_NEXT_PRESS_BUTTON");
		
	}
	
	// Menü
	
	public String APP_NAME() {
		return defaultLanguage.getString("Globalization.APP_NAME");
		
	}
	
	public String APP_NAME_BODY() {
		return defaultLanguage.getString("Globalization.APP_NAME_BODY");
		
	}
	
	public String MENU_SEARCH_BY_YEAR() {
		return defaultLanguage.getString("Globalization.MENU_SEARCH_BY_YEAR");
		
	}
	
	public String MENU_SEARCH_BY_CATEGORY() {
		return defaultLanguage.getString("Globalization.MENU_SEARCH_BY_CATEGORY");
		
	}
	
	public String MENU_SEARCH_BY_NAME() {
		return defaultLanguage.getString("Globalization.MENU_SEARCH_BY_NAME");
		
	}
	
	public String MENU_SEARCH_BY_ARTIST_NAME() {
		return defaultLanguage.getString("Globalization.MENU_SEARCH_BY_ARTIST_NAME");
		
	}
	
	public String MENU_LANGUAGE(int key) {
		String str = defaultLanguage.getString("Globalization.MENU_LANGUAGE");
		
		return str.replace("*", String.valueOf(key));
		
	}
	
	public String LOG_READABLE_DATABASE_NOT_FOUND() {
		return defaultLanguage.getString("Globalization.LOG_READABLE_DATABASE_NOT_FOUND");
		
	}
	
	public String LOG_READABLE_DATABASE_FOUND() {
		return defaultLanguage.getString("Globalization.LOG_READABLE_DATABASE_FOUND");
		
	}
	
	public String MENU_EXIT() {
		return defaultLanguage.getString("Globalization.MENU_EXIT");
		
	}
	
	public String MENU_RELOAD_DATABASE() {
		return defaultLanguage.getString("Globalization.MENU_RELOAD_DATABASE");
		
	}
	
	public String SCAN_ARTIST_NAME() {
		return defaultLanguage.getString("Globalization.SCAN_ARTIST_NAME");
		
	}
	
	public String SCAN_YEARS() {
		return defaultLanguage.getString("Globalization.SCAN_YEARS");
		
	}
	
	public String SCAN_NAME() {
		return defaultLanguage.getString("Globalization.SCAN_NAME");
		
	}
	
	public String TITLE_MOVIE_NAME() {
		return defaultLanguage.getString("Globalization.TITLE_MOVIE_NAME");
		
	}
	
	public String TITLE_MAX_RATING() {
		return defaultLanguage.getString("Globalization.TITLE_MAX_RATING");
		
	}
	
	public String TITLE_MIN_RATING() {
		return defaultLanguage.getString("Globalization.TITLE_MIN_RATING");
		
	}
	
	public String TITLE_AVG_RATING() {
		return defaultLanguage.getString("Globalization.TITLE_AVG_RATING");
		
	}
	
	public String TITLE_RELATE_DATE() {
		return defaultLanguage.getString("Globalization.TITLE_RELATE_DATE");
		
	}
	
	public String TITLE_TAG() {
		return defaultLanguage.getString("Globalization.TITLE_TAG");
		
	}
	
	public String TITLE_GENRES() {
		return defaultLanguage.getString("Globalization.TITLE_GENRES");
		
	}
	
	public String TITLE_IS_ADULT() {
		return defaultLanguage.getString("Globalization.TITLE_IS_ADULT");
		
	}
	
	public String TITLE_START_DATE() {
		return defaultLanguage.getString("Globalization.TITLE_START_DATE");
		
	}
	
	public String TITLE_END_YEAR() {
		return defaultLanguage.getString("Globalization.TITLE_END_YEAR");
		
	}
	
	public String TITLE_RUNTIME_MINUTES() {
		return defaultLanguage.getString("Globalization.TITLE_RUNTIME_MINUTES");
		
	}
	
	public String TITLE_ORIGINAL_TITLE() {
		return defaultLanguage.getString("Globalization.TITLE_ORIGINAL_TITLE");
		
	}
	
	public String TITLE_PRIMARY_NAME() {
		return defaultLanguage.getString("Globalization.TITLE_PRIMARY_NAME");
		
	}
	
	public String TITLE_BIRTHDAY() {
		return defaultLanguage.getString("Globalization.TITLE_ORIGINAL_TITLE");
		
	}
	
	public String TITLE_DEATH_DAY() {
		return defaultLanguage.getString("Globalization.TITLE_DEATH_DAY");
		
	}
	
	public String TITLE_PRIMARY_PROFESSION() {
		return defaultLanguage.getString("Globalization.TITLE_PRIMARY_PROFESSION");
		
	}
	
	public List<String> MENU_CATEGORY() {
		if (defaultLanguage.getLeangue().equals("tr")) {
			return this.listCategory_tr;
		} else {
			return this.listCategory_en;
		}
	}
	
	public String MENU_SELECT_CATEGORY(int index) {
		return listCategory_en.get(index);
	}
	
}
