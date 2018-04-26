package dbconnection;

import java.util.ArrayList;

public interface ReceptionistUI {

	public boolean insertClient(String Name, String Surname, String Sex, String DOB, String Telephone, String Address,String Status);

	public boolean getClient(ArrayList<Object[]> Q);
	
	public boolean searchClient(ArrayList<Object[]> Q,String Name, String Surname);
	
	public boolean insertAppointment(int ClientID, String Date,int LawyerID,int BranchID);
	
	public boolean getAppointments(ArrayList<Object[]> Q);

	public boolean checkIfClientWent(int AppointmentID, String accomplish);
	
	public boolean insertDropIN(int ClientID, String Date, int LawyerID, int BranchID);
	
	public boolean getDropIn(ArrayList<Object[]> Q);
	
	public boolean getLawyers(ArrayList<Object[]> Q);
	
	public boolean insertLegalOpinion(String Rec_LegalOp);
	
	public boolean insertRecommendation(String Rec); 
	
	
	
	


}
