package core.less3;

public class Hunter extends Human{

	private int killedMammonts;
	
	public Hunter() {
	}

	public Hunter(int age) {
		super(age);
	}

	public void eatMeat(String meat){
		System.out.println("nyam-nyam "+meat);
	}
	
	public void killMammont(){
		killedMammonts++;
		eatMeat("mammont meat");
	}
	
	public void walk(){
		System.out.println("faster go-go-go");
	}
	
	public void talk(){
		System.out.println("bla-bla");
	}
	
	public int getKilledMammonts(){
		return killedMammonts;
	}
	
	public void setAge(int age){
		super.setAge(++age);
	}
}
