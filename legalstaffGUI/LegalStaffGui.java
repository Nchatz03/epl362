package legalstaff;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import dbconnection.LegalStaffUI;
import dbconnection.ReceptionistUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class LegalStaffGui {
	public LegalStaffUI le;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane dispute_scrollPane;
	private JScrollPane dispute_tarnsaction_scrollPane;
	private JScrollPane unwilling_scrollPane;
	JFrame frame;
	private JScrollPane scrollPane_appoi;
	private JTextField cli_id_case;
	private JTextField lawyer_id;
	private JTextField case_idle;
	private JTextField req_cli_ID;
	private JTextField cli_cli_id;
	private JTextField unw_cli_id;
	private JButton btnOverwrite;
	private JButton btnNewButton_3;
	private JLabel over_label;
	private JTextField la_over_id;
	private JTextField request_name;
	private JTextField request_surname;
	private JTextField request_address;
	private JTextField request_phone;
	private JTextField request_DBO;
	private JTextField appoi_ID;
	private JTextField cli_appoi;
	private JComboBox case_comboBox;
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// LegalStaffGui window = new LegalStaffGui();
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
	public LegalStaffGui(LegalStaffUI le) {
		this.le = le;

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 997, 773);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Legal Staff");
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 24, 955, 689);
		frame.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Client", null, panel, null);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(231, 54, 694, 552);
		panel.add(scrollPane);

		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(231, 25, 56, 16);
		panel.add(lblClient);

		JLabel lblClientId_1 = new JLabel("Client ID:");
		lblClientId_1.setBounds(12, 25, 56, 16);
		panel.add(lblClientId_1);

		cli_cli_id = new JTextField();
		cli_cli_id.setBounds(80, 22, 116, 22);
		panel.add(cli_cli_id);
		cli_cli_id.setColumns(10);

		JButton btnNeedsUpdate = new JButton("Needs Update");
		btnNeedsUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(cli_cli_id.getText());
				le.needsUpdate(id);
				cli(le);
			}
		});
		btnNeedsUpdate.setBounds(36, 99, 149, 25);
		panel.add(btnNeedsUpdate);

		JButton btnNewButton = new JButton("Who Needs Update?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cliUp(le);

			}
		});
		btnNewButton.setBounds(36, 137, 149, 25);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cli(le);

			}
		});
		btnNewButton_1.setBounds(36, 607, 149, 25);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Who is Illegal?");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cliIli(le);

			}
		});
		btnNewButton_2.setBounds(36, 175, 148, 25);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("Add Client For Remove");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idremo=Integer.parseInt(cli_cli_id.getText());
				le.addRemoveClient(idremo);
				
				
			}
		});
		btnNewButton_5.setBounds(12, 231, 184, 25);
		panel.add(btnNewButton_5);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Clients Cases", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblCases = new JLabel("Cases");
		lblCases.setBounds(268, 25, 56, 16);
		panel_1.add(lblCases);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(268, 54, 682, 286);
		panel_1.add(scrollPane_1);

		JLabel lblClientId = new JLabel("Client Id:");
		lblClientId.setBounds(12, 13, 56, 16);
		panel_1.add(lblClientId);

		cli_id_case = new JTextField();
		cli_id_case.setBounds(95, 10, 116, 22);
		panel_1.add(cli_id_case);
		cli_id_case.setColumns(10);

		JLabel lblCase = new JLabel("Case:");
		lblCase.setBounds(12, 122, 56, 16);
		panel_1.add(lblCase);

		JComboBox comboBox_le = new JComboBox();
		comboBox_le.setModel(new DefaultComboBoxModel(new String[] { "Legal Opinion 1", "Legal Opinion 2",
				"Legal Opinion 3", "Recommendation  1", "Recommendation  2", "Recommendation  3" }));
		comboBox_le.setBounds(511, 382, 233, 37);
		panel_1.add(comboBox_le);

		JLabel lblLegalOpinion = new JLabel("Legal Strategy");
		lblLegalOpinion.setBounds(514, 353, 141, 16);
		panel_1.add(lblLegalOpinion);

		JButton btnUpdate = new JButton("Insert Legal Strategy");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int ca_id = Integer.parseInt(case_idle.getText());

				String s = comboBox_le.getSelectedItem().toString();

				if (le.isRecommedationTheSame(s, ca_id)) {
					JOptionPane.showMessageDialog(null, "Same Recommendation", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (le.isUnwilling(le.getClients(ca_id), s)) {

					JOptionPane.showMessageDialog(null, "Client is Unwilling for that Strategy", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					le.addDispute(le.getClients(ca_id), ca_id, s);

					over_label.setVisible(true);
					la_over_id.setVisible(true);
					btnOverwrite.setVisible(true);
					btnNewButton_3.setVisible(true);
				} else {
					le.insertRecommendation(s, ca_id);
				}

				cas(le);
				cliDispute(le);

			}
		});
		btnUpdate.setBounds(531, 452, 165, 25);
		panel_1.add(btnUpdate);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int cli_id = Integer.parseInt(cli_id_case.getText());
				  String cas =   case_comboBox.getSelectedItem().toString();
				int law_id = Integer.parseInt(lawyer_id.getText());
				boolean bo = le.isCaseTheSame(cas, cli_id);
				
				if (!le.checkClientExist(cli_id)) {
					JOptionPane.showMessageDialog(null, "Client not exist!",
							"Problem", JOptionPane.INFORMATION_MESSAGE);
				}

				else if (!bo) {
					le.addNewCase(cas, cli_id, law_id);
					le.addCaseToAppointments(Integer.parseInt(cli_appoi.getText()), cas);
					JOptionPane.showMessageDialog(null, "Case insertion confirm.", "Succeed",
							JOptionPane.INFORMATION_MESSAGE);
					
				} else {
					JOptionPane.showMessageDialog(null, "Already in.", "Allert", JOptionPane.INFORMATION_MESSAGE);

				}

				cas(le);

			}
		});
		btnInsert.setBounds(56, 286, 97, 25);
		panel_1.add(btnInsert);

		JLabel lblLawyerId = new JLabel("Lawyer ID:");
		lblLawyerId.setBounds(12, 51, 74, 16);
		panel_1.add(lblLawyerId);

		lawyer_id = new JTextField();
		lawyer_id.setColumns(10);
		lawyer_id.setBounds(95, 48, 116, 22);
		panel_1.add(lawyer_id);

		JLabel lblCaseId = new JLabel("Case ID:");
		lblCaseId.setBounds(12, 324, 56, 16);
		panel_1.add(lblCaseId);

		case_idle = new JTextField();
		case_idle.setBounds(12, 365, 127, 22);
		panel_1.add(case_idle);
		case_idle.setColumns(10);

		JCheckBox chckbxLegal = new JCheckBox("Legal");
		chckbxLegal.setBounds(12, 408, 68, 25);
		panel_1.add(chckbxLegal);

		JCheckBox chckbxIllegal = new JCheckBox("Illegal");
		chckbxIllegal.setBounds(98, 412, 113, 25);
		panel_1.add(chckbxIllegal);

		JButton btnInsert_1 = new JButton("Insert");
		btnInsert_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idle = Integer.parseInt(case_idle.getText());
				int client;
				if (chckbxLegal.isSelected()) {

					le.addLegal(idle);
					client = le.getClients(idle);
					le.updateLegal(client);

				} else if (chckbxIllegal.isSelected()) {
					le.addIllegal(idle);
					client = le.getClients(idle);
					le.updateIllegal(client);

				}

				cas(le);
				cli(le);
			}
		});
		btnInsert_1.setBounds(12, 446, 127, 37);
		panel_1.add(btnInsert_1);

		btnOverwrite = new JButton("Overwrite");
		btnOverwrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int caseID = Integer.parseInt(case_idle.getText());
				String s = comboBox_le.getSelectedItem().toString();
				int laid = Integer.parseInt(la_over_id.getText());

				le.addDisputeTransaction(le.getClients(caseID), caseID, s, laid);
				cliDispute_transaction(le);

				btnOverwrite.setVisible(false);
				over_label.setVisible(false);
				la_over_id.setVisible(false);
				btnNewButton_3.setVisible(false);
			}
		});
		btnOverwrite.setBounds(511, 515, 97, 25);
		panel_1.add(btnOverwrite);

		over_label = new JLabel("Lawyer ID:");
		over_label.setBounds(483, 563, 74, 16);
		panel_1.add(over_label);

		la_over_id = new JTextField();
		la_over_id.setBounds(591, 560, 116, 22);
		panel_1.add(la_over_id);
		la_over_id.setColumns(10);

		btnNewButton_3 = new JButton("No Overwrite");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOverwrite.setVisible(false);
				over_label.setVisible(false);
				la_over_id.setVisible(false);
				btnNewButton_3.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(650, 515, 107, 25);
		panel_1.add(btnNewButton_3);
		
		JLabel lblAppointmentId = new JLabel("Appointment ID:");
		lblAppointmentId.setBounds(0, 93, 107, 16);
		panel_1.add(lblAppointmentId);
		
		cli_appoi = new JTextField();
		cli_appoi.setBounds(119, 90, 116, 22);
		panel_1.add(cli_appoi);
		cli_appoi.setColumns(10);
		
		  case_comboBox = new JComboBox();
		case_comboBox.setModel(new DefaultComboBoxModel(new String[] {"CaseType1", "CaseType2", "CaseType3", "CaseType4", "CaseType5"}));
		case_comboBox.setBounds(22, 163, 226, 37);
		panel_1.add(case_comboBox);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Request", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Client Id:");
		lblNewLabel.setBounds(12, 25, 73, 36);
		panel_2.add(lblNewLabel);

		req_cli_ID = new JTextField();
		req_cli_ID.setBounds(106, 32, 116, 22);
		panel_2.add(req_cli_ID);
		req_cli_ID.setColumns(10);

		JCheckBox req_name = new JCheckBox("Name");
		req_name.setBounds(23, 82, 113, 25);
		panel_2.add(req_name);

		JCheckBox req_sur = new JCheckBox("Surname");
		req_sur.setBounds(23, 126, 113, 25);
		panel_2.add(req_sur);

		JCheckBox req_addre = new JCheckBox("Address");
		req_addre.setBounds(23, 169, 113, 25);
		panel_2.add(req_addre);

		JCheckBox req_phone = new JCheckBox("Phone");
		req_phone.setBounds(23, 209, 113, 25);
		panel_2.add(req_phone);

		JCheckBox req_dbo = new JCheckBox("DBO");
		req_dbo.setBounds(23, 259, 113, 25);
		panel_2.add(req_dbo);

		JButton btnInsert_2 = new JButton("Insert");
		btnInsert_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int i = Integer.parseInt(req_cli_ID.getText());

				if (request_name.getText().equals("") || request_address.equals("")
						|| request_surname.getText().equals("") || request_phone.getText().equals("")
						|| request_DBO.getText().equals("")) {
					
					
					JOptionPane.showMessageDialog(null, "Please complete all fields even if theyn don't need change!",
							"Problem", JOptionPane.INFORMATION_MESSAGE);

				} else {
					le.insertRequest(i, req_name.isSelected(), req_sur.isSelected(), req_addre.isSelected(),
							req_phone.isSelected(), req_dbo.isSelected(), request_name.getText(),
							request_surname.getText(), request_address.getText(), request_phone.getText(),
							request_DBO.getText());
				}
			}
		});
		btnInsert_2.setBounds(23, 334, 97, 25);
		panel_2.add(btnInsert_2);

		request_name = new JTextField();
		request_name.setBounds(144, 83, 161, 22);
		panel_2.add(request_name);
		request_name.setColumns(10);

		request_surname = new JTextField();
		request_surname.setBounds(144, 127, 161, 22);
		panel_2.add(request_surname);
		request_surname.setColumns(10);

		request_address = new JTextField();
		request_address.setBounds(144, 170, 161, 25);
		panel_2.add(request_address);
		request_address.setColumns(10);

		request_phone = new JTextField();
		request_phone.setBounds(144, 210, 161, 22);
		panel_2.add(request_phone);
		request_phone.setColumns(10);

		request_DBO = new JTextField();
		request_DBO.setBounds(144, 260, 161, 22);
		panel_2.add(request_DBO);
		request_DBO.setColumns(10);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Dispute", null, panel_3, null);
		panel_3.setLayout(null);

		dispute_scrollPane = new JScrollPane();
		dispute_scrollPane.setBounds(246, 24, 678, 535);
		panel_3.add(dispute_scrollPane);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Dispute Transaction", null, panel_4, null);
		panel_4.setLayout(null);

		dispute_tarnsaction_scrollPane = new JScrollPane();
		dispute_tarnsaction_scrollPane.setBounds(180, 72, 758, 519);
		panel_4.add(dispute_tarnsaction_scrollPane);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Unwilling", null, panel_5, null);
		panel_5.setLayout(null);

		unwilling_scrollPane = new JScrollPane();
		unwilling_scrollPane.setBounds(516, 24, 422, 291);
		panel_5.add(unwilling_scrollPane);

		JLabel lblClientId_2 = new JLabel("Client ID: ");
		lblClientId_2.setBounds(0, 13, 68, 16);
		panel_5.add(lblClientId_2);

		unw_cli_id = new JTextField();
		unw_cli_id.setBounds(68, 10, 116, 22);
		panel_5.add(unw_cli_id);
		unw_cli_id.setColumns(10);

		JComboBox un_como_reco = new JComboBox();
		un_como_reco.setModel(new DefaultComboBoxModel(new String[] { "Recommendation  1", "Recommendation  2",
				"Recommendation  3", "Legal Opinion 1", "Legal Opinion 2", "Legal Opinion 3" }));
		un_como_reco.setBounds(12, 100, 230, 37);
		panel_5.add(un_como_reco);

		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int un_id = Integer.parseInt(unw_cli_id.getText());
				String s = un_como_reco.getSelectedItem().toString();
				le.addUnwilling(un_id, s);
				cliUnwilling(le);

			}
		});
		btnAdd.setBounds(28, 182, 169, 50);
		panel_5.add(btnAdd);

		JLabel lblChooseLegalStrategy = new JLabel("Choose Legal Strategy");
		lblChooseLegalStrategy.setBounds(12, 71, 159, 16);
		panel_5.add(lblChooseLegalStrategy);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Appointments", null, panel_6, null);
		panel_6.setLayout(null);
		
		 scrollPane_appoi = new JScrollPane();
		scrollPane_appoi.setBounds(331, 52, 594, 549);
		panel_6.add(scrollPane_appoi);
		
		JLabel lblYourId = new JLabel("Your ID:");
		lblYourId.setBounds(12, 29, 56, 16);
		panel_6.add(lblYourId);
		
		appoi_ID = new JTextField();
		appoi_ID.setBounds(101, 26, 116, 22);
		panel_6.add(appoi_ID);
		appoi_ID.setColumns(10);
		
		JButton btnGetAppointmants = new JButton("Get Appointments");
		btnGetAppointmants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vieAppoi(le);
				
			}
		});
		btnGetAppointmants.setBounds(64, 141, 153, 25);
		panel_6.add(btnGetAppointmants);

		// iniend

		cli(le);
		cas(le);
		cliDispute(le);
		cliDispute_transaction(le);
		cliUnwilling(le);
		btnOverwrite.setVisible(false);
		over_label.setVisible(false);
		la_over_id.setVisible(false);
		btnNewButton_3.setVisible(false);

	}

	public void cli(LegalStaffUI le) {
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

		scrollPane.setViewportView(table_1);

	}

	public void cliDispute(LegalStaffUI le) {
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

		dispute_scrollPane.setViewportView(table_1);

	}

	public void cliDispute_transaction(LegalStaffUI le) {
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

		dispute_tarnsaction_scrollPane.setViewportView(table_1);

	}

	public void cliUp(LegalStaffUI le) {
		Object rowData[][] = null; // {{1,1,1,1,1,1,1}};
		String columns[] = null;
		columns = new String[] { "ID", "Name", "Surname", "NeedsUpdate" };
		//
		ArrayList<Object[]> clientsList = new ArrayList<Object[]>();
		le.getNeedsUpdate(clientsList);

		rowData = new Object[clientsList.size()][10];

		// ColumnModel

		for (int i = 0; i < clientsList.size(); i++) {
			rowData[i] = clientsList.get(i);
		}
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData, columns));

		scrollPane.setViewportView(table_1);

	}

	public void cliIli(LegalStaffUI le) {
		Object rowData[][] = null; // {{1,1,1,1,1,1,1}};
		String columns[] = null;
		columns = new String[] { "ID", "Name", "Surname", "Legal" };
		//
		ArrayList<Object[]> clientsList = new ArrayList<Object[]>();
		le.getIllegal(clientsList);

		rowData = new Object[clientsList.size()][10];

		// ColumnModel

		for (int i = 0; i < clientsList.size(); i++) {
			rowData[i] = clientsList.get(i);
		}
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData, columns));

		scrollPane.setViewportView(table_1);

	}

	public void cas(LegalStaffUI le) {
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

	public void cliUnwilling(LegalStaffUI le) {
		Object rowData[][] = null;
		String columns[] = null;
		columns = new String[] { "Client ID", "Recommendation or Legal Opinion" };
		//
		ArrayList<Object[]> caseList = new ArrayList<Object[]>();
		le.getUnwilling(caseList);

		rowData = new Object[caseList.size()][10];

		// ColumnModel

		for (int i = 0; i < caseList.size(); i++) {
			rowData[i] = caseList.get(i);
		}
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData, columns));

		unwilling_scrollPane.setViewportView(table_1);

	}
	public void vieAppoi(LegalStaffUI le) {
		Object rowData[][] = null;
		String columns[] = null;
		columns = new String[] { " ID", "Client_ID","Date" ,"DateCreated"};
		//
		ArrayList<Object[]> caseList = new ArrayList<Object[]>();
		le.getAppointments(Integer.parseInt(appoi_ID.getText()), caseList);

		rowData = new Object[caseList.size()][10];

		// ColumnModel

		for (int i = 0; i < caseList.size(); i++) {
			rowData[i] = caseList.get(i);
		}
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData, columns));

		scrollPane_appoi.setViewportView(table_1);

	}
}
