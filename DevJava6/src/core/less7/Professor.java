package core.less7;

public class Professor {

	private final String name;

	public Professor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Professor [name=" + name + "]";
	}
}
