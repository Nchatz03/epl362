package receptionist1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dbconnection.HOManagementUI;
import dbconnection.LegalRecordsUI;
import dbconnection.LegalStaffUI;
import dbconnection.ReceptionistUI;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginReceptionist {
	public ReceptionistUI re;
	public JFrame frame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginLegalStaff window = new LoginLegalStaff();
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
	public LoginReceptionist(ReceptionistUI re ) {
		this.re=re;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(27, 29, 149, 31);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(27, 87, 71, 16);
		frame.getContentPane().add(lblPassword);
		
		username = new JTextField();
		username.setBounds(152, 33, 172, 22);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(152, 84, 172, 19);
		frame.getContentPane().add(password);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				if (username.getText().equals("admin")&&String.valueOf(password.getPassword()).equals("1234")) {
					Receptionistgui legalStaffGui=new Receptionistgui(re);
					
					legalStaffGui.frame.setVisible(true);
					frame.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Username or Password", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(59, 170, 256, 50);
		frame.getContentPane().add(btnNewButton);
	}
}
