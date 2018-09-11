package learn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import learn.model.Movie;

public class MovieDAOImpl implements MovieDAO {

	@Override
	public Movie insertMovie(Movie newMovie) {
		
		String sql = "INSERT INTO MOVIES VALUES(MOVIE_SEQ.NEXTVAL,?,?,?,?)";
		ResultSet rs = null;
		try (Connection conn = DBUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql,new String[]{"MOVIE_ID"})) {//,Statement.RETURN_GENERATED_KEYS
			
			stmt.setString(1, newMovie.getTitle());
			stmt.setString(2, newMovie.getGenre());
			stmt.setString(3, newMovie.getLanguage());
			stmt.setInt(4, newMovie.getRealeaseYear());
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			if(rs.next()){
				newMovie.setMovieId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newMovie;
	}

	@Override
	public Movie getMovie(int movieId) {
		String sql = "SELECT * FROM MOVIES WHERE MOVIE_ID = ?";
		ResultSet rs = null;
		Movie movie = null;
		try (Connection conn = DBUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1, movieId);
			rs = stmt.executeQuery();
			if(rs.next()){
				movie = new Movie(
						rs.getInt("MOVIE_ID"), 
						rs.getString("TITLE"), 
						rs.getString("GENRE"), 
						rs.getString("LANGUAGE"), 
						rs.getInt("RELEASE_YEAR"));		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}

	@Override
	public List<Movie> getMovies(String title) {
		String sql = "SELECT * FROM MOVIES WHERE LOWER(TITLE) LIKE ?";
		ResultSet rs = null;
		Movie movie = null;
		List<Movie> movies = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, "%"+title+"%");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				movie = new Movie(
						rs.getInt("MOVIE_ID"), 
						rs.getString("TITLE"), 
						rs.getString("GENRE"), 
						rs.getString("LANGUAGE"), 
						rs.getInt("RELEASE_YEAR"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;

	}

	@Override
	public List<Movie> getMovies() {
		
		String sql = "SELECT * FROM MOVIES";
		ResultSet rs = null;
		Movie movie = null;
		List<Movie> movies = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			rs = stmt.executeQuery();
			
			while(rs.next()){
				movie = new Movie(
						rs.getInt("MOVIE_ID"), 
						rs.getString("TITLE"), 
						rs.getString("GENRE"), 
						rs.getString("LANGUAGE"), 
						rs.getInt("RELEASE_YEAR"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}

	@Override
	public void deleteMovie(int movieId) {
		String sql = "DELETE FROM MOVIES WHERE MOVIE_ID = ?";
		try (Connection conn = DBUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, movieId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Movie> getMovies(int year) {
		String sql = "SELECT * FROM MOVIES WHERE RELEASE_YEAR = ?";
		ResultSet rs = null;
		Movie movie = null;
		List<Movie> movies = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, year);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				movie = new Movie(
						rs.getInt("MOVIE_ID"), 
						rs.getString("TITLE"), 
						rs.getString("GENRE"), 
						rs.getString("LANGUAGE"), 
						rs.getInt("RELEASE_YEAR"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;

	}

}
