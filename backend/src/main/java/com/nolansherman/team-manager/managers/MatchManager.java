package com.nolansherman.team_manager.managers;

import java.util.List;
import com.nolansherman.team_manager.domains.Match;
import com.nolansherman.team_manager.views.MatchView;
import com.nolansherman.team_manager.repositories.MatchRepository;
import com.nolansherman.team_manager.converters.MatchConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * A Manager class for Match
 * @author Nolan Sherman
 * @since Nov-2017
 */
 @Service
public class MatchManager implements Manager<MatchView> {

    @Autowired
    MatchRepository matchRepo;

    @Autowired
    MatchConverter converter;

    /**
  	* Returns a match with the ID provided
  	* @param id The ID of the match to return.
  	* @return a MatchView object with the given ID
  	*/
    @Override
    public MatchView get(Long id){
      Match match = matchRepo.findOne(id);
      return converter.convertToView(match);
    }

    /**
  	* Returns a List of all the Matches in the database
  	* @return A list of all matches.
  	*/
    @Override
    public List<MatchView> getAll(){
      Iterable<Match> matchs = matchRepo.findAll();

      return converter.convertToViews(matchs);
    }

    /**
    * Creates a new Match with the properties of the provided MatchView
    * and adds it to the database.
    * @param match A MatchView to store in the database
    * @return Returns the MatchView if the creation was succcessful.
    */
    @Override
    public MatchView add(MatchView view){

      Match match = converter.convertToDomain(view);
      MatchView savedMatch = converter.convertToView(matchRepo.save(match));
      return savedMatch;
    }

    /**
  	* Update a given match.
  	* @param match A MatchView representing the match to update. The ID property of
  	* team will be used to select the team to update.
    * @param id The id of the match to update
  	* @return The updated MatchView.
  	*/
    @Override
    public MatchView update(long id, MatchView view){
      if(id != view.getId())//if the id is not the same as the view
        return null;//dont do anythign and return null

      if(this.get(id) == null)
        return null;

      Match match = converter.convertToDomain(view);
      MatchView savedMatch = converter.convertToView(matchRepo.save(match));
      return savedMatch;
    }

    /**
  	* Removes a match with the given ID from the database.
  	* @param id The ID of the match to remove from the database.
  	* @return The Match that was removed from the database.
  	*/
    @Override
    public MatchView delete(Long id){
      Match match = matchRepo.findOne(id);
      matchRepo.delete(id);
      return converter.convertToView(match);
    }

    /**
    * Returns a list of all the matches a team has or is scheduled to play in.
    * @param id The ID of the team whos matches you want a list of.
    * @return A list of all the matches for a given team (past and present).
    */
    public List<MatchView> getMatchsByTeamId(Long id){
      Iterable<Match> matchs = matchRepo.findDistinctMatchByTeam1IdOrTeam2Id(id, id);
      return converter.convertToViews(matchs);
    }
}
