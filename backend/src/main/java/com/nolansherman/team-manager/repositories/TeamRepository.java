package com.nolansherman.team_manager.repositories;

import java.util.List;
import com.nolansherman.team_manager.domains.Team;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    List<Team> findById(long id);
}
