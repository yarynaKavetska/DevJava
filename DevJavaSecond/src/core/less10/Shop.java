package core.less10;

import java.util.ArrayList;
import java.util.List;

public class Shop {

	private final List<Item> items = new ArrayList<>();
	
	public void init(){
		items.add(new Item("Hsjhdjh", new Manufacturer("Jerer", "Ukraine"),
				65.8, 120, Category.ALCHEMY));
		items.add(new Item("Tdjjjh", new Manufacturer("JGshgd", "USA"),
				34.78, 100, Category.INDUSTRY));
		items.add(new Item("Yhddnnbd", new Manufacturer("Jerer", "Ukraine"),
				98.1, 46, Category.ALCHEMY));
		items.add(new Item("Udnjfn", new Manufacturer("JGshgd", "USA"),
				670.0, 5, Category.WEAPON));
		items.add(new Item("Fjdfhjh", new Manufacturer("UUdndbf", "UK"),
				86.21, 80, Category.ALCHEMY));
		items.add(new Item("Nksjhsd", new Manufacturer("JGshgd", "USA"),
				12.0, 300, Category.ALCHEMY));
		items.add(new Item("Insjjd", new Manufacturer("UUdndbf", "UK"),
				56.8, 1000, Category.INDUSTRY));
		items.add(new Item("Ewqvvvbs", new Manufacturer("Jerer", "Ukraine"),
				111.11, 90, Category.ALCHEMY));
		items.add(new Item("Isjdhjh", new Manufacturer("UUdndbf", "UK"),
				34.8, 56, Category.INDUSTRY));
	}

	public int size() {
		return items.size();
	}

	public void clear() {
		items.clear();
	}
	
	public void addItem(String title, String manufacturerTitle, String country,
			double price, int quantity, String categoryName){
		Category category = Category.valueOf(categoryName.toUpperCase());
		Manufacturer manufacturer = new Manufacturer(manufacturerTitle, country);
		Item item = new Item(title, manufacturer, price, quantity, category);
		items.add(item);
	}
	
	public void sellItem(String title, int quantity){
		for (Item item : items) {
			if(item.getTitle().equalsIgnoreCase(title)){
				int posible = item.getQuantity();
				int current = posible - quantity < 0 ? 0 : posible - quantity;
				item.setQuantity(current);
			}
		}
		removeIfSold();
	}
	
	private void removeIfSold(){
		items.removeIf((item)->item.getQuantity()==0);
	}
	
	public void sortByPrice(){
		items.sort((item1, item2)->(int)(item1.getPrice()*100-item2.getPrice()*100));
	}
	
	public void increase(String categoryName, int percent){
		Category category = Category.valueOf(categoryName.toUpperCase());
		for (Item item : items) {
			if(item.getCategory()==category){
				double curent = item.getPrice();
				item.setPrice(curent*(1+(double)percent/100));
			}
		}
	}

	public List<Item> getItems() {
		return items;
	}
}
