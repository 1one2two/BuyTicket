package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;

@RestController
public class TestController {

//    @Autowired
//    StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    private RedisScript<String> flashSaleScript;

    @GetMapping("/test/{id}")
    public String test(@PathVariable Long id) {
//        String result = stringRedisTemplate.execute(flashSaleScript, Collections.singletonList("flash_sale_result2"), id.toString());
//
//        if (result.startsWith("success-"))
//            return result;
//        else
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "not found"
//            );

        return "QQ";

    }
}
