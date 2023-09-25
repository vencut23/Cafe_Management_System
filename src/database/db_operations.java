package database;
import java.sql.*;

import javax.swing.JOptionPane;
public class db_operations {
   public static void updatedb(String Query,String msg) {
	   try {
		    Connection con=connection.getConnection();
		    Statement st=con.createStatement();
		    st.executeUpdate(Query);
		   if(!msg.equals(""))
                JOptionPane.showMessageDialog(null, msg);		   
	   }catch(Exception e) {
		   JOptionPane.showMessageDialog(null, e,"Message",JOptionPane.ERROR_MESSAGE);
	   }
   }
   public static ResultSet getdata(String Query) {
	   try {
		   Connection con=connection.getConnection();
		   Statement st= con.createStatement();
		   ResultSet rs=st.executeQuery(Query);
		   return rs;
	   }catch(Exception e) {
		   JOptionPane.showMessageDialog(null, e, "message", JOptionPane.ERROR_MESSAGE);
		   return null;
	   }
   }
}
