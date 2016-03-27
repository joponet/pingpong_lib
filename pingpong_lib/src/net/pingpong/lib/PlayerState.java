package net.pingpong.lib;

import java.io.Serializable;

public class PlayerState implements Serializable{

	private static final long serialVersionUID = -1221270601529336999L;
	int posX;
	int posX_ball;
	int posY_ball;
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
		// posX [0..3]
		packet[2] = (byte) (posX >> 8);
		packet[3] = (byte) (posX);		
		// posX_ball [4..7]
		packet[6] = (byte) (posX_ball >> 8);
		packet[7] = (byte) (posX_ball);		
		// posY_ball [8..11]
		packet[10] = (byte) (posY_ball >> 8);
		packet[11] = (byte) (posY_ball);		
		// goal [12..12]
		packet[12] = (byte) 0;
		if (goal) packet[12] = (byte) 1;
		// shoot [13..16]
		packet[16] = (byte) shoot;

		return packet;
	}
	
	public void set(byte[] packet) {
		// posX [0..3]
		posX = (packet[2] & 0xFF) <<8 | (packet[3] & 0xFF);
		// posX_ball [4..7]
		posX_ball = (packet[6] & 0xFF) <<8 | (packet[7] & 0xFF);
		// posY_ball [8..11]
		posX_ball = (packet[10] & 0xFF) <<8 | (packet[11] & 0xFF);
		// goal [12..12]
		goal = false;
		if (packet[12] == (byte) 1) goal=true;
		// shoot [13..16]
		shoot = packet[16];
	}
}
