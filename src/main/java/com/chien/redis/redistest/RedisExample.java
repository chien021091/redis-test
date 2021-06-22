package com.chien.redis.redistest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisExample implements CommandLineRunner {
    
    @Autowired
    private RedisTemplate<Object, Object> template;

    @Override
    public void run(String... args) throws Exception {
        listExample();
        
        System.out.println(template.opsForList().size("linh_kon"));
        
    }
    
    public void valueExample() {
        template.opsForValue().set("chien", "123");
        System.out.println("value of chien " + template.opsForValue().get("chien"));
    }
    
    public void listExample() {
        List<String> list = List.<String>of("Hello", "Quang Chien");
        
        template.opsForList().rightPushAll("linh_kon", list);
    }

}
