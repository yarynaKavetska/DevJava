package core.less3;

public class Hunter extends Human {
	
	private int count = 0;
	
	public Hunter(int age, String name) {
		super(age, name);
		System.out.println("I am hunter Aghrrrrrrrr!!!!!");
	}
	
	public Hunter(int age, String name, int count) {
		this(age, name);
		this.count = count;
	}

	public void eatMeat(String meat){
		System.out.println(getName() + ": nyam-nyam "+ meat);
	}
	
	public void eatMeat(){
		run();
		count++;
		System.out.println(getName() + ": I kill "+count+" mammont");
		eatMeat("mammont meat");
	}
	
	protected void setAge(int age){
		if(age<20){
			age=20;
		}
		super.setAge(age);
	}
	
	public void run(){
		System.out.println(getName() + ": faster go-go-go");
	}
	
	public String toString(){
		return "Hunter [age="+getAge()+", name="+getName()+" count="+count+"]";
	}
}
