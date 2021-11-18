package com.bilgeadam.aliergul.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bilgeadam.aliergul.dto.DtoArtist;
import com.bilgeadam.aliergul.dto.DtoMovie;
import com.bilgeadam.aliergul.dto.DtoMovieDetail;
import com.bilgeadam.aliergul.language.ChooseLanguage;

public class DaoMovies implements IMovieProgress {
	private ChooseLanguage language = ChooseLanguage.getInstance;
	
	@Override
	public List<DtoMovieDetail> searchByYears(int years) {
		List<DtoMovieDetail> tempList = new ArrayList<>();
		String query = "SELECT *,SUBSTRING(trim(title),length(trim(title))-4,4) AS movie_year"
				+ " FROM movies WHERE SUBSTRING(trim(title),length(trim(title))-4,4) LIKE ? ;";
		try (Connection conn = getConection("searchByArtist")) {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, "" + years);
			ResultSet result = st.executeQuery();
			while (result.next()) {
				int movieId = result.getInt("movieid");
				String title = result.getString("title");
				String genres = result.getString("genres");
				String movie_year = result.getString("movie_year");
				tempList.add(new DtoMovieDetail(movieId, title, genres, movie_year));
			}
		} catch (SQLException e) {
			System.out.println(language.LOG_ERROR() + ": " + e.getMessage());
		}
		return tempList;
	}
	
	@Override
	public List<DtoArtist> searchByArtist(String artistName) {
		List<DtoArtist> tempArtist = new ArrayList<>();
		
		String queryArtist = "SELECT m.movieid,t.tag,m.genres, m.title, AVG(r.rating),MAX(r.rating),MIN(r.rating), SUBSTRING(trim(m.title), length(trim(m.title))-4,4) as movie_year"
				+ " FROM movies as m" + " INNER JOIN tags as t ON t.movieid = m.movieid"
				+ " INNER JOIN ratings as r ON r.movieid = m.movieid"
				+ " WHERE LOWER(t.tag) LIKE ? GROUP BY t.tag,m.title,m.movieid,m.genres ORDER BY movie_year DESC;";
		List<DtoMovieDetail> listMovie = dtoMovieFilter(artistName, queryArtist);
		if (listMovie.size() > 0) {
			for (DtoMovieDetail movie : listMovie) {
				String tag = movie.getTag();
				if (containsName(tempArtist, tag)) {
					DtoArtist search = new DtoArtist();
					search.setPrimaryName(tag);
					tempArtist.get(tempArtist.indexOf(search)).addListMovie(movie);
				} else {
					DtoArtist artist = new DtoArtist();
					artist.setPrimaryName(tag);
					artist.addListMovie(movie);
					tempArtist.add(artist);
				}
			}
			
		}
		return tempArtist;
		
	}
	
	private boolean containsName(final List<DtoArtist> list, final String name) {
		return list.stream().map(DtoArtist::getPrimaryName).filter(name::equals).findFirst().isPresent();
	}
	
	@Override
	public List<DtoMovieDetail> searchByTitle(String titleName) {
		String query = "SELECT m.movieid,t.tag,m.genres, m.title, AVG(r.rating),MAX(r.rating),MIN(r.rating), SUBSTRING(trim(m.title), length(trim(m.title))-4,4) as movie_year"
				+ " FROM movies as m" + " INNER JOIN tags as t ON t.movieid = m.movieid"
				+ " INNER JOIN ratings as r ON r.movieid = m.movieid"
				+ " WHERE LOWER(m.title) LIKE ? GROUP BY t.tag,m.title,m.movieid,m.genres ORDER BY movie_year DESC;";
		return dtoMovieFilter(titleName, query);
	}
	
	private List<DtoMovieDetail> dtoMovieFilter(String searchKey, String query) {
		List<DtoMovieDetail> tempList = new ArrayList<>();
		try (Connection conn = getConection("searchByArtist")) {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, "%" + searchKey.toLowerCase() + "%");
			ResultSet result = st.executeQuery();
			while (result.next()) {
				int movieId = result.getInt("movieid");
				String title = result.getString("title").trim();
				String genres = result.getString("genres");
				double maxRatings = result.getDouble("MAX");
				double minRatings = result.getDouble("MIN");
				double avgRatings = result.getDouble("AVG");
				String movieYears = result.getString("movie_year");
				String tag = result.getString("tag").trim().toLowerCase();
				tempList.add(new DtoMovieDetail(movieId, title, genres, maxRatings, minRatings, avgRatings, movieYears,
						tag));
			}
		} catch (SQLException e) {
			System.out.println(language.LOG_ERROR() + ": " + e.getMessage());
		}
		return tempList;
	}
	
	@Override
	public List<DtoMovie> searchByCategory(String category) {
		List<DtoMovie> tempList = new ArrayList<>();
		String query = "SELECT * FROM movies as m WHERE LOWER(m.genres) LIKE ?";
		try (Connection conn = getConection("searchByCategory")) {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, "%" + category.toLowerCase() + "%");
			ResultSet result = st.executeQuery();
			while (result.next()) {
				int movieId = result.getInt("movieid");
				String title = result.getString("title");
				String genres = result.getString("genres");
				tempList.add(new DtoMovie(movieId, title, genres));
			}
		} catch (SQLException e) {
			System.out.println(language.LOG_ERROR() + ": " + e.getMessage());
		}
		return tempList;
	}
	
}
