package test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import dbconnection.LegalRecordsUI;
import dbconnection.LegalRecordsUIImpl;

public class LegalRecordsUITest {

	/**
	 * Test method for {@link JunitTest.LegalRecordsUI#updateRecord(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testUpdateRecord() {
		try {
			LegalRecordsUI a = new LegalRecordsUIImpl();
			int ClientID = -1;
			String Name = "test";
			String Surname = "test";
			String DOB = "test";
			String Telephone = "test";
			String Address = "test";
			assertTrue(a.updateRecord(ClientID, Name, Surname, DOB, Telephone, Address));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	/**
	 * Test method for {@link JunitTest.LegalRecordsUI#insertClientRecord(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testInsertClientRecord() {
		try {
			LegalRecordsUI a = new LegalRecordsUIImpl();
			int clientID = -1;
			String Name = "test";
			String Surname = "test";
			String Sex = "test";
			String DOB = "test";
			String Telephone = "test";
			String Address = "test";
			assertTrue(a.insertClientRecord(clientID, Name, Surname, Sex, DOB, Telephone));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalRecordsUI#noUpdateRecord(int)}.
	 */
	@Test
	public final void testNoUpdateRecord() {
		try {
			LegalRecordsUI a = new LegalRecordsUIImpl();
			int ClientID = -1;
			assertTrue(a.noUpdateRecord(ClientID));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalRecordsUI#getRequest(java.util.ArrayList)}.
	 */
	@Test
	public final void testGetRequest() {
		try {
			LegalRecordsUI a = new LegalRecordsUIImpl();
 			ArrayList<Object[]> Q = new ArrayList<Object[]>();
			assertTrue(a.getRequest(Q));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalRecordsUI#updateDone(int)}.
	 */
	@Test
	public final void testUpdateDone() {
		try {
			LegalRecordsUI a = new LegalRecordsUIImpl();
			int requestID = -1;
			assertTrue(a.updateDone(requestID));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalRecordsUI#requestDecision(int, java.lang.Boolean)}.
	 */
	@Test
	public final void testRequestDecision() {
		try {
			LegalRecordsUI a = new LegalRecordsUIImpl();
			int Request_ID = -1;
			boolean decision = true;
			assertTrue(a.requestDecision(Request_ID, decision));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalRecordsUI#updateClientRemove(int)}.
	 */
	@Test
	public final void testUpdateClientRemove() {
		try {
			LegalRecordsUI a = new LegalRecordsUIImpl();
			int ClientID = -1;
			assertTrue(a.updateClientRemove(ClientID));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalRecordsUI#updateStatus(int)}.
	 */
	@Test
	public final void testUpdateStatus() {
		try {
			LegalRecordsUI a = new LegalRecordsUIImpl();
			int ClientID = -1;
			assertTrue(a.updateStatus(ClientID));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalRecordsUI#getWhoNeedsRemoved(java.util.ArrayList)}.
	 */
	@Test
	public final void testGetWhoNeedsRemoved() {
		try {
			LegalRecordsUI a = new LegalRecordsUIImpl();
			ArrayList<Object[]> Q = new ArrayList<Object[]>();
			assertTrue(a.getWhoNeedsRemoved(Q));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
