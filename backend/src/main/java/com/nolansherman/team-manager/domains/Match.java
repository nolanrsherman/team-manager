package com.nolansherman.team_manager.domains;

import com.nolansherman.team_manager.domains.Domain;

import javax.persistence.*;

/**
* A Match between two different teams.
* @author Nolan Sherman
* @since Nov-2017
* @version 1.0
*/
@Entity
public class Match extends Domain{
  /** The Unique ID for this Match */
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  /** The ID of the team who initiated this match*/
  private long team1ID;

  /** The ID of the other team */
  private long team2ID;

  /** The time and date of the match as a epoch*/
  private long time;

  /** The location of the match */
  private String geocode;

  /**The 1st team's score*/
  private int scoreTeam1;

  /**The 2nd team's score*/
  private int scoreTeam2;

  /** Whether or not this match has happened yet*/
  private boolean isOver;

  protected Match(){}

  public Match(long team1ID, long team2ID, long time, String geocode,
  int scoreTeam1, int scoreTeam2, boolean isOver){

    this.team1ID = team1ID;
    this.team2ID = team2ID;
    this.time = time;
    this.geocode = geocode;
    this.scoreTeam1 = scoreTeam1;
    this.scoreTeam2 = scoreTeam2;
    this.isOver = isOver;
  }

  @Override
    public String toString() {
        return String.format(
                "Match[id=%d, team1ID='%d', team2ID='%d', time='%d', geocode='%s', scoreTeam1='%d', scoreTeam2='%d', isOver='%b']",
                team1ID, team2ID, time, geocode, scoreTeam1, scoreTeam2, isOver);
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
	* Returns value of team1ID
	* @return
	*/
	public long getTeam1ID() {
		return team1ID;
	}

	/**
	* Sets new value of team1ID
	* @param
	*/
	public void setTeam1ID(long team1ID) {
		this.team1ID = team1ID;
	}

	/**
	* Returns value of team2ID
	* @return
	*/
	public long getTeam2ID() {
		return team2ID;
	}

	/**
	* Sets new value of team2ID
	* @param
	*/
	public void setTeam2ID(long team2ID) {
		this.team2ID = team2ID;
	}

	/**
	* Returns value of time
	* @return
	*/
	public long getTime() {
		return time;
	}

	/**
	* Sets new value of time
	* @param
	*/
	public void setTime(long time) {
		this.time = time;
	}

	/**
	* Returns value of geocode
	* @return
	*/
	public String getGeocode() {
		return geocode;
	}

	/**
	* Sets new value of geocode
	* @param
	*/
	public void setGeocode(String geocode) {
		this.geocode = geocode;
	}

	/**
	* Returns value of scoreTeam1
	* @return
	*/
	public int getScoreTeam1() {
		return scoreTeam1;
	}

	/**
	* Sets new value of scoreTeam1
	* @param
	*/
	public void setScoreTeam1(int scoreTeam1) {
		this.scoreTeam1 = scoreTeam1;
	}

	/**
	* Returns value of scoreTeam2
	* @return
	*/
	public int getScoreTeam2() {
		return scoreTeam2;
	}

	/**
	* Sets new value of scoreTeam2
	* @param
	*/
	public void setScoreTeam2(int scoreTeam2) {
		this.scoreTeam2 = scoreTeam2;
	}

	/**
	* Returns value of isOver
	* @return
	*/
	public boolean isOver() {
		return isOver;
	}

	/**
	* Sets new value of isOver
	* @param
	*/
	public void setIsOver(boolean isOver) {
		this.isOver = isOver;
	}

}
