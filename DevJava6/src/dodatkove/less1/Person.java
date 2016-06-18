package dodatkove.less1;

public class Person implements Human{

	private int age;
	
	private String name;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public Person() {
	}

	@Override
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
