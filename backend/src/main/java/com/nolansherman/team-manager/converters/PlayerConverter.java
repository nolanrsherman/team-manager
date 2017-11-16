package com.nolansherman.team_manager.converters;

import com.nolansherman.team_manager.domains.Player;
import com.nolansherman.team_manager.views.PlayerView;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.LinkedList;

@Component("PlayerConverter")
public class PlayerConverter implements Converter<Player, PlayerView> {


  /**
  * Convert a View object to a Domain object
  */
  @Override
  public Player convertToDomain(PlayerView view){
    Player player = new Player();//create empty team
    //add properties to team.
    player.setId(view.getId());
    player.setFirstName(view.getFirstName());
    player.setLastName(view.getLastName());
    player.setPosition(view.getPosition());
    player.setPhone(view.getPhone());
    player.setTeamID(view.getTeamID());
    player.setNumber(view.getNumber());

    return player;
  }

  /**
  * Convert a domain object to a view object
  */
  @Override
  public PlayerView convertToView(Player domain){
    PlayerView player = new PlayerView();

    player.setId(domain.getId());
    player.setFirstName(domain.getFirstName());
    player.setLastName(domain.getLastName());
    player.setPosition(domain.getPosition());
    player.setPhone(domain.getPhone());
    player.setTeamID(domain.getTeamID());
    player.setNumber(domain.getNumber());

    return player;
  }

  public List<PlayerView> convertToViews(Iterable<Player> players){
    List<PlayerView> views = new LinkedList<PlayerView>();
    for(Player player : players)
      views.add(convertToView(player));

    return views;
  }
}
