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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
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
				
				
				
			}
		});
		btnGetWeeklyReport.setBounds(12, 313, 188, 47);
		panel.add(btnGetWeeklyReport);

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
				
				
		String string=		case_type_text.getText();
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
	}

	public void viewclient(HOManagementUI le) {
		Object rowData[][] = null;
		String columns[] = null;
		columns = new String[] { "Client_ID", "Name", "Surname" };
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
		//le.CalculateStatistics(ClientsPerDay, casetype, Recommendations, Allclients, Branch);

		rowData = new Object[caseList.size()][4];

		// ColumnModel

		for (int i = 0; i < caseList.size(); i++) {
			rowData[i] = caseList.get(i);
		}
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData, columns));

		scrollPane.setViewportView(table_1);

	}
}
