package ra.webmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.webmvc.models.entity.Movie;
import ra.webmvc.models.service.IMovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private IMovieService movieService;
    //hiển thị danh sách phim chiếu rạp hiện có
    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "listMovie";
    }
    //Hiển thị form thêm mới phim
    @GetMapping("/add")
    public String showFormMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "addMovie";
    }
    //xử lý form thêm mới phim
    @PostMapping("/add")
    public String processAddMovie(@ModelAttribute("movie") Movie movie) {
        movieService.addMovie(movie);
        return "redirect:/movies";
    }
    //hiển thị form edit phim với những thông tin cũ của phim thông qua id phim
    @GetMapping("/edit/{id}")
    public String showFormEditMovie(@PathVariable("id") Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "updateMovie";
    }
    //Xử lý yêu cầu sửa phim
    @PostMapping("/edit/{id}")
    public String processEditMovie(
            @PathVariable Long id,
            @ModelAttribute("movie") Movie movie) {
        movie.setId(id);
        movieService.updateMovie(movie);
        return "redirect:/movies";
    }
    // xử lý chức năng xóa phim
    @GetMapping("/delete/{id}")
    public String processDeleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }

}
