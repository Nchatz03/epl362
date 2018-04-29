package test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import dbconnection.HOManagementUI;
import dbconnection.HOManagementUIImpl;

public class HOManagementUITest {

	@Test
	public final void testGetNotAttended() {
		try {
			HOManagementUI a = new HOManagementUIImpl();
			ArrayList<Object[]> Q = new ArrayList<Object[]>();
			String date = "test";
			assertTrue(a.getNotAttended(Q, date));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public final void testGetClient() {
		try {
			HOManagementUI a = new HOManagementUIImpl();
			ArrayList<Object[]> Q = new ArrayList<Object[]>();
			assertTrue(a.getClient(Q));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public final void testInsertLegalOpinion() {
		try {
			HOManagementUI a = new HOManagementUIImpl();
			String Rec_LegalOp = "test";
			assertTrue(a.insertLegalOpinion(Rec_LegalOp));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public final void testInsertRecommendation() {
		try {
			HOManagementUI a = new HOManagementUIImpl();
			String Rec = "test";
			assertTrue(a.insertRecommendation(Rec));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public final void testInsertCaseType() {
		try {
			HOManagementUI a = new HOManagementUIImpl();
			String CaseType = "test";
			assertTrue(a.insertCaseType(CaseType));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
