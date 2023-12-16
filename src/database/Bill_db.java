package database;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Bill_db {
     
	public static String getId() {
		 int id=1;
		 try {
			 ResultSet rs= db_operations.getdata("select max(id) from BillTable");
			 while(rs.next()) {
				 id=rs.getInt(1);
				 id=id+1;
			 }
		 }catch(Exception e) {
			 JOptionPane.showMessageDialog(null, e);
		 }
		 return String.valueOf(id);
	}
	
}
