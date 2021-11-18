package com.bilgeadam.aliergul.dao;

import java.sql.Connection;

import com.bilgeadam.aliergul.util.database.DatabaseConnection;

public interface ICsvProgress {
	public boolean transferCsvoDatabase();
	
	public boolean isThereDatabase();
	
	public default Connection getConection(String tag) {
		return DatabaseConnection.getInstance().getConnMarathonMovies("ICsvProgress / " + tag);
		
	}
}
