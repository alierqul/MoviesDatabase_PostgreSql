package com.bilgeadam.aliergul.dao;

import java.sql.Connection;
import java.util.List;

import com.bilgeadam.aliergul.dto.DtoArtist;
import com.bilgeadam.aliergul.dto.DtoMovie;
import com.bilgeadam.aliergul.dto.DtoMovieDetail;
import com.bilgeadam.aliergul.util.database.DatabaseConnection;

public interface IMovieProgress {
	public List<DtoMovieDetail> searchByYears(int years);
	
	public List<DtoArtist> searchByArtist(String ArtistName);
	
	public List<DtoMovieDetail> searchByTitle(String titleName);
	
	public List<DtoMovie> searchByCategory(String category);
	
	public default Connection getConection(String tag) {
		return DatabaseConnection.getInstance().getConn("ICsvProgress / " + tag);
		
	}
}
