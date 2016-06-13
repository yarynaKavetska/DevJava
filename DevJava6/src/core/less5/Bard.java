package core.less5;

public class Bard {

	private final String name;

	public Bard(String name) {
		this.name = name;
	}
	
	public void singingBallada(final Ballada ballada){
		System.out.print(name + ": ");
		ballada.singing();
	}
}
