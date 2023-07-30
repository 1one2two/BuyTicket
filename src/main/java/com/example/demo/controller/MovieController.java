package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.MovieModel;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieService movieService;

    @RequestMapping("/movie")
    public List<MovieModel> getAllMovie() {
        return movieRepository.findAll();
    }

    @RequestMapping(value = "/movie/{id:[\\d]+}",
            method = RequestMethod.GET)
    public MovieModel getMovie(@PathVariable Long id) throws ResourceNotFoundException {
        return movieService.getMovieService(id);
    }

    @RequestMapping(value = "/movie/{id:[\\d]+}/left",
            method = RequestMethod.GET)
    public Long getMovieLeft(@PathVariable Long id) throws ResourceNotFoundException {
        return movieService.getLeftTicket(id);
    }

    @RequestMapping(value = "/movie",
            method = RequestMethod.POST)
    public MovieModel setMovie(@RequestBody MovieModel movie) {
        return movieService.setMovieService(movie);
    }
}
