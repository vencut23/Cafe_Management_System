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
   
}
