package com.nolansherman.team_manager.converters;

import com.nolansherman.team_manager.domains.Stat;
import com.nolansherman.team_manager.views.StatView;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.LinkedList;

@Component("StatConverter")
public class StatConverter implements Converter<Stat, StatView> {


  /**
  * Convert a View object to a Domain object
  */
  @Override
  public Stat convertToDomain(StatView view){
    Stat stat = new Stat();//create empty team
    //add properties to team.
    stat.setId(view.getId());
    stat.setPlayerID(view.getPlayerID());
    stat.setLabel(view.getLabel());
    stat.setValue(view.getValue());

    return stat;
  }

  /**
  * Convert a domain object to a view object
  */
  @Override
  public StatView convertToView(Stat domain){
    StatView stat = new StatView();

    stat.setId(domain.getId());
    stat.setPlayerID(domain.getPlayerID());
    stat.setLabel(domain.getLabel());
    stat.setValue(domain.getValue());

    return stat;
  }

  /**
  * Converts a list of domain objects to a list of view objects.
  */
  public List<StatView> convertToViews(Iterable<Stat> stats){
    List<StatView> views = new LinkedList<StatView>();
    for(Stat stat : stats)
      views.add(convertToView(stat));

    return views;
  }
}
