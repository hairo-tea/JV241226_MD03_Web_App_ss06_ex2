package ra.webmvc.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.webmvc.models.dao.IMovieDao;
import ra.webmvc.models.entity.Movie;

import java.util.List;

@Service
public class MovieServiceImpl implements  IMovieService{
    @Autowired
    private IMovieDao movieDao;

    @Override
    public List<Movie> getAllMovies() {
        return movieDao.getAllMovies();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieDao.getMovieById(id);
    }

    @Override
    public boolean addMovie(Movie movie) {
       return movieDao.addMovie(movie);
    }

    @Override
    public boolean updateMovie(Movie movie) {
       return movieDao.updateMovie(movie);
    }

    @Override
    public boolean deleteMovie(Long id) {
        return movieDao.deleteMovie(id);
    }
}
