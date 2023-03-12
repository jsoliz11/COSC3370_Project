package og.teamupdate.cosc3370project.application;

//import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import og.teamupdate.cosc3370project.application.controllers.SQLController;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

@SuppressWarnings("serial")
public class GUIReadInfo extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private DefaultListModel<String> listModel  = new DefaultListModel();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JList list = new JList(listModel);
	protected String data[];
	
	
	//Populates the JList
	private void queryDatabase() {
		data = SQLController.getEmployeeInfo();
		loadDatabaseContents();
		
	}
	@SuppressWarnings("unchecked")
	private void loadDatabaseContents() {
		if(data != null) {
			list.setListData(data);
		}
		else {
			JOptionPane.showMessageDialog(null, "The database appears to be empty, or the connection has failed.", "Load from Database", JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Launch the window
	 */
	public void openRead() {
		try {
			GUIReadInfo frame = new GUIReadInfo();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//UPDATES THE LABELS DISPLAYING THE INFORMATION
	public void showEmployeeInfo(String selected) {
		
	}

	/**
	 * Create the frame.
	 */
	public GUIReadInfo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//To-Do Query Database for Employee Info
				queryDatabase();
			}
		});
		setTitle("Employee Database");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 984, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//UPDATES THE INFO DISPLAYED FROM JLIST SELECTION
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
                    return;
                }
                int index = list.getSelectedIndex();
                if (index >= 0) {
                    String selected = listModel.getElementAt(index);
                    showEmployeeInfo(selected);
                }
			}
		});
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//WINDOW CREATION
		
		list.setBounds(30, 43, 404, 347);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("Employee Name:");
		lblNewLabel.setBounds(479, 43, 122, 14);
		contentPane.add(lblNewLabel);
		
		JLabel employeeNameLabel = new JLabel("<Name Placeholder>");
		employeeNameLabel.setBounds(613, 43, 347, 14);
		contentPane.add(employeeNameLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Organization Details");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(479, 68, 143, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Designation:");
		lblNewLabel_1.setBounds(479, 93, 175, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Department:");
		lblNewLabel_3.setBounds(479, 118, 108, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Employee Sick Days/PTO Accrued:");
		lblNewLabel_4.setBounds(479, 143, 264, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hours Worked Year-To-Date:");
		lblNewLabel_5.setBounds(479, 168, 242, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Contact Information");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(479, 193, 175, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Employee Phone:");
		lblNewLabel_6.setBounds(479, 218, 143, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Employee E-Mail Address:");
		lblNewLabel_8.setBounds(479, 243, 186, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Employee Physical Address:");
		lblNewLabel_9.setBounds(479, 268, 201, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel employeeDesLabel = new JLabel("<Designation>");
		employeeDesLabel.setBounds(650, 93, 328, 14);
		contentPane.add(employeeDesLabel);
		
		JLabel departmentLabel = new JLabel("<Department>");
		departmentLabel.setBounds(586, 117, 347, 16);
		contentPane.add(departmentLabel);
		
		JLabel employeePTOLabel = new JLabel("<int>");
		employeePTOLabel.setBounds(723, 142, 234, 16);
		contentPane.add(employeePTOLabel);
		
		JLabel ytdLabel = new JLabel("<YTD>");
		ytdLabel.setBounds(690, 167, 267, 16);
		contentPane.add(ytdLabel);
		
		JLabel employeePhone = new JLabel("###-###-####");
		employeePhone.setBounds(613, 217, 347, 16);
		contentPane.add(employeePhone);
		
		JLabel employeeEmail = new JLabel("<E-Mail>");
		employeeEmail.setBounds(663, 242, 61, 16);
		contentPane.add(employeeEmail);
		
		JLabel employeePAddress = new JLabel("<Address>");
		employeePAddress.setBounds(673, 267, 292, 16);
		contentPane.add(employeePAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(446, 43, 19, 347);
		contentPane.add(scrollPane);
	}
}
