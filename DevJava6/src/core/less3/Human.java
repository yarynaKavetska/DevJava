package core.less3;

public abstract class Human{

	private int age;
	
	private String name;
	
	public Human(int age, String name) {
		setAge(age);
		setName(name);
	}

	public abstract void run();
	
	protected void setAge(int age){
		if(age<0){
			age=0;
		}
		this.age = age;
	}
	
	protected void setName(String name){
		if(name!=null&&!name.isEmpty())
		this.name = name;
	}
	
	protected int getAge(){
		return age;
	}
	
	protected String getName(){
		return name;
	}
	
	public String toString(){
		return "Human [age="+age+", name="+name+"]";
	}
}
