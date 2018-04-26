package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LegalRecordsUIImpl implements LegalRecordsUI {

	public Connection connection;

	public LegalRecordsUIImpl() throws SQLException {
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

	public boolean getRequest(ArrayList<Object[]> Q) {

		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from clientrequest WHERE Done=0 ";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {

				Q.add(new Object[] { result.getString("Request_ID"), result.getString("ClientID"),
						result.getString("Name"), result.getString("Surname"), result.getString("Address"),
						result.getString("Phone"), result.getString("DOB"), result.getString("NameChange"),
						result.getString("SurnameChange"), result.getString("AddressChange"),
						result.getString("PhoneChange"), result.getString("DOBChange"), result.getString("Done") });

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean noUpdateRecord(int ClientID) {

		String query = "Select * from clients where ID = ? AND Status = 'ACTIVE' "; // AND NeedsUpdate=1

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, ClientID);

			ResultSet result = preparedStmt.executeQuery();
			if (result.next())
				return false;

			query = "UPDATE clients SET  ChangedRecord = ? NeedsUpdate=? WHERE ID = ? AND Status = ?";

			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setBoolean(1, false);
			preparedStmt.setBoolean(2, false);
			preparedStmt.setInt(3, ClientID);
			preparedStmt.setString(4, "ACTIVE");

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean updateRecord(int ClientID, String Name, String Surname, String DOB, String Telephone,
			String Address) {

		String query = "UPDATE clients SET Name = ? , Surname = ?, DOB = ?, Telephone = ?, Address = ?, ChangedRecord = ? , NeedsUpdate=? WHERE ID = ? AND Status = ?";
		try {

			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, Name);
			preparedStmt.setString(2, Surname);
			preparedStmt.setString(3, DOB);

			preparedStmt.setString(4, Telephone);
			preparedStmt.setString(5, Address);
			preparedStmt.setBoolean(6, true);
			preparedStmt.setBoolean(7, false);
			preparedStmt.setInt(8, ClientID);
			preparedStmt.setString(9, "ACTIVE");

			preparedStmt.execute();

		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean updateDone(int requestID) {

		String query = "UPDATE clientrequest SET Done = ? WHERE Request_ID = ? ";
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			// preparedStmt = connection.prepareStatement(query);
			preparedStmt.setBoolean(1, true);
			preparedStmt.setInt(2, requestID);

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean insertClientRecord(Integer clientID, String Name, String Surname, String DOB, String Telephone,
			String Address) {
		String query = "INSERT INTO clientrsecords(ClientID,Name,Surname, DOB,Telephone,Address,Status,ChangedRecord) Values (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, clientID);
			preparedStmt.setString(2, Name);
			preparedStmt.setString(3, Surname);
			preparedStmt.setString(4, DOB);
			preparedStmt.setString(5, Telephone);
			preparedStmt.setString(6, Address);
			preparedStmt.setString(7, "ACTIVE");
			preparedStmt.setBoolean(8, true);

			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean updateStatus(int ClientID) {

		// String query = "Select * from clients where ID = ? // AND Status = 'ACTIVE'
		// "; // AND NeedsUpdate=1
		String query = "UPDATE clients SET Status = ? WHERE ID = ?";
		try {
			
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, "Read Only");
			preparedStmt.setInt(2, ClientID);

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean updateClientRemove(int ClientID) {

		String query = "UPDATE clientremoved SET Removed = ?  WHERE Client_ID = ?";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setBoolean(1, true);
			preparedStmt.setInt(2, ClientID);

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean getWhoNeedsRemoved(ArrayList<Object[]> Q) {

		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from clientremoved  WHERE Removed=0  ";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {

				Q.add(new Object[] { result.getString("Client_ID") });

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean requestDecision(int Request_ID, Boolean decision) {

		String query = "UPDATE clientrequest SET Accept = ?  WHERE Request_ID = ?";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setBoolean(1, decision);
			preparedStmt.setInt(2, Request_ID);

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}
	
	
	
}
