package com.example.demo.controller;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

@RestController
public class HazelcastController {
    @Autowired
    HazelcastInstance hazelcastInstance;

    private ConcurrentMap<String, String> mapping() {
        return hazelcastInstance.getMap("map");
    }

    @GetMapping("/Hazelcast")
//    @Cacheable(value = "userInfo", key = "#key")
    public String Hazelcast(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) throws InterruptedException {
        String res = mapping().get(key);
        System.out.println(res);
        return res;
    }

    @PostMapping("/Hazelcast")
//    @CachePut(value = "userInfo", key = "#key")
    public String putHazelcast(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        mapping().put(key, value);
        System.out.println(key + ", " + value);
        return "OK!";
    }

    @GetMapping("/Hazelcast2")
    @Cacheable(value = "userInfo2", key = "#key")
    public String Hazelcast2(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) throws InterruptedException {
        String res = mapping().get(key);
        System.out.println(res);
        return res;
    }

    @PostMapping("/Hazelcast2")
    @CachePut(value = "userInfo2", key = "#key")
    public String putHazelcast2(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        mapping().put(key, value);
        System.out.println(key + ", " + value);
        return "OK!";
    }
}
