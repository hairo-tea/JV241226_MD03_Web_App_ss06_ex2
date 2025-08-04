package ra.webmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ra.webmvc.models.entity.Movie;
import ra.webmvc.models.service.IMovieService;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private IMovieService movieService;

    @GetMapping("/home")
    public String home(Model model) {
       List<Movie> movies = movieService.getAllMovies();
       model.addAttribute("movies", movies);
        return "home";
    }
    @GetMapping("/detailMovie/{id}")
    public String detailMovie(
            @PathVariable("id") Long id,
            Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "detailMovie";
    }

}
