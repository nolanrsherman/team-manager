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


/**
* A Rest Controller for the Stat Domain
* @author Nolan Sherman
* @since Nov-2017
*/
@RequestMapping("/api/v1/stat")
@RestController
public class StatControllerV1 {

  @Autowired
  StatManager statManager;

  /**
	* Creates a new Stat with the properties of the provided StatView and adds it to the database.
	* @param stat A StatView to store in the database.
	* @return Returns the StatView if the creation was succcessful.
	*/
  @RequestMapping(value = "/", method = RequestMethod.POST)
	public StatView createStat(@RequestBody StatView stat){
    return statManager.add(stat);
  }

	/**
	* Returns a List of all the stats in the database
	* @return A list of all stats.
	*/
  @RequestMapping(value = "/", method = RequestMethod.GET)
	public List<StatView> getAllStats(@RequestParam("playerId")long id){
    return statManager.getAll();
  }

	/**
	* Returns a stat with the ID provided
	* @param id The ID of the stat to return.
	* @return a StatView object with the given ID
	*/
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public StatView getStatById(@PathVariable long id){
    return statManager.get(id);
  }

	/**
	* Removes a stat with the given ID from the database.
	* @param id The ID of the stat to remove from the database.
	* @return The Stat that was removed from the database.
	*/
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public StatView deleteStatById(@PathVariable long id){
    return statManager.delete(id);
  }

	/**
	* Update a given stat.
  * @param id The id of the stat to update
	* @param stat A StatView representing the stat to update.
	* @return The updated StatView.
	*/
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public StatView updateStat(@PathVariable long id, @RequestBody StatView stat){
    return statManager.update(id, stat);
  }


}
