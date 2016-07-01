package core.less10;

public class Manufacturer {

	private final String title;
	
	private final String country;

	public Manufacturer(String title, String country) {
		this.title = title;
		this.country = country;
	}

	public String getTitle() {
		return title;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Manufacturer [title=" + title + ", country=" + country + "]";
	}
}
