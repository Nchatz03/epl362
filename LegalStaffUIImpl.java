package com.javaworld.sample.helloservice;

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

		String url = "jdbc:mysql://127.0.0.1:3306/v2?useUnicode=true&characterEncoding=utf-8";
		String username = "root";
		String password = "";
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			
			
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
		
		connection = DriverManager.getConnection(url, username, password);

	}
	
	//ok
	public boolean getClient(ArrayList<Object[]> Q){
		 
		try {
			Statement stm = connection.createStatement();
			 String Query = "Select * from clients where Status=ACTIVE";
			 ResultSet result;
			result = stm.executeQuery(Query);			
			
			while(result.next()){
				 Q.add(new Object[]{result.getString("ID"),result.getString("Name"),result.getString("Surname"),result.getString("Sex"), result.getString("DOB")
						 , result.getString("NeedUpdate"),result.getString("DropIn"),result.getString("Telephone"),result.getString("Address")});
				 
			 }
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	
		return true;
		 
	}

	//ok
	public boolean isCaseTheSame(String CaseTrans,int ClientID){
		
		String query = "Select * from clients where CaseTrans=? AND ID=?";
		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString (1, CaseTrans);
			preparedStmt.setInt (2, ClientID);
		  

		    ResultSet result = preparedStmt.executeQuery();
		    if(result.next()){
		    	return true;
		    }
		    else{
		    	return false;
		    }
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	      
	    
		
		
	}

	//ok
	public boolean changeCase(String CaseTrans,int ClientID) {
		
		String query = "UPDATE clients SET CaseTrans = ? , NeedsUpdate = 0 WHERE ID = ? AND Status = 0";

		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString (1, CaseTrans);
			preparedStmt.setInt (2, ClientID);
		  

		    preparedStmt.execute();
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	      
	    return true;
		
		
	}

	//ok
	public boolean isRecommedationTheSame(String Recommendation,int ClientID){
		String query = "Select * from clients where Rec_LegalOp =? AND ID=?";
		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString (1, Recommendation);
			preparedStmt.setInt (2, ClientID);
		  

		    ResultSet result = preparedStmt.executeQuery();
		    if(result.next()){
		    	return true;
		    }
		    else{
		    	return false;
		    }
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	//ok
	public boolean changeRecommendation(String Recommedation,int ClientID){

		String query = "UPDATE clients SET Rec_LegalOp = ?, NeedsUpdate = 0 WHERE ID = ?";

		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString (1, Recommedation);
			preparedStmt.setInt (2, ClientID);
		  

		    preparedStmt.execute();
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		 
		 return true;
	      
	    
		
		
	}

	//ok
	public boolean viewLegalStrategies(ArrayList<Object[]> Q){
		
		
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from legalstrategies";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] { result.getString("LegalStrategy"), result.getString("SideEffects")});

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
		    
		
	      
	}

	//ok
	public boolean updateLater(int ClientID){
		String query = "UPDATE clients SET NeedsUpdate = ? WHERE ID = ?";

		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setBoolean (1, true);
			preparedStmt.setInt (2, ClientID);


		    preparedStmt.execute();
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		 
		 return true;
	}

	//ok
	public boolean getNeedsUpdate(ArrayList<Object[]> Q){
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from clients where NeedsUpdate = 1";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] {result.getString("ID"), result.getString("Name"),result.getString("Surname"), result.getString("DOB"),result.getString("Sex"), result.getString("Legal")
                        ,result.getString("CaseTrans"), result.getString("Rec_LegalOp")});

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
		    
	}

	//ok
	public boolean getIllegal(ArrayList<Object[]> Q){
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from clients where Suicide = 0 ";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] {result.getString("ID"), result.getString("Name"),result.getString("Surname"), result.getString("Legal"),result.getString("CaseTrans"), result.getString("Rec_LegalOp")});

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
		    
	}

    //ok
	public boolean addDispute (int ClientID, String Date, String Description){
		String query = "INSERT INTO dispute(Client_ID,DisputeDate,Description) Values (?,?,?)";
		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, ClientID);
			preparedStmt.setString (2, Date);
		    preparedStmt.setString (3, Description);
		   


		    preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	      
	     return true;
	}

	//ok
	public boolean addDisputeTransaction(int ClientID, String Date, String Description, String LegalStrategy){
		String query = "INSERT INTO disputetransaction(Client_ID,DisputeDate,Description,LegalStrategy) Values (?,?,?,?)";
		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, ClientID);
			preparedStmt.setString (2, Date);
		    preparedStmt.setString (3, Description);
		    preparedStmt.setString (4, LegalStrategy);



		    preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	      
	     return true;
	}

	//ok
	public boolean getDispute(ArrayList<Object[]> Q){
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from dispute";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] {result.getString("ID"),result.getString("Client_ID"),result.getString("DisputeDate"),result.getString("Description")});

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	//ok
	public boolean getDisputeTransaction(ArrayList<Object[]> Q){
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from disputetransaction";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] {result.getString("Dispute_ID"),result.getString("Client_ID"),result.getString("DisputeDate"),result.getString("Description"),result.getString("LegalStrategy")});

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	//ok
	public boolean getUnwilling(ArrayList<Object[]> Q){
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from unwilling";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] {result.getString("Client_ID"),result.getString("LegalStrategy")});

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	//ok
	public boolean isUnwilling(int ClientID, String LegalStrategy){
		
			
			String Query = "Select * from unwilling where Client_ID = ? AND LegalStrategy = ?";
			
			
			 try {
					PreparedStatement preparedStmt = connection.prepareStatement(Query);
					preparedStmt.setInt (1, ClientID);
					preparedStmt.setString (2, LegalStrategy);
				    


				    ResultSet result = preparedStmt.executeQuery();
				    if(result.next()){
				    	return true;
				    }
				    else{
				    	return false;
				    }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
			}
			 
			
			      
			     
	}

	//ok
	public boolean addUnwilling(int ClientID, String LegalStrategy){
		String query = "INSERT INTO unwilling(Client_ID,LegalStrategy) Values (?,?)";
		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, ClientID);
			preparedStmt.setString (2, LegalStrategy);
		    


		    preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	      
	     return true;
	}


	
	

}
