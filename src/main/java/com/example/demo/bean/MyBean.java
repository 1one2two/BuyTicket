package com.example.demo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    @Bean
    public RedisScript<String> flashSaleScript() {
        return RedisScript.of(new ClassPathResource("scripts/myfunc.lua"), String.class);
    }
}