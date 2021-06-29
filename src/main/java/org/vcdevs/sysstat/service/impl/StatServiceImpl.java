package org.vcdevs.sysstat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vcdevs.sysstat.entity.Stat;
import org.vcdevs.sysstat.repository.StatRepository;
import org.vcdevs.sysstat.service.StatService;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class StatServiceImpl implements StatService {

    @Autowired
    private StatRepository repository;

    @Override
    public List<Stat> findAll() {
        return (List<Stat>) repository.findAll();
    }

    @Override
    public Stat findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Stat stat) {
        System.out.println("request before ===>" + stat);
        stat.setId(UUID.randomUUID().toString());
        if (stat.getTimestamp() <= 0) {
            stat.setTimestamp(Instant.now().toEpochMilli());
        }

        System.out.println("request after ===>" + stat);
        repository.save(stat);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}