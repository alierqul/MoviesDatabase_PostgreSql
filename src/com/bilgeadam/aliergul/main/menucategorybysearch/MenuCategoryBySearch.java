package com.bilgeadam.aliergul.main.menucategorybysearch;

import java.util.List;

import com.bilgeadam.aliergul.controller.ControllerMovies;
import com.bilgeadam.aliergul.dto.DtoMovie;
import com.bilgeadam.aliergul.language.ChooseLanguage;
import com.bilgeadam.aliergul.util.helper.ConsoleHelper;
import com.bilgeadam.aliergul.util.helper.MenuBuilder;

public enum MenuCategoryBySearch {
	getInstance;
	
	private ChooseLanguage language = ChooseLanguage.getInstance;
	
	public void searchCategory() {
		
		MenuBuilder menuCategory = new MenuBuilder.Builder().title(language.MENU_SEARCH_BY_CATEGORY()).build();
		int j = 1;
		List<String> listCategory = language.MENU_CATEGORY();
		for (int i = 0; i < listCategory.size(); i += 2) {
			String row = "";
			if (i < listCategory.size() - 1) {
				row = String.format("%02d %-17s | %02d %s", i, listCategory.get(i), j, listCategory.get(j));
			} else {
				row = String.format("%02d %15s", i, listCategory.get(i));
			}
			
			menuCategory.addRow(row);
			j += 2;
		}
		int choose = -1;
		while (!(choose >= 0 && choose < listCategory.size())) {
			choose = menuCategory.show().readInteger();
		}
		
		String enSearchCategor = language.MENU_SELECT_CATEGORY(choose);
		System.out.println(enSearchCategor + " " + choose);
		List<DtoMovie> tempList = ControllerMovies.getInstance.searchByCategory(enSearchCategor);
		int i = 0;
		
		for (DtoMovie dtoMovie : tempList) {
			i++;
			System.out.printf("[%02d] - [%-40s]  [%s]%n", i, dtoMovie.getTitle(), dtoMovie.getGenres());
			
			String exitChoose = "-1";
			if (i % 10 == 0) {
				exitChoose = ConsoleHelper.getInstance()
						.readString(language.NOTICE_FOR_THE_NEXT_PRESS_BUTTON() + "\n" + language.MENU_EXIT());
				
			}
			if (exitChoose.equalsIgnoreCase("0")) {
				break;
			}
			
		}
		
	}
	
}
