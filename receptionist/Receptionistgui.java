package receptionist1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dbconnection.ReceptionistUI;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
//import dbconnection.*;
public class Receptionistgui {

	public JFrame frame;
	private JTextField clinet_name;
	private JTextField client_surname;
	private JTextField DOB;
	private JTextField telephone;
	private JTextField address;
	private JTextField client_id;
	private JTextField apo_date;
	private JTextField lawyer_id;
	private JTextField branch_id;
	public ReceptionistUI re;
	private JTable table_1;
	private JTable apo_table;
	private JTable table_lawyers;
	private JTextField apo_id;
	private JTextField drop_in;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Receptionistgui window = new Receptionistgui();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * 
	 * ReceptionistUIImpl re
	 */
	public Receptionistgui(ReceptionistUI re) {
		//System.out.println("dfd");
		this.re=re;
		
		
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.	
	 */
	private void initialize() {
		
		
			
			
			
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1249, 949);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Receptionst");
		frame.getContentPane().setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 1207, 876);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Clients", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblClientName = new JLabel("Client Name:");
		lblClientName.setBounds(12, 9, 74, 25);
		panel.add(lblClientName);
		
		JLabel lblClientSurname = new JLabel("Client Surname:");
		lblClientSurname.setBounds(12, 47, 93, 25);
		panel.add(lblClientSurname);
		
		clinet_name = new JTextField();
		clinet_name.setBounds(146, 10, 116, 22);
		panel.add(clinet_name);
		clinet_name.setColumns(10);
		
		client_surname = new JTextField();
		client_surname.setBounds(146, 48, 116, 22);
		panel.add(client_surname);
		client_surname.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setBounds(12, 87, 56, 16);
		panel.add(lblSex);
		
		JComboBox comboBox_sex = new JComboBox();
		comboBox_sex.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox_sex.setBounds(146, 83, 45, 22);
		panel.add(comboBox_sex);
		
		JLabel lblBithOfBrithday = new JLabel("Day of Brith:");
		lblBithOfBrithday.setBounds(12, 147, 93, 16);
		panel.add(lblBithOfBrithday);
		
		DOB = new JTextField();
		DOB.setBounds(146, 147, 116, 22);
		panel.add(DOB);
		DOB.setColumns(10);
		
		JLabel lblDdmmyyyy = new JLabel("DD/MM/YYYY");
		lblDdmmyyyy.setBounds(146, 118, 116, 16);
		panel.add(lblDdmmyyyy);
		
		JLabel lblTelephone = new JLabel("Telephone:");
		lblTelephone.setBounds(12, 198, 93, 16);
		panel.add(lblTelephone);
		
		telephone = new JTextField();
		telephone.setBounds(146, 198, 116, 22);
		panel.add(telephone);
		telephone.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(12, 246, 56, 16);
		panel.add(lblAddress);
		
		address = new JTextField();
		address.setBounds(146, 243, 116, 22);
		panel.add(address);
		address.setColumns(10);
		
