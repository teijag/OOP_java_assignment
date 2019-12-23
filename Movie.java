package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Movie implements Comparable<Movie>{
	int movieId;
	String movieName;
	int movieYear;
	String countries;
	List<String> movieGenres = new ArrayList<>();
	
	
	
	Movie(int moviedId, String movieName, int movieYear, String countries) {
		this.movieId = moviedId;
		this.movieName = movieName;
		this.movieYear = movieYear;
		this.countries = countries;
	}


	@Override
	public int hashCode() {
		return Objects.hash(movieId);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if ( this == o) return true;
		if (getClass() != o.getClass()) return false;
		Movie m = (Movie) o;
		return (movieId == m.movieId);
	}
	
	@Override
	public int compareTo(Movie m) {
		// TODO Auto-generated method stub
		return movieName.compareTo(m.movieName);
	}

}
