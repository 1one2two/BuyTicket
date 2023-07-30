package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.MovieModel;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    BookingRepository bookingRepository;

    public MovieModel getMovieService(Long movieId) throws ResourceNotFoundException {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found for this id : " + movieId));
    }

    public Long getLeftTicket(Long movieId) throws ResourceNotFoundException {
        movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found for this id : " + movieId));
        return movieRepository.findByMovieidIs(movieId).get(0).getNumber()
                - bookingRepository.findByMovieIdIs(movieId).stream().count();
    }

    public MovieModel setMovieService(MovieModel movieModel) {
        return movieRepository.save(movieModel);
    }
}
