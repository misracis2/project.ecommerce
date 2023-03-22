package com.example.ecommerce.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @PostMapping("/fruit")
    public String setFruit(@RequestParam String name) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("fruit", name);

        return name + " is fruit";
    }

    @GetMapping("/fruit")
    public String getFruit() {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        return ops.get("fruit");
    }


}
