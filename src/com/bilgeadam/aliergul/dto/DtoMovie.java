package com.bilgeadam.aliergul.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DtoMovie extends Dto implements Serializable {
	private static final long serialVersionUID = -7141869128644193470L;
	// movieId,title,genres
	
	private String title;
	private String genres;
	private List<String> listCategory;
	
	public DtoMovie(int movieId, String title, String genres) {
		super(movieId);
		this.title = title;
		this.genres = genres;
	}
	
	public DtoMovie() {
		super();
		
	}
	
	@Override
	public String toString() {
		return "DtoMovie [movieId=" + super.getMovieId() + ", title=" + title + ", genres=" + genres + "]";
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGenres() {
		return genres;
	}
	
	public void setGenres(String genres) {
		this.genres = genres;
	}
	
	public List<String> getListCategory() {
		List<String> tempList = new ArrayList<>();
		if (genres != null && !genres.isEmpty()) {
			StringTokenizer token = new StringTokenizer(genres, "|");
			while (token.hasMoreElements()) {
				String s = token.nextToken();
				tempList.add(s);
			}
			return tempList;
		}
		return null;
		
	}
	
}
