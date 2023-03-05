package og.teamupdate.cosc3370project.application.controllers;

import og.teamupdate.cosc3370project.application.SQLConnect;

import java.sql.*;

import javax.swing.JOptionPane;

//Authors: Team Update: Changjiang He, David Schelanko, Joseph Garcia, Jose Soliz

public class SQLController extends SQLConnect{

	private static void addEmployee(String employeeFname, String employeeLname, String employeeDept, String empDesig, String employeePhone, String employeeAddress, String employeeEmail) {
		try {
			Statement stmt = serverConnect.createStatement();
			
			String addEmployeeString = "INSERT INTO employeeTable (employeeFirstName, employeeLastName, employeeDepartment, employeeDesignation, employeePhone, employeeAddress, employeeEmail)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement addEmployeeStmt = serverConnect.prepareStatement(addEmployeeString);
			addEmployeeStmt.setString(1,  employeeFname);
			addEmployeeStmt.setString(2,  employeeLname);
			addEmployeeStmt.setString(3, employeeDept);
			addEmployeeStmt.setString(4, empDesig);
			addEmployeeStmt.setString(5, employeePhone);
			addEmployeeStmt.setString(6, employeeAddress);
			addEmployeeStmt.setString(7, employeeEmail);
			
			int queryRes = addEmployeeStmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Added " + queryRes + " to the database.", "MariaDB Connection", JOptionPane.INFORMATION_MESSAGE);
			addEmployeeStmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error while trying to add data entry.", "MariaDB Connection", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private static void rmEmployee(String employeeTimeCardID) {
		
	}
	
	private static void setEmployeeAlert(String alertMsg, int importance) {
		
	}
	
	public static void getHoursInfo() {
		
	}
	
	public static void getEmployeeInfo() {
		
	}
	
	public static void addEmployeeQuery(String f, String l, String dept, String desig, String phone, String address, String email){
		addEmployee(f, l, dept, desig, phone, address, email);
	}
	
	/*public static void loginQuery(String username, String passwd) {
		String AdminSQL = "SELECT * FROM managers, employeeTable WHERE username = ? AND password = ?";
		try {
			PreparedStatement adminStmt = serverConnect.prepareStatement(AdminSQL);
			adminStmt.setString(1,  username);
			adminStmt.setString(2,  passwd);
			ResultSet adminResult = adminStmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
}
