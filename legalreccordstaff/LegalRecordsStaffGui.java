package legalreccordstaff;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import dbconnection.LegalRecordsUI;
import dbconnection.LegalStaffUI;
import dbconnection.ReceptionistUI;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LegalRecordsStaffGui {
	public LegalRecordsUI le;
	public JFrame frame;

	private JScrollPane scrollPane;
	private JTextField cli_id;
	private JTextField cli_name;
	private JTextField cli_surname;
	private JTextField cli_dbo;
	private JTextField cli_address;
	private JTextField cli_telephone;
	private JTextField cli_request;
private JScrollPane scrollPane_1 ;
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// LegalRecordsStaffGui window = new LegalRecordsStaffGui();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */
	public LegalRecordsStaffGui(LegalRecordsUI legalDB) {
		this.le = legalDB;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1231, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 1164, 647);
		frame.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Records Update", null, panel, null);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(366, 55, 781, 534);
		panel.add(scrollPane);

		JButton btnNewButton = new JButton("See Recuest");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seeRecuest(le);
			}
		});
		btnNewButton.setBounds(38, 440, 175, 35);
		panel.add(btnNewButton);

		cli_id = new JTextField();
		cli_id.setBounds(159, 40, 116, 22);
		panel.add(cli_id);
		cli_id.setColumns(10);

		JLabel lblClientId = new JLabel("Client ID:");
		lblClientId.setBounds(12, 42, 96, 19);
		panel.add(lblClientId);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(12, 87, 56, 16);
		panel.add(lblName);

		cli_name = new JTextField();
		cli_name.setBounds(159, 84, 116, 22);
		panel.add(cli_name);
		cli_name.setColumns(10);

		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(12, 132, 70, 16);
		panel.add(lblSurname);

		cli_surname = new JTextField();
		cli_surname.setBounds(159, 129, 116, 22);
		panel.add(cli_surname);
		cli_surname.setColumns(10);

		JLabel lblDbo = new JLabel("DBO:");
		lblDbo.setBounds(12, 173, 56, 16);
		panel.add(lblDbo);

		cli_dbo = new JTextField();
		cli_dbo.setBounds(159, 170, 116, 22);
		panel.add(cli_dbo);
		cli_dbo.setColumns(10);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(12, 228, 56, 16);
		panel.add(lblAddress);

		cli_address = new JTextField();
		cli_address.setBounds(159, 225, 116, 22);
		panel.add(cli_address);
		cli_address.setColumns(10);

		JLabel lblTelephone = new JLabel("Telephone:");
		lblTelephone.setBounds(12, 274, 96, 16);
		panel.add(lblTelephone);

		cli_telephone = new JTextField();
		cli_telephone.setBounds(159, 271, 116, 22);
		panel.add(cli_telephone);
		cli_telephone.setColumns(10);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (cli_address.getText().equals("") || cli_dbo.getText().equals("") || cli_id.getText().equals("")
						|| cli_name.getText().equals("") || cli_request.getText().equals("")
						|| cli_surname.getText().equals("") || cli_telephone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Complete all the above fields", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				}

				else {
					le.updateRecord(Integer.parseInt(cli_id.getText()), cli_name.getText(), cli_surname.getText(),
							cli_dbo.getText(), cli_telephone.getText(), cli_address.getText());
					le.insertClientRecord(Integer.parseInt(cli_id.getText()), cli_name.getText(), cli_surname.getText(),
							cli_dbo.getText(), cli_telephone.getText(), cli_address.getText());

					le.updateDone(Integer.parseInt(cli_request.getText()));
					le.requestDecision(Integer.parseInt(cli_request.getText()), true);
					
				}
				
				seeRecuest(le);

			}
		});
		btnUpdate.setBounds(38, 326, 175, 35);
		panel.add(btnUpdate);

		JButton btnNoUpdate = new JButton("No Update");
		btnNoUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (  cli_id.getText().equals("")|| cli_request.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Complete  the fields Request ID and Client ID", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else {
				le.noUpdateRecord(Integer.parseInt(cli_id.getText()));
				le.updateDone(Integer.parseInt(cli_request.getText()));
				le.requestDecision(Integer.parseInt(cli_request.getText()), false);
				seeRecuest(le);
				}
				
				
			}
		});
		btnNoUpdate.setBounds(38, 374, 175, 35);
		panel.add(btnNoUpdate);

		JLabel lblRequestId = new JLabel("Request ID:");
		lblRequestId.setBounds(12, 13, 81, 16);
		panel.add(lblRequestId);

		cli_request = new JTextField();
		cli_request.setBounds(159, 10, 116, 22);
		panel.add(cli_request);
		cli_request.setColumns(10);
		
		JButton btnWhoNeedsRemove = new JButton("Who needs remove?");
		btnWhoNeedsRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				whoneedsremove(le);
				
				
			}
		});
		btnWhoNeedsRemove.setBounds(38, 506, 175, 25);
		panel.add(btnWhoNeedsRemove);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cli_id.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Complete  the field Client ID", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else {
				le.updateStatus(Integer.parseInt(cli_id.getText()));
				
				le.updateClientRemove(Integer.parseInt(cli_id.getText()));
				}
				
			}
		});
		btnRemove.setBounds(38, 544, 175, 25);
		panel.add(btnRemove);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Records", null, panel_1, null);
		panel_1.setLayout(null);
		
		  scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(199, 13, 917, 554);
		panel_1.add(scrollPane_1);
		
		JButton btnNewButton_1 = new JButton("Clients");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				cli(le);
				
			}
		});
		btnNewButton_1.setBounds(12, 25, 97, 25);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Appointments");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apo(le);
				
						}
		});
		btnNewButton_2.setBounds(12, 88, 131, 25);
		panel_1.add(btnNewButton_2);
		
		JButton btnClientsCases = new JButton("Clients Cases");
		btnClientsCases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cas(le);
				
			}
		});
		btnClientsCases.setBounds(12, 142, 131, 25);
		panel_1.add(btnClientsCases);
		
		JButton btnDispute = new JButton("Dispute");
		btnDispute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		
				cliDispute(le);
				
			}
		});
		btnDispute.setBounds(12, 201, 111, 25);
		panel_1.add(btnDispute);
		
		JButton btnNewButton_3 = new JButton("Dispute \r\nTransaction");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cliDispute_transaction(le);
			}
		});
		btnNewButton_3.setBounds(12, 263, 154, 46);
		panel_1.add(btnNewButton_3);
	}

	public void seeRecuest(LegalRecordsUI le) {
		Object rowData[][] = null; // {{1,1,1,1,1,1,1}};
		String columns[] = null;
		columns = new String[] { "Request_ID", "Client ID", "Change Name", "Change Surname", "Change Address",
				"Change Telephone", "Change DOB", "Name", "Surname", "Address", "Phone", "DOB", "Done" };
		//
		ArrayList<Object[]> clientsList = new ArrayList<Object[]>();

		le.getRequest(clientsList);
		rowData = new Object[clientsList.size()][10];

		// ColumnModel

		for (int i = 0; i < clientsList.size(); i++) {
			rowData[i] = clientsList.get(i);
		}
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData, columns));

		scrollPane.setViewportView(table_1);

	}
	
	
	public void whoneedsremove(LegalRecordsUI le) {
		Object rowData[][] = null; // {{1,1,1,1,1,1,1}};
		String columns[] = null;
		columns = new String[] {  "Client ID" };
		//
		ArrayList<Object[]> clientsList = new ArrayList<Object[]>();

		le.getWhoNeedsRemoved(clientsList);
		rowData = new Object[clientsList.size()][2];

		// ColumnModel

		for (int i = 0; i < clientsList.size(); i++) {
			rowData[i] = clientsList.get(i);
		}
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData, columns));

		scrollPane.setViewportView(table_1);

	}
	
	
	public void cliDispute(LegalRecordsUI le) {
		Object rowData[][] = null; // {{1,1,1,1,1,1,1}};
		String columns[] = null;
		columns = new String[] { "Dispute ID", "Client ID", "Date", "Case", "Recommendation or Legal Opinion" };
		//
		ArrayList<Object[]> clientsList = new ArrayList<Object[]>();
		le.getDispute(clientsList);

		rowData = new Object[clientsList.size()][10];

		// ColumnModel

		for (int i = 0; i < clientsList.size(); i++) {
			rowData[i] = clientsList.get(i);
		}
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData, columns));

		scrollPane_1.setViewportView(table_1);

	}
	
	public void cli(LegalRecordsUI le) {
		Object rowData[][] = null; // {{1,1,1,1,1,1,1}};
		String columns[] = null;
		columns = new String[] { "ID", "Name", "Surname", "Sex", "DOB", "NeedsUpdate", "Telephone", "Address", "Status",
				"Legal" };
		//
		ArrayList<Object[]> clientsList = new ArrayList<Object[]>();
		le.getClient(clientsList);

		rowData = new Object[clientsList.size()][10];

		// ColumnModel

		for (int i = 0; i < clientsList.size(); i++) {
			rowData[i] = clientsList.get(i);
		}
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData, columns));

		scrollPane_1.setViewportView(table_1);

	}
	
	
	
	public void apo(LegalRecordsUI le) {
		Object rowData[][] = null; // {{1,1,1,1,1,1,1}};
		String columns[] = null;
		 columns =new String[] { "ID", "Client_ID", "Date", "Lawyer_Id", "Branch_ID", "Date_Created", "Accomplish","Case Trans" };

		ArrayList<Object[]> apoList = new ArrayList<Object[]>();
		le.getAppointments(apoList);

		rowData = new Object[apoList.size()][7];

		// ColumnModel

		for (int i = 0; i < apoList.size(); i++) {
			rowData[i] = apoList.get(i);
		}
		JTable table_apo = new JTable();
		table_apo.setModel(new DefaultTableModel(rowData, columns));

		scrollPane_1.setViewportView(table_apo);
		///
	}
	
	
	
	public void cas(LegalRecordsUI le) {
		Object rowData[][] = null; // {{1,1,1,1,1,1,1}};
		String columns[] = null;
		columns = new String[] { "ID", "Client ID", "Case", "Recommendation or Legal Opinion", "Lawyer ID", "Illegal" };
		//
		ArrayList<Object[]> caseList = new ArrayList<Object[]>();
		le.getCases(caseList);

		rowData = new Object[caseList.size()][10];

		// ColumnModel

		for (int i = 0; i < caseList.size(); i++) {
			rowData[i] = caseList.get(i);
		}
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData, columns));

		scrollPane_1.setViewportView(table_1);

	}
	
	
	
	public void cliDispute_transaction(LegalRecordsUI le) {
		Object rowData[][] = null; // {{1,1,1,1,1,1,1}};
		String columns[] = null;
		columns = new String[] { "DisputeTrans_ID", "Client ID", "Date", "Case", "Recommendation or Legal Opinion",
				"Lawyer ID" };
		//
		ArrayList<Object[]> clientsList = new ArrayList<Object[]>();
		le.getDisputeTransaction(clientsList);

		rowData = new Object[clientsList.size()][10];

		// ColumnModel

		for (int i = 0; i < clientsList.size(); i++) {
			rowData[i] = clientsList.get(i);
		}
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData, columns));

		scrollPane_1.setViewportView(table_1);

	}
	
}
