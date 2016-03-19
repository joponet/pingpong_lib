package net.pingpong.lib;

public class Pilota {
	final int width = GameConst.BALL_WIDTH;
	final int height = GameConst.BALL_HEIGHT;
	int xmax;
	int xmin;
	int ymax;
	int ymin;
	int x;
	int y;
	double xd;
	double yd;
	int xa;
	int ya;
	int delaystart=GameConst.DELAYSTART;
	double speed;
	int goal; // 0: no goal, 1:goal playerl, 2: goal player2
	boolean stop;
	public boolean active;
	boolean reset;
	boolean shoot;
	
	public void init() {
		xmax = GameConst.WIDTH-width;
		xmin=0;
		ymax = GameConst.HEIGHT-height-1;
		ymin = 0;
		xa=1;
		ya=-1;
		reset();
		stop=true;
		active=false;
	}
	
	public void reset() {
		speed = GameConst.SPEED;
		goal=0;
		shoot = false;
		reset=false;
		x = xmax/2;
		xd=x;
		y = ymax/2;
		yd=y;
	}
	
	public void start() {
		stop=false;
		delaystart = GameConst.DELAYSTART;
	}
	
	public void stop() {
		stop=true;
	}
	
	public boolean stopped() {
		return stop;
	}
	
	public void tick() {
		if (!active) return;
		if (stop) return;
		if (goal>0) reset();
		if (reset) reset();
		if (delaystart>0) {
			delaystart--;
			return;
		}
		
		xd +=xa*speed;
		x = (int) xd;
		yd +=ya*speed;
		y = (int) yd;
		
		if (x<=xmin) {
			xa=1;
		}

		if (x>=xmax) {
			xa=-1;
		}

		if (y<ymin) {
			//y=1;
			stop();
			ya=1;
			goal=1;
		}
		
		if (y>ymax) {
			//y=ymax;
			stop();
			ya=-1;
			goal=2;
		}
		/*
		int centerx=x+(width/2);
		if((ya == 1) && (y+height >= player1.y) && (centerx >= player1.x) && (centerx <= player1.x+player1.width-1)) {
			ya=-1;
			if (speed<GameConst.MAXSPEED) speed += GameConst.INCSPEED;
			//player1.shoot();
			//sound.click();
			shoot = true;
		}
		else if ((ya <0) && (y <= player2.y+player2.height-1) && (centerx >= player2.x) && (centerx <= player2.x+player2.width-1)) {
			ya=1;
			if (speed<GameConst.MAXSPEED) speed += GameConst.INCSPEED;
			//player2.shoot();
			//sound.click();
			shoot = true;
		}	*/
	}	
	
	public int get_goal () {
		int goal;
		goal = this.goal;
		this.goal = 0;
		return goal;
	}
	
	public void shoot(int ya) {
		this.ya = ya;
		if (speed<GameConst.MAXSPEED) speed += GameConst.INCSPEED;
	}
	
	public int get_y () {
		return y;
	}
	
	public int get_x () {
		return x;
	}
	
	public int get_ya () {
		return ya;
	}


}
