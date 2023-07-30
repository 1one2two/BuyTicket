package com.example.demo.repository;

import com.example.demo.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Long> {
    List<MovieModel> findByMovieidIs(Long id);

}