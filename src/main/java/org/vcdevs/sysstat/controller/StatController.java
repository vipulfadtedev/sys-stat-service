package org.vcdevs.sysstat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vcdevs.sysstat.entity.Stat;
import org.vcdevs.sysstat.service.StatService;

import java.util.List;

@RestController
@RequestMapping("stats")
public class StatController {

    @Autowired
    private StatService service;

    @GetMapping
    @RequestMapping("/all")
    public List<Stat> showStats() {
        return service.findAll();
    }

    @GetMapping
    public Stat showStat(@RequestParam("id") long id) {
        return service.findById(id);
    }

    @PostMapping
    public void saveStat(@RequestBody Stat stat) {
        service.save(stat);
    }

    @DeleteMapping
    public void deleteStat(@RequestParam("id") long id) {
        service.deleteById(id);
    }


}
