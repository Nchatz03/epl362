package legalstaff;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import dbconnection.LegalStaffUI;

public class Activator implements BundleActivator {

	ServiceReference legalReference;


	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		legalReference = bundleContext.getServiceReference(LegalStaffUI.class.getName());
     	LegalStaffUI legalDB  = (LegalStaffUI)bundleContext.getService(legalReference);
     	LegalStaffGui   windows = new LegalStaffGui(legalDB);
     	windows.frame.setVisible(true);
     	
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(legalReference);
	}

}
