package com.example.learing_redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RedisController {
    final private StringRedisTemplate redisTemplate;

    // /setAnimal?name=name=dog
    // /getAnimal

    @PostMapping("/redis/animal")
    public void setAnimal(@RequestParam String name) {
        var ops = redisTemplate.opsForValue();
        ops.set("animal", name);
    }

    @GetMapping("/redis/animal")
    public String getAnimal() {
        var ops = redisTemplate.opsForValue();
        String animalName = ops.get("animal");

        return animalName;
    }
}
