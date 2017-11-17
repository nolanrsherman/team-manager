package com.nolansherman.team_manager.repositories;

import java.util.List;
import com.nolansherman.team_manager.domains.Match;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> findById(long id);
    List<Match> findDistinctMatchByTeam1IdOrTeam2Id(long fistTeamId, long secondTeamId);
}
