package test;

import dbconnection.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



/**
 * JUnit Suite Test for all classes
 * 
 * @author NXATZ
 *
 */
@RunWith(Suite.class)

@SuiteClasses({LegalStaffUITest.class,ReceptionistUITest.class,LegalRecordsUITest.class,HOManagementUITest.class})

public class JUnitTestSuit {

}
