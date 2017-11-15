package com.nolansherman.team_manager.managers;

import java.util.List;
import com.nolansherman.team_manager.domains.Team;
import com.nolansherman.team_manager.views.TeamView;
import com.nolansherman.team_manager.views.PlayerView;
import com.nolansherman.team_manager.repositories.TeamRepository;
import com.nolansherman.team_manager.converters.TeamConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * A manager interface
 * @author Nolan Sherman
 * @since Nov-2017
 */
 @Service
public class TeamManager implements Manager<TeamView> {
    @Autowired
    TeamRepository teamRepo;

    @Autowired
    TeamConverter converter;

    @Autowired
    PlayerManager playerManager;

    @Override
    public TeamView get(Long id){
      Team team = teamRepo.findOne(id);
      return converter.convertToView(team);
    }

    @Override
    public List<TeamView> getAll(){
      Iterable<Team> teams = teamRepo.findAll();

      return converter.convertToViews(teams);
    }

    @Override
    public TeamView add(TeamView view){
      Team team = converter.convertToDomain(view);
      PlayerView pv = view.getCaptain();
      PlayerView savedCaptain = playerManager.add(pv);
      long captainId = savedCaptain.getId();
      TeamView savedTeam = converter.convertToView(teamRepo.save(team));
      return savedTeam;
    }

    @Override
    public TeamView update(TeamView view){
      Team team = converter.convertToDomain(view);
      TeamView savedTeam = converter.convertToView(teamRepo.save(team));
      return savedTeam;
    }

    @Override
    public TeamView delete(Long id){
      Team team = teamRepo.findOne(id);
      teamRepo.delete(id);
      return converter.convertToView(team);
    }
}
