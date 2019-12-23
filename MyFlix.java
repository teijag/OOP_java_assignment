package lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class MyFlix {
	List<Movie> moviesList = new ArrayList<>();
	List<Genre> genresList = new ArrayList<>();
	String[] movieDBStrings;
	
	//do not change this method
	public static void main(String[] args) {
		MyFlix myFlix = new MyFlix();
		myFlix.movieDBStrings = myFlix.readMovieDB("MoviesDB.tsv");
		myFlix.loadMovies();
		myFlix.loadGenres();
		Collections.sort(myFlix.moviesList);
		Collections.sort(myFlix.genresList);
		myFlix.showMenu();
	}
	
	//do not change this method
	void showMenu() {
		System.out.println("*** Welcome to MyFlix ***"); 
		System.out.println("1. Search for a movie");
		System.out.println("2. List of genres");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		input.nextLine();
		switch (choice) {
		case 1: {
			System.out.println("Enter the string to search in movie names");
			String searchString = input.nextLine();
			printSearchResults(findMovies(searchString));
			break;
		}
		case 2: {
			printGenreReport();
			break;
		}
		default: break;
		}
		input.close();
	}

	//do not change this method
	//readMovieDB reads all data from the MovieDB file
	//and loads each row as a string in movieDBStrings
	String[] readMovieDB(String filename) {
		StringBuilder movies = new StringBuilder();
		try {
			Scanner input = new Scanner(new File(filename));
			while (input.hasNextLine()) {
				movies.append(input.nextLine() + "\n");
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return movies.toString().split("\n");
	}
	
	void loadMovies() {
		//String temp = null;
		Movie m = null;
		String[] tempList = null;
		for (int i = 0; i<movieDBStrings.length;i++) {
			//temp = movieDBStrings[i];
			tempList = movieDBStrings[i].split("\t");
			m = new Movie(Integer.parseInt(tempList[0].trim()),tempList[1].trim(),Integer.parseInt(tempList[2].trim()),tempList[3].trim());
			
			for (int j = 4; j<tempList.length; j++) {
				m.movieGenres.add(tempList[j]);
			}
			moviesList.add(m);
		}
		
	}

	void loadGenres() {
		for (int i = 0; i<moviesList.size();i++) {
			for (String name : moviesList.get(i).movieGenres) {
				Genre g = new Genre(name);
				if (!genresList.contains(g)) {
					genresList.add(new Genre(name));
					
				}
				
			}
		}
		Collections.sort(genresList);
		for (int i = 0; i<moviesList.size();i++) {
			for (Genre g : genresList) {
				if (moviesList.get(i).movieGenres.contains(g.genreName)){
					g.genreMovies.add(moviesList.get(i));
				}
			}
		}
//		String[] tempList = null;
//		for (int i = 0; i<movieDBStrings.length;i++) {
//			tempList = movieDBStrings[i].split("\t");
//			for (int j = 4; j<tempList.length; j++) {
//				genresList.add(new Genre(tempList[j]));
//			}
//			
//		}
	}

	List<Movie> findMovies(String searchString) {
		List<Movie> matchedMovies = new ArrayList<>();
		for (Movie m : moviesList) {
			if (m.movieName.toLowerCase().contains(searchString.toLowerCase())){
				matchedMovies.add(m);
			}
		}
		return matchedMovies;
	}

	void printGenreReport() {
		int count = 0;
	
		for (Genre g : genresList) {	
			System.out.printf("%3d. %-15s Number of movies: %,6d%n", ++count, g.genreName, g.genreMovies.size());

		}
		//System.out.printf("%3d. %-15s Number of movies: %,6d%n", ++count, genre.genreName, genre.genreMovies.size());
	}

	void printSearchResults(List<Movie> searchResults) {
		//write your code here
		//print statements to print the genre report
		System.out.println(searchResults.size() + " movies matching the search criteria");
		
		int count = 0;
		for (Movie m : searchResults) {
			String temp = m.movieGenres.toString();
			System.out.printf("%3d. %-50s\tYear: %d Countries: %-20s\t  Genre: %-20s\t\n", ++count, m.movieName, m.movieYear, m.countries, temp);

		}
		//...
		//System.out.printf("%s ", genre);
	}
}
