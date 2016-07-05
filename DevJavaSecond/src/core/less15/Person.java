package core.less15;

public class Person {

	private int id;
	
	private String name;
	
	private int age;
	@Ignore
	private String nick;
	
	public Person(int id, String name, int age, String nick) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.nick = nick;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
