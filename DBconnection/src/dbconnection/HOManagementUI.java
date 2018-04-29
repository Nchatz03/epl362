package dbconnection;

import java.util.ArrayList;

public interface HOManagementUI {
	public boolean getNotAttended(ArrayList<Object[]> Q,String date);
	public boolean getClient(ArrayList<Object[]> Q); 
	public boolean CalculateStatistics(int ClientsPerDay[], int casetype[],int Recommendations[], int Allclients[], int Branch);
	public boolean insertLegalOpinion(String Rec_LegalOp); 
	public boolean insertRecommendation(String Rec);  
	public boolean insertCaseType(String CaseType);

}