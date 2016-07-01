package core.less3;

public class Human {

	private int age;
	
	public Human(int age) {
		setAge(age);
	}

	public Human() {
	}

	public void walk(){
		System.out.println("go-go-go");
	}
	
	public void walk(int dist){
		talk();
		System.out.println("go-go-go " + dist);
	}
	
	private void talk(){
		System.out.println("bla");
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		age = age > 0 ? age : 1;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Human [age=" + age + "]";
	}
}
