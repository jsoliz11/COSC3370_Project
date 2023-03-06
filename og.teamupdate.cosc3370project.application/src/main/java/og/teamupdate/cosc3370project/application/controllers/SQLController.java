package og.teamupdate.cosc3370project.application.controllers;

import og.teamupdate.cosc3370project.application.SQLConnect;

import java.sql.*;

import javax.swing.JOptionPane;

//Authors: Team Update: Changjiang He, David Schelanko, Joseph Garcia, Jose Soliz

public class SQLController extends SQLConnect{

	//======================================
	//addEmployee method
	//Purpose: inserts a NEW employee entry into the database. Takes the information from the GUIEditAdd class/form.
	//Returns nothing
	//Parameters: employeeFirstName, employeeMiddleInitial, emploteeLastName, employeeDepartment, employeePosition, employeePhone, employeeAddress, employeeEmail, employeeHireDate
	//======================================
	private static void addEmployee(String employeeFname, String employeeMI, String employeeLname, String employeeDept, String empDesig, String employeePhone, String employeeAddress, String employeeEmail, String hireDate) {
		try {
			Statement stmt = serverConnect.createStatement();
			
			String addEmployeeString = "INSERT INTO employeeTable (employeeFirstName, employeeMI, employeeLastName, employeeDepartment, employeeDesignation, employeePhone, employeeAddress, employeeEmail, hireDate)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement addEmployeeStmt = serverConnect.prepareStatement(addEmployeeString);
			addEmployeeStmt.setString(1,  employeeFname);
			
			if(employeeMI != "")
				addEmployeeStmt.setString(2, employeeMI);
			else
				addEmployeeStmt.setString(2, null);
			
			addEmployeeStmt.setString(3,  employeeLname);
			addEmployeeStmt.setString(4, employeeDept);
			addEmployeeStmt.setString(5, empDesig);
			addEmployeeStmt.setString(6, employeePhone);
			addEmployeeStmt.setString(7, employeeAddress);
			addEmployeeStmt.setString(8, employeeEmail);
			addEmployeeStmt.setString(9, hireDate);
			
			int queryRes = addEmployeeStmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Added " + queryRes + " to the database.", "MariaDB Connection", JOptionPane.INFORMATION_MESSAGE);
			addEmployeeStmt.close();
			
			String sql = "SELECT employee_id FROM employeeTable WHERE employeePhone = '" + employeePhone + "' AND employeeFirstName = '" + employeeFname + "' AND employeeLastName = '" + employeeLname + "'";
		    //PreparedStatement timeCardStmt = serverConnect.prepareStatement(sql);
		    //timeCardStmt.setString(1, employeePhone);
		    //timeCardStmt.setString(2, employeeFname);
		    //timeCardStmt.setString(3, employeeLname);
			Statement timeCardStmt = serverConnect.createStatement();
		    ResultSet rs = timeCardStmt.executeQuery(sql);
		    
		    if (rs.next()) {
		   	 	int id = rs.getInt("employee_id");
		        
		   	 	addEmployeeTimeCard(id);
		    } else {
		    	JOptionPane.showMessageDialog(null, "The system failed to insert the appropriate time card entry.", "MariaDB Connection", JOptionPane.ERROR_MESSAGE);
		    }
		    timeCardStmt.close();
		    stmt.close();
			
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
	
	public static void addEmployeeTimeCard(int employeeId) {
		//Statement
		String id = String.valueOf(employeeId);
		String addTimeCardString = "INSERT INTO employeeTimeCard (employee_id) VALUES (?)";
		try {
			PreparedStatement timecard = serverConnect.prepareStatement(addTimeCardString);
			timecard.setString(1, id);
			
			timecard.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//JOptionPane.showMessageDialog(null, "Successfully entered " + queryRes + " timecard entry.", "MariaDB Connection", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void addEmployeeQuery(String f, String MI, String l, String dept, String desig, String phone, String address, String email, String hireDate){
		addEmployee(f, MI, l, dept, desig, phone, address, email, hireDate);
	}
	
}
