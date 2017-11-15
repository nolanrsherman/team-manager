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
    public PlayerView update(PlayerView view){
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
}