package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private CustomerModel customerModel;
    @ManyToOne
    @JoinColumn(name = "movieid")
    private MovieModel movieModel;

    public BookingModel() {

    }

    public BookingModel(Long customerId, Long movieId) {
        this.customerModel = new CustomerModel();
        this.customerModel.setCustomerid(customerId);
        this.movieModel = new MovieModel();
        this.movieModel.setMovieid(movieId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return this.customerModel.getCustomerid();
    }

    public void setCustomerId(Long customerId) {
        this.customerModel.setCustomerid(customerId);
    }

    public Long getMovieId() {
        return this.movieModel.getMovieid();
    }

    public void setMovieId(Long movieId) {
        this.movieModel.setMovieid(movieId);
    }

    @Override
    public String toString() {
        return "BookingModel{" +
                "id=" + id +
                ", customerModel=" + customerModel +
                ", movieModel=" + movieModel +
                '}';
    }
}
