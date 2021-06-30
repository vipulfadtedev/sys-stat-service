package org.vcdevs.sysstat.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vcdevs.sysstat.entity.Stat;

import java.util.List;


@Repository
public interface StatRepository extends CrudRepository<Stat, Long>{

    @Query(
            value = "SELECT * FROM vcd_open_projects.stat WHERE timestamp > ?1",
            nativeQuery = true)
    List<Stat> findAllInLastHour(long timestamp);

}