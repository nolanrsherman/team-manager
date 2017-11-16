package com.nolansherman.team_manager.conrtollers;

import com.nolansherman.team_manager.views.TeamView;
import java.util.List;
/**
* An interface for the Team Rest Controller.
* @author Nolan Sherman
* @since Nov-2017
* @version 1.0
*/
public interface TeamController{

	/**
	* Creates a new Team with the properties of the provided TeamView
	* and adds it to the database.
	* @param team A TeamView to store in the database. The TeamView must have a unique name, hometown and a valid captain: PlayerView.
	* The PlayerView must have a name and phone number
	* @return Returns the TeamView if the creation was succcessful. Throws an error if not.
	*/
	public TeamView createTeam(TeamView team);

	/**
	* Returns a List of all the teams in the database
	* @return A list of all teams.
	*/
	public List<TeamView> getAllTeams();

	/**
	* Returns a team with the ID provided
	* @param id The ID of the team to return.
	* @return a TeamView object with the given ID
	*/
	public TeamView getTeamById(long id);

	/**
	* Removes a team with the given ID from the database.
	* @param id The ID of the team to remove from the database.
	* @return The Team that was removed from the database.
	*/
	public TeamView deleteTeamById(long id);

	/**
	* Update a given team.
	* @param team A TeamView representing the team to update. The ID property of
	* team will be used to select the team to update.
	* @return The updated TeamView.
	*/
	public TeamView updateTeam(long id, TeamView team);

}
