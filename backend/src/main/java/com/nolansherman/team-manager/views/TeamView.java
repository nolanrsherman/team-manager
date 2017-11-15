package com.nolansherman.team_manager.views;

import com.nolansherman.team_manager.views.PlayerView;
import com.nolansherman.team_manager.views.View;

/**
* The 'View' representation of a Team
* @author Nolan Sherman
* @since Nov-2017
* @version 1.0
*/
public class TeamView extends View{

  private long id;

  /** The name of the Team*/
  private String name;

  /** The Team's hometown */
  private String hometown;

  /** The ID of the plaer who is this team's captain */
  private PlayerView captain;




	/**
	* Default empty TeamView constructor
	*/
	public TeamView() {
		super();
	}

	/**
	* Default TeamView constructor
	*/
	public TeamView(long id, String name, String hometown, PlayerView captain) {
		super();
		this.id = id;
		this.name = name;
		this.hometown = hometown;
		this.captain = captain;
	}



	/**
	* Returns value of id
	* @return
	*/
	public long getId() {
		return id;
	}

	/**
	* Sets new value of id
	* @param
	*/
	public void setId(long id) {
		this.id = id;
	}

	/**
	* Returns value of name
	* @return
	*/
	public String getName() {
		return name;
	}

	/**
	* Sets new value of name
	* @param
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Returns value of hometown
	* @return
	*/
	public String getHometown() {
		return hometown;
	}

	/**
	* Sets new value of hometown
	* @param
	*/
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	/**
	* Returns value of captain
	* @return
	*/
	public PlayerView getCaptain() {
		return captain;
	}

	/**
	* Sets new value of captain
	* @param
	*/
	public void setCaptain(PlayerView captain) {
		this.captain = captain;
	}


	/**
	* Create string representation of TeamView for printing
	* @return
	*/
	@Override
	public String toString() {
		return "TeamView [id=" + id + ", name=" + name + ", hometown=" + hometown + ", captain=" + captain + "]";
	}
}
