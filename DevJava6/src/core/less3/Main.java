package core.less3;

public class Main {

	public static void main(String[] args) {
		Hunter hunter = new Hunter(18,"Vasyl");
		hunter.eatMeat("bird meat");
		hunter.eatMeat();
		System.out.println(hunter);
	}

}
