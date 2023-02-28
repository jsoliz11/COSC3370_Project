package og.teamupdate.cosc3370project.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import og.teamupdate.cosc3370project.application.*;

public class GUILogin extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JTextField passField;
	private String username;
	private String password;
	private static SQLConnect databaseConnection;
	private static GUISystem guisystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//creating the database connection object
		//SQLConnect databaseConnection = new SQLConnect();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILogin frame = new GUILogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUILogin() {
		setTitle("System Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Plase enter your details.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 50, 63, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 87, 56, 14);
		contentPane.add(lblNewLabel_2);
		
		userField = new JTextField();
		userField.setBounds(76, 47, 348, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		passField = new JTextField();
		passField.setBounds(76, 84, 348, 20);
		contentPane.add(passField);
		passField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = userField.getText();
				password = passField.getText();
				
				if(username.isEmpty() || password.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Username and Password cannot be left blank.", "Field Error", 2);
				}
				else
				{
					try {
						SQLConnect.initConnection(username, password);
						guisystem = new GUISystem();
						//guisystem.setVisible(true);
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(335, 120, 89, 23);
		contentPane.add(btnNewButton);
	}
}
