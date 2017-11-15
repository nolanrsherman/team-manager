package com.nolansherman.team_manager.domains;

import com.nolansherman.team_manager.domains.Domain;
import javax.persistence.*;

/**
* A Player is a member of a Futbol Team
* @author Nolan Sherman
* @since Nov-2017
* @version 1.0
*/
@Entity
public class Player extends Domain{

  /** The Unique ID for this Player */
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  /** The name of the player*/
  private String firstName;

  /** The name of the player*/
  private String lastName;

  /** The players positon */
  private String position;

  /**The players phone number */
  private String phone;

  /** The ID of the team this player belongs too */
  private long teamID;

  /** The jersey number of this player */
  private int number;

  public Player(){}

  public Player(String firstName, String lastName, String position, String phone, long teamID, int number){
    this.firstName = firstName;
    this.lastName = lastName;
    this.position = position;
    this.phone = phone;
    this.teamID = teamID;
    this.number = number;
  }

  @Override
    public String toString() {
        return String.format(
                "Player[id=%d, firstName='%s', lastName='%s', position='%s', phone='%s', teamID='%d', number='%d']",
                id, firstName, lastName, position, phone, teamID, number);
    }



	/**
	* Returns value of id
	* @return
	*/
	public long getId() {
		return id;
	}

  /**
	* Sets the value of id
	* @param
	*/
	public void setId(long id) {
		this.id = id;
	}

	/**
	* Returns value of firstName
	* @return
	*/
	public String getFirstName() {
		return firstName;
	}

	/**
	* Sets new value of firstName
	* @param
	*/
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	* Returns value of lastName
	* @return
	*/
	public String getLastName() {
		return lastName;
	}

	/**
	* Sets new value of lastName
	* @param
	*/
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	* Returns value of position
	* @return
	*/
	public String getPosition() {
		return position;
	}

	/**
	* Sets new value of position
	* @param
	*/
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	* Returns value of phone
	* @return
	*/
	public String getPhone() {
		return phone;
	}

	/**
	* Sets new value of phone
	* @param
	*/
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	* Returns value of teamID
	* @return
	*/
	public long getTeamID() {
		return teamID;
	}

	/**
	* Sets new value of teamID
	* @param
	*/
	public void setTeamID(long teamID) {
		this.teamID = teamID;
	}

	/**
	* Returns value of number
	* @return
	*/
	public int getNumber() {
		return number;
	}

	/**
	* Sets new value of number
	* @param
	*/
	public void setNumber(int number) {
		this.number = number;
	}

}
