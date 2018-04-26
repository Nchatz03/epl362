package legalreccordstaff;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import dbconnection.LegalRecordsUI;


public class Activator implements BundleActivator {
	ServiceReference legalReferenceRecords;
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		 

     	
		
		
		legalReferenceRecords = bundleContext.getServiceReference(LegalRecordsUI.class.getName());
 		LegalRecordsUI Dbc  = (LegalRecordsUI)bundleContext.getService(legalReferenceRecords);
     	LegalRecordsStaffGui  windows = new LegalRecordsStaffGui(Dbc);
     	windows.frame.setVisible(true);
     	
		
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(legalReferenceRecords);
		
		
		
	}

}
