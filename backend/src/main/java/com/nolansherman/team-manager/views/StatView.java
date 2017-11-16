package com.nolansherman.team_manager.views;
import com.nolansherman.team_manager.views.View;
/**
* The 'View' representation of a Stat for a player.
* @author Nolan Sherman
* @since Nov-2017
* @version 1.0
*/
public class StatView  extends View{

  private long id;

  /** The ID of the player this stat belongs too */
  private long playerID;

  /** The label of this stat */
  private String label;

  /**The value of this stat */
  private long value;

  public StatView(){}

  public StatView(long playerID, String label, long value){
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
	* Create string representation of StatView for printing
	* @return
	*/
	@Override
	public String toString() {
		return "StatView [id=" + id + ", playerID=" + playerID + ", label=" + label + ", value=" + value + "]";
	}
}
