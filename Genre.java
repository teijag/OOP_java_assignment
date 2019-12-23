package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Genre implements Comparable<Genre>{
	String genreName;
	List<Movie> genreMovies = new ArrayList<>();
	
	Genre(String genreName) {
		this.genreName = genreName;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(genreName);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if ( this == o) return true;
		if (getClass() != o.getClass()) return false;
		Genre g = (Genre) o;
		return genreName.equals(g.genreName);
	}
	
	@Override
	public int compareTo(Genre g) {
		// TODO Auto-generated method stub
		return g.genreMovies.size()-genreMovies.size();
	}

}
