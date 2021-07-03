package org.vcdevs.sysstat.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HealthController {

    @GetMapping("/health")
    public String showStats() {
        return "OK 200";
    }

}
