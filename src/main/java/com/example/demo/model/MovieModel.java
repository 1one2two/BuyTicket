package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "movie")
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long movieid;
    private String name;
    private Integer number;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<MovieModel> bookingModelSet;

    public MovieModel() {

    }

    public MovieModel(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public Long getMovieid() {
        return movieid;
    }

    public void setMovieid(Long movieid) {
        this.movieid = movieid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "movie{" +
                "id=" + movieid +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
