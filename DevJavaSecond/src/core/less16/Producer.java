package core.less16;

public class Producer implements Runnable{

	public Producer() {
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		Connector connector = Connector.getInstance();
		for (int i = 0; i < 100; i++) {
			int task = (int) Math.round(Math.random()*10);
			System.out.println("Producer: "+task);
			connector.addTask(task);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
