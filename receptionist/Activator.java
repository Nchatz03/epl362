package receptionist1;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import dbconnection.ReceptionistUI;



public class Activator implements BundleActivator {


	ServiceReference receReference;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("louakas ");
		receReference = bundleContext.getServiceReference(ReceptionistUI.class.getName());
     	ReceptionistUI receptionDB  = (ReceptionistUI)bundleContext.getService(receReference);		
//		 ManagementReference= context.getServiceReference(Management.class.getName());
//	        Management management  = (Management)context.getService(ManagementReference);
//	        MainManagement m = new MainManagement(management);
//	        m.frame.setVisible(true);
//		
		Receptionistgui window=new Receptionistgui(receptionDB);
		window.frame.setVisible(true);
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(receReference);
	}

}
