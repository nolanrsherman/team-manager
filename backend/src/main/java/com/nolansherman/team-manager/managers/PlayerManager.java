package com.nolansherman.team_manager.managers;

import java.util.List;
import com.nolansherman.team_manager.domains.Player;
import com.nolansherman.team_manager.views.PlayerView;
import com.nolansherman.team_manager.repositories.PlayerRepository;
import com.nolansherman.team_manager.converters.PlayerConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * A manager interface
 * @author Nolan Sherman
 * @since Nov-2017
 */
 @Service
public class PlayerManager implements Manager<PlayerView> {
    @Autowired
    PlayerRepository playerRepo;

    @Autowired
    PlayerConverter converter;


    @Override
    public PlayerView get(Long id){
      Player player = playerRepo.findOne(id);
      return converter.convertToView(player);
    }

    @Override
    public List<PlayerView> getAll(){
      Iterable<Player> players = playerRepo.findAll();

      return converter.convertToViews(players);
    }

    @Override
    public PlayerView add(PlayerView view){

      Player player = converter.convertToDomain(view);
      PlayerView savedPlayer = converter.convertToView(playerRepo.save(player));
      return savedPlayer;
    }

    @Override
    public PlayerView update(long id, PlayerView view){
      if(id != view.getId())//if the id is not the same as the view
        return null;//dont do anythign and return null

      if(this.get(id) == null)
        return null;

      Player player = converter.convertToDomain(view);
      PlayerView savedPlayer = converter.convertToView(playerRepo.save(player));
      return savedPlayer;
    }

    @Override
    public PlayerView delete(Long id){
      Player player = playerRepo.findOne(id);
      playerRepo.delete(id);
      return converter.convertToView(player);
    }

    public List<PlayerView> getPlayersByTeamId(Long id){
      Iterable<Player> players = playerRepo.findByTeamID(id);
      return converter.convertToViews(players);
    }
}