		JLabel lblViewClients = new JLabel("Clients");
		lblViewClients.setBounds(306, 10, 158, 22);
		panel.add(lblViewClients);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name= clinet_name.getText();
				String surname= client_surname.getText();
				String sex = comboBox_sex.getSelectedItem().toString();
				String dbo= DOB.getText();
				String teleph= telephone.getText();
				String addre=address.getText();
				re.insertClient(name, surname, sex, dbo, teleph, addre, true);

				
				cli(re);
			}
		}); 
		btnInsert.setBounds(12, 318, 97, 25);
		panel.add(btnInsert);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name =clinet_name.getName();
				String surname =client_surname.getText();
				
				 Object rowData[][] = null; //{{1,1,1,1,1,1,1}};
			    //String columns[] = null;
			    Object [] columns = { "ID","Name", "Surname", "Sex","DOB", "Telephone", "Address", "DropIn",
			    		"NeedsUpdate","Legal","Status","Rec_LegalOp","CaseTrans","ChangedRecord"};
			
			    ArrayList<Object[]> clientsList= new ArrayList<Object[]>();
			    re.searchClient(clientsList, name, surname);
			
			 rowData = new Object[clientsList.size()][14];
			  
			   // ColumnModel
			    
				for(int i=0; i< clientsList.size(); i++){
						//System.out.println(clientsList.get(0).toString());
					   rowData[i] = clientsList.get(i);
				}
				//table_1.setColumnModel();
		    table_1.setModel(new DefaultTableModel(rowData,columns));
				
				
				
			}
		});
		btnSearch.setBounds(12, 386, 97, 25);
		panel.add(btnSearch);
		
		table_1 = new JTable();
		table_1.setBounds(306, 47, 873, 774);
		panel.add(table_1);
		
		JLabel lblDropInClient = new JLabel("Drop in Client");
		lblDropInClient.setBounds(12, 499, 110, 16);
		panel.add(lblDropInClient);
		
		drop_in = new JTextField();
		drop_in.setBounds(12, 528, 93, 22);
		panel.add(drop_in);
		drop_in.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dro_id= Integer.parseInt(drop_in.getText());
				re.insertDropIN(dro_id);
				cli(re);
			}
		});
		btnUpdate.setBounds(12, 563, 97, 25);
		panel.add(btnUpdate);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1158, 386, 21, 48);
		panel.add(scrollBar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Appointments", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblClieantId = new JLabel("Client Id:");
		lblClieantId.setBounds(12, 13, 68, 30);
		panel_1.add(lblClieantId);
		
		client_id = new JTextField();
		client_id.setBounds(136, 17, 116, 22);
		panel_1.add(client_id);
		client_id.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(12, 76, 56, 16);
		panel_1.add(lblDate);
		
		JLabel lblDdmmyyy = new JLabel("DD/MM/YYY");
		lblDdmmyyy.setBounds(136, 52, 77, 16);
		panel_1.add(lblDdmmyyy);
		
		apo_date = new JTextField();
		apo_date.setBounds(126, 73, 116, 22);
		panel_1.add(apo_date);
		apo_date.setColumns(10);
		
		JLabel lblLawyerId = new JLabel("Lawyer ID:");
		lblLawyerId.setBounds(12, 120, 77, 16);
		panel_1.add(lblLawyerId);
		
		lawyer_id = new JTextField();
		lawyer_id.setBounds(126, 120, 116, 22);
		panel_1.add(lawyer_id);
		lawyer_id.setColumns(10);
		
		JLabel lblBranchId = new JLabel("Branch ID:");
		lblBranchId.setBounds(12, 172, 68, 16);
		panel_1.add(lblBranchId);
		
		branch_id = new JTextField();
		branch_id.setBounds(126, 169, 116, 22);
		panel_1.add(branch_id);
		branch_id.setColumns(10);
		
		JButton apo_btn_insert = new JButton("Insert");
		apo_btn_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  client=Integer.parseInt(client_id.getText());
				String date=apo_date.getText();
				int  lawyer=Integer.parseInt( lawyer_id.getText());
				int branch=Integer.parseInt( branch_id.getText());
				re.insertAppointment(client, date, lawyer, branch);
				
				apo(re);
				
				
			}
		});
		apo_btn_insert.setBounds(12, 271, 141, 44);
		panel_1.add(apo_btn_insert);
		
		JLabel lblAppointments = new JLabel("Appointments");
		lblAppointments.setBounds(323, 17, 154, 22);
		panel_1.add(lblAppointments);
		
		apo_table = new JTable();
		apo_table.setBounds(329, 39, 838, 680);
		panel_1.add(apo_table);
		
		JCheckBox CheckBox_acco = new JCheckBox("Accomplish");
		CheckBox_acco.setBounds(8, 445, 113, 25);
		panel_1.add(CheckBox_acco);
		
		apo_id = new JTextField();
		apo_id.setBounds(12, 407, 68, 22);
		panel_1.add(apo_id);
		apo_id.setColumns(10);
		
		JLabel lblAccomplish = new JLabel("Appoiment ID");
		lblAccomplish.setBounds(12, 364, 83, 30);
		panel_1.add(lblAccomplish);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int apo_ID= Integer.parseInt(apo_id.getText());
				if(CheckBox_acco.isSelected()) {
					re.checkIfClientWent(apo_ID, "YES");
				}
				else {
					re.checkIfClientWent(apo_ID, "no");
				}
				apo(re);
			}
		});
		btnNewButton.setBounds(12, 506, 109, 25);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Lawyers", null, panel_2, null);
		panel_2.setLayout(null);
		
	
		table_lawyers = new JTable();
		table_lawyers.setBounds(26, 13, 1103, 650);
		panel_2.add(table_lawyers);
	    cli(re);
	  
	    apo(re);
	    law(re);
	
	}
	public void apo(ReceptionistUI re ) {
		 Object rowData[][] = null; //{{1,1,1,1,1,1,1}};
		    Object [] columns = { "ID","Client_ID", "Date","Lawyer_Id","Branch_ID","Date_Created","Accomplish"};
		
		    ArrayList<Object[]> apoList= new ArrayList<Object[]>();
	    re.getAppointments(apoList);
		
		 rowData = new Object[apoList.size()][14];
		  
		   // ColumnModel
		    
			for(int i=0; i< apoList.size(); i++){
					//System.out.println(clientsList.get(0).toString());
				   rowData[i] = apoList.get(i);
			}
			//table_1.setColumnModel();
	    apo_table.setModel(new DefaultTableModel(rowData,columns));
	    
	  }
	
	public void cli(ReceptionistUI re ) {
		 Object rowData[][] = null; //{{1,1,1,1,1,1,1}};
		    String columns[] = null;
		    columns = new String[]{ "ID","Name", "Surname", "Sex","DOB", "Telephone", "Address", "DropIn",
		    		"NeedsUpdate","Legal","Status","Rec_LegalOp","CaseTrans","ChangedRecord"};
		
		    ArrayList<Object[]> clientsList= new ArrayList<Object[]>();
	    re.getClient(clientsList);
		
		 rowData = new Object[clientsList.size()][14];
		  
		   // ColumnModel
		    
			for(int i=0; i< clientsList.size(); i++){
					//System.out.println(clientsList.get(0).toString());
				   rowData[i] = clientsList.get(i);
			}
			//table_1.setColumnModel();
	    table_1.setModel(new DefaultTableModel(rowData,columns));
	    
	  }
	public void law(ReceptionistUI re ) {
		 Object rowData[][] = null; //{{1,1,1,1,1,1,1}};
		    Object columns[] = null;
		    columns = new String[]{ "ID","Name", "Surname", "Branch_ID"};
		
		    ArrayList<Object[]> lawList= new ArrayList<Object[]>();
	    re.getLawyers(lawList);
		
		 rowData = new Object[lawList.size()][14];
		  
		   // ColumnModel
		    
			for(int i=0; i< lawList.size(); i++){
					//System.out.println(clientsList.get(0).toString());
				   rowData[i] = lawList.get(i);
			}
			//table_1.setColumnModel();
	   table_lawyers.setModel(new DefaultTableModel(rowData,columns));
	   
	  }
}
