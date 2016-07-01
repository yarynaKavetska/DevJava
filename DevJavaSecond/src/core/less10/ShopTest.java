package core.less10;


import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShopTest {

	private final Shop shop = new Shop();

	@Before
	public void init() {
		shop.init();
	}

	@After
	public void clear() {
		shop.clear();
	}
	
	@Test
	public void initTest(){
		int actual = shop.size();
		int expected = 9;
		assertEquals(expected, actual);
	}
	
	@Test
	public void addItemTest(){
		shop.addItem("GHdhgf", "JHsdhsdhg", "JHgshg", 23, 50, "INDUSTRY");
		int actual = shop.size();
		int expected = 10;
		assertEquals(expected, actual);
	}
	
	@Test
	public void sellItemTest(){
		shop.sellItem("Isjdhjh", 30);
		int actual = shop.size();
		int expected = 9;
		assertEquals(expected, actual);
	}
	
	@Test
	public void sellItemTest2(){
		shop.sellItem("Isjdhjh", 60);
		int actual = shop.size();
		int expected = 8;
		assertEquals(expected, actual);
	}
	
	@Test
	public void sortByPriceTest(){
		shop.sortByPrice();
		Iterator<Item> iter = shop.getItems().iterator();
		Item first = iter.next();
		while(iter.hasNext()){
			Item second = iter.next();
			boolean test = (first.getPrice()*100)-(second.getPrice()*100) <= 0;
			assertTrue(test);
			first = second;
		}
	}
	
	@Test
	public void increaseTest(){
		double sum = 0;
		String categoryName = "ALCHEMY";
		Category category = Category.valueOf(categoryName);
		int percent = 20;
		for (Item item : shop.getItems()) {
			if(item.getCategory()==category){
				sum+=item.getPrice();
			}
		}
		shop.increase(categoryName, percent);
		double sumInc = 0;
		for (Item item : shop.getItems()) {
			if(item.getCategory()==category){
				sumInc+=item.getPrice();
			}
		}
		System.out.println(((sumInc - sum)/sum)*100);
		int actualPercent = (int) Math.round(((sumInc - sum)/sum)*100);
		assertEquals(percent, actualPercent);
	}
}
