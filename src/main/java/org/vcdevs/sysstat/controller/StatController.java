package org.vcdevs.sysstat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.vcdevs.sysstat.entity.Stat;
import org.vcdevs.sysstat.service.StatService;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("stats")
public class StatController {

    private static final Logger LOGGER=LoggerFactory.getLogger(StatController.class);

    @Autowired
    private StatService service;

    @GetMapping
    public List<Stat> showStats() {
        LOGGER.info("::: sys-stat-service ::: showStats ::: requested ->");
        List<Stat> response = service.findAll();
        LOGGER.info("::: sys-stat-service ::: showStats ::: response -> OK");
        return response;
    }

    @GetMapping("/in-last-hour")
    public List<Stat> showStatsInLastHour() {
        LOGGER.info("::: sys-stat-service ::: showStatsInLastHour ::: requested ->");
        List<Stat> response = service.findAllInLastHour();
        LOGGER.info("::: sys-stat-service ::: showStatsInLastHour ::: response -> OK");
        return response;

    }

    @GetMapping("/{id}")
    public Stat showStat(@RequestParam("id") long id) {
        LOGGER.info("::: sys-stat-service ::: showStat ::: requested ::: id -> ", id);
        Stat response = service.findById(id);
        LOGGER.info("::: sys-stat-service ::: showStat ::: response -> " + response);
        return response;
    }

    @PostMapping
    public void saveStat(@RequestBody Stat stat) {
        LOGGER.info("::: sys-stat-service ::: saveStat ::: requested ::: Stat -> ", stat);
        service.save(stat);
        LOGGER.info("::: sys-stat-service ::: saveStat ::: response -> Created");
    }

    @DeleteMapping("/{id}")
    public void deleteStat(@RequestParam("id") long id) {
        LOGGER.info("::: sys-stat-service ::: deleteStat ::: requested ::: id -> ", id);
        service.deleteById(id);
        LOGGER.info("::: sys-stat-service ::: deleteStat ::: response -> Deleted");
    }

}
