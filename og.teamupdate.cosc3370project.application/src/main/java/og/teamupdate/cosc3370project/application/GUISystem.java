package og.teamupdate.cosc3370project.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import og.teamupdate.cosc3370project.application.SQLConnect;
import og.teamupdate.cosc3370project.application.GUIReadInfo;

//Authors: Team Update: Changjiang He, David Schelanko, Joseph Garcia, Jose Soliz

public class GUISystem extends JFrame {

	private JPanel contentPane;

	public void openGUI() {
		try {
			GUISystem frame = new GUISystem();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public GUISystem() {
		setTitle("Employee Admin Manager");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 526, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("What would you like to do?");
		lblNewLabel.setBounds(26, 31, 271, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Select");
		
		btnNewButton.setBounds(369, 95, 117, 29);
		contentPane.add(btnNewButton);
		
		String[] choices = {"Read employee records...", "Add an employee...", "Remove an employee...", "Fetch employee messages/grievances..."};
		final JComboBox optionSelectionBox = new JComboBox(choices);
		//optionSelectionBox.setModel(new DefaultComboBoxModel(new String[] {"Read employee records...", "Add an employee...", "Remove an employee...", "Fetch employee messages/grievances..."}));
		optionSelectionBox.setToolTipText("Select an action...");
		optionSelectionBox.setBounds(26, 57, 460, 27);
		contentPane.add(optionSelectionBox);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = optionSelectionBox.getSelectedIndex();
				if(selection == 0) {
					JOptionPane.showMessageDialog(null, "Read employee records selected.", "option", 1);
					GUIReadInfo employeeRead = new GUIReadInfo();
					employeeRead.openRead();
				}
			}
		});
	}
}
