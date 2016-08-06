package less18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	private final static ExecutorService SERVICE = Executors.newFixedThreadPool(3);

	public static void main(String[] args) {
		SERVICE.execute(new MyThread(300));
		SERVICE.execute(new MyThread(300));
		SERVICE.execute(new MyThread(300));
		SERVICE.shutdown();
	}
}