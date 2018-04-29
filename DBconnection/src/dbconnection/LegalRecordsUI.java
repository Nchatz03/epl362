package dbconnection;

import java.util.ArrayList;

public interface LegalRecordsUI {

	public boolean updateRecord(int ClientID, String Name, String Surname, String DOB, String Telephone, String Address);
	
	public boolean insertClientRecord(Integer clientID, String Name, String Surname,  String DOB,
			String Telephone, String Address);

	public boolean getRequest(ArrayList<Object[]> Q);
	public boolean updateDone(int requestID);
	public boolean updateClientRemove(int ClientID);

	public boolean updateStatus(int ClientID);
	////
	public boolean getClient(ArrayList<Object[]> Q);
	public boolean getAppointments(ArrayList<Object[]> Q) ;
	
	public boolean getCases(ArrayList<Object[]> Q);
	public boolean getDisputeTransaction(ArrayList<Object[]> Q);
	
	public boolean getDispute(ArrayList<Object[]> Q);
	
	//
	
	public boolean noUpdateRecord(int ClientID);
	public boolean requestDecision(int Request_ID, Boolean decision);
	public boolean getWhoNeedsRemoved(ArrayList<Object[]> Q);

}
