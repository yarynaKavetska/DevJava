package core.less16;

public class Consumer extends Thread{

	public Consumer() {
		this.setDaemon(true);
		this.start();
	}

	@Override
	public void run() {
		Connector connector = Connector.getInstance();
		while(true){
			Integer task = connector.getTask();
			if(task!=null){
				if(task%2==0){
					System.out.println("Consumer: even");
				}else{
					System.out.println("Consumer: odd");
				}
			}else{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
