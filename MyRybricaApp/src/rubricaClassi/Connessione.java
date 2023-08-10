package rubricaClassi;

import java.sql.*;


public class Connessione {
	private String url;
	private String username;
	private String password;
	private Connection myConn;
	private Statement myStmt;
	
	public Connessione() {
		this.url = "jdbc:mysql://localhost:3306/rubrica_project";
		this.username = "dev1";
		this.password = "passdev1!";
		
		try {
			this.myConn = DriverManager.getConnection(url, username, password);
			this.myStmt = myConn.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connessione(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
		
		try {
			this.myConn = DriverManager.getConnection(url, username, password);
			this.myStmt = myConn.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void chiudiConnessione() {
		try {
			this.myStmt.close();
			this.myConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getMyConn() {
		return myConn;
	}

	public Statement getMyStmt() {
		return myStmt;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	


}
