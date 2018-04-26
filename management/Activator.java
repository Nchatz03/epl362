package management;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import dbconnection.HOManagementUI;
import dbconnection.LegalStaffUI;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceReference ManaReference;
	 
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		ManaReference = bundleContext.getServiceReference(HOManagementUI.class.getName());
     	HOManagementUI legalDB  = (HOManagementUI)bundleContext.getService(ManaReference);
     	
     	ManagementGui wi=new ManagementGui(legalDB);
     	wi.frame.setVisible(true); 
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(ManaReference);
	}

}
