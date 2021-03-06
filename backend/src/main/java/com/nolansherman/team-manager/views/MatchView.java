package com.nolansherman.team_manager.views;
import com.nolansherman.team_manager.views.View;
/**
* The 'View' representation of a Match
* @author Nolan Sherman
* @since Nov-2017
* @version 1.0
*/
public class MatchView extends View{

  private long id;

  /** The ID of the team who initiated this match*/
  private long team1Id;

  /** The ID of the other team */
  private long team2Id;

  /** The time and date of the match as a epoch*/
  private long time = 1510885984;

  /** The location of the match */
  private String geocode;

  /**The 1st team's score*/
  private int scoreTeam1 = 0;

  /**The 2nd team's score*/
  private int scoreTeam2 = 0;

  /** Whether or not this match has happened yet*/
  private boolean isOver = false;

  public MatchView(){}

  public MatchView(long team1Id, long team2Id, long time, String geocode,
  int scoreTeam1, int scoreTeam2, boolean isOver){

    this.team1Id = team1Id;
    this.team2Id = team2Id;
    this.time = time;
    this.geocode = geocode;
    this.scoreTeam1 = scoreTeam1;
    this.scoreTeam2 = scoreTeam2;
    this.isOver = isOver;
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
	* Returns value of team1Id
	* @return
	*/
	public long getTeam1Id() {
		return team1Id;
	}

	/**
	* Sets new value of team1Id
	* @param
	*/
	public void setTeam1Id(long team1Id) {
		this.team1Id = team1Id;
	}

	/**
	* Returns value of team2Id
	* @return
	*/
	public long getTeam2Id() {
		return team2Id;
	}

	/**
	* Sets new value of team2Id
	* @param
	*/
	public void setTeam2Id(long team2Id) {
		this.team2Id = team2Id;
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
