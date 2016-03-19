package net.pingpong.lib;

public class MatchState {
	int posX_P1;
	int posX_P2;
	int posX_Ball , posY_Ball;  
	int P1_goals , P2_goals;
	boolean pause;
	
	//player1
	public int getP1posX(){
		return posX_P1;
	}
	public void setP1posX(int pos){
		posX_P1 = pos;		
	}
	
	//Player2
	public int getP2posX(){
		return posX_P2;
	}
	public void setP2posX(int pos){
		posX_P2 = pos;		
	}
	
	//Goals
	public int getP1goals(){
		return P1_goals;
	}
	public void addP1goals(){
		P1_goals++;
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
