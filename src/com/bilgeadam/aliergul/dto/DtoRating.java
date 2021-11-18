package com.bilgeadam.aliergul.dto;

import java.io.Serializable;

public class DtoRating extends Dto implements Serializable {
	
	private static final long serialVersionUID = -3515098595121878897L;
	// userId,movieId,rating,timestamp
	
	private int movieId;
	private double rating;
	private long timestamp;
	
	public DtoRating(int userId, int movieId, double rating, long timestamp) {
		super(userId);
		
		this.movieId = movieId;
		this.rating = rating;
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "DtoRatings [userId=" + super.getMovieId() + ", movieId=" + movieId + ", rating=" + rating
				+ ", timestamp=" + timestamp + "]";
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
}
