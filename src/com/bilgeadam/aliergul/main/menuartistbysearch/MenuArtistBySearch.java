package com.bilgeadam.aliergul.main.menuartistbysearch;

import java.util.List;

import com.bilgeadam.aliergul.dto.DtoArtist;
import com.bilgeadam.aliergul.dto.DtoMovieDetail;
import com.bilgeadam.aliergul.language.ChooseLanguage;
import com.bilgeadam.aliergul.main.menutitlebysearch.MenuTitleBySearch;
import com.bilgeadam.aliergul.server.ClientTSV;
import com.bilgeadam.aliergul.util.helper.MenuBuilder;
import com.bilgeadam.aliergul.util.helper.progresbar.MyProgressBar;

public enum MenuArtistBySearch {
	getInstance;
	
	private ChooseLanguage language = ChooseLanguage.getInstance;
	
	public void searchByArtistName() {
		List<DtoArtist> listSearch = null;
		String searchArtistName = new MenuBuilder.Builder().title(language.MENU_SEARCH_BY_ARTIST_NAME())
				.addRow(language.SCAN_ARTIST_NAME()).build().show().readString();
		
		if (searchArtistName.length() > 5) {
			searchForClientAndDatabase(searchArtistName);
		} else {
			System.err.println(language.ERR_LONGER_SEARCH_KEY());
		}
		
	}
	
	private void searchForClientAndDatabase(String key) {
		MyProgressBar.getInstance().onStartRunable();
		ClientTSV client = new ClientTSV();
		
		DtoArtist artist = (DtoArtist) client.requestArtistSearch(key);
		MenuBuilder searchList = new MenuBuilder.Builder().build();
		if (artist != null) {
			
			searchList.addRowLine();
			searchList.addRow(String.format("[ %-30s : %s ]", language.TITLE_PRIMARY_NAME(), artist.getPrimaryName()));
			searchList.addRow(String.format("[ %-30s : %s ]", language.TITLE_BIRTHDAY(), artist.getBirthYear()));
			searchList.addRow(String.format("[ %-30s : %s ]", language.TITLE_DEATH_DAY(), artist.getDeathYear()));
			searchList.addRow(String.format("[ %-30s : %s ]", language.TITLE_PRIMARY_PROFESSION(),
					artist.getPrimaryProfession()));
			searchList.addRowLine();
			for (DtoMovieDetail dtoMovie : artist.getListMovie()) {
				
				searchList.addRow(String.format("\t %-30s: [%s]", language.TITLE_MOVIE_NAME(), dtoMovie.getTitle()));
				searchList.addRow(
						String.format("\t %-30s: [%s]", language.TITLE_ORIGINAL_TITLE(), dtoMovie.getOrginalTitle()));
				searchList.addRow(String.format("\t %-30s: [%s]", language.TITLE_IS_ADULT(),
						dtoMovie.getIsAdult().equals("0") ? "false" : "true"));
				searchList.addRow(String.format("\t %-30s: [%s] [%5.2f]", language.TITLE_MAX_RATING(),
						MenuTitleBySearch.getInstance.starWrite(dtoMovie.getMaxRating()), 2 * dtoMovie.getMaxRating()));
				searchList.addRow(String.format("\t %-30s: [%s] [%5.2f]", language.TITLE_MIN_RATING(),
						MenuTitleBySearch.getInstance.starWrite(dtoMovie.getMinRating()), 2 * dtoMovie.getMinRating()));
				searchList.addRow(String.format("\t %-30s: [%s] [%5.2f]", language.TITLE_AVG_RATING(),
						MenuTitleBySearch.getInstance.starWrite(dtoMovie.getAvgRating()), 2 * dtoMovie.getAvgRating()));
				searchList.addRow(String.format("\t %-30s: [%s]", language.TITLE_GENRES(), dtoMovie.getGenres()));
				searchList.addRow(String.format("\t %-30s: [%s]", language.TITLE_TAG(), dtoMovie.getTag()));
				searchList.addRow(String.format("\t %-30s: [%s]", language.TITLE_RELATE_DATE(), dtoMovie.getYears()));
				
				searchList
						.addRow(String.format("\t %-30s: [%s]", language.TITLE_START_DATE(), dtoMovie.getStartYear()));
				searchList.addRow(String.format("\t %-30s: [%s]", language.TITLE_END_YEAR(), dtoMovie.getEndYear()));
				searchList.addRow(String.format("\t %-30s: [%s]", language.TITLE_RUNTIME_MINUTES(),
						dtoMovie.getRuntimeMinutes()));
				searchList.addRow("");
			}
			
		} else {
			searchList.addRow(language.LOG_NOT_FOUND());
			
		}
		MyProgressBar.getInstance().onCloseRunable();
		searchList.show().readInteger();
	}
	
}
