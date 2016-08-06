package less18;

public class MyThread extends Thread{

	private int millis;
	
	public MyThread(int millis) {
		this.millis = millis;
	}

	@Override
	public void run() {
		while(Singleton.getInstance().getI()<=100){
			System.out.println(
					Thread.currentThread().getName()+" "+
							Singleton.getInstance().getI());
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
			}
		}
	}
}