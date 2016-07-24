package dodatkove.less4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dodatkove.less4.entity.MeasuringSystem;

public class MeasuringSystemDao {

private final Connection conn = SingleConnection.INSTANCE.getConn();
	
	public void create(MeasuringSystem measuringSystem){
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO "
					+ "MeasuringSystem(name) VALUES (?)");
			ps.setString(1, measuringSystem.getName());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
		}
	}
	
	public MeasuringSystem readOne(int id){
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM "
					+ "MeasuringSystem where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String name = rs.getString("name");
			MeasuringSystem measuringSystem = new MeasuringSystem(name);
			measuringSystem.setId(id);
			ps.close();
			rs.close();
			return measuringSystem;
		} catch (SQLException e) {
		}
		return null;
	}
	
	public List<MeasuringSystem> readAll(){
		List<MeasuringSystem> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM "
					+ "MeasuringSystem");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				int id = rs.getInt("id");
				MeasuringSystem measuringSystem = new MeasuringSystem(name);
				measuringSystem.setId(id);
				list.add(measuringSystem);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
		}
		return list;
	}
}
