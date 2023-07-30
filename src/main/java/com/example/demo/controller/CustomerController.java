package com.example.demo.controller;

import com.example.demo.model.CustomerModel;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer",
                    method = RequestMethod.GET)
    public List<CustomerModel> getAllCustomer() {
        return customerService.getAllCustomerService();
    }

    @RequestMapping(value = "/customer/{id:[\\d]+}",
                    method = RequestMethod.GET)
    public CustomerModel getCustomer(@PathVariable Long id) throws ResourceNotFoundException {
        return customerService.getCustomerService(id);
    }

    @RequestMapping(value = "/customer",
                    method = RequestMethod.POST)
    public CustomerModel setCustomer(@RequestBody CustomerModel customer) {
        return customerService.setCustomerService(customer);
    }
}
