package com.nolansherman.team_manager.conrtollers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nolansherman.team_manager.views.PlayerView;
import com.nolansherman.team_manager.managers.PlayerManager;
import com.nolansherman.team_manager.managers.StatManager;
import com.nolansherman.team_manager.views.StatView;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

/**
* A Rest Controller for the Player Domain
* @author Nolan Sherman
* @since Nov-2017
*/
@RequestMapping("/api/v1/player")
@RestController
public class PlayerControllerV1 {

  @Autowired
  PlayerManager playerManager;

  @Autowired
  StatManager statManager;

  /**
	* Creates a new Player with the properties of the provided PlayerView and adds it to the database.
	* @param player A PlayerView to store in the database.
	* @return Returns the PlayerView if the creation was succcessful.
	*/
  @RequestMapping(value = "/", method = RequestMethod.POST)
	public PlayerView createPlayer(@RequestBody PlayerView player){
    return playerManager.add(player);
  }

	/**
	* Returns a List of all the players in the database
	* @return A list of all players.
	*/
  @RequestMapping(value = "/", method = RequestMethod.GET)
	public List<PlayerView> getAllPlayers(){
    return playerManager.getAll();
  }

	/**
	* Returns a player with the ID provided
	* @param id The ID of the player to return.
	* @return a PlayerView object with the given ID
	*/
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public PlayerView getPlayerById(@PathVariable long id){
    return playerManager.get(id);
  }

	/**
	* Removes a player with the given ID from the database.
	* @param id The ID of the player to remove from the database.
	* @return The Player that was removed from the database.
	*/
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public PlayerView deletePlayerById(@PathVariable long id){
    return playerManager.delete(id);
  }

	/**
	* Update a given player.
  * @param id The id of the player to update
	* @param player A PlayerView representing the player to update.
	* @return The updated PlayerView.
	*/
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public PlayerView updatePlayer(@PathVariable long id, @RequestBody PlayerView player){
    return playerManager.update(id, player);
  }


  /**
	* Get all the stats for a given player by the player's ID.
	* @param id The id of the player whos stats you want a list of.
	* @return A list of stats belonging to the player.
	*/
  @RequestMapping(value = "/{id}/stats", method = RequestMethod.GET)
	public List<StatView> getPlayerStats(@PathVariable long id){
    return statManager.getStatsByPlayerId(id);
  }




}
