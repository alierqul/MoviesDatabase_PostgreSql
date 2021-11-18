package com.bilgeadam.aliergul.util.database;

public class DatabaseInformation {
	private String URL_MARATHON_MOVIES;
	private String USER_NAME;
	private String PASSWORD;
	private String FOR_NAME_DATA;
	private String URL_MAIN;
	
	public DatabaseInformation() {
		
		this.URL_MARATHON_MOVIES = "jdbc:postgresql://localhost:5432/marathonmovies";
		this.URL_MAIN = "jdbc:postgresql://localhost:5432/";
		this.USER_NAME = "postgres";
		this.PASSWORD = "root";
		this.FOR_NAME_DATA = "org.postgresql.Driver";
	}
	
	public String getURL_MAIN() {
		return URL_MAIN;
	}
	
	public void setURL_MAIN(String uRL_MAIN) {
		URL_MAIN = uRL_MAIN;
	}
	
	public String getURL() {
		return URL_MARATHON_MOVIES;
	}
	
	public void setURL(String uRL) {
		URL_MARATHON_MOVIES = uRL;
	}
	
	public String getUSER_NAME() {
		return USER_NAME;
	}
	
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	
	public String getPASSWORD() {
		return PASSWORD;
	}
	
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	
	public String getFOR_NAME_DATA() {
		return FOR_NAME_DATA;
	}
	
	public void setFOR_NAME_DATA(String fOR_NAME_DATA) {
		FOR_NAME_DATA = fOR_NAME_DATA;
	}
	
}
