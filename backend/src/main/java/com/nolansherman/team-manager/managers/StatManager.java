package com.nolansherman.team_manager.managers;

import java.util.List;
import com.nolansherman.team_manager.domains.Stat;
import com.nolansherman.team_manager.views.StatView;
import com.nolansherman.team_manager.repositories.StatRepository;
import com.nolansherman.team_manager.converters.StatConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * A manager interface
 * @author Nolan Sherman
 * @since Nov-2017
 */
 @Service
public class StatManager implements Manager<StatView> {
    @Autowired
    StatRepository statRepo;

    @Autowired
    StatConverter converter;


    @Override
    public StatView get(Long id){
      Stat stat = statRepo.findOne(id);
      return converter.convertToView(stat);
    }

    @Override
    public List<StatView> getAll(){
      Iterable<Stat> stats = statRepo.findAll();

      return converter.convertToViews(stats);
    }

    @Override
    public StatView add(StatView view){

      Stat stat = converter.convertToDomain(view);
      StatView savedStat = converter.convertToView(statRepo.save(stat));
      return savedStat;
    }

    @Override
    public StatView update(long id, StatView view){
      if(id != view.getId())//if the id is not the same as the view
        return null;//dont do anythign and return null

      if(this.get(id) == null)
        return null;

      Stat stat = converter.convertToDomain(view);
      StatView savedStat = converter.convertToView(statRepo.save(stat));
      return savedStat;
    }

    @Override
    public StatView delete(Long id){
      Stat stat = statRepo.findOne(id);
      statRepo.delete(id);
      return converter.convertToView(stat);
    }


    public List<StatView> getStatsByPlayerId(Long id){
      Iterable<Stat> stats = statRepo.findByPlayerID(id);
      return converter.convertToViews(stats);
    }
}
