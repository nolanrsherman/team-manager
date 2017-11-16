package com.nolansherman.team_manager.conrtollers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nolansherman.team_manager.views.StatView;
import com.nolansherman.team_manager.managers.StatManager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/api/v1/stat")
@RestController
public class StatControllerV1 {

  @Autowired
  StatManager statManager;

  /**
	* Creates a new Team with the properties of the provided TeamView
	* and adds it to the database.
	* @param team A TeamView to store in the database. The TeamView must have a unique name, hometown and a valid captain: StatView.
	* The StatView must have a name and phone number
	* @return Returns the TeamView if the creation was succcessful. Throws an error if not.
	*/
  @RequestMapping(value = "/", method = RequestMethod.POST)
	public StatView createStat(@RequestBody StatView stat){
    return statManager.add(stat);
  }

	/**
	* Returns a List of all the teams in the database
	* @return A list of all teams.
	*/
  @RequestMapping(value = "/", method = RequestMethod.GET)
	public List<StatView> getAllStats(@RequestParam("playerId")long id){
    return statManager.getAll();
  }

	/**
	* Returns a team with the ID provided
	* @param id The ID of the team to return.
	* @return a TeamView object with the given ID
	*/
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public StatView getStatById(@PathVariable long id){
    return statManager.get(id);
  }

	/**
	* Removes a team with the given ID from the database.
	* @param id The ID of the team to remove from the database.
	* @return The Team that was removed from the database.
	*/
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public StatView deleteStatById(@PathVariable long id){
    return statManager.delete(id);
  }

	/**
	* Update a given team.
	* @param team A TeamView representing the team to update. The ID property of
	* team will be used to select the team to update.
	* @return The updated TeamView.
	*/
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public StatView updateStat(@PathVariable long id, @RequestBody StatView stat){
    return statManager.update(id, stat);
  }


}
