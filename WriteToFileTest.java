package JunitTest;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;

public class WriteToFileTest {

	@Test
	public final void testPrintAppointment() throws SQLException {
		WriteToFile a = new WriteToFileImpl();
		int Appointment =-1;
		int ClientID = -1;
		String Date = "test";
		int lawyerID = -1;
		int BranchID = -1;
		String dateCreated = "test";
		boolean dropIn =true;
		assertNotNull(a.printAppointment(Appointment, ClientID, Date, lawyerID, BranchID, dateCreated, dropIn));
	}

}
