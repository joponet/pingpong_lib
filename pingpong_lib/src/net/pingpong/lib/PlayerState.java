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
		
		int pos = posX;
		for (int i=3; i>=0; i--) {
			packet[i]= (byte) pos;
			pos = pos >> 8;
		}
		
		packet[4] = (byte) 0;
		if (goal) packet[4] = (byte) 1;
		
		Integer shoot_l = shoot;
		packet[5] = shoot_l.byteValue();
		
		return packet;
	}
	
	public void set(byte[] packet) {
		for (int i=0; i<4; i++) {
			posX = posX << 8;
			posX = posX + packet[i];
		}
		
		goal = false;
		if (packet[4] == (byte) 1) goal=true;
		
		shoot = (int) packet[5];
	}
}
