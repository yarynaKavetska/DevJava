package core.less16;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
	
	private static final ExecutorService SERVICE = 
			Executors.newFixedThreadPool(10);

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//		new Producer();
//		new Consumer();
//		System.out.println("End");
		SERVICE.execute(()->{
			System.out.println(12);
		});
		Future<String> future = SERVICE.submit(new Task());
		String result = future.get(2, TimeUnit.SECONDS);
		System.out.println(result);
		SERVICE.shutdown();
	}
}
