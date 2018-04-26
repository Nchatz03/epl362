/**
 * 
 */
package JunitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * @author NXATZ
 *
 */
public class ReceptionistUITest {

	/**
	 * Test method for {@link JunitTest.ReceptionistUI#insertClient(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testInsertClient() {
		try {
			ReceptionistUI a = new ReceptionistUIImpl();
			String Name = "test";
			String Surname = "test";
			String Sex = "test";
			String DOB = "test";
			String Telephone = "test";
			String Address = "test";
			String Status = "test";
			assertTrue(a.insertClient(Name, Surname, Sex, DOB, Telephone, Address, Status));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.ReceptionistUI#getClient(java.util.ArrayList)}.
	 */
	@Test
	public final void testGetClient() {
		try {
			ReceptionistUI a = new ReceptionistUIImpl();
			ArrayList<Object[]> Q = new ArrayList<Object[]>();
			assertTrue(a.getClient(Q));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.ReceptionistUI#searchClient(java.util.ArrayList, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testSearchClient() {
		try {
			ReceptionistUI a = new ReceptionistUIImpl();
			String Name = "test";
			String Surname = "test";
			ArrayList<Object[]> Q = new ArrayList<Object[]>();
			assertTrue(a.searchClient(Q, Name, Surname));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.ReceptionistUI#insertAppointment(int, java.lang.String, int, int)}.
	 */
	@Test
	public final void testInsertAppointment() {
		try {
			ReceptionistUI a = new ReceptionistUIImpl();
			int ClientID =-1;
			String Date = "test";
			int LawyerID = -1;
			int BranchID = -1;
			assertTrue(a.insertAppointment(ClientID, Date, LawyerID, BranchID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.ReceptionistUI#getAppointments(java.util.ArrayList)}.
	 */
	@Test
	public final void testGetAppointments() {
		try {
			ReceptionistUI a = new ReceptionistUIImpl();
			ArrayList<Object[]> Q = new ArrayList<Object[]>();
			assertTrue(a.getAppointments(Q));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.ReceptionistUI#checkIfClientWent(int, java.lang.String)}.
	 */
	@Test
	public final void testCheckIfClientWent() {
		try {
			ReceptionistUI a = new ReceptionistUIImpl();
			int AppointmentID = -1;
			String accomplish = "1";
			assertTrue(a.checkIfClientWent(AppointmentID, accomplish));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.ReceptionistUI#insertDropIN(int, java.lang.String, int, int)}.
	 */
	@Test
	public final void testInsertDropIN() {
		try {
			ReceptionistUI a = new ReceptionistUIImpl();
			int ClientID = -1;
			String Date = "1";
			int LawyerID = -1;
			int BranchID = -1;
			assertTrue(a.insertDropIN(ClientID, Date, LawyerID, BranchID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.ReceptionistUI#getDropIn(java.util.ArrayList)}.
	 */
	@Test
	public final void testGetDropIn() {
		try {
			ReceptionistUI a = new ReceptionistUIImpl();
			ArrayList<Object[]> Q = new ArrayList<Object[]>();
			assertTrue(a.getDropIn(Q));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.ReceptionistUI#getLawyers(java.util.ArrayList)}.
	 */
	@Test
	public final void testGetLawyers() {
		try {
			ReceptionistUI a = new ReceptionistUIImpl();
			ArrayList<Object[]> Q = new ArrayList<Object[]>();
			assertTrue(a.getLawyers(Q));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.ReceptionistUI#insertLegalOpinion(java.lang.String)}.
	 */
	@Test
	public final void testInsertLegalOpinion() {
		try {
			ReceptionistUI a = new ReceptionistUIImpl();
			String Rec_LegalOp = "test";
			assertTrue(a.insertLegalOpinion(Rec_LegalOp));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.ReceptionistUI#insertRecommendation(java.lang.String)}.
	 */
	@Test
	public final void testInsertRecommendation() {
		try {
			ReceptionistUI a = new ReceptionistUIImpl();
			String Rec = "test";
			assertTrue(a.insertRecommendation(Rec));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
