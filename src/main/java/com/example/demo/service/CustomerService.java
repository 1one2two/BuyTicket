package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CustomerModel;
import com.example.demo.repository.CustomerRepository;
import io.lettuce.core.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private RedisScript<String> flashSaleScript;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    RedisClient redisClient;

    @Cacheable(value = "getAllCustomer")
    public List<CustomerModel> getAllCustomerService() {
        return customerRepository.findAll();
    }

//    @Cacheable(value = "getCustomer", key = "#p0")
    public CustomerModel getCustomerService(Long customerId) throws ResourceNotFoundException {
        String result = stringRedisTemplate.execute(flashSaleScript, Collections.singletonList("flash_sale_result2"), customerId.toString());

        if (result.startsWith("success-")) {
            return customerRepository.findById(1L)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id : " + customerId));
        } else {
            return customerRepository.findById(-1L)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id : " + customerId));
        }
    }

    public CustomerModel setCustomerService(CustomerModel customer) {
        return customerRepository.save(customer);
    }

}
