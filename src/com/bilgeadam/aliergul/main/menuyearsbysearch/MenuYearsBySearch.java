package com.bilgeadam.aliergul.main.menuyearsbysearch;

import java.util.List;

import com.bilgeadam.aliergul.controller.ControllerMovies;
import com.bilgeadam.aliergul.dto.DtoMovie;
import com.bilgeadam.aliergul.dto.DtoMovieDetail;
import com.bilgeadam.aliergul.language.ChooseLanguage;
import com.bilgeadam.aliergul.util.helper.MenuBuilder;

public enum MenuYearsBySearch {
	getInstance;
	
	private ChooseLanguage language = ChooseLanguage.getInstance;
	
	public void searchByYears() {
		
		int searchYear = new MenuBuilder.Builder().title(language.MENU_SEARCH_BY_YEAR())
				.title(language.SCAN_ARTIST_NAME()).build().show().readInteger();
		List<DtoMovieDetail> listSearch = ControllerMovies.getInstance.searchByYears(searchYear);
		MenuBuilder searcMenuBuilder = new MenuBuilder.Builder().title(language.MENU_SEARCH_BY_YEAR())
				.body(searchYear + "").build();
		
		List<String> listCategory = language.MENU_CATEGORY();
		int j = 0;
		for (String trGenres : listCategory) {
			String enGenres = language.MENU_SELECT_CATEGORY(j);
			j++;
			int movieCount = 0;
			
			for (int i = 0; i < listSearch.size(); i++) {
				DtoMovie dtoMovie = listSearch.get(i);
				if (dtoMovie.getListCategory().contains(enGenres)) {
					if (movieCount == 0) {
						searcMenuBuilder.addRow("[ ------------------------------------------- ]");
						searcMenuBuilder.addRow(String.format("[%-40s\t]", trGenres));
						searcMenuBuilder.addRow("[ ------------------------------------------- ]");
					}
					movieCount++;
					String formatString = String.format("\t\t ==>[ %-40s ] ", dtoMovie.getTitle());
					searcMenuBuilder.addRow(formatString);
					if (movieCount > 10) {
						break;
					}
				}
				
			}
			
		}
		if (listSearch.size() == 0) {
			searcMenuBuilder.addMenu("", language.LOG_NOT_FOUND());
		}
		searcMenuBuilder.show().readInteger();
	}
}
