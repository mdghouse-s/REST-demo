package learn.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "movieId", "title", "genre", "language", "realeaseYear" })
public class Movie {

	private int movieId;
	private String title;
	private String genre;
	private String language;
	private int realeaseYear;

	public Movie() {
	}

	public Movie(int movieId, String title, String genre, String language, int realeaseYear) {
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.language = language;
		this.realeaseYear = realeaseYear;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getRealeaseYear() {
		return realeaseYear;
	}

	public void setRealeaseYear(int realeaseYear) {
		this.realeaseYear = realeaseYear;
	}
}