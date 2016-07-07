package core.less16;

import java.util.concurrent.Callable;

public class Task implements Callable<String>{

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Hello";
	}

}
