package com.example.demo.service;

import com.example.demo.model.BookingModel;
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public List<BookingModel> getBookingService(Long customerId, Long movieId) {
        if (customerId != null) {
            return bookingRepository.findByCustomerIdIs(customerId);
        } else if (movieId != null) {
            return bookingRepository.findByMovieIdIs(movieId);
        } else {
            return bookingRepository.findAll();
        }
    }

    public record BookingRecord(Long movieid, Long customerid) {}

    public BookingModel setBookingService(BookingRecord booking) {
        BookingModel bookingModel = new BookingModel(booking.customerid, booking.movieid);
        System.out.println(booking);
        return bookingRepository.save(bookingModel);
    }
}
