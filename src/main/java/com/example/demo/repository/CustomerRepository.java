package com.example.demo.repository;

import com.example.demo.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long>{

}
