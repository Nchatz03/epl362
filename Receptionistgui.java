package receptionistgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	 */
	public Receptionistgui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1128, 737);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 1086, 664);
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
		
		JLabel lblBithOfBrithday = new JLabel("Day of Brithday:");
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
		
		JLabel lblViewClients = new JLabel("View Clients");
		lblViewClients.setBounds(365, 10, 158, 22);
		panel.add(lblViewClients);
		
		JList client_list = new JList();
		client_list.setBounds(365, 47, 687, 563);
		panel.add(client_list);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInsert.setBounds(12, 318, 97, 25);
		panel.add(btnInsert);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(12, 386, 97, 25);
		panel.add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Appointments", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblClieantId = new JLabel("Client Id:");
		lblClieantId.setBounds(12, 13, 68, 30);
		panel_1.add(lblClieantId);
		
		client_id = new JTextField();
		client_id.setBounds(126, 17, 116, 22);
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
		apo_btn_insert.setBounds(12, 271, 141, 44);
		panel_1.add(apo_btn_insert);
		
		JLabel lblAppointments = new JLabel("Appointments");
		lblAppointments.setBounds(377, 17, 154, 22);
		panel_1.add(lblAppointments);
		
		JList apo_list = new JList();
		apo_list.setBounds(377, 52, 676, 551);
		panel_1.add(apo_list);
	}
}
