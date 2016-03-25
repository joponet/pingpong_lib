package net.pingpong.lib;

import java.io.Serializable;

public class PlayerState implements Serializable{

	private static final long serialVersionUID = -1221270601529336999L;
	int posX;
	boolean goal = false;
	int shoot = 0;
	
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
	public int getShoot(){
		return shoot;	
	}
	public void setShoot(int ya){
		shoot = ya;
	}
	
	public void reste(){
		goal = false;
		shoot = 0;
	}
	
	//Global set
	public void set(int posX,boolean goal,int ya){
		this.posX = posX;
		this.goal = goal;
		shoot = ya;
	}
	
	public byte[] toByte () {
		byte[] packet = new byte[256];
		packet[0] = 0;
		return packet;
	}
	
	public void set(byte[] packet) {
		
	}
}
