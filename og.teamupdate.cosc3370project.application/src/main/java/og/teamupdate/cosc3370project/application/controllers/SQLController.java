package og.teamupdate.cosc3370project.application.controllers;

import og.teamupdate.cosc3370project.application.SQLConnect;
import java.sql.*;

import javax.swing.JOptionPane;

//Authors: Team Update: Changjiang He, David Schelanko, Joseph Garcia, Jose Soliz

public class SQLController extends SQLConnect{

	private static void addEmployee(String employeeFname, String employeeLname, String employeeDept, String empDesig, String employeePhone, String employeeAddress, String employeeEmail) {
		try {
			Statement stmt = serverConnect.createStatement();
			
			String addEmployeeString = "INSERT INTO employeeTable (employeeFirstName, employeeLastName, employeeDepartment, " +
					"employeeDesigation, employeePhone, employeeAddress, employeeEmail) VALUES ('" + employeeFname + "', '" + employeeLname + "', '" + employeeDept
					+ "', '" + empDesig + "', '" + employeePhone + "', '" + employeeAddress + "', '" + employeeEmail + "')";
			
			int queryRes = stmt.executeUpdate(addEmployeeString);
			JOptionPane.showMessageDialog(null, "Added " + queryRes + " to the database.", "MariaDB Connection", JOptionPane.INFORMATION_MESSAGE);
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
	
	public static void addEmployeeQuery() {
		
	}
	
	
}
