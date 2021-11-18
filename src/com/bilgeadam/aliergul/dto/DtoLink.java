package com.bilgeadam.aliergul.dto;

import java.io.Serializable;

public class DtoLink extends Dto implements Serializable {
	
	private static final long serialVersionUID = -7257886653400832413L;
	// movieId,imdbId,tmdbId
	
	private int imdbId;
	private int tmdbId;
	
	public DtoLink(int movieId, int imdbId, int tmdbId) {
		super(movieId);
		this.imdbId = imdbId;
		this.tmdbId = tmdbId;
	}
	
	@Override
	public String toString() {
		return "DtoLink [movieId=" + super.getMovieId() + ", imdbId=" + imdbId + ", tmdbId=" + tmdbId + "]";
	}
	
	public int getImdbId() {
		return imdbId;
	}
	
	public void setImdbId(int imdbId) {
		this.imdbId = imdbId;
	}
	
	public int getTmdbId() {
		return tmdbId;
	}
	
	public void setTmdbId(int tmdbId) {
		this.tmdbId = tmdbId;
	}
	
}
