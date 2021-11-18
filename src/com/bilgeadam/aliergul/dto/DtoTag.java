package com.bilgeadam.aliergul.dto;

import java.io.Serializable;

public class DtoTag extends Dto implements Serializable {
	
	private static final long serialVersionUID = -749825444530381679L;
	// userId,movieId,tag,timestamp
	
	private int movieId;
	private String tag;
	private long timestamp;
	
	public DtoTag(int userId, int movieId, String tag, long timestamp) {
		super(userId);
		
		this.movieId = movieId;
		this.tag = tag;
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "DtoTag [userId=" + super.getMovieId() + ", movieId=" + movieId + ", tag=" + tag + ", timestamp="
				+ timestamp + "]";
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
}
