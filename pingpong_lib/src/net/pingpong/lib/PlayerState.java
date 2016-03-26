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
		// posX
		packet[2] = (byte) (posX >> 8);
		packet[3] = (byte) (posX);		
		// goal
		packet[4] = (byte) 0;
		if (goal) packet[4] = (byte) 1;
		// shoot
		packet[5] = (byte) shoot;

		return packet;
	}
	
	public void set(byte[] packet) {
		// posX
		posX = (packet[2] & 0xFF) <<8 | (packet[3] & 0xFF);
		// goal
		goal = false;
		if (packet[4] == (byte) 1) goal=true;
		// shoot
		shoot = packet[5];
	}
}
