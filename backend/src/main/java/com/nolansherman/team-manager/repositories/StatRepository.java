package com.nolansherman.team_manager.repositories;

import java.util.List;
import com.nolansherman.team_manager.domains.Stat;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends CrudRepository<Stat, Long> {

    List<Stat> findById(long id);
    List<Stat> findByPlayerID(long id);
}
