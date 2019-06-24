package com.arkarmoe.springboot_caching.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClearSchedule {
    Logger logger = LoggerFactory.getLogger(ClearSchedule.class);

//    @Scheduled(cron = "1 * * * * *")
//    @Scheduled(fixedRate = 6000)
    public void run(){
        logger.info("Schedule is running.");
    }
}
