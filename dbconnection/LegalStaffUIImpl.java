package dbconnection;

import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

public class LegalStaffUIImpl implements LegalStaffUI {

	public Connection connection;

	public LegalStaffUIImpl() throws SQLException {
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

	// ok
	public boolean getClient(ArrayList<Object[]> Q) {

		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from clients where Status='ACTIVE'";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {

				Q.add(new Object[] { result.getString("ID"), result.getString("Name"), result.getString("Surname"),
						result.getString("Sex"), result.getString("DOB"), result.getString("NeedsUpdate"),
						result.getString("Telephone"), result.getString("Address"), result.getString("Status"),
						result.getBoolean("Legal"), result.getBoolean("ChangedRecord") });

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean checkClientExist(int ClientID) {

		String query = "Select * from clients where ID=?";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, ClientID);

			ResultSet result = preparedStmt.executeQuery();
			if (result.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	// ok
	public boolean getCases(ArrayList<Object[]> Q) {

		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from clientcase";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {

				Q.add(new Object[] { result.getString("ID"), result.getString("Client_ID"),
						result.getString("CaseTrans"), result.getString("Rec_LegOp"), result.getString("Lawyer_ID"),
						result.getString("Illegal") });

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	// ok
	public boolean isCaseTheSame(String CaseTrans, int ClientID) {

		String query = "Select * from clientcase where CaseTrans=? AND Client_ID=?";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, CaseTrans);
			preparedStmt.setInt(2, ClientID);

			ResultSet result = preparedStmt.executeQuery();
			if (result.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	// ok
	public boolean addNewCase(String CaseTrans, int ClientID, int LawyerID) {

		String query = "INSERT clientcase(CaseTrans,Client_ID,Lawyer_ID) VALUES (?,?,?)";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, CaseTrans);
			preparedStmt.setInt(2, ClientID);
			preparedStmt.setInt(3, LawyerID);

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean addIllegal(int CaseID) {

		String query = "UPDATE clientcase SET Illegal = ?  WHERE ID=?";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setBoolean(1, true);
			preparedStmt.setInt(2, CaseID);

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean addLegal(int CaseID) {

		String query = "UPDATE clientcase SET Illegal = ?  WHERE ID=?";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setBoolean(1, false);
			preparedStmt.setInt(2, CaseID);

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean isRecommedationTheSame(String Recommendation, int CaseID) {
		String query = "Select * from clientcase where Rec_LegOp =? AND ID=?";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, Recommendation);
			preparedStmt.setInt(2, CaseID);

			ResultSet result = preparedStmt.executeQuery();
			if (result.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean changeRecommendation(String Recommedation, int CaseID) {

		String query = "UPDATE clientcase SET Rec_LegOp = ?  WHERE ID = ? ";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, Recommedation);
			preparedStmt.setInt(2, CaseID);

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean insertRecommendation(String Recommedation, int CaseID) {

		String query = "UPDATE clientcase SET Rec_LegOp = ?  WHERE ID = ?";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, Recommedation);
			preparedStmt.setInt(2, CaseID);

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	// ok

	public boolean addRemoveClient(int ClientID) {
		String query = "INSERT INTO clientremoved(Client_ID,Removed) Values (?,?)";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, ClientID);
			preparedStmt.setBoolean(2, false);

			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	/*
	 * public boolean viewLegalStrategies(ArrayList<Object[]> Q){
	 * 
	 * 
	 * try { Statement stm = connection.createStatement(); String Query =
	 * "Select * from legalstrategies"; ResultSet result; result =
	 * stm.executeQuery(Query);
	 * 
	 * while (result.next()) {
	 * //System.out.print(result.getString("LegalStrategy")+result.getString(
	 * "SideEffects")); Q.add(new Object[] { result.getString("LegalStrategy"),
	 * result.getString("SideEffects")});
	 * 
	 * } } catch (SQLException e) {
	 * 
	 * // TODO Auto-generated catch block e.printStackTrace(); return false; }
	 * 
	 * return true;
	 * 
	 * 
	 * 
	 * }
	 */

	// ok

	public boolean insertRequest(int ClientID, boolean requestName, boolean requestSurname, boolean requestAddress,
			boolean requestPhone, boolean requestDOB, String name, String surname, String Address, String phone,
			String DOB) {

		String query = "INSERT clientrequest(CLientID, Name,Surname,Address,Phone,DOB,"
				+ "NameChange,SurnameChange,AddressChange,PhoneChange,DOBChange,Done) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, ClientID);
			preparedStmt.setBoolean(2, requestName);
			preparedStmt.setBoolean(3, requestSurname);
			preparedStmt.setBoolean(4, requestAddress);
			preparedStmt.setBoolean(5, requestPhone);
			preparedStmt.setBoolean(6, requestDOB);
			preparedStmt.setString(7, name);
			preparedStmt.setString(8, surname);
			preparedStmt.setString(9, Address);
			preparedStmt.setString(10, phone);
			preparedStmt.setString(11, DOB);
			preparedStmt.setBoolean(12, false);
			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean needsUpdate(int ClientID) {
		String query = "UPDATE clients SET NeedsUpdate = ? WHERE ID = ?";

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

	public int getClients(int CaseID) {
		String query = "Select * from clientcase where ID=?";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, CaseID);

			ResultSet result = preparedStmt.executeQuery();
			if (result.next()) {
				return result.getInt("Client_ID");
			} else {
				return -1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

	}

	public boolean updateIllegal(int clientID) {

		String query = "UPDATE clients SET Legal = ? WHERE ID = ?";

		try {

			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setBoolean(1, false);
			preparedStmt.setInt(2, clientID);

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean updateLegal(int clientID) {

		String query = "UPDATE clients SET Legal = ? WHERE ID = ?";

		try {

			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setBoolean(1, true);
			preparedStmt.setInt(2, clientID);

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	// ok
	public boolean getNeedsUpdate(ArrayList<Object[]> Q) {
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from clients where NeedsUpdate = 1";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				// System.out.print(result.getString("ID")+
				// result.getString("Name")+result.getString("Surname")
				// + result.getString("DOB")+result.getString("Sex")+ result.getString("Legal")
				// +result.getString("CaseTrans")+ result.getString("Rec_LegalOp"));

				Q.add(new Object[] { result.getString("ID"), result.getString("Name"), result.getString("Surname"),
						result.getString("NeedsUpdate") });

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	// ok
	public boolean getIllegal(ArrayList<Object[]> Q) {
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from clients where Legal = 0 ";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {

				// System.out.print(result.getString("ID")+
				// result.getString("Name")+result.getString("Surname")
				// + result.getString("DOB")+result.getString("Sex")+ result.getString("Legal")
				// +result.getString("CaseTrans")+ result.getString("Rec_LegalOp"));

				Q.add(new Object[] { result.getString("ID"), result.getString("Name"), result.getString("Surname"),
						result.getString("Legal") });

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	// ok
	public boolean addDispute(int ClientID, int CaseTrans, String Rec_LegOp) {
		String query = "INSERT INTO dispute(Client_ID,DisputeDate,CaseTrans,Rec_LegOp) Values (?,?,?,?)";

		try {

			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date dNOW = new Date();
			String myDate = f.format(dNOW);

			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, ClientID);
			preparedStmt.setString(2, myDate);
			preparedStmt.setInt(3, CaseTrans);
			preparedStmt.setString(4, Rec_LegOp);

			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	// ok
	public boolean addDisputeTransaction(int ClientID, int CaseTrans, String Rec_LegOp, int LawyerID) {
		String query = "INSERT INTO disputetransaction(Client_ID,DisputeDate,Rec_LegOp,CaseTrans,Lawyer_ID) Values (?,?,?,?,?)";

		try {

			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date dNOW = new Date();
			String myDate = f.format(dNOW);
			PreparedStatement preparedStmt = connection.prepareStatement(query);

			preparedStmt.setInt(1, ClientID);
			preparedStmt.setString(2, myDate);
			preparedStmt.setString(3, Rec_LegOp);
			preparedStmt.setInt(4, CaseTrans);
			preparedStmt.setInt(5, LawyerID);

			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	// ok
	public boolean getDispute(ArrayList<Object[]> Q) {
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from dispute";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] { result.getString("ID"), result.getString("Client_ID"),
						result.getString("DisputeDate"), result.getString("CaseTrans"),
						result.getString("Rec_LegOp") });

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	// ok
	public boolean getDisputeTransaction(ArrayList<Object[]> Q) {
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from disputetransaction";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] { result.getString("DisputeTrans_ID"), result.getString("Client_ID"),
						result.getString("DisputeDate"), result.getString("CaseTrans"), result.getString("Rec_LegOp"),
						result.getString("Lawyer_ID") });

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	// ok
	public boolean getUnwilling(ArrayList<Object[]> Q) {
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from unwilling";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] { result.getString("Client_ID"), result.getString("Rec_LegOp") });

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	// ok
	public boolean isUnwilling(int ClientID, String Rec_LegOp) { // String LegalStrategy){

		String Query = "Select * from unwilling where Client_ID = ? AND Rec_LegOp= ? ";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setInt(1, ClientID);
			preparedStmt.setString(2, Rec_LegOp);

			ResultSet result = preparedStmt.executeQuery();
			if (result.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	// ok
	public boolean addUnwilling(int ClientID, String Rec_LegOp) {
		String query = "INSERT INTO unwilling(Client_ID,Rec_LegOp) Values (?,?)";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, ClientID);
			preparedStmt.setString(2, Rec_LegOp);

			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean viewRecommendations(ArrayList<String> Q) {

		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from recommendations";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {

				Q.add(result.getString("Recommendation"));

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean viewLegalOpinions(ArrayList<String> Q) {

		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from legalopinions";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {

				Q.add(result.getString("LegalStrategy"));

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}
	
	public boolean addCaseToAppointments(int AppointmentID,String CaseTrans) {
		
		String query =  "UPDATE appointments SET CaseTrans = ?  WHERE ID=?";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, CaseTrans);
			preparedStmt.setInt(2, AppointmentID);


			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}
	
	
	public boolean getAppointments(int LawyerID, ArrayList<Object[]> Q) {

		String Query = "Select * from appointments Where Lawyer_ID=? AND Accomplish=?";
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setInt(1, LawyerID);
			preparedStmt.setBoolean(2, false);

			ResultSet result;
			result = preparedStmt.executeQuery();

			while (result.next()) {

				Q.add(new Object[] { result.getString("ID"), result.getString("Client_ID"), result.getString("Date"),
						result.getString("DateCreated") });

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}
}
