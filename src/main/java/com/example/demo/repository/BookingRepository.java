package com.example.demo.repository;

import com.example.demo.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, Long> {
    @Query(value = "SELECT * FROM customer WHERE customerid = ?1", nativeQuery = true)
    List<BookingModel> findByCustomerIdIs(Long customerId);
    @Query(value = "SELECT * FROM movie WHERE movieid = ?1", nativeQuery = true)
    List<BookingModel> findByMovieIdIs(Long movieId);
}
