package com.nolansherman.team_manager.managers;

import java.util.List;
import com.nolansherman.team_manager.domains.Match;
import com.nolansherman.team_manager.views.MatchView;
import com.nolansherman.team_manager.repositories.MatchRepository;
import com.nolansherman.team_manager.converters.MatchConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * A manager interface
 * @author Nolan Sherman
 * @since Nov-2017
 */
 @Service
public class MatchManager implements Manager<MatchView> {
    @Autowired
    MatchRepository matchRepo;

    @Autowired
    MatchConverter converter;


    @Override
    public MatchView get(Long id){
      Match match = matchRepo.findOne(id);
      return converter.convertToView(match);
    }

    @Override
    public List<MatchView> getAll(){
      Iterable<Match> matchs = matchRepo.findAll();

      return converter.convertToViews(matchs);
    }

    @Override
    public MatchView add(MatchView view){

      Match match = converter.convertToDomain(view);
      MatchView savedMatch = converter.convertToView(matchRepo.save(match));
      return savedMatch;
    }

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

    @Override
    public MatchView delete(Long id){
      Match match = matchRepo.findOne(id);
      matchRepo.delete(id);
      return converter.convertToView(match);
    }

    public List<MatchView> getMatchsByTeamId(Long id){
      Iterable<Match> matchs = matchRepo.findDistinctMatchByTeam1IdOrTeam2Id(id, id);
      return converter.convertToViews(matchs);
    }
}
