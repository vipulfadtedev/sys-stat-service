package org.vcdevs.sysstat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HealthController {

    private static final Logger LOGGER=LoggerFactory.getLogger(HealthController.class);

    @GetMapping("/health")
    public String health() {
        LOGGER.info(":::sys-stat-service:::health:::requested::: response -> OK");
        return "OK";
    }

}
