package core.less23;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException{
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lesson", 
						"root", "1987");
		Statement st = conn.createStatement();
		st.execute("CREATE TABLE IF NOT EXISTS Person("
				+ " id int primary key auto_increment,"
				+ " name varchar(255),"
				+ " age int)");
		st.close();
		st = conn.createStatement();
		st.execute("CREATE TABLE IF NOT EXISTS Author(id int primary key auto_increment,_name varchar(255),age int)");
		st.close();
		st = conn.createStatement();
		st.execute("CREATE TABLE IF NOT EXISTS Book(id int primary key auto_increment,title varchar(255),author_id int)");
		st.close();
		
		st = conn.createStatement();
		try {
			st.execute("alter table Book add constraint fk_author_book foreign key (author_id) references Author(id)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		st.close();
		
//		PreparedStatement ps = conn.prepareStatement("INSERT INTO Person"
//				+ " (name, age)"
//				+ " VALUES"
//				+ " (?, ?)");
//		ps.setString(1, "Ivan");
//		ps.setInt(2, 18);
//		ps.execute();
//		ps.setString(1, "Petro");
//		ps.setInt(2, 24);
//		ps.execute();
//		ps.setString(1, "Mykola");
//		ps.setInt(2, 36);
//		ps.execute();
//		ps.close();
		st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Person");
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			System.out.println(id+" "+name+" "+age);
		}
		st.close();
		rs.close();
		conn.close();
	}
}
