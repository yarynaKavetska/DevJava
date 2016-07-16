package less6;

public class Hunter extends Human{

	private int killedMammonts = 0;
	
	public Hunter(String name) {
		super(name);
	}

	public void eatMeat(String meat){
		System.out.println(getName()+": nyam nyam "+meat);
	}
	
	public void run(){
		System.out.println(getName()+": faster go-go-go");
	}
	
	public void eatMeat(){
		run();
		killedMammonts++;
		System.out.println(getName()+": I kill mammont "+killedMammonts);
		eatMeat("mammont meat");
	}
	
	public int getKilledMammonts(){
		return killedMammonts;
	}

	public String toString() {
		return "Hunter [killedMammonts=" + killedMammonts + ", age=" + getAge()
				+ ", name=" + getName() + "]";
	}
}
