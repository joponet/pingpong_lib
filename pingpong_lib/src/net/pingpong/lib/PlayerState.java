package net.pingpong.lib;

import java.io.Serializable;

public class PlayerState implements Serializable{
	private static final long serialVersionUID = 1L;
	int posX;
	boolean goal = false;
	boolean shoot = false;
	
	//Position
	public int getPos(){
		return posX;
	}
	public void setPos(int pos){
		posX = pos;		
	}
	
	//goal
	public boolean isGoal(){
		return goal;	
	}
	public void Goal(){
		goal = true;
	}
	
	//shoot
	public boolean isShoot(){
		return shoot;	
	}
	public void Shoot(){
		shoot = true;
	}
	
	public void reste(){
		goal = false;
		shoot = false;
	}
}
