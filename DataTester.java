package test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.javaworld.sample.helloservice.*;

import org.junit.Assert;

public class MyTester {

	
	@Test
	public void test(){
		try {
			Management m = new ManagementImpl();
			Assert.assertFalse(m==null);
			Assert.assertEquals("Error", true,m.getClient(new ArrayList<Object[]>()));
			Assert.assertEquals("Error", true,m.CalculateStatistics(new int[5], new int[1024], new int[1024], new int[1024], 1));
			HelloService h = new HelloServiceImpl();
			Assert.assertEquals("Error",true,h.checkIfClientWent(1, "YES"));
			Assert.assertEquals("Error",true,h.getAppointments(new ArrayList<Object[]>()));
			Assert.assertEquals("Error",true,h.insertDropIN(10));
			Assert.assertEquals("Error",true,h.searchClient(new ArrayList<Object[]>(), "Kostis", "K"));
			Assert.assertEquals("Error",true,h.insertClient("dg", "sdfsfd", "2000-10-10", "M", "9", "df", false));
			LegaLRecords med = new LegalRecordsImpl();
			Assert.assertEquals("Error",true,med.updateRecord(1, "sdf", "Asf", "2000-10-10", "55", "asd", "M"));
			LegalStaff c = new LegalStaffImpl();
			//Next line will result in exception
			Assert.assertEquals("Should be false because of duplicate primary key",false,c.addUnwilling(1, "Î¦Î¬Ï�Î¼Î±ÎºÎ¿1"));
			Assert.assertEquals("Error",true,c.changeCase("Î£Ï‡Î¹Î¶Î¿Ï†Ï�Î­Î½ÎµÎ¹Î±", 1));
			Assert.assertEquals("Error",true,c.addDisputeTransaction(1, "2017-12-12", "sdf", "Î¦Î¬Ï�Î¼Î±ÎºÎ¿1"));
			Assert.assertEquals("Error",true,c.addDispute(1, "2000-10-10", "sdf"));
			Assert.assertEquals("Error",true,c.getClient(new ArrayList<Object[]>()));
			Assert.assertEquals("Error",true,c.getIllegal(new ArrayList<Object[]>()));
			Assert.assertEquals("Must be true. Patient 1 is allergic",true,c.isUnwilling(1, "Î¦Î¬Ï�Î¼Î±ÎºÎ¿1"));
			Assert.assertEquals("Error",true,c.updateLater(1));


			


			







		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
