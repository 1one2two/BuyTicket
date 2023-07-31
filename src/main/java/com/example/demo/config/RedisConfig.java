package com.example.demo.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
//    @Bean
//    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(factory);
//        stringRedisTemplate.setEnableTransactionSupport(true);
//        return stringRedisTemplate;
//    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//        redisTemplate.setConnectionFactory(factory);
//        return redisTemplate;
//    }

}
