package epl362_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HOManagementUIImpl implements HOManagementUI {

	public Connection connection;

	public HOManagementUIImpl() throws SQLException {
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

	public boolean getNotAttended(ArrayList<Object[]> Q, String date) {

		String Query = "Select * from appointments WHERE Accomplish=? AND Date=? ";

		try {
			PreparedStatement stm = connection.prepareStatement(Query);
			stm.setBoolean(1, false);
			stm.setString(2, date);

			ResultSet result;
			result = stm.executeQuery();

			while (result.next()) {
				Q.add(new Object[] { result.getString("Client_ID"), result.getString("Name"),
						result.getString("Surname") });

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	// ok
	public boolean CalculateStatistics(int ClientsPerDay[], int casetype[], int Recommendations[], int Allclients[],
			int Branch) {

		String Query = "Select DISTINCT COUNT(*) from clientcase where CaseTrans = ?";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(Query);
			String c = "CaseType1";
			preparedStmt.setString(1, c);

			ResultSet result = preparedStmt.executeQuery();
			if (result.next()) {
				casetype[0] = result.getInt("COUNT(*)");

			}

			preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setString(1, "CaseType2");

			result = preparedStmt.executeQuery();
			if (result.next()) {
				casetype[1] = result.getInt("COUNT(*)");
			}

			preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setString(1, "CaseType3");

			result = preparedStmt.executeQuery();
			if (result.next()) {
				casetype[2] = result.getInt("COUNT(*)");
			}

			preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setString(1, "CaseType4");

			result = preparedStmt.executeQuery();
			if (result.next()) {
				casetype[3] = result.getInt("COUNT(*)");
			}

			preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setString(1, "CaseType5");

			result = preparedStmt.executeQuery();
			if (result.next()) {
				casetype[4] = result.getInt("COUNT(*)");
			}

			// Drug1
			Query = "Select COUNT(*) from clientcase where Rec_LeglOp = ? ";

			preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setString(1, "Legal Opinion 1");

			result = preparedStmt.executeQuery();
			if (result.next()) {
				Recommendations[0] = result.getInt("COUNT(*)");
			}

			// Drug2
			Query = "Select COUNT(*) from clients where Rec_LeglOp = ? ";

			preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setString(1, "Legal Opinion 2");

			result = preparedStmt.executeQuery();
			if (result.next()) {
				Recommendations[1] = result.getInt("COUNT(*)");
			}

			// Drug3
			Query = "Select COUNT(*) from clientcase where Rec_LeglOp = ? ";

			preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setString(1, "Legal Opinion 3");

			result = preparedStmt.executeQuery();
			if (result.next()) {
				Recommendations[2] = result.getInt("COUNT(*)");
			}

			// Drug4
			Query = "Select COUNT(*) from clientcase where Rec_LeglOp = ? ";

			preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setString(1, "Legal Opinion 4");

			result = preparedStmt.executeQuery();
			if (result.next()) {

				Recommendations[3] = result.getInt("COUNT(*)");

			}

			// Drug5
			Query = "Select COUNT(*) from clients where Rec_LeglOp = ? ";

			preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setString(1, "Legal Opinion 5");

			result = preparedStmt.executeQuery();
			if (result.next()) {
				Recommendations[4] = result.getInt("COUNT(*)");
			}

			//

			Query = "SELECT DISTINCT COUNT(Client_ID) FROM appointments WHERE  DATE(Date) = DATE_SUB(CURDATE(), INTERVAL 4 DAY) AND Accomplish = 1 AND Branch_ID = ?";

			preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setInt(1, Branch);
			result = preparedStmt.executeQuery();
			if (result.next()) {
				ClientsPerDay[0] = result.getInt("COUNT(Client_ID)");
			}

			Query = "SELECT DISTINCT COUNT(Client_ID) FROM appointments WHERE  DATE(Date) = DATE_SUB(CURDATE(), INTERVAL 3 DAY) AND Accomplish = 1 AND Branch_ID = ?";

			preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setInt(1, Branch);
			result = preparedStmt.executeQuery();
			if (result.next()) {
				ClientsPerDay[1] = result.getInt("COUNT(Client_ID)");
			}

			Query = "SELECT DISTINCT COUNT(Client_ID) FROM appointments WHERE  DATE(Date) = DATE_SUB(CURDATE(), INTERVAL 2 DAY) AND Accomplish = 1 AND Branch_ID = ?";

			preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setInt(1, Branch);
			result = preparedStmt.executeQuery();
			if (result.next()) {
				ClientsPerDay[2] = result.getInt("COUNT(Client_ID)");
			}

			Query = "SELECT DISTINCT COUNT(Client_ID) FROM appointments WHERE  DATE(Date) = DATE_SUB(CURDATE(), INTERVAL 1 DAY) AND Accomplish = 1 AND Branch_ID = ?";

			preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setInt(1, Branch);
			result = preparedStmt.executeQuery();
			if (result.next()) {
				ClientsPerDay[3] = result.getInt("COUNT(Client_ID)");
			}

			Query = "SELECT DISTINCT COUNT(Client_ID) FROM appointments WHERE  DATE(Date) = DATE_SUB(CURDATE(), INTERVAL 0 DAY) AND Accomplish = 1 AND Branch_ID = ?";

			preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setInt(1, Branch);
			result = preparedStmt.executeQuery();
			if (result.next()) {
				ClientsPerDay[4] = result.getInt("COUNT(Client_ID)");
			}

			Query = "Select DISTINCT COUNT(Client_ID) from appointments WHERE Date >= curdate() - INTERVAL DAYOFWEEK(curdate())"
					+ "+6 DAY AND Date < curdate() - INTERVAL DAYOFWEEK(curdate())-1 DAY";
			preparedStmt = connection.prepareStatement(Query);
			result = preparedStmt.executeQuery();
			if (result.next()) {
				Allclients[0] = result.getInt("COUNT(Client_ID)");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	// ok
	public boolean getClient(ArrayList<Object[]> Q) {

		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from clients";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] { result.getString("ID"), result.getString("Name"), result.getString("Surname"),
						result.getString("CaseTrans"), result.getString("Rec_LeglOp") });

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean insertLegalOpinion(String Rec_LegalOp) {

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

	public boolean insertRecommendation(String Rec) {

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

	public boolean insertCaseType(String CaseType) {

		String query = "INSERT INTO casetypes(CaseType) Values (?)";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, CaseType);

			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

}
