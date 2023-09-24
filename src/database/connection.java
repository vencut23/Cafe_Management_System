package database;

import java.sql.DriverManager;
import java.sql.*;

import javax.swing.JOptionPane;

public class connection {
	  public static Connection getConnection() {
		  Connection con=null;
		  try {
			 // Class.forName("com.mysql.jdbc.Driver");
			  con= DriverManager.getConnection("jdbc:mysql://localhost:3306/venkat",
	                    "root", "9865271790a");
	    	}catch(Exception e){
	    		JOptionPane.showMessageDialog(null, e);
		  }
		  return con;
	  }
	  
}
