package com.arkarmoe.springboot_caching.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Arkar
 * 25-June-2019
 * **/
@Component
@EnableCaching
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("user_greeting"),
                new ConcurrentMapCache("user_name"),
                new ConcurrentMapCache("user_id")
        ));
        return cacheManager;
    }
}
