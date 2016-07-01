package core.less10;

public class Item {

	private final String title;
	
	private final Manufacturer manufacturer;
	
	private double price;
	
	private int quantity;
	
	private final Category category;

	public Item(String title, Manufacturer manufacturer, double price,
			int quantity, Category category) {
		this.title = title;
		this.manufacturer = manufacturer;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTitle() {
		return title;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public Category getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "Item [title=" + title + ", manufacturer=" + manufacturer
				+ ", price=" + price + ", quantity=" + quantity + ", category="
				+ category + "]";
	}
}
