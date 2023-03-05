package og.teamupdate.cosc3370project.application;

import java.sql.*;

import javax.swing.JOptionPane;

//Authors: Team Update: Changjiang He, David Schelanko, Joseph Garcia, Jose Soliz

public class SQLConnect {
	
	//Dynamic DNS teamupdateproject.ddns.net
	private static String SQLURL = "teamupdateproject.ddns.net";
	
	//Credentials String Holders
	private static String Username = "admin";
	private static String Passwd = "TeamUpdateAdmin!@";
	protected static Connection serverConnect;
	
	//Setters for the username and password
	//private static void setUsername(String username) { Username = username; }
	//private static void setPass(String pass) { Passwd = pass; }
	

	//=================================================
	//Method: startConnection
	//Purpose: Connects to the system configured with the MariaDB.
	//Parameters: nothing
	//Returns: nothing
	//=================================================
	//Connects serverConnect object to the MariaDB system
	private static void StartConnection() throws SQLException {
		try {
			serverConnect = DriverManager.getConnection("jdbc:mariadb://" + SQLURL + ":3306/employees", Username, Passwd);
			GUILogin.setFlag();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to connect to the database.", "MariaDB Connection", 0); //Displays a message box with an error icon to the user
			GUILogin.rmFlag();
		}
	}
	
	
	//=================================================
	//Method: initConnection
	//Purpose: Retrieves the Username and Password fields from the Login form, and then tries to initiate the connection with StartConnection() method.
	//Parameters: String username, String pass
	//Returns: nothing
	//=================================================
	protected static void initConnection(String username, String pass) throws SQLException {
		//setUsername(username);
		//setPass(pass);
		
		//try{
			StartConnection();
			connectUser(username, pass);
		//}
		//finally {
		//	serverConnect.close(); //This should always close the SQL connection
		//}
	}
	
	protected static void closeConnection() throws SQLException
	{
		getServerConnect().close();
	}
	public static Connection getServerConnect() {
		return serverConnect;
	}
	public static void connectUser(String username, String password) {
		try {
			Statement stmt = serverConnect.createStatement();
			
			String loginString = "SELECT * FROM managers WHERE manager_username = ? AND manager_password = ?";
			PreparedStatement adminStmt = serverConnect.prepareStatement(loginString);
			adminStmt.setString(1, username);
			adminStmt.setString(2,  password);
			ResultSet adminResult = adminStmt.executeQuery();
			if(adminResult.next()) {
				GUILogin.setUserConnectedFlag();
			}
			else {
				JOptionPane.showMessageDialog(null, "Credentials do not match any entries.", "MariaDB Connection", 2);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


