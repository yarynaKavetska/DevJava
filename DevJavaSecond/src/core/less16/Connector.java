package core.less16;

import java.util.LinkedList;
import java.util.Queue;

public class Connector {

	private volatile Queue<Integer> queue = new LinkedList<>();
	
	private static final Connector instance = new Connector();

	private Connector() {
	}
	
	public static Connector getInstance(){
		return instance;
	}

	public Integer getTask(){
		return queue.poll();
	}
	
	public void addTask(int task){
		queue.add(task);
	}
}
