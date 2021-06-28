package org.vcdevs.sysstat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vcdevs.sysstat.entity.Stat;


@Repository
public interface StatRepository extends CrudRepository<Stat, Long>{
}