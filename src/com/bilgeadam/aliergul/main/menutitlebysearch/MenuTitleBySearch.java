package com.bilgeadam.aliergul.main.menutitlebysearch;

import java.util.List;

import com.bilgeadam.aliergul.controller.ControllerMovies;
import com.bilgeadam.aliergul.dto.DtoMovieDetail;
import com.bilgeadam.aliergul.language.ChooseLanguage;
import com.bilgeadam.aliergul.util.helper.MenuBuilder;

public enum MenuTitleBySearch {
	getInstance;
	
	ChooseLanguage language = ChooseLanguage.getInstance;
	
	public void searchByTitleName() {
		
		String searchTitleName = new MenuBuilder.Builder().title(language.MENU_SEARCH_BY_NAME())
				.title(language.SCAN_NAME()).build().show().readString();
		List<DtoMovieDetail> listSearch = ControllerMovies.getInstance.searchByTitle(searchTitleName);
		printSearchList(listSearch).show().readInteger();
	}
	
	public MenuBuilder printSearchList(List<DtoMovieDetail> listSearch) {
		MenuBuilder searchList = new MenuBuilder.Builder().build();
		for (DtoMovieDetail dtoMovie : listSearch) {
			
			// String formatString = String.format("\t %-40s %-40s | %s",
			// dtoMovie.getTitle(), dtoMovie.getGenres());
			searchList.addRow(String.format("\t%-30s: [%s]", language.TITLE_MOVIE_NAME(), dtoMovie.getTitle()));
			searchList.addRow(String.format("\t%-30s: [%s] [%5.2f]", language.TITLE_MAX_RATING(),
					starWrite(dtoMovie.getMaxRating()), 2 * dtoMovie.getMaxRating()));
			searchList.addRow(String.format("\t%-30s: [%s] [%5.2f]", language.TITLE_MIN_RATING(),
					starWrite(dtoMovie.getMinRating()), 2 * dtoMovie.getMinRating()));
			searchList.addRow(String.format("\t%-30s: [%s] [%5.2f]", language.TITLE_AVG_RATING(),
					starWrite(dtoMovie.getAvgRating()), 2 * dtoMovie.getAvgRating()));
			searchList.addRow(String.format("\t%-30s: [%s]", language.TITLE_GENRES(), dtoMovie.getGenres()));
			searchList.addRow(String.format("\t%-30s: [%s]", language.TITLE_TAG(), dtoMovie.getTag()));
			searchList.addRow(String.format("\t%-30s: [%s]", language.TITLE_RELATE_DATE(), dtoMovie.getYears()));
			searchList.addRow("");
		}
		if (listSearch.size() == 0) {
			searchList.addRow(language.LOG_NOT_FOUND());
		}
		return searchList;
	}
	
	public String starWrite(double count) {
		final int MAX_COUNT = 10;
		int fullStarCount = (int) Math.ceil(count * 2);
		int nullStarCount = (int) (MAX_COUNT - Math.ceil(count * 2));
		final String STAR_FULL = language.STAR_FULL();
		final String STAR_NULL = language.STAR_NULL();
		String star = "";
		for (int i = 0; i < fullStarCount; i++) {
			star = star.concat(STAR_FULL);
			
		}
		for (int i = 0; i < nullStarCount; i++) {
			star = star.concat(STAR_NULL);
		}
		return star;
	}
}
