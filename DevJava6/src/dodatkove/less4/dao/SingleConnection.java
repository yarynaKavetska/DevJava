package dodatkove.less4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SingleConnection {

	public static final SingleConnection INSTANCE = new SingleConnection();
	private Connection conn;
	
	private SingleConnection(){
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/lesson",
					"root", "1987");
		} catch (SQLException e) {
		}
		createAllTables();
		createRelationCollectorRecipe();
		createRelationCollectorMS();
		createRelationCollectorIngredient();
		createRelationRecipeCountry();
	}
	
	private void createRelationCollectorRecipe(){
		if(conn!=null){
			try {
				Statement st = conn.createStatement();
				st.execute("ALTER TABLE Recipe_Collector ADD CONSTRAINT "
						+ "fk_recipe_collector_collector FOREIGN KEY (collector_id) "
						+ "REFERENCES Collector(id)");
				st.close();
				st = conn.createStatement();
				st.execute("ALTER TABLE Recipe_Collector ADD CONSTRAINT "
						+ "fk_recipe_collector_recipe FOREIGN KEY (recipe_id) "
						+ "REFERENCES Recipe(id)");
				st.close();
			} catch (SQLException e) {
			}
		}
	}
	
	private void createRelationCollectorMS(){
		if(conn!=null){
			try {
				Statement st = conn.createStatement();
				st.execute("ALTER TABLE Collector ADD CONSTRAINT "
						+ "fk_collector_ms FOREIGN KEY (measuringSystem_id) "
						+ "REFERENCES MeasuringSystem(id)");
				st.close();
			} catch (SQLException e) {
			}
		}
	}
	
	private void createRelationCollectorIngredient(){
		if(conn!=null){
			try {
				Statement st = conn.createStatement();
				st.execute("ALTER TABLE Collector ADD CONSTRAINT "
						+ "fk_collector_ingredient FOREIGN KEY (ingredient_id) "
						+ "REFERENCES Ingredient(id)");
				st.close();
			} catch (SQLException e) {
			}
		}
	}
	
	private void createRelationRecipeCountry(){
		if(conn!=null){
			try {
				Statement st = conn.createStatement();
				st.execute("ALTER TABLE Recipe ADD CONSTRAINT "
						+ "fk_recipe_country FOREIGN KEY (country_id) "
						+ "REFERENCES Country(id)");
				st.close();
			} catch (SQLException e) {
			}
		}
	}
	
	private void createAllTables(){
		try{
			createTableRecipeCollector();
			createTableRecipe();
			createTableCollector();
			createTableMS();
			createTableIngredient();
			createTableCountry();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	private void createTableRecipeCollector() throws SQLException{
		if(conn!=null){
			Statement st = conn.createStatement();
			st.execute("CREATE TABLE IF NOT EXISTS Recipe_Collector("
					+ "recipe_id int,"
					+ "collector_id int)");
			st.close();
		}
	}
	
	private void createTableRecipe() throws SQLException{
		if(conn!=null){
			Statement st = conn.createStatement();
			st.execute("CREATE TABLE IF NOT EXISTS Recipe("
					+ "id int primary key auto_increment, "
					+ "title varchar(255), "
					+ "country_id int)");
			st.close();
		}
	}
	
	private void createTableCollector() throws SQLException{
		if(conn!=null){
			Statement st = conn.createStatement();
			st.execute("CREATE TABLE IF NOT EXISTS Collector("
					+ "id int primary key auto_increment, "
					+ "amount int, "
					+ "ingredient_id int,"
					+ "measuringSystem_id int)");
			st.close();
		}
	}
	
	private void createTableMS() throws SQLException{
		if(conn!=null){
			Statement st = conn.createStatement();
			st.execute("CREATE TABLE IF NOT EXISTS MeasuringSystem("
					+ "id int primary key auto_increment, "
					+ "name varchar(255))");
			st.close();
		}
	}
	
	private void createTableIngredient() throws SQLException{
		if(conn!=null){
			Statement st = conn.createStatement();
			st.execute("CREATE TABLE IF NOT EXISTS Ingredient("
					+ "id int primary key auto_increment, "
					+ "name varchar(255))");
			st.close();
		}
	}
	
	private void createTableCountry() throws SQLException{
		if(conn!=null){
			Statement st = conn.createStatement();
			st.execute("CREATE TABLE IF NOT EXISTS Country("
					+ "id int primary key auto_increment, "
					+ "name varchar(255))");
			st.close();
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
