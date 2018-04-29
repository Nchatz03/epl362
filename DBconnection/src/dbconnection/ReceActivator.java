package dbconnection;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ReceActivator implements BundleActivator {

	ServiceRegistration ManagementRegistration;
	
	ServiceRegistration legalStafRegistration;

	ServiceRegistration legalStafRegords;

	ServiceRegistration Manaregistra;
	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
		//ReceptionistUI interface  ReceptionistUIImpl ylopihsi
		
		 ReceptionistUI management = new ReceptionistUIImpl();
	        ManagementRegistration = context.registerService(ReceptionistUI.class.getName(),management,null);
	        
	        
	        LegalStaffUI legal = new LegalStaffUIImpl();
	        legalStafRegistration = context.registerService(LegalStaffUI.class.getName(),legal,null);
	        
	        LegalRecordsUI recordsUI=new LegalRecordsUIImpl();
	        legalStafRegords=context.registerService(LegalRecordsUI.class.getName(),recordsUI,null);
	        
	        
	       HOManagementUI mana=new HOManagementUIImpl();
	       Manaregistra=context.registerService(HOManagementUI.class.getName(),mana,null);
	        
	        
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		// TODO Auto-generated method stub
		
		//ekina p diloses poio panw
		
		
		
        ManagementRegistration.unregister();
        legalStafRegistration.unregister();
        legalStafRegords.unregister();
        Manaregistra.unregister();
	
	}

}
