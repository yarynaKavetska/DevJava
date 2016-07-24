package dodatkove.less4;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dodatkove.less4.dao.CollectorDao;
import dodatkove.less4.dao.CountryDao;
import dodatkove.less4.dao.IngredientDao;
import dodatkove.less4.dao.MeasuringSystemDao;
import dodatkove.less4.dao.SingleConnection;
import dodatkove.less4.entity.Ingredient;

public class Main {
	
	private static final Connection conn = SingleConnection.INSTANCE.getConn();
	private static final CountryDao COUNTRY_DAO = new CountryDao();
	private static final IngredientDao INGREDIENT_DAO = new IngredientDao();
	private static final MeasuringSystemDao SYSTEM_DAO = new MeasuringSystemDao();
	private static final CollectorDao COLLECTOR_DAO = new CollectorDao();
	private static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to manage ingredients");
			switch (sc.next()) {
			case "1":{
				addIngredient();
				break;
			}
			case "2":{
				break;
			}
			default:
				isRun = false;
			}
		}
		conn.close();
	}

	private static void addIngredient() {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add ingredient");
			System.out.println("Enter 2 to find by id");
			System.out.println("Enter 3 to find all");
			System.out.println("Enter 0 to exit");
			switch (sc.next()) {
			case "1":{
				System.out.println("Enter ingredient name");
				String name = sc.next();
				Ingredient ingredient = new Ingredient(name);
				INGREDIENT_DAO.create(ingredient);
				break;
			}
			case "2":{
				System.out.println("Enter id of ingredient");
				int id = sc.nextInt();
				Ingredient ingredient = INGREDIENT_DAO.readOne(id);
				System.out.println(ingredient);
				break;
			}
			case "3":{
				List<Ingredient> ingredients = INGREDIENT_DAO.readAll();
				ingredients.forEach(System.out::println);
				break;
			}
			default:
				isRun = false;
			}
		}
	}
}
