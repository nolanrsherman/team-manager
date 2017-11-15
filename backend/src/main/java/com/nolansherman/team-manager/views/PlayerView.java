package com.nolansherman.team_manager.views;
import com.nolansherman.team_manager.views.View;
/**
* The 'View' representation of a Player
* @author Nolan Sherman
* @since Nov-2017
* @version 1.0
*/
public class PlayerView  extends View{
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

  public PlayerView(){}

  public PlayerView(String firstName, String lastName, String position, String phone, long teamID, int number){
    this.firstName = firstName;
    this.lastName = lastName;
    this.position = position;
    this.phone = phone;
    this.teamID = teamID;
    this.number = number;
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



	/**
	* Create string representation of PlayerView for printing
	* @return
	*/
	@Override
	public String toString() {
		return "PlayerView [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", position=" + position + ", phone=" + phone + ", teamID=" + teamID + ", number=" + number  + "]";
	}
}
