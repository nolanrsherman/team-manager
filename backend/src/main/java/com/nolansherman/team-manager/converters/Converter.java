package com.nolansherman.team_manager.converters;

import com.nolansherman.team_manager.domains.Domain;
import com.nolansherman.team_manager.views.View;

public interface Converter<D extends Domain, V extends View> {
  /**
  * Convert a View object to a Domain object
  */
  public D convertToDomain(V view);

  /**
  * Convert a domain object to a view object
  */
  public V convertToView(D domain);
}
