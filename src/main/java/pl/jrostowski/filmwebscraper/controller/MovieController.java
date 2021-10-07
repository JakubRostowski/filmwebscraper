package pl.jrostowski.filmwebscraper.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jrostowski.filmwebscraper.entity.Movie;
import pl.jrostowski.filmwebscraper.service.MovieService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    @GetMapping("/")
    public String home() {
        return "Homepage";
    }

    @GetMapping("/display")
    public Map<Integer, Movie> displayFilmwebData() throws IOException {
        return service.downloadData();
    }

    @GetMapping("/updateDatabase")
    public void updateDatabase() throws IOException {
        if (service.countMovies() == 0) {
            System.out.println("Database is empty.");
            service.populateDatabase(service.downloadData());
        } else {
            System.out.println("Database is NOT empty.");
            service.checkDifferences(service.downloadData());
        }
        System.out.println("Done!");
    }

    @GetMapping("/movies")
    public List<Movie> displayMovieContent(){
        return service.getMovieContent();
    }
}
