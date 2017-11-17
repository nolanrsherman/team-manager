package com.nolansherman.team_manager.converters;

import com.nolansherman.team_manager.domains.Match;
import com.nolansherman.team_manager.views.MatchView;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.LinkedList;

@Component("MatchConverter")
public class MatchConverter implements Converter<Match, MatchView> {


  /**
  * Convert a View object to a Domain object
  */
  @Override
  public Match convertToDomain(MatchView view){
    Match match = new Match();//create empty team
    //add properties to team.
    match.setId(view.getId());
    match.setTeam1Id(view.getTeam1Id());
    match.setTeam2Id(view.getTeam2Id());
    match.setTime(view.getTime());
    match.setGeocode(view.getGeocode());
    match.setScoreTeam1(view.getScoreTeam1());
    match.setScoreTeam2(view.getScoreTeam2());
    match.setIsOver(view.isOver());

    return match;
  }

  /**
  * Convert a domain object to a view object
  */
  @Override
  public MatchView convertToView(Match domain){
    MatchView match = new MatchView();

    match.setId(domain.getId());
    match.setTeam1Id(domain.getTeam1Id());
    match.setTeam2Id(domain.getTeam2Id());
    match.setTime(domain.getTime());
    match.setGeocode(domain.getGeocode());
    match.setScoreTeam1(domain.getScoreTeam1());
    match.setScoreTeam2(domain.getScoreTeam2());
    match.setIsOver(domain.isOver());

    return match;
  }

  /**
  * Converts a list of domain objects to a list of view objects.
  */
  public List<MatchView> convertToViews(Iterable<Match> matchs){
    List<MatchView> views = new LinkedList<MatchView>();
    for(Match match : matchs)
      views.add(convertToView(match));

    return views;
  }
}
