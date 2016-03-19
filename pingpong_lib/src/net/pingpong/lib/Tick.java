package net.pingpong.lib;

public class Tick {
	// vars
	boolean status;
	long lastTime;
	boolean running;

	// game time
	final double nstick = 1000000000D / 120D;
	double delay = 0;

	public Tick () {
		this.stop();
	}
	public boolean update() {
		ticktime ();
		long now = System.nanoTime();
		if (!running) return false;
		delay += (now-lastTime) / nstick;
		lastTime = now;
		if (delay>=1) {
			delay--;
			return true;
		}
		return false;
	}
	public void start () {
		running = true;
		lastTime = System.nanoTime();		
	}
	void stop () {
		running = false;		
	}
	
	void ticktime () {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
