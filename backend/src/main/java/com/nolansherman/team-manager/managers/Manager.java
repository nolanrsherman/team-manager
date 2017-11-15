package com.nolansherman.team_manager.managers;

import java.util.List;

/**
 * A manager interface
 * @author Nolan Sherman
 * @since Nov-2017
 */
public interface Manager<T> {

    public T get(Long id);

    public List<T> getAll();

    public T add(T view);

    public T update(T view);

    public T delete(Long id);
}
