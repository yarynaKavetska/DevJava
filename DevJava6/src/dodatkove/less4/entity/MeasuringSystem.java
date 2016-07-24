package dodatkove.less4.entity;

public class MeasuringSystem {

	private int id;
	
	private String name;

	public MeasuringSystem(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "MeasuringSystem [id=" + id + ", name=" + name + "]";
	}
}
