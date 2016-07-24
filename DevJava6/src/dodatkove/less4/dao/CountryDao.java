package dodatkove.less4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dodatkove.less4.entity.Country;

public class CountryDao {

	private final Connection conn = SingleConnection.INSTANCE.getConn();
	
	public void create(Country country){
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO "
					+ "Country(name) VALUES (?)");
			ps.setString(1, country.getName());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
		}
	}
	
	public Country readOne(int id){
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM "
					+ "Country where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String name = rs.getString("name");
			Country country = new Country(name);
			country.setId(id);
			ps.close();
			rs.close();
			return country;
		} catch (SQLException e) {
		}
		return null;
	}
	
	public List<Country> readAll(){
		List<Country> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM "
					+ "Country");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				int id = rs.getInt("id");
				Country country = new Country(name);
				country.setId(id);
				list.add(country);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
		}
		return list;
	}
}
