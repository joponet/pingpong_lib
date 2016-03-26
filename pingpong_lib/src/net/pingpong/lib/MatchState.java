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
	
	public byte[] toByte () {
		byte[] packet = new byte[256];
		// posX_R [0..3]
		packet[2] = (byte) (posX_R >> 8);
		packet[3] = (byte) (posX_R);		
		// posX_Ball [4..7]
		packet[6] = (byte) (posX_Ball >> 8);
		packet[7] = (byte) (posX_Ball);		
		// posY_Ball [8..11]
		packet[10] = (byte) (posY_Ball >> 8);
		packet[11] = (byte) (posY_Ball);		
		// goals_L [12..15]
		packet[14] = (byte) (goals_L >> 8);
		packet[15] = (byte) (goals_L);		
		// goals_R [16..19]
		packet[18] = (byte) (goals_R >> 8);
		packet[19] = (byte) (goals_R);		
		return packet;
	}
	
	public void set (byte[] packet) {
		// posX_R [0..3]
		posX_R = (packet[2] & 0xFF) <<8 | (packet[3] & 0xFF);
		// posX_Ball [4..7]
		posX_Ball = (packet[6] & 0xFF) <<8 | (packet[7] & 0xFF);
		// posY_Ball [8..11]
		posY_Ball = (packet[10] & 0xFF) <<8 | (packet[11] & 0xFF);
		// goals_L [12..15]
		goals_L = (packet[14] & 0xFF) <<8 | (packet[15] & 0xFF);
		// goals_R [16..19]
		goals_R = (packet[18] & 0xFF) <<8 | (packet[19] & 0xFF);
	}
}
