package com.nolansherman.team_manager.domains;

import com.nolansherman.team_manager.domains.Domain;
import javax.persistence.*;

/**
* A Stat is a record of performance of a player for a certain action with some
* sort of numerical value associated with it. (ie. number of goals : 59)
* @author Nolan Sherman
* @since Nov-2017
* @version 1.0
*/
@Entity
public class Stat extends Domain{

  /** The Unique ID for this Stat */
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  /** The ID of the player this stat belongs too */
  private long playerID;

  /** The label of this stat */
  private String label;

  /**The value of this stat */
  private long value;

  public Stat(){}

  public Stat(long playerID, String label, long value){
    this.playerID = playerID;
    this.label = label;
    this.value = value;
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
	* Returns value of playerID
	* @return
	*/
	public long getPlayerID() {
		return playerID;
	}

	/**
	* Sets new value of playerID
	* @param
	*/
	public void setPlayerID(long playerID) {
		this.playerID = playerID;
	}

	/**
	* Returns value of label
	* @return
	*/
	public String getLabel() {
		return label;
	}

	/**
	* Sets new value of label
	* @param
	*/
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	* Returns value of value
	* @return
	*/
	public long getValue() {
		return value;
	}

	/**
	* Sets new value of value
	* @param
	*/
	public void setValue(long value) {
		this.value = value;
	}

	/**
	* Create string representation of Stat for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Stat [id=" + id + ", playerID=" + playerID + ", label=" + label + ", value=" + value + "]";
	}

}
