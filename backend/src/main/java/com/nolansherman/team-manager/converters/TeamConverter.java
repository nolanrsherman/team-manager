package com.nolansherman.team_manager.converters;

import com.nolansherman.team_manager.domains.Team;
import com.nolansherman.team_manager.domains.Player;

import com.nolansherman.team_manager.views.TeamView;
import com.nolansherman.team_manager.repositories.PlayerRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.LinkedList;

@Component("TeamConverter")
public class TeamConverter implements Converter<Team, TeamView> {

  @Autowired
  PlayerRepository playerRepo;

  @Autowired
  PlayerConverter pConverter;

  /**
  * Convert a View object to a Domain object
  */
  @Override
  public Team convertToDomain(TeamView view){
    Team team = new Team();//create empty team
    //add properties to team.
    team.setId(view.getId());
    team.setName(view.getName());
    team.setHometown(view.getHometown());
    team.setCaptainID(view.getCaptain().getId());

    return team;
  }

  /**
  * Convert a domain object to a view object
  */
  @Override
  public TeamView convertToView(Team domain){
    TeamView team = new TeamView();

    team.setId(domain.getId());
    team.setName(domain.getName());
    team.setHometown(domain.getHometown());
    Player player = playerRepo.findOne(domain.getCaptainID());
    if(player != null)
      team.setCaptain(pConverter.convertToView(player));

    return team;
  }

  public List<TeamView> convertToViews(Iterable<Team> teams){
    List<TeamView> views = new LinkedList<TeamView>();
    for(Team team : teams)
      views.add(convertToView(team));

    return views;
  }
}
