package learn.dao;

import java.util.List;

import learn.model.Movie;

public interface MovieDAO {
	Movie insertMovie(Movie newMovie);
	Movie getMovie(int movieId);
	List<Movie> getMovies(String title);
	List<Movie> getMovies(int year);
	List<Movie> getMovies();
	void deleteMovie(int movieId);
}
