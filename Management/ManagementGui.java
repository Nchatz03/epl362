package management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.PortableServer.ThreadPolicyOperations;

import dbconnection.HOManagementUI;
import dbconnection.LegalStaffUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ManagementGui {
	private HOManagementUI le;
	public JFrame frame;
	public JScrollPane scrollPane;
	private JTextField date;
	private JTextField legal_text;
	private JTextField reco_text;
	private JTextField case_type_text;
	private JTextField list_brach_id;
	private JButton btnNewButton_1;
	private JButton btnCaseTypes;
	private JButton btnNewButton;
	private JButton btnAllClients;
	int[] ClientsPerDay = new int[5];
	int[] casetype = new int[5];
	int[] Recommendations = new int[10];
	int[] Allclients = new int[1];
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// ManagementGui window = new ManagementGui();
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
	public ManagementGui(HOManagementUI le) {
		this.le = le;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1123, 746);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 1081, 673);
		frame.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("LIST", null, panel, null);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(369, 33, 680, 597);
		panel.add(scrollPane);

		JButton btnClients = new JButton("Clients");
		btnClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				viewclient(le);

			}
		});
		btnClients.setBounds(12, 437, 188, 42);
		panel.add(btnClients);

		JButton btnNotAte = new JButton("Not Attended");
		btnNotAte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (date.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Give Date", "Message", JOptionPane.INFORMATION_MESSAGE);
				} else {
					viewade(le);
				}

			}
		});
		btnNotAte.setBounds(22, 555, 188, 42);
		panel.add(btnNotAte);

		JLabel lblNewLabel = new JLabel("Give Date:");
		lblNewLabel.setBounds(22, 521, 93, 21);
		panel.add(lblNewLabel);

		date = new JTextField();
		date.setBounds(114, 520, 116, 22);
		panel.add(date);
		date.setColumns(10);

		JLabel lblYyyymmdd = new JLabel("YYYY-MM-DD");
		lblYyyymmdd.setBounds(114, 492, 116, 16);
		panel.add(lblYyyymmdd);

		JButton btnGetWeeklyReport = new JButton("Get weekly report");
		btnGetWeeklyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list_brach_id.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Give Branch ID ", "Message", JOptionPane.INFORMATION_MESSAGE);
				} else {
					btnCaseTypes.setVisible(true);
					btnNewButton_1.setVisible(true);
					btnNewButton.setVisible(true);
					btnAllClients.setVisible(true);

					le.CalculateStatistics(ClientsPerDay, casetype, Recommendations, Allclients,
							Integer.parseInt(list_brach_id.getText()));

				}

			}
		});
		btnGetWeeklyReport.setBounds(12, 57, 306, 47);
		panel.add(btnGetWeeklyReport);

		JLabel lblBranchId = new JLabel("Branch ID:");
		lblBranchId.setBounds(12, 13, 72, 16);
		panel.add(lblBranchId);

		list_brach_id = new JTextField();
		list_brach_id.setBounds(96, 10, 116, 22);
		panel.add(list_brach_id);
		list_brach_id.setColumns(10);

		btnCaseTypes = new JButton("Case Types");
		btnCaseTypes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ClientsPerDayTable(le, casetype);

			}
		});
		btnCaseTypes.setBounds(22, 210, 125, 25);
		panel.add(btnCaseTypes);

		btnNewButton = new JButton("Legal opinions and Recommendations");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RecomeLegal(le, Recommendations);

			}
		});
		btnNewButton.setBounds(22, 117, 259, 25);
		panel.add(btnNewButton);

		btnNewButton_1 = new JButton("Clients per Day");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Clientday(le, ClientsPerDay);
			}
		});
		btnNewButton_1.setBounds(22, 171, 125, 25);
		panel.add(btnNewButton_1);

		btnAllClients = new JButton("All Clients");
		btnAllClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				allCli(le, Allclients);

			}
		});
		btnAllClients.setBounds(149, 173, 135, 21);
		panel.add(btnAllClients);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Legal Opinions or Recommendations", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel label = new JLabel("Legal Opinion");
		label.setBounds(30, 50, 120, 16);
		panel_1.add(label);

		legal_text = new JTextField();
		legal_text.setColumns(10);
		legal_text.setBounds(188, 34, 372, 61);
		panel_1.add(legal_text);

		JButton button = new JButton("Insert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String l = legal_text.getText();
				le.insertLegalOpinion(l);

			}
		});
		button.setBounds(677, 50, 97, 25);
		panel_1.add(button);

		JLabel label_1 = new JLabel("Recommendation");
		label_1.setBounds(30, 169, 138, 30);
		panel_1.add(label_1);

		reco_text = new JTextField();
		reco_text.setColumns(10);
		reco_text.setBounds(188, 157, 372, 61);
		panel_1.add(reco_text);

		JButton button_1 = new JButton("Insert");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String r = reco_text.getText();

				le.insertRecommendation(r);

			}
		});
		button_1.setBounds(677, 175, 97, 25);
		panel_1.add(button_1);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String string = case_type_text.getText();
				le.insertCaseType(string);
			}
		});
		btnInsert.setBounds(677, 264, 97, 25);
		panel_1.add(btnInsert);

		case_type_text = new JTextField();
		case_type_text.setColumns(10);
		case_type_text.setBounds(188, 265, 372, 61);
		panel_1.add(case_type_text);

		JLabel lblNewLabel_1 = new JLabel("Case Type");
		lblNewLabel_1.setBounds(30, 287, 108, 25);
		panel_1.add(lblNewLabel_1);

		btnCaseTypes.setVisible(false);
		btnNewButton_1.setVisible(false);
		btnNewButton.setVisible(false);
		btnAllClients.setVisible(false);

		//
	}

	public void viewclient(HOManagementUI le) {
		Object rowData[][] = null;
		String columns[] = null;
		columns = new String[] { "Client_ID", "Case Transaction", "Legal Opinion or Recommendatio" };
		//
		ArrayList<Object[]> caseList = new ArrayList<Object[]>();
		le.getClient(caseList);

		rowData = new Object[caseList.size()][4];

		// ColumnModel

		for (int i = 0; i < caseList.size(); i++) {
			rowData[i] = caseList.get(i);
		}
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData, columns));

		scrollPane.setViewportView(table_1);

	}

	public void viewade(HOManagementUI le) {
		Object rowData[][] = null;
		String columns[] = null;
		columns = new String[] { "Client_ID" };
		//
		ArrayList<Object[]> caseList = new ArrayList<Object[]>();
		le.getNotAttended(caseList, date.getText());

		rowData = new Object[caseList.size()][4];

		// ColumnModel

		for (int i = 0; i < caseList.size(); i++) {
			rowData[i] = caseList.get(i);
		}
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData, columns));

		scrollPane.setViewportView(table_1);

	}

	public void statistic(HOManagementUI le) {
		Object rowData[][] = null;
		String columns[] = null;
		columns = new String[] { "Client_ID" };
		//
		ArrayList<Object[]> caseList = new ArrayList<Object[]>();
		// le.CalculateStatistics(ClientsPerDay, casetype, Recommendations, Allclients,
		// Branch);

		rowData = new Object[caseList.size()][4];

		// ColumnModel

		for (int i = 0; i < caseList.size(); i++) {
			rowData[i] = caseList.get(i);
		}
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData, columns));

		scrollPane.setViewportView(table_1);

	}

	public void ClientsPerDayTable(HOManagementUI le, int t[]) {
		DefaultListModel DLM = new DefaultListModel();

		DLM.addElement("Clients for case type 1: " + t[0]);
		DLM.addElement("Clients for case type 2: " + t[1]);
		DLM.addElement("Clients for case type 3: " + t[2]);
		DLM.addElement("Clients for case type 1 :" + t[3]);
		DLM.addElement("Clients for case type 1 :" + t[4]);

		JList list = new JList();
		list.setModel(DLM);
		scrollPane.setViewportView(list);

	}

	public void RecomeLegal(HOManagementUI le, int t[]) {
		DefaultListModel DLM = new DefaultListModel();

		DLM.addElement("Legal Opinion 1: " + t[0]);
		DLM.addElement("Legal Opinion 2: " + t[1]);
		DLM.addElement("Legal Opinion 3: " + t[2]);
		DLM.addElement("Legal Opinion 4: " + t[3]);
		DLM.addElement("Legal Opinion 5: " + t[4]);

		DLM.addElement("Recommendation 1: " + t[5]);
		DLM.addElement("Recommendation 2: " + t[6]);
		DLM.addElement("Recommendation 3: " + t[7]);
		DLM.addElement("Recommendation 4: " + t[8]);
		DLM.addElement("Recommendation 5: " + t[9]);

		JList list = new JList();
		list.setModel(DLM);
		scrollPane.setViewportView(list);

	}

	public void Clientday(HOManagementUI le, int t[]) {
		DefaultListModel DLM = new DefaultListModel();

		DLM.addElement("Clients on Monday : " + t[0]);
		DLM.addElement("Clients on Tuesday: " + t[1]);
		DLM.addElement("Clients on Wednesday: " + t[2]);
		DLM.addElement("Clients on Thursday : " + t[3]);
		DLM.addElement("Clients on Friday : " + t[4]);

		JList list = new JList();
		list.setModel(DLM);
		scrollPane.setViewportView(list);

	}

	public void allCli(HOManagementUI le, int t[]) {
		DefaultListModel DLM = new DefaultListModel();
		int allclientsint = ClientsPerDay[0];
		allclientsint = allclientsint + ClientsPerDay[1];
		allclientsint = allclientsint + ClientsPerDay[2];
		allclientsint = allclientsint + ClientsPerDay[3];
		allclientsint = allclientsint + ClientsPerDay[4];
		DLM.addElement("All Clients this Week : " + allclientsint);

		JList list = new JList();
		list.setModel(DLM);
		scrollPane.setViewportView(list);

	}

}
