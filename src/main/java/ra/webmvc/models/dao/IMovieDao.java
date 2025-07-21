package ra.webmvc.models.dao;

import ra.webmvc.models.entity.Movie;

import java.util.List;

public interface IMovieDao {
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    boolean addMovie(Movie movie);
    boolean updateMovie(Movie movie);
    boolean deleteMovie(Long id);
}
