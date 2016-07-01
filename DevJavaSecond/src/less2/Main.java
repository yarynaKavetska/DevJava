package less2;

public class Main {

	public static void main(String[] args) {
		int amount = 0;
		amount = drive(100, amount);
		stop();
		amount = drive(400, amount);
		stop();
		amount = drive(1000, amount);
		stop();
		System.out.println("Totaly we go to " + amount + "m");
	}
	
	static int drive(int meter, int am){
		am =am + meter;
		System.out.println("I drive "+meter+" m");
		return am;
	}
	
	static void stop(){
		System.out.println("I'm stoped");
	}
}
