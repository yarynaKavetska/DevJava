package less18;

import java.util.concurrent.atomic.AtomicInteger;

public class Singleton {

	private volatile AtomicInteger i = new AtomicInteger(0);
	private static Singleton instance = new Singleton();
	
	private Singleton() {
	}
	
	public static Singleton getInstance(){
		return instance;
	}

	public int getI() {
		synchronized (instance) {
			return i.incrementAndGet();
		}
	}

}
