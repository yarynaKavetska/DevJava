package ua.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.entity.Category;
import ua.service.CategoryService;

public class Main {

	static final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
			"/META-INF/applicationContext.xml");
	static final CategoryService service = context
			.getBean(CategoryService.class);

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add category");
			System.out.println("Enter 2 to find all");
			System.out.println("Enter 3 change parent");
			System.out.println("Enter 4 to find one");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter category name");
				String name = sc.next();
				System.out.println("Enter parent id, 0 if first category");
				int parentId = sc.nextInt();
				service.save(name, parentId);
				break;
			case "2":
				print(service.findAll());
				break;
			case "3":
				changeParent();
				break;
			case "4":
				findOne();
				break;
			default:
				isRun = false;
			}
		}
		context.close();
	}

	private static void findOne() {
		System.out.println("Enter category id");
		int id = sc.nextInt();
		Category category = service.findOne(id);
		print(category);
	}
	
	private static void print(Category category){
		if(category.getParent()!=null)
		print(category.getParent());
		String tab = "";
		for(int i = 0; i<category.getLevel(); i++){
			tab+="--";
		}
		System.out.println("|"+tab+category.getName());
	}

	private static void changeParent() {
		System.out.println("Enter category id");
		int catId = sc.nextInt();
		System.out.println("Enter category new parent id, 0 if first category");
		int newParentId = sc.nextInt();
		service.changeParent(catId, newParentId);
	}

	static void print(List<Category> categories){
		for (Category category : categories) {
			String tab = "";
			for(int i = 0; i<category.getLevel(); i++){
				tab+="--";
			}
			System.out.println("|"+tab+category.getName());
			print(category.getChilds());
		}
	}
}
