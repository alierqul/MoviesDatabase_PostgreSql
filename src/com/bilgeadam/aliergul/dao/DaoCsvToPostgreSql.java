package com.bilgeadam.aliergul.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bilgeadam.aliergul.language.ChooseLanguage;
import com.bilgeadam.aliergul.util.database.DatabaseConnection;
import com.bilgeadam.aliergul.util.database.DatabaseInformation;
import com.bilgeadam.aliergul.util.helper.FileReaderHelper;
import com.bilgeadam.aliergul.util.helper.progresbar.MyProgressBar;

public class DaoCsvToPostgreSql implements ICsvProgress {
	private ChooseLanguage language = ChooseLanguage.getInstance;
	private final int FORMATTER_SPACE = 27;
	private final DatabaseInformation info = new DatabaseInformation();
	
	@Override
	public boolean transferCsvoDatabase() {
		MyProgressBar.getInstance.startProgress();
		if (deleteDatabase()) {
			createdNewDatabase();
			createdNewTable();
			copyCsvToDatabaseMovies();
			copyCsvToDatabaseRatings();
			copyCsvToDatabaseTags();
			copyCsvToDatabaseLinks();
		} else {
			System.err.println(language.ERR_OPEN_DATABASE());
		}
		MyProgressBar.getInstance.stopProgress();
		return false;
	}
	
	private boolean createdNewTable() {
		
		try (Connection conn = getConection("transferCsvoDatabase")) {
			
			Statement st = conn.createStatement();
			
			String query = FileReaderHelper.getInstance
					.readFiletoString("./src/com/bilgeadam/aliergul/postgresql/CreateDatabase.sql");
			st.executeUpdate(query);
			formatterWrite(" 'createdNewTable'", language.LOG_CREATE_TABLE_SUCCESSFUL(), FORMATTER_SPACE);
			return true;
		} catch (SQLException e) {
			System.err.println(" 'createdNewTable' " + language.LOG_ERROR() + ": " + e.getMessage());
			return false;
		}
		
	}
	
	public boolean isThereDatabase() {
		final String query = "SELECT * FROM pg_database WHERE datname=?;";
		try (Connection conn = DatabaseConnection.getInstance().getConnPostgreSql("transferCsvoDatabase")) {
			// movieId,title,genres
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, info.getDatabase());
			ResultSet resut = st.executeQuery();
			
			while (resut.next()) {
				
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("'isThereDatabase'" + language.LOG_ERROR() + ": " + language.LOG_IS_NOT_SUCCESSFUL()
					+ "\n" + e.getMessage());
			return false;
		}
		
		return false;
	}
	
	private boolean deleteDatabase() {
		
		try (Connection conn = DatabaseConnection.getInstance().getConnPostgreSql("transferCsvoDatabase")) {
			// movieId,title,genres
			final String query = "DROP DATABASE IF EXISTS " + info.getDatabase();
			Statement st = conn.createStatement();
			
			st.executeUpdate(query);
			formatterWrite(" 'Database' " + language.LOG_DELETE(), language.LOG_IS_SUCCESSFUL(), FORMATTER_SPACE);
			
			Thread.sleep(1000);
			return true;
		} catch (SQLException | InterruptedException e) {
			System.out.println("'deleteDatabase'" + language.LOG_ERROR() + ": " + language.LOG_IS_NOT_SUCCESSFUL()
					+ "\n" + e.getMessage());
			return false;
		}
		
	}
	
	private boolean createdNewDatabase() {
		try (Connection conn = DatabaseConnection.getInstance().getConnPostgreSql("createdNewDatabase")) {
			// movieId,title,genres
			
			final String query = "CREATE DATABASE  " + info.getDatabase()
					+ " WITH OWNER = postgres ENCODING = 'UTF8' LC_CTYPE = 'Turkish_Turkey.1254' CONNECTION LIMIT = -1;";
			Statement st = conn.createStatement();
			
			// st.setString(1, path);
			// D:\ECLIPSE\eclipse-workspace\JavaMarathonMovies\src\data
			st.executeUpdate(query);
			formatterWrite(" 'MarathonMovies'", language.LOG_CREATE_DATABASE_SUCCESSFUL(), FORMATTER_SPACE);
			Thread.sleep(1000);
			return true;
		} catch (SQLException | InterruptedException e) {
			System.out.println("createdNewDatabase ERR: " + e.getMessage());
			return false;
			
		}
		
	}
	
	private void copyCsvToDatabaseMovies() {
		String path = System.getProperty("user.dir") + "\\src\\data\\movies.csv";
		try (Connection conn = getConection("transferCsvoDatabase")) {
			// movieId,title,genres
			final String query = "COPY movies FROM '" + path + "' DELIMITER ',' CSV HEADER;";
			Statement st = conn.createStatement();
			// st.setString(1, path);
			// D:\ECLIPSE\eclipse-workspace\JavaMarathonMovies\src\data
			st.executeUpdate(query);
			formatterWrite(" 'copyCsvToDatabaseMovies'", language.LOG_IS_SUCCESSFUL(), FORMATTER_SPACE);
		} catch (SQLException e) {
			System.err.println("copyCsvToDatabaseMovies path= " + path + "\n hata: " + e.getMessage());
			
		}
	}
	
	private void copyCsvToDatabaseRatings() {
		String path = System.getProperty("user.dir") + "\\src\\data\\ratings.csv";
		try (Connection conn = getConection("transferCsvoDatabase")) {
			// movieId,title,genres
			final String query = "COPY ratings FROM '" + path + "' DELIMITER ',' CSV HEADER;";
			Statement st = conn.createStatement();
			st.executeUpdate(query);
			formatterWrite(" 'copyCsvToDatabaseRatings'", language.LOG_IS_SUCCESSFUL(), FORMATTER_SPACE);
		} catch (SQLException e) {
			System.err.println("copyCsvToDatabaseRatings path= " + path + "\n hata: " + e.getMessage());
			
		}
	}
	
	private void copyCsvToDatabaseTags() {
		String path = System.getProperty("user.dir") + "\\src\\data\\tags.csv";
		try (Connection conn = getConection("transferCsvoDatabase")) {
			// movieId,title,genres
			final String query = "COPY tags FROM '" + path + "' DELIMITER ',' CSV HEADER;";
			Statement st = conn.createStatement();
			st.executeUpdate(query);
			formatterWrite(" 'copyCsvToDatabaseTags'", language.LOG_IS_SUCCESSFUL(), FORMATTER_SPACE);
			
		} catch (SQLException e) {
			System.err.println("copyCsvToDatabaseTags path= " + path + "\n hata: " + e.getMessage());
			
		}
	}
	
	private void copyCsvToDatabaseLinks() {
		String path = System.getProperty("user.dir") + "\\src\\data\\links.csv";
		try (Connection conn = getConection("transferCsvoDatabase")) {
			// movieId,title,genres
			final String query = "COPY links FROM '" + path + "' DELIMITER ',' CSV HEADER;";
			Statement st = conn.createStatement();
			st.executeUpdate(query);
			formatterWrite(" 'copyCsvToDatabaseLinks'", language.LOG_IS_SUCCESSFUL(), FORMATTER_SPACE);
		} catch (SQLException e) {
			System.err.println("copyCsvToDatabaseLinks path= " + path + "\n hata: " + e.getMessage());
			
		}
	}
	
	private void formatterWrite(String str, String str2, int count) {
		System.out.printf("%-" + count + "s :%s%n", str, str2);
	}
	
}
