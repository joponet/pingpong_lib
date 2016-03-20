package net.pingpong.lib;

import java.io.Serializable;

public class MatchState implements Serializable {

	private static final long serialVersionUID = 181077855453321314L;
	int posX_R;
	int posX_Ball , posY_Ball;  
	int goals_L , goals_R;
	boolean pause;
	
	//player1
	public int getRposX(){
		return posX_R;
	}
	public void setRposX(int pos){
		posX_R = pos;		
	}
	
	//Goals
	public int getLgoals(){
		return goals_L;
	}
	public void setLgoal(int goals){
		goals_L = goals;
	}
	public int getRgoals(){
		return goals_R;
	}
	public void setRgoal(int goals){
		goals_R = goals;
	}
	
	//Ball
	public int getBposX(){
		return posX_Ball;
	}
	public int getBposY(){
		return posY_Ball;
	}
	public void setBpos(int x, int y){
		posX_Ball = x;
		posY_Ball = y;
	}
	
	//Pause
	public void pause(){
		pause = true;
	}
	public void start(){
		pause = false;
	}
	public boolean isPaused(){
		return pause;
	}
}
