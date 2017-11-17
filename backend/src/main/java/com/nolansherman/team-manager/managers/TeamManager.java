package com.nolansherman.team_manager.managers;

import java.util.List;
import com.nolansherman.team_manager.domains.Team;
import com.nolansherman.team_manager.views.TeamView;
import com.nolansherman.team_manager.views.PlayerView;
import com.nolansherman.team_manager.repositories.TeamRepository;
import com.nolansherman.team_manager.converters.TeamConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * A manager for the Team domain
 * @author Nolan Sherman
 * @since Nov-2017
 */
 @Service
public class TeamManager implements Manager<TeamView> {
    @Autowired
    TeamRepository teamRepo;

    @Autowired
    TeamConverter converter;

    @Autowired
    PlayerManager playerManager;

    /**
    * Returns a team with the ID provided
    * @param id The ID of the team to return.
    * @return a TeamView object with the given ID
    */
    @Override
    public TeamView get(Long id){
      Team team = teamRepo.findOne(id);
      return converter.convertToView(team);
    }

    /**
    * Returns a List of all the teams in the database
    * @return A list of all teams.
    */
    @Override
    public List<TeamView> getAll(){
      Iterable<Team> teams = teamRepo.findAll();

      return converter.convertToViews(teams);
    }

    /**
    * Creates a new Team with the properties of the provided TeamView and adds it to the database.
    * @param team A TeamView to store in the database. The TeamView must have a unique name, hometown and a valid captain: PlayerView.
    * The PlayerView must have a name and phone number
    * @return Returns the TeamView if the creation was succcessful.
    */
    @Override
    public TeamView add(TeamView view){
      //first get the captain from the team and save it.
      PlayerView pv = view.getCaptain();
      PlayerView savedCaptain = playerManager.add(pv);
      view.setCaptain(savedCaptain);//set the views captain to the saved captain

      Team team = converter.convertToDomain(view);//convert the team to a domain object

      TeamView savedTeam = converter.convertToView(teamRepo.save(team));//save the team

      savedCaptain.setTeamID(savedTeam.getId());//set the captains team ID
      savedCaptain = playerManager.update(savedCaptain.getId(), savedCaptain); //update the id of captain in DB

      savedTeam.setCaptain(savedCaptain);
      return savedTeam;
    }

    /**
    * Update a given team.
    * @param team A TeamView representing the team to update. The ID property of
    * team will be used to select the team to update.
    * @return The updated TeamView.
    */
    @Override
    public TeamView update(long id, TeamView view){
      if(id != view.getId())//if the id is not the same as the view
        return null;//dont do anythign and return null

      if(this.get(id) == null)
        return null;

      Team team = converter.convertToDomain(view);
      TeamView savedTeam = converter.convertToView(teamRepo.save(team));
      return savedTeam;
    }

    /**
    * Removes a team with the given ID from the database.
    * @param id The ID of the team to remove from the database.
    * @return The Team that was removed from the database.
    */
    @Override
    public TeamView delete(Long id){
      Team team = teamRepo.findOne(id);
      teamRepo.delete(id);
      return converter.convertToView(team);
    }
}
