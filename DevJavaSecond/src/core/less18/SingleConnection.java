package core.less18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {

	private static final SingleConnection INSTANCE = new SingleConnection();
	
	private Connection connection;

	private SingleConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/lesson", "root", "1987");
		} catch (SQLException e) {
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static SingleConnection getInstance(){
		return INSTANCE;
	}
}
