package dbconnection;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;





public class ReceActivator implements BundleActivator {

	ServiceRegistration ManagementRegistration;
	
	ServiceRegistration legalStafRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		 ReceptionistUI management = new ReceptionistUIImpl();
	        ManagementRegistration = context.registerService(ReceptionistUI.class.getName(),management,null);
	        
	        
	        LegalStaffUI legal = new LegalStaffUIImpl();
	        legalStafRegistration = context.registerService(LegalStaffUI.class.getName(),legal,null);
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		// TODO Auto-generated method stub
        ManagementRegistration.unregister();
        legalStafRegistration.unregister();
	}

}
