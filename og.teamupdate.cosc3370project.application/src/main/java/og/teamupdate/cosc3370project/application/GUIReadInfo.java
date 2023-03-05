package og.teamupdate.cosc3370project.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import og.teamupdate.cosc3370project.application.controllers.SQLController;

public class GUIReadInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void openRead() {
		try {
			GUIReadInfo frame = new GUIReadInfo();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public GUIReadInfo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//To-Do Query Database for Employee Info
			}
		});
		setTitle("Employee Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(30, 42, 404, 348);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("Employee Name: ");
		lblNewLabel.setBounds(479, 43, 122, 14);
		contentPane.add(lblNewLabel);
		
		JLabel employeeNameLabel = new JLabel("<Name Placeholder>");
		employeeNameLabel.setBounds(611, 43, 347, 14);
		contentPane.add(employeeNameLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Organization Details");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(479, 68, 143, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Designation:");
		lblNewLabel_1.setBounds(479, 93, 143, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Department: ");
		lblNewLabel_3.setBounds(479, 118, 108, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Employee Sick Days/PTO Accrued: ");
		lblNewLabel_4.setBounds(479, 143, 201, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hours Worked Year-To-Date: ");
		lblNewLabel_5.setBounds(479, 168, 175, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Contact Information");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(479, 193, 175, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Employee Phone:");
		lblNewLabel_6.setBounds(479, 218, 143, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Employee E-Mail Address: ");
		lblNewLabel_8.setBounds(479, 243, 186, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Employee Physical Address: ");
		lblNewLabel_9.setBounds(479, 268, 201, 14);
		contentPane.add(lblNewLabel_9);
	}
}
