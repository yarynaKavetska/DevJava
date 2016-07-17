package less7;

public class Bard {

	private String name;
	
	public Bard(String name) {
		this.name = name;
	}
	
	public void singing(Ballada ballada){
		System.out.print(name+": ");
		ballada.song();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
