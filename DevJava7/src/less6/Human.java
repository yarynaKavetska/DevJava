package less6;

public class Human {
	
	public static final String CLASS_NAME = "Human";

	private int age;
	
	private final String name;
	
	public static int countOfHumans = 0;
	
	public Human(String name){
		countOfHumans++;
		this.name = name;
	}
	
	public int getCountOfHumans(){
		return countOfHumans;
	}
	
	public void run(){
		System.out.println(name+": go-go-go");
	}
	
	public String toString(){
		return "Human[age="+age+", name="+name+"]";
	}
	
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setAge(final int age){
		if(age<0){
			this.age = 0;
		}else{
			this.age=age;
		}
	}
	
	public static void go(){
		System.out.println("RHhsdfgh");
	}
}
