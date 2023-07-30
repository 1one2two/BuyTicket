package com.example.demo.controller;

import com.example.demo.model.BookingModel;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    BookingRepository bookingRepository;

    @RequestMapping(value = "/booking",
            method = RequestMethod.GET)
    public List<BookingModel> getBooking(@RequestParam(name = "customerId", required = false) Long customerId,
                                         @RequestParam(name = "movieId", required = false) Long movieId) {
        return bookingService.getBookingService(customerId, movieId);
    }

//    record BookingRecord(Integer movieid, Integer customerid) {}

    @RequestMapping(value = "/booking",
                    method = RequestMethod.POST)
    public BookingModel setBooking(@RequestBody BookingService.BookingRecord requestBody) {
        return bookingService.setBookingService(requestBody);
    }
}
