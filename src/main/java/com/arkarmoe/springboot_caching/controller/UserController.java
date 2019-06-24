package com.arkarmoe.springboot_caching.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caching")
@Cacheable("user")
public class UserController {
    private Logger logger =  LoggerFactory.getLogger(UserController.class);


    @CrossOrigin
    @RequestMapping("/")
    public String helloCaching(){
        logger.info(">>>> Calling greeting function.>>>>>");
        return "Welcome from caching testing project.";
    }

    @CrossOrigin
    @RequestMapping("/{name}")
//    @Cacheable("greetings")
    public String helloCaching(@PathVariable (value = "name")String name){
        logger.info(">>>> Calling greeting name function.>>>>>"+name);
        return "Welcome "+name+" from caching testing project.";
    }

    @CrossOrigin
    @RequestMapping("/name/{name}")
    public String cachingName(@PathVariable (value = "name")String name){
        logger.info(">>>> Caching name >>>>>"+name);
        return "Cache name is "+name;
    }



    @Scheduled(fixedRate = 60000) //one minute
    @CacheEvict(value = "user", allEntries = true)
    public void evictAllCache(){
        logger.info(">>> Evict  cache >>>");
    }
}
