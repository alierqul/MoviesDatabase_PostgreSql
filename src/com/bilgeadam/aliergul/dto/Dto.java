package com.bilgeadam.aliergul.dto;

import java.io.Serializable;

public class Dto implements Serializable {
	private static final long serialVersionUID = 2879047184633895538L;
	private int movieId;
	
	public Dto(int movieId) {
		super();
		this.movieId = movieId;
	}
	
	public Dto() {
		super();
		
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
}
