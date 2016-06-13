package less2;

public class Main2 {

	public static void main(String[] args) {
		drive(100);
		stop();
		int a = 200;
		drive(a);
		stop();
		int shgdhg = 300;
		drive(shgdhg);
		stop();
	}
	
	static void drive(int a){
		int d =8;
		System.out.println("Buuummmmm!!!! " + a + " m drived");
	}

	static void stop(){
		System.out.println("stoped");
	}
}
