package dbconnection;

import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

public class ReceptionistUIImpl implements ReceptionistUI {

	public Connection connection;

	public ReceptionistUIImpl() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}

		String url = "jdbc:mysql://127.0.0.1:3306/systemdb_362?useSSL=false";
		String username = "root";
		String password = "";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {

		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}

		connection = DriverManager.getConnection(url, username, password);

	}

	public boolean insertDropIN(int ClientID, String Date, int LawyerID, int BranchID) {
		String query = "Select Status From clients where ID=?";

		try {

			PreparedStatement Stmt = connection.prepareStatement(query);
			Stmt.setInt(1, ClientID);
			ResultSet result = Stmt.executeQuery();

			if (result.next()) {
				if (result.getString("Status").equals("READ ONLY")) {
					return false;

				}
			} else
				return false;

			query = "INSERT INTO appointments (Client_ID,Date,Lawyer_ID,Branch_ID,DateCreated,DropIn) Values (?,?,?,?,?,?)";

			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date dNOW = new Date();
			String myDate = f.format(dNOW);

			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, ClientID);
			preparedStmt.setString(2, Date);
			preparedStmt.setInt(3, LawyerID);
			preparedStmt.setInt(4, BranchID);
			preparedStmt.setString(5, myDate);
			preparedStmt.setBoolean(6, true);

			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean insertClient(String Name, String Surname, String Sex, String DOB, String Telephone, String Address,
			String Status) {
		String query = "INSERT INTO clients(Name,Surname,Sex,DOB,Telephone,Address,Status) Values (?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, Name);
			preparedStmt.setString(2, Surname);
			preparedStmt.setString(3, Sex);
			preparedStmt.setString(4, DOB);
			preparedStmt.setString(5, Telephone);
			preparedStmt.setString(6, Address);
			preparedStmt.setString(7, Status);

			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean getClient(ArrayList<Object[]> Q) {

		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from clients";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				// System.out.println(result.getString("ID")+result.getString("Name")
				// +result.getString("Surname")+
				// result.getString("DOB")+result.getString("Sex")+
				// result.getString("Telephone") + result.getString("Address"));

				Q.add(new Object[] { result.getString("ID"), result.getString("Name"), result.getString("Surname"),
						result.getString("Sex"), result.getString("DOB"), result.getString("Telephone"),
						result.getString("Address"), result.getString("NeedsUpdate"), result.getString("Status"),
						result.getString("ChangedRecord") });

			}
			// System.out.println(Q.toString());
			// columns = new String[]{ "Name", "Surname", "DOB", "Sex", "Telephone",
			// "Address", "Suicide"};
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean searchClient(ArrayList<Object[]> Q, String Name, String Surname) {
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from clients Where Name LIKE ? OR Surname LIKE ?";

			PreparedStatement preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setString(1, "%" + Name + "%");
			preparedStmt.setString(2, "%" + Surname + "%");
			ResultSet result;
			result = preparedStmt.executeQuery();

			while (result.next()) {
				// System.out.println(result.getString("ID")+result.getString("Name")+result.getString("Surname")+
				// result.getString("DOB")+result.getString("Sex")+
				// result.getString("Telephone") + result.getString("Address"));
				Q.add(new Object[] { result.getString("ID"), result.getString("Name"), result.getString("Surname"),
						result.getString("Sex"), result.getString("DOB"), result.getString("Telephone"),
						result.getString("Address"), result.getString("NeedsUpdate"), result.getString("Status"),
						result.getString("ChangedRecord") });
			}
			// System.out.println(Q.toString());
			// columns = new String[]{ "Name", "Surname", "DOB", "Sex", "Telephone",
			// "Address", "Suicide"};
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean insertAppointment(int ClientID, String Date, int LawyerID, int BranchID) {
		String query = "Select Status From clients where ID=?";

		try {

			PreparedStatement Stmt = connection.prepareStatement(query);
			Stmt.setInt(1, ClientID);
			ResultSet result = Stmt.executeQuery();

			if (result.next()) {
				if (result.getString("Status").equals("READ ONLY")) {
					return false;

				}
			} else
				return false;

			query = "INSERT INTO appointments (Client_ID,Date,Lawyer_ID,Branch_ID,DateCreated,DropIn,Accomplish) Values (?,?,?,?,?,?,?)";

			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date dNOW = new Date();
			String myDate = f.format(dNOW);

			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, ClientID);
			preparedStmt.setString(2, Date);
			preparedStmt.setInt(3, LawyerID);
			preparedStmt.setInt(4, BranchID);
			preparedStmt.setString(5, myDate);
			preparedStmt.setBoolean(6, false);
			preparedStmt.setBoolean(7, false);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean getAppointments(ArrayList<Object[]> Q) {
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from appointments";// WHERE DropIn=0";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {

				// System.out.println(result.getString("ID")+result.getString("Client_ID")
				// +result.getString("Date")+
				// result.getString("Lawyer_ID")+result.getString("Branch_ID")+
				// result.getString("DateCreated") + result.getString("Accomplish"));

				Q.add(new Object[] { result.getString("ID"), result.getString("Client_ID"), result.getString("Date"),
						result.getString("Lawyer_ID"), result.getString("Branch_ID"), result.getString("DateCreated"),
						result.getString("Accomplish") });

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean getDropIn(ArrayList<Object[]> Q) {
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from appointments WHERE DropIn=1 ";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {

				// System.out.println(result.getString("ID")+result.getString("Client_ID")
				// +result.getString("Date")+
				// result.getString("Lawyer_ID")+result.getString("Branch_ID")+
				// result.getString("DateCreated") + result.getString("Accomplish"));

				Q.add(new Object[] { result.getString("ID"), result.getString("Client_ID"), result.getString("Date"),
						result.getString("Lawyer_ID"), result.getString("Branch_ID"),
						result.getString("DateCreated"), });

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean checkIfClientWent(int AppointmentID, String went) {
		String query = "UPDATE appointments SET Accomplish = ? WHERE ID = ?";
		boolean flag;

		if (went.equals("YES")) {
			flag = true;
		} else {
			flag = false;
		}

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setBoolean(1, flag);
			preparedStmt.setInt(2, AppointmentID);

			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean getLawyers(ArrayList<Object[]> Q) {

		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from lawyers";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {

				Q.add(new Object[] { result.getString("ID"), result.getString("Name"), result.getString("Surname"),
						result.getString("Branch_ID") });

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean insertLegalOpinion(String Rec_LegalOp) { // tha xrisimopoieitai gia na valoume recommendation kai
															// legal Strategy

		String query = "INSERT INTO legalopinions(LegalStrategy) Values (?)";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, Rec_LegalOp);

			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean insertRecommendation(String Rec) { // tha xrisimopoieitai gia na valoume recommendation kai legal
														// Strategy

		String query = "INSERT INTO recommendations(Recommendation) Values (?)";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, Rec);

			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

}
