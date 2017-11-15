package com.nolansherman.team_manager.conrtollers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nolansherman.team_manager.views.PlayerView;
import com.nolansherman.team_manager.managers.PlayerManager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/api/v1/player")
@RestController
public class PlayerControllerV1 {

  @Autowired
  PlayerManager playerManager;

  /**
	* Creates a new Team with the properties of the provided TeamView
	* and adds it to the database.
	* @param team A TeamView to store in the database. The TeamView must have a unique name, hometown and a valid captain: PlayerView.
	* The PlayerView must have a name and phone number
	* @return Returns the TeamView if the creation was succcessful. Throws an error if not.
	*/
  @RequestMapping(value = "/", method = RequestMethod.POST)
	public PlayerView createPlayer(@RequestBody PlayerView player){
    return null;
  }

	/**
	* Returns a List of all the teams in the database
	* @return A list of all teams.
	*/
  @RequestMapping(value = "/", method = RequestMethod.GET)
	public List<PlayerView> getAllPlayers(){
    return playerManager.getAll();
  }

	/**
	* Returns a team with the ID provided
	* @param id The ID of the team to return.
	* @return a TeamView object with the given ID
	*/
	public PlayerView getPlayerById(long id){
    return null;
  }

	/**
	* Removes a team with the given ID from the database.
	* @param id The ID of the team to remove from the database.
	* @return The Team that was removed from the database.
	*/
	public PlayerView deletePlayerById(long id){
    return null;
  }

	/**
	* Update a given team.
	* @param team A TeamView representing the team to update. The ID property of
	* team will be used to select the team to update.
	* @return The updated TeamView.
	*/
	public PlayerView updatePlayer(PlayerView player){
    return null;
  }



}
