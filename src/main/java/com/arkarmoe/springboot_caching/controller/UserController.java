package com.arkarmoe.springboot_caching.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private Logger logger =  LoggerFactory.getLogger(UserController.class);


    @CrossOrigin
    @RequestMapping("/")
    @Cacheable("user_greeting")
    public String helloCaching(){
        logger.info(">>>> Calling greeting function.>>>>>");
        return "Welcome from caching testing project.";
    }

    @CrossOrigin
    @Cacheable("user_name")
    @RequestMapping("/{name}")
    public String helloCaching(@PathVariable (value = "name")String name){
        logger.info(">>>> Calling greeting name function.>>>>>"+name);
        return "Welcome "+name+" from caching testing project.";
    }

    @CrossOrigin
    @Cacheable("user_id")
    @RequestMapping("/id/{id}")
    public String cachingId(@PathVariable (value = "id")String id){
        logger.info(">>>> Caching user id >>>>>"+id);
        return "Cache name is "+id;
    }


}
