import java.util.*;
import java.util.stream.*;

class Movie {
    String title;
    String genre;
    double rating;
    int releaseYear;

    Movie(String title, String genre, double rating, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }
}

public class MovieAnalyzer {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Inception", "Sci-Fi", 8.8, 2010),
            new Movie("Interstellar", "Sci-Fi", 8.6, 2014),
            new Movie("The Dark Knight", "Action", 9.0, 2008),
            new Movie("Parasite", "Thriller", 8.6, 2019),
            new Movie("Avengers: Endgame", "Action", 8.4, 2019),
            new Movie("Joker", "Drama", 8.5, 2019),
            new Movie("Dune", "Sci-Fi", 8.2, 2021)
        );
        //Top 3 movies 
        movies.stream()
            .sorted((m1, m2) -> Double.compare(m2.rating, m1.rating))
            .limit(3)
            .forEach(movie -> System.out.println(movie.title + " - " + movie.rating));  
        System.out.println();
        //Movies by Genre
        movies.stream()
            .collect(Collectors.groupingBy(movie -> movie.genre))
            .forEach((genre, genreMovies) -> {
                System.out.println("Genre: " + genre);
                genreMovies.forEach(movie -> System.out.println(" - " + movie.title));
            });
        System.out.println();
        //Average Rating by Genre
        movies.stream()
            .collect(Collectors.groupingBy(movie -> movie.genre, Collectors.averagingDouble(movie -> movie.rating)))
            .forEach((genre, avgRating) -> System.out.println("Average rating for " + genre + ": " + avgRating));
        System.out.println();
        //Average Rating Post 2010
        System.out.println(
            "Average rating for movies released after 2010: " +
            movies.stream()
                .filter(movie -> movie.releaseYear > 2010)
                .collect(Collectors.averagingDouble(movie -> movie.rating))
        );

        System.out.println();
    }
}
