package com.nolansherman.team_manager.conrtollers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nolansherman.team_manager.views.MatchView;
import com.nolansherman.team_manager.managers.MatchManager;
import com.nolansherman.team_manager.managers.StatManager;
import com.nolansherman.team_manager.views.StatView;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

/**
* A Rest Controller for the Match Domain
*
* @author Nolan Sherman
* @since Nov-2017
*/
@RequestMapping("/api/v1/match")
@RestController
public class MatchControllerV1 {

  @Autowired
  MatchManager matchManager;

  @Autowired
  StatManager statManager;

  /**
	* Creates a new Match with the properties of the provided MatchView
	* and adds it to the database.
	* @param match A MatchView to store in the database
	* @return Returns the MatchView if the creation was succcessful.
	*/
  @RequestMapping(value = "/", method = RequestMethod.POST)
	public MatchView createMatch(@RequestBody MatchView match){
    return matchManager.add(match);
  }

	/**
	* Returns a List of all the Matches in the database
	* @return A list of all matches.
	*/
  @RequestMapping(value = "/", method = RequestMethod.GET)
	public List<MatchView> getAllMatchs(){
    return matchManager.getAll();
  }

	/**
	* Returns a match with the ID provided
	* @param id The ID of the match to return.
	* @return a MatchView object with the given ID
	*/
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MatchView getMatchById(@PathVariable long id){
    return matchManager.get(id);
  }

	/**
	* Removes a match with the given ID from the database.
	* @param id The ID of the match to remove from the database.
	* @return The Match that was removed from the database.
	*/
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MatchView deleteMatchById(@PathVariable long id){
    return matchManager.delete(id);
  }

	/**
	* Update a given match.
	* @param match A MatchView representing the match to update. The ID property of
	* team will be used to select the team to update.
  * @param id The id of the match to update
	* @return The updated MatchView.
	*/
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public MatchView updateMatch(@PathVariable long id, @RequestBody MatchView match){
    return matchManager.update(id, match);
  }





}
