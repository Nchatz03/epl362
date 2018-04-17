package dbconnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public interface LegalStaffUI {

	
	public boolean getClient(ArrayList<Object[]> Q); //ok
	
	public boolean isCaseTheSame(String CaseTrans,int ClientID); //ok

	public boolean changeCase(String CaseTrans,int ClientID); //ok

	public boolean isRecommedationTheSame(String Recommendation,int ClientID);//ok

	public boolean changeRecommendation(String Recommedation,int ClientID);//ok
	
	public boolean viewLegalStrategies(ArrayList<Object[]> Q); 
	
	public boolean updateLater(int ClientID); // ok
	
	public boolean getNeedsUpdate(ArrayList<Object[]> Q);//ok
	
	public boolean getIllegal(ArrayList<Object[]> Q);//ok
	
	public boolean addDispute(int ClientID, String Date, String Description);//ok
	
	public boolean addDisputeTransaction(int DisputeID, int ClientID, String Date, String Description, String LegalStrategy);
	
	public boolean getDispute(ArrayList<Object[]> Q);//ok
	
	public boolean getDisputeTransaction(ArrayList<Object[]> Q);
	
	public boolean getUnwilling(ArrayList<Object[]> Q); //ok
	
	public boolean isUnwilling(int ClientID);// String LegalStrategy);//ok
	
	public boolean addUnwilling(int ClientID, String LegalStrategy);//ok
	
	
	


}