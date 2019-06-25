package com.arkarmoe.springboot_caching.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClearCacheTask {
    Logger logger = LoggerFactory.getLogger(ClearCacheTask.class);

    @Autowired
    private CacheManager cacheManager;
    @Scheduled(fixedRate =60000, initialDelay = 6000)// clear cache every 6sec ,- @Schedule cron
    public void reportCurrentTime() {
        logger.info("Clear caches --->"+cacheManager.getCacheNames().toString());
        cacheManager.getCacheNames().parallelStream().forEach(name -> cacheManager.getCache(name).clear());
    }
}
