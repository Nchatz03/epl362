/**
 * 
 */
package JunitTest;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.ArrayList;

import JunitTest.LegalStaffUIImpl;

import org.junit.Test;

/**
 * @author NXATZ
 *
 */
public class LegalStaffUITest {

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#getClient(java.util.ArrayList)}.
	 */
	@Test
	public final void testGetClient() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			ArrayList<Object[]> ArrayList = new ArrayList<Object[]>();
			assertTrue(a.getClient(ArrayList));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#isCaseTheSame(java.lang.String, int)}.
	 */
	@Test
	public final void testIsCaseTheSame() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			String CaseTrans = "dd";
			int ClientID = 5;
			assertTrue(a.isCaseTheSame(CaseTrans, ClientID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#addNewCase(java.lang.String, int, int)}.
	 */
	@Test
	public final void testAddNewCase() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			String CaseTrans = "test";
			int ClientID = -1;
			int LawyerID = -1;
			assertTrue(a.addNewCase(CaseTrans, ClientID, LawyerID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalStaffUI#addIllegal(int)}.
	 */
	@Test
	public final void testAddIllegal() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int CaseID = 1;
			assertTrue(a.addIllegal(CaseID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalStaffUI#addLegal(int)}.
	 */
	@Test
	public final void testAddLegal() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int CaseID = 2;
			assertTrue(a.addLegal(CaseID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#isRecommedationTheSame(java.lang.String, int)}.
	 */
	@Test
	public final void testIsRecommedationTheSame() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int CaseID = 2;
			String Recommendation = "Legal Opinion 2";
			assertTrue(a.isRecommedationTheSame(Recommendation, CaseID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#changeRecommendation(java.lang.String, int)}.
	 */
	@Test
	public final void testChangeRecommendation() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int CaseID = 2;
			String Recommendation = "Legal Opinion 10";
			assertTrue(a.changeRecommendation(Recommendation, CaseID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#insertRecommendation(java.lang.String, int)}.
	 */
	@Test
	public final void testInsertRecommendation() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int CaseID = -1;
			String Recommendation = "test";
			assertTrue(a.insertRecommendation(Recommendation, CaseID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#insertRequest(int, boolean, boolean, boolean, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testInsertRequest() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int ClientID = -1;
			boolean requestName = true;
			boolean requestSurname = true;
			boolean requestAddress = true;
			boolean requestDOB = true;
			boolean requestPhone = true;
			String name = "test";
			String surname = "test";
			String DOB = "test";
			String phone = "test";
			String Address = "test";

			assertTrue(a.insertRequest(ClientID, requestName, requestSurname, requestAddress, requestPhone, requestDOB,
					name, surname, Address, phone, DOB));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalStaffUI#needsUpdate(int)}.
	 */
	@Test
	public final void testNeedsUpdate() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int ClientID = -1;
			assertTrue(a.needsUpdate(ClientID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalStaffUI#getClients(int)}.
	 */
	@Test
	public final void testGetClients() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int CaseID = -1;
			assertEquals(a.getClients(CaseID), -1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalStaffUI#updateIllegal(int)}.
	 */
	@Test
	public final void testUpdateIllegal() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int ClientID = -1;
			assertTrue(a.updateIllegal(ClientID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalStaffUI#updateLegal(int)}.
	 */
	@Test
	public final void testUpdateLegal() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int ClientID = -1;
			assertTrue(a.updateLegal(ClientID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#getNeedsUpdate(java.util.ArrayList)}.
	 */
	@Test
	public final void testGetNeedsUpdate() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			ArrayList<Object[]> ArrayList = new ArrayList<Object[]>();
			assertTrue(a.getNeedsUpdate(ArrayList));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#getIllegal(java.util.ArrayList)}.
	 */
	@Test
	public final void testGetIllegal() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			ArrayList<Object[]> ArrayList = new ArrayList<Object[]>();
			assertTrue(a.getIllegal(ArrayList));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#addDispute(int, int, java.lang.String)}.
	 */
	@Test
	public final void testAddDispute() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int ClientID = -1;
		    int CaseTrans =-1;
			String Rec_LegOp="test";
			assertTrue(a.addDispute(ClientID, CaseTrans, Rec_LegOp));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#addDisputeTransaction(int, int, java.lang.String, int)}.
	 */
	@Test
	public final void testAddDisputeTransaction() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int ClientID = -1;
		    int CaseTrans =-1;
		    int LawyerID =-1;
			String Rec_LegOp="test";
			assertTrue(a.addDisputeTransaction(ClientID, CaseTrans, Rec_LegOp, LawyerID));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#getDispute(java.util.ArrayList)}.
	 */
	@Test
	public final void testGetDispute() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			ArrayList<Object[]> Q = new ArrayList<Object[]>();
			assertTrue(a.getDispute(Q));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#getDisputeTransaction(java.util.ArrayList)}.
	 */
	@Test
	public final void testGetDisputeTransaction() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			ArrayList<Object[]> Q = new ArrayList<Object[]>();
			assertTrue(a.getDisputeTransaction(Q));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#getUnwilling(java.util.ArrayList)}.
	 */
	@Test
	public final void testGetUnwilling() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			ArrayList<Object[]> Q = new ArrayList<Object[]>();
			assertTrue(a.getUnwilling(Q));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#isUnwilling(int, java.lang.String)}.
	 */
	@Test
	public final void testIsUnwilling() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int ClientID = -1;
			String Rec_LegOp = "test";
			assertTrue(a.isUnwilling(ClientID, Rec_LegOp));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#addUnwilling(int, java.lang.String)}.
	 */
	@Test
	public final void testAddUnwilling() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int ClientID = -1;
			String Rec_LegOp = "test";
			assertTrue(a.addUnwilling(ClientID, Rec_LegOp));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#viewRecommendations(java.util.ArrayList)}.
	 */
	@Test
	public final void testViewRecommendations() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			ArrayList<String> arrayList = new ArrayList<String>();
			assertTrue(a.viewRecommendations(arrayList));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#viewLegalOpinions(java.util.ArrayList)}.
	 */
	@Test
	public final void testViewLegalOpinions() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			ArrayList<String> arrayList = new ArrayList<String>();
			assertTrue(a.viewLegalOpinions(arrayList));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link JunitTest.LegalStaffUI#getCases(java.util.ArrayList)}.
	 */
	@Test
	public final void testGetCases() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			ArrayList<Object[]> arrayList = new ArrayList<Object[]>();
			assertTrue(a.getCases(arrayList));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalStaffUI#checkClientExist(int)}.
	 */
	@Test
	public final void testCheckClientExist() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int ClientID = -1;
			assertTrue(a.checkClientExist(ClientID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link JunitTest.LegalStaffUI#addRemoveClient(int)}.
	 */
	@Test
	public final void testAddRemoveClient() {
		try {
			LegalStaffUI a = new LegalStaffUIImpl();
			int ClientID = -1;
			assertTrue(a.addRemoveClient(ClientID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
