package core.less21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	private static final ExecutorService SERVICE = Executors.newFixedThreadPool(3);

	public static void main(String[] args) {
		MyThread mt = new MyThread();
//		mt.start();
		SERVICE.execute(mt);
		SERVICE.execute(mt);
		SERVICE.execute(mt);
		SERVICE.execute(mt);
		System.out.println(Thread.currentThread().getName()+" done");
		SERVICE.shutdown();
	}
	
	static void sdsd(){
		synchronized (Main.class) {
			
		}
	}
	
	void asas(){
		synchronized (this) {
			
		}
	}
}
