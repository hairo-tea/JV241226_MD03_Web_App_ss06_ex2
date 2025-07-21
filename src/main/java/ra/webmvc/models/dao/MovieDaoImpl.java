package ra.webmvc.models.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.webmvc.models.entity.Movie;
import ra.webmvc.models.dao.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieDaoImpl implements IMovieDao {
    @Autowired
    private ConnectionDB connectionDB;

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        try (Connection conn = connectionDB.openConnection();
             CallableStatement call = conn.prepareCall("{call findAll()}")) {
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getLong("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setGenre(rs.getString("genre"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getInt("duration"));
                movie.setLanguage(rs.getString("language"));
                movies.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public Movie getMovieById(Long id) {
        Movie movie = null;
        try(
           Connection conn = connectionDB.openConnection();
           CallableStatement call = conn.prepareCall("{call findMovieId(?)}")){
            call.setLong(1, id);
            ResultSet rs = call.executeQuery();
            if (rs.next()) {
                movie = new Movie();
                movie.setId(rs.getLong("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setGenre(rs.getString("genre"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getInt("duration"));
                movie.setLanguage(rs.getString("language"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return movie;
    }

    @Override
    public boolean addMovie(Movie movie) {
       try( Connection conn = connectionDB.openConnection();
            CallableStatement call = conn.prepareCall("{call addMovie(?,?,?,?,?,?)}"))
       {
           call.setString(1, movie.getTitle());
           call.setString(2, movie.getDirector());
           call.setString(3, movie.getGenre());
           call.setString(4, movie.getDescription());
           call.setInt(5, movie.getDuration());
           call.setString(6, movie.getLanguage());
           call.execute();
       }catch (Exception e){
           e.printStackTrace();
       }
       return true;
    }

    @Override
    public boolean updateMovie(Movie movie) {
        try(Connection conn = connectionDB.openConnection();
        CallableStatement call = conn.prepareCall("{call updateMovie(?,?,?,?,?,?,?)}")){
            call.setLong(1, movie.getId());
            call.setString(2, movie.getTitle());
            call.setString(3, movie.getDirector());
            call.setString(4, movie.getGenre());
            call.setString(5, movie.getDescription());
            call.setInt(6, movie.getDuration());
            call.setString(7, movie.getLanguage());
            call.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean deleteMovie(Long id) {
        try(Connection conn = connectionDB.openConnection();
        CallableStatement call = conn.prepareCall("{call deleteMovie(?)}")){
            call.setLong(1, id);
           int rs =  call.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
