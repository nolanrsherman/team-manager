package com.nolansherman.team_manager.domains;

import com.nolansherman.team_manager.domains.Domain;
import javax.persistence.*;

/**
* A Futbol Team
* @author Nolan Sherman
* @since Nov-2017
* @version 1.0
*/
@Entity
public class Team extends Domain{

  /** The Unique ID for this Team */
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  /** The name of the Team*/
  private String name;

  /** The Team's hometown */
  private String hometown;

  /** The ID of the plaer who is this team's captain */
  private long captainID;

  public Team(){}

	/**
	* Default Team constructor
	*/
	public Team(long id, String name, String hometown, long captainID) {
		super();
		this.id = id;
		this.name = name;
		this.hometown = hometown;
		this.captainID = captainID;
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
	* Returns value of captainID
	* @return
	*/
	public long getCaptainID() {
		return captainID;
	}

	/**
	* Sets new value of captainID
	* @param
	*/
	public void setCaptainID(long captainID) {
		this.captainID = captainID;
	}

	/**
	* Create string representation of Team for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", hometown=" + hometown + ", captainID=" + captainID + "]";
	}

}
