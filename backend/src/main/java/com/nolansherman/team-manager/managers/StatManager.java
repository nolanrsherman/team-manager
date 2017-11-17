package com.nolansherman.team_manager.managers;

import java.util.List;
import com.nolansherman.team_manager.domains.Stat;
import com.nolansherman.team_manager.views.StatView;
import com.nolansherman.team_manager.repositories.StatRepository;
import com.nolansherman.team_manager.converters.StatConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * A manager for the Stat domain
 * @author Nolan Sherman
 * @since Nov-2017
 */
 @Service
public class StatManager implements Manager<StatView> {
    @Autowired
    StatRepository statRepo;

    @Autowired
    StatConverter converter;

    /**
    * Returns a stat with the ID provided
    * @param id The ID of the stat to return.
    * @return a StatView object with the given ID
    */
    @Override
    public StatView get(Long id){
      Stat stat = statRepo.findOne(id);
      return converter.convertToView(stat);
    }

    /**
    * Returns a List of all the stats in the database
    * @return A list of all stats.
    */
    @Override
    public List<StatView> getAll(){
      Iterable<Stat> stats = statRepo.findAll();

      return converter.convertToViews(stats);
    }

    /**
    * Creates a new Stat with the properties of the provided StatView and adds it to the database.
    * @param stat A StatView to store in the database.
    * @return Returns the StatView if the creation was succcessful.
    */
    @Override
    public StatView add(StatView view){

      Stat stat = converter.convertToDomain(view);
      StatView savedStat = converter.convertToView(statRepo.save(stat));
      return savedStat;
    }

    /**
    * Update a given stat.
    * @param id The id of the stat to update
    * @param stat A StatView representing the stat to update.
    * @return The updated StatView.
    */
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

    /**
    * Removes a stat with the given ID from the database.
    * @param id The ID of the stat to remove from the database.
    * @return The Stat that was removed from the database.
    */
    @Override
    public StatView delete(Long id){
      Stat stat = statRepo.findOne(id);
      statRepo.delete(id);
      return converter.convertToView(stat);
    }

    /**
    * Get all the stats for a given player by the player's ID.
    * @param id The id of the player whos stats you want a list of.
    * @return A list of stats belonging to the player.
    */
    public List<StatView> getStatsByPlayerId(Long id){
      Iterable<Stat> stats = statRepo.findByPlayerID(id);
      return converter.convertToViews(stats);
    }
}
