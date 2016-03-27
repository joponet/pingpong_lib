package net.pingpong.lib;

public class Delay {
	long last;
	int delay;
	
	public Delay() {
		last = System.nanoTime();		
	}
	
	public void reset() {
		last = System.nanoTime();				
	}
	
	public int get() {
		long now = System.nanoTime();
		delay = (int) ((now-last)/1000000);
		last = now;
		return delay;
	}
}
