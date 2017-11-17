package com.nolansherman.team_manager.managers;

import java.util.List;
import com.nolansherman.team_manager.domains.Player;
import com.nolansherman.team_manager.views.PlayerView;
import com.nolansherman.team_manager.repositories.PlayerRepository;
import com.nolansherman.team_manager.converters.PlayerConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * A Manager for the Player domain
 * @author Nolan Sherman
 * @since Nov-2017
 */
 @Service
public class PlayerManager implements Manager<PlayerView> {
    @Autowired
    PlayerRepository playerRepo;

    @Autowired
    PlayerConverter converter;

    /**
    * Returns a player with the ID provided
    * @param id The ID of the player to return.
    * @return a PlayerView object with the given ID
    */
    @Override
    public PlayerView get(Long id){
      Player player = playerRepo.findOne(id);
      return converter.convertToView(player);
    }

    /**
    * Returns a List of all the players in the database
    * @return A list of all players.
    */
    @Override
    public List<PlayerView> getAll(){
      Iterable<Player> players = playerRepo.findAll();

      return converter.convertToViews(players);
    }

    /**
    * Creates a new Player with the properties of the provided PlayerView and adds it to the database.
    * @param player A PlayerView to store in the database.
    * @return Returns the PlayerView if the creation was succcessful.
    */
    @Override
    public PlayerView add(PlayerView view){

      Player player = converter.convertToDomain(view);
      PlayerView savedPlayer = converter.convertToView(playerRepo.save(player));
      return savedPlayer;
    }

    /**
  	* Update a given player.
    * @param id The id of the player to update
  	* @param player A PlayerView representing the player to update.
  	* @return The updated PlayerView.
  	*/
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

    /**
    * Removes a player with the given ID from the database.
    * @param id The ID of the player to remove from the database.
    * @return The Player that was removed from the database.
    */
    @Override
    public PlayerView delete(Long id){
      Player player = playerRepo.findOne(id);
      playerRepo.delete(id);
      return converter.convertToView(player);
    }

    /**
    * Returns a list of all the players that belong to a given team.
    * @param id The ID of the team whos player you want a list of.
    * @return A list of all the players that belong to a given team.
    */
    public List<PlayerView> getPlayersByTeamId(Long id){
      Iterable<Player> players = playerRepo.findByTeamID(id);
      return converter.convertToViews(players);
    }
}
