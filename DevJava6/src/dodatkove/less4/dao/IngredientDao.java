package dodatkove.less4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dodatkove.less4.entity.Ingredient;

public class IngredientDao {

private final Connection conn = SingleConnection.INSTANCE.getConn();
	
	public void create(Ingredient ingredient){
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO "
					+ "Ingredient(name) VALUES (?)");
			ps.setString(1, ingredient.getName());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
		}
	}
	
	public Ingredient readOne(int id){
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM "
					+ "Ingredient where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String name = rs.getString("name");
			Ingredient ingredient = new Ingredient(name);
			ingredient.setId(id);
			ps.close();
			rs.close();
			return ingredient;
		} catch (SQLException e) {
		}
		return null;
	}
	
	public List<Ingredient> readAll(){
		List<Ingredient> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM "
					+ "Ingredient");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				int id = rs.getInt("id");
				Ingredient ingredient = new Ingredient(name);
				ingredient.setId(id);
				list.add(ingredient);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
		}
		return list;
	}
}
