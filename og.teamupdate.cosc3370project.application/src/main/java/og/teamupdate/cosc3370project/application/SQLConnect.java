package og.teamupdate.cosc3370project.application;

import java.sql.*;
import og.teamupdate.cosc3370project.application.GUISystem;

import javax.swing.JOptionPane;

public class SQLConnect {
	/**Dynamic DNS teamupdateproject.ddns.net*/
	
	private static String SQLURL = "teamupdateproject.ddns.net";
	
	/**Credentials String Holders*/
	private static String Username;
	private static String Passwd;
	private static Connection serverConnect;
	
	private static void setUsername(String username) { Username = username; }
	private static void setPass(String pass) { Passwd = pass; }

	private static void StartConnection() throws SQLException {
		try {
			serverConnect = DriverManager.getConnection("jdbc:mariadb://teamupdateproject.ddns.net:3306/employees", Username, Passwd);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Connection Failed.", "MariaDB Connection", 0); //Displays a message box with an error icon to the user
		}
	}
	
	public static void initConnection(String username, String pass) throws SQLException {
		setUsername(username);
		setPass(pass);
		
		try{
			StartConnection();
		}
		finally {
			serverConnect.close(); //This will always close the SQL connection
		}
	}
}