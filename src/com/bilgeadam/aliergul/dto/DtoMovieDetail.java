package com.bilgeadam.aliergul.dto;

import java.io.Serializable;

public class DtoMovieDetail extends DtoMovie implements Serializable {
	
	private static final long serialVersionUID = 7123846291595606967L;
	private String tconst;
	private String orginalTitle;
	private String isAdult;
	private String startYear;
	private String endYear;
	private String runtimeMinutes;
	private String genres;
	private double maxRating = 0;
	private double minRating = 0;
	private double avgRating = 0;
	private String years = "";
	private String tag = "";
	
	public DtoMovieDetail(int movieId, String title, String genres, String years) {
		super(movieId, title, genres);
		this.years = years;
	}
	
	public DtoMovieDetail(int movieId, String title, String genres, double maxRating, double minRating,
			double avgRating, String years, String tag) {
		super(movieId, title, genres);
		this.maxRating = maxRating;
		this.minRating = minRating;
		this.avgRating = avgRating;
		this.years = years;
		this.tag = tag;
	}
	
	public DtoMovieDetail(String tconst, String title, String orginalTitle, String isAdult, String startYear,
			String endYear, String runtimeMinutes, String genres) {
		super();
		super.setTitle(title);
		this.tconst = tconst;
		this.orginalTitle = orginalTitle;
		this.isAdult = isAdult;
		this.startYear = startYear;
		this.endYear = endYear;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
	}
	
	public String getTconst() {
		return tconst;
	}
	
	public void setTconst(String tconst) {
		this.tconst = tconst;
	}
	
	public String getOrginalTitle() {
		return orginalTitle;
	}
	
	public void setOrginalTitle(String orginalTitle) {
		this.orginalTitle = orginalTitle;
	}
	
	public String getIsAdult() {
		return isAdult;
	}
	
	public void setIsAdult(String isAdult) {
		this.isAdult = isAdult;
	}
	
	public String getStartYear() {
		return startYear;
	}
	
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	
	public String getEndYear() {
		return endYear;
	}
	
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	
	public String getRuntimeMinutes() {
		return runtimeMinutes;
	}
	
	public void setRuntimeMinutes(String runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}
	
	public String getGenres() {
		return genres;
	}
	
	public void setGenres(String genres) {
		this.genres = genres;
	}
	
	public double getMaxRating() {
		return maxRating;
	}
	
	public void setMaxRating(double maxRating) {
		this.maxRating = maxRating;
	}
	
	public double getMinRating() {
		return minRating;
	}
	
	public void setMinRating(double minRating) {
		this.minRating = minRating;
	}
	
	public double getAvgRating() {
		return avgRating;
	}
	
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	
	public String getYears() {
		return years;
	}
	
	public void setYears(String years) {
		this.years = years;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
