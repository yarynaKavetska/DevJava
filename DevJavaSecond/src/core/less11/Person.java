package core.less11;

public class Person {

	private String name;
	
	private int age;

	public Person(String name, int age) {
		this.name = name;
		if(age < 0 || age > 120) throw new IllegalArgumentException
		("Person age can be betwean 0 and 120");
		this.age = age;
	}
	
	public void changeAge(String age){
		this.age = Integer.valueOf(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
