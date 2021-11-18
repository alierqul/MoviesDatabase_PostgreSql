package com.bilgeadam.aliergul.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DtoArtist implements Serializable {
	
	private static final long serialVersionUID = 8099770063404674849L;
	
	private String nconst;
	private String primaryName;
	private String birthYear;
	private String deathYear;
	private String primaryProfession;
	private String knownForTitles;
	private List<DtoMovieDetail> listMovie;
	
	public DtoArtist() {
		
	}
	
	public DtoArtist(String nconst, String primaryName, String birthYear, String deathYear, String primaryProfession,
			String knownForTitles, List<DtoMovieDetail> listMovie) {
		super();
		this.nconst = nconst;
		this.primaryName = primaryName;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
		this.primaryProfession = primaryProfession;
		this.knownForTitles = knownForTitles;
		this.listMovie = listMovie;
	}
	
	@Override
	public String toString() {
		return "MoviesArthistTsvDetail [nconst=" + nconst + ", primaryName=" + primaryName + ", birthYear=" + birthYear
				+ ", deathYear=" + deathYear + ", primaryProfession=" + primaryProfession + ", knownForTitles="
				+ knownForTitles + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtoArtist artist = (DtoArtist) obj;
		return Objects.equals(this.primaryName.toLowerCase(), artist.primaryName.toLowerCase());
	}
	
	public List<DtoMovieDetail> getListMovie() {
		return listMovie;
	}
	
	public void setListMovie(List<DtoMovieDetail> listMovie) {
		this.listMovie = listMovie;
	}
	
	public void addListMovie(DtoMovieDetail movie) {
		if (this.listMovie == null) {
			this.listMovie = new ArrayList<>();
		}
		this.listMovie.add(movie);
	}
	
	public String getNconst() {
		return nconst;
	}
	
	public void setNconst(String nconst) {
		this.nconst = nconst;
	}
	
	public String getPrimaryName() {
		return primaryName;
	}
	
	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}
	
	public String getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	
	public String getDeathYear() {
		return deathYear;
	}
	
	public void setDeathYear(String deathYear) {
		this.deathYear = deathYear;
	}
	
	public String getPrimaryProfession() {
		return primaryProfession;
	}
	
	public void setPrimaryProfession(String primaryProfession) {
		this.primaryProfession = primaryProfession;
	}
	
	public String getKnownForTitles() {
		return knownForTitles;
	}
	
	public void setKnownForTitles(String knownForTitles) {
		this.knownForTitles = knownForTitles;
	}
	
}
