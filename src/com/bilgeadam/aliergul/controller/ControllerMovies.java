
package com.bilgeadam.aliergul.controller;

import java.util.List;

import com.bilgeadam.aliergul.dao.DaoMovies;
import com.bilgeadam.aliergul.dao.IMovieProgress;
import com.bilgeadam.aliergul.dto.DtoArtist;
import com.bilgeadam.aliergul.dto.DtoMovie;
import com.bilgeadam.aliergul.dto.DtoMovieDetail;

public enum ControllerMovies implements IMovieProgress {
	getInstance;
	
	private DaoMovies dao = new DaoMovies();
	
	@Override
	public List<DtoMovieDetail> searchByYears(int years) {
		
		return dao.searchByYears(years);
	}
	
	@Override
	public List<DtoArtist> searchByArtist(String ArtistName) {
		
		return dao.searchByArtist(ArtistName);
	}
	
	@Override
	public List<DtoMovie> searchByCategory(String category) {
		return dao.searchByCategory(category);
	}
	
	@Override
	public List<DtoMovieDetail> searchByTitle(String titleName) {
		return dao.searchByTitle(titleName);
	}
	
}
