package com.bilgeadam.aliergul.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.bilgeadam.aliergul.controller.ControllerMovies;
import com.bilgeadam.aliergul.dto.DtoArtist;
import com.bilgeadam.aliergul.dto.DtoMovieDetail;

public class MyServer implements Runnable {
	
	private boolean isStartServer = true;
	public static final String EXIT = "exit_server";
	private int errorCount = 0;
	
	@Override
	public void run() {
		isStartServer = true;
		while (isStartServer) {
			startServer();
		}
		
	}
	
	private void startServer() {
		PortInfo port = new PortInfo();
		try (ServerSocket server = new ServerSocket(port.getPort());) {
			Socket socket = server.accept();
			DataInputStream input = new DataInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			String inputMessage = "";
			while (isStartServer) {
				inputMessage = input.readUTF().trim().toLowerCase();
				if (inputMessage != null && !inputMessage.isEmpty() && !inputMessage.equals(EXIT)) {
					if (inputMessage != null && !inputMessage.isEmpty()) {
						DtoArtist temp = fileSearchNameTSV(inputMessage);
						out.writeObject(temp);
					}
				} else {
					isStartServer = false;
					
				}
				
			}
			
		} catch (IOException e) {
			System.err.println("Server Başlatılamadı " + e.getMessage());
			errorCount++;
			if (errorCount > 10) {
				isStartServer = false;
			}
		}
		
	}
	
	private DtoArtist fileSearchNameTSV(String searchKey) {
		String path = "./src/data/names.tsv";
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
			String row = "";
			while ((row = reader.readLine()) != null) {
				if (row.toLowerCase().contains(searchKey)) {
					return dtoArtistCreate(row);
				}
			}
		} catch (IOException e) {
			
		}
		return null;
	}
	
	private DtoMovieDetail fileSearchMovieTSV(String searchKey) {
		String path = "./src/data/movies.tsv";
		List<DtoMovieDetail> temp = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
			String row = "";
			
			while ((row = reader.readLine()) != null) {
				if (row.toLowerCase().contains(searchKey)) {
					DtoMovieDetail dto = dtoMovieCreate(row);
					
					return dto;
					
				}
			}
		} catch (IOException e) {
			System.out.println("hata : ");
		}
		return null;
	}
	
	private DtoMovieDetail dtoMovieCreate(String row) {
		String tconst = "";
		String title = "";
		String orginalTitle = "";
		String isAdult = "";
		String startYear = "";
		String endYear = "";
		String runtimeMinutes = "";
		String genres = "";
		StringTokenizer token = new StringTokenizer(row, "\t");
		if (token.hasMoreTokens()) {
			tconst = token.nextToken();
		}
		if (token.hasMoreTokens()) {
			title = token.nextToken();
		}
		if (token.hasMoreTokens()) {
			orginalTitle = token.nextToken();
		}
		if (token.hasMoreTokens()) {
			isAdult = token.nextToken();
		}
		if (token.hasMoreTokens()) {
			startYear = token.nextToken();
		}
		if (token.hasMoreTokens()) {
			endYear = token.nextToken();
		}
		if (token.hasMoreTokens()) {
			runtimeMinutes = token.nextToken();
		}
		if (token.hasMoreTokens()) {
			genres = token.nextToken();
		}
		
		return new DtoMovieDetail(tconst, title, orginalTitle, isAdult, startYear, endYear, runtimeMinutes, genres);
	}
	
	DtoArtist dtoArtistCreate(String row) {
		StringTokenizer token = new StringTokenizer(row, "\t");
		
		String nconst = "";
		String primaryName = "";
		String birthYear = "";
		String deathYear = "";
		String primaryProfession = "";
		String knownForTitles = "";
		if (token.hasMoreTokens()) {
			nconst = token.nextToken();
		}
		if (token.hasMoreTokens()) {
			primaryName = token.nextToken();
		}
		
		if (token.hasMoreTokens()) {
			birthYear = token.nextToken();
		}
		if (token.hasMoreTokens()) {
			deathYear = token.nextToken();
		}
		if (token.hasMoreTokens()) {
			primaryProfession = token.nextToken();
		}
		if (token.hasMoreTokens()) {
			knownForTitles = token.nextToken();
		}
		// tt0102685,tt0111257,tt0133093,tt0234215
		String[] arrayKnowForTitles = knownForTitles.split(",");
		List<DtoMovieDetail> listMovie = new ArrayList<>();
		for (int i = 0; i < arrayKnowForTitles.length; i++) {
			DtoMovieDetail temp = fileSearchMovieTSV(arrayKnowForTitles[i]);
			if (temp != null) {
				List<DtoMovieDetail> movieDatabase = ControllerMovies.getInstance.searchByTitle(temp.getTitle());
				if (movieDatabase.size() > 0) {
					DtoMovieDetail dto = movieDatabase.get(0);
					temp.setAvgRating(dto.getAvgRating());
					temp.setMaxRating(dto.getMaxRating());
					temp.setMinRating(dto.getMinRating());
					temp.setYears(dto.getYears());
					temp.setTag(dto.getTag());
					temp.setGenres(dto.getGenres());
				}
				listMovie.add(temp);
			}
			
		}
		DtoArtist artist = new DtoArtist(nconst, primaryName, birthYear, deathYear, primaryProfession, knownForTitles,
				listMovie);
		System.out.println(artist);
		return artist;
	}
	
}
