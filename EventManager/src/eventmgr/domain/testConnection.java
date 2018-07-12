package eventmgr.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class testConnection {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection conf= DriverManager.getConnection("jdbc:mysql://localhost:3306/apple","root","Password@1234");
				System.out.println("connectin--->"+conf);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
