package org.vcdevs.sysstat.service;

import org.vcdevs.sysstat.entity.Stat;

import java.util.List;

public interface StatService {
    List<Stat> findAll();

    List<Stat> findAllInLastHour();

    Stat findById(long id);

    void save(Stat stat);

    void deleteById(long id);
}
