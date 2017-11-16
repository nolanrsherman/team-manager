package com.nolansherman.team_manager.repositories;

import java.util.List;
import com.nolansherman.team_manager.domains.Player;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    List<Player> findById(long id);
    List<Player> findByTeamID(long id);
}
