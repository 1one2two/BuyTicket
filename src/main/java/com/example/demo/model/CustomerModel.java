package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "customer")
public class CustomerModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "customerid")
    private Long customerid;
    private String name;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<BookingModel> bookingModelSet;

    public CustomerModel() {

    }

    public CustomerModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "cutomer{" +
                "id=" + customerid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
