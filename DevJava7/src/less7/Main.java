package less7;

public class Main {

	public static void main(String[] args) {
		Human human = new Hunter();
		Bard bard = new Bard("Lutik");
		Ballada ballada = new SimpleBallada();
		bard.singing(ballada);
		System.out.println("boo-boo!!!!");
		ballada = new HeroBallada();
		bard.singing(ballada);
		System.out.println("Great!!!!");
	}
}
