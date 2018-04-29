package dbconnection;

import java.net.UnknownServiceException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAuthImpl implements UserAuthentication {

	public Connection connection;

	public UserAuthImpl() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}

		String url = "jdbc:mysql://127.0.0.1:3306/systemdb_362?useUnicode=true&characterEncoding=utf-8";
		String username = "root";
		String password = "";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {

		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}

		connection = DriverManager.getConnection(url, username, password);

	}
	
	

	public String findUserType(String username, String password) {

		String query = "Select * from user where Username=? AND Password=?";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, username);

			ResultSet result = preparedStmt.executeQuery();
			if (result.next()) {
				return result.getString("Type");
			} else {
				return "";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}

}
