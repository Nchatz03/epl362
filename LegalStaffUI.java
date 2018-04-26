package epl362_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public interface LegalStaffUI {

	public boolean getClient(ArrayList<Object[]> Q); // ok

	public boolean isCaseTheSame(String CaseTrans, int ClientID); // ok

	public boolean addNewCase(String CaseTrans, int ClientID, int LawyerID);
	
	public boolean addCaseToAppointments(int AppointmentID,String CaseTrans);
	
	public boolean getAppointments(int LawyerID,ArrayList<Object[]> Q) ;
	
	// public boolean changeCase(String CaseTrans,int ClientID); //ok

	public boolean addIllegal(int CaseID);

	public boolean addLegal(int CaseID);

	public boolean isRecommedationTheSame(String Recommendation, int CaseID);// ok

	public boolean changeRecommendation(String Recommedation, int CaseID);// ok

	public boolean insertRecommendation(String Recommedation, int CaseID);


	public boolean insertRequest(int ClientID,boolean requestName,
			boolean requestSurname,boolean requestAddress,boolean requestPhone,
			boolean requestDOB,String name,String surname,String Address,String phone,String DOB); // ok

	public boolean needsUpdate(int ClientID);

	public int getClients(int CaseID);

	public boolean updateIllegal(int ClientID);

	public boolean updateLegal(int ClientID);

	public boolean getNeedsUpdate(ArrayList<Object[]> Q);// ok

	public boolean getIllegal(ArrayList<Object[]> Q);// ok

	public boolean addDispute(int ClientID, int CaseTrans, String Rec_LegOp);// ok

	public boolean addDisputeTransaction(int ClientID, int CaseTrans, String Rec_LegOp, int LawyerID);

	public boolean getDispute(ArrayList<Object[]> Q);// ok

	public boolean getDisputeTransaction(ArrayList<Object[]> Q);

	public boolean getUnwilling(ArrayList<Object[]> Q); // ok

	public boolean isUnwilling(int ClientID, String Rec_LegOp);// ok

	public boolean addUnwilling(int ClientID, String Rec_LegOp);// ok

	public boolean viewRecommendations(ArrayList<String> Q);

	public boolean viewLegalOpinions(ArrayList<String> Q);

	public boolean getCases(ArrayList<Object[]> Q);

	public boolean checkClientExist(int ClientID);
	
	public boolean addRemoveClient(int ClientID);

}