package run;

import thread.NoodleCook;

public class NoodleProgram {
	public static void main(String[] args) {
		try {
			NoodleCook nc = new NoodleCook(4);
			new Thread(nc, "a").start();
			new Thread(nc, "b").start();
			new Thread(nc, "c").start();
			new Thread(nc, "d").start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
