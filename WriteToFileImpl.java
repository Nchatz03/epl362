package epl362_project;


	
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;

	public class WriteToFileImpl implements WriteToFile {
		
		public boolean printAppointment(int Appointment,int ClientID, String Date, int lawyerID, int BranchID, String dateCreated,Boolean dropIn) {
			String x;
			if (dropIn == true) {
				x = "YES";
			} else
				x = "NO";
			
			try (FileWriter fw = new FileWriter("C:\\Users\\George\\eclipse-workspace\\epl362_project\\\\Appointments.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw)) {
				out.println("Appointment ID:         " + Appointment);
				// more code
				out.println("Client ID:     " + ClientID);
				// more code
				out.println("Date:     " + Date);
				out.println("Lawyer ID:       " + lawyerID);
				out.println("Branch ID: " + BranchID);
				out.println("Date Created:       " + dateCreated);
				out.println("Drop in?       " + x);
				out.println("\n------------------------------------------------------------\n");
				
			
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			
			return true;
			
			
		}

}
