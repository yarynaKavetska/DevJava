package dodatkove.less4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dodatkove.less4.entity.Collector;
import dodatkove.less4.entity.Ingredient;
import dodatkove.less4.entity.MeasuringSystem;

public class CollectorDao {

	private final Connection conn = SingleConnection.INSTANCE.getConn();
	
	public void create(Collector collector){
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO "
					+ "Collector(amount, ingredient_id, measuringSystem_id) VALUES (?)");
			ps.setInt(1, collector.getAmount());
			ps.setInt(2, collector.getIngredient().getId());
			ps.setInt(3, collector.getMeasuringSystem().getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
		}
	}
	
	public Collector readOne(int id){
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT "
					+ "Collector.id, Collector.ingredient_id, "
					+ "Collector.measuringSystem_id, "
					+ "MeasuringSystem.name as msName, "
					+ "Ingredient.name as iName FROM "
					+ "Collector JOIN Ingredient ON Ingredient.id "
					+ "= Collector.ingredient_id JOIN MeasuringSystem "
					+ "ON Collector.measuringSystem_id = MeasuringSystem.id"
					+ " where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int ingredientId = rs.getInt("ingredient_id");
			int msId = rs.getInt("measuringSystem_id");
			String msName = rs.getString("msName");
			MeasuringSystem measuringSystem = new MeasuringSystem(msName);
			measuringSystem.setId(msId);
			String iName = rs.getString("iName");
			Ingredient ingredient = new Ingredient(iName);
			ingredient.setId(ingredientId);
			int amount = rs.getInt("amount");
			Collector collector = new Collector(ingredient, measuringSystem, amount);
			collector.setId(id);
			ps.close();
			rs.close();
			return collector;
		} catch (SQLException e) {
		}
		return null;
	}
	
	public List<Collector> readAll(){
		List<Collector> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT "
					+ "Collector.id, Collector.ingredient_id, "
					+ "Collector.measuringSystem_id, "
					+ "MeasuringSystem.name as msName, "
					+ "Ingredient.name as iName FROM "
					+ "Collector JOIN Ingredient ON Ingredient.id "
					+ "= Collector.ingredient_id JOIN MeasuringSystem "
					+ "ON Collector.measuringSystem_id = MeasuringSystem.id");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int ingredientId = rs.getInt("ingredient_id");
				int msId = rs.getInt("measuringSystem_id");
				String msName = rs.getString("msName");
				MeasuringSystem measuringSystem = new MeasuringSystem(msName);
				measuringSystem.setId(msId);
				String iName = rs.getString("iName");
				Ingredient ingredient = new Ingredient(iName);
				ingredient.setId(ingredientId);
				int amount = rs.getInt("amount");
				int id = rs.getInt("id");
				Collector collector = new Collector(ingredient, measuringSystem, amount);
				collector.setId(id);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
		}
		return list;
	}
}
