package database;

import model.User;
import java.sql.*;

import javax.swing.JOptionPane;
public class user_db {
   public static void saveondb(User user) {
	   String name=user.getName();
	   String emailAddress=user.getEmail();
	   String phoneNumber=user.getMobileNumber();
	   String passwordValue=user.getPassward();
	   String securityQuestion=user.getSecurityQuestion();
	   String answer=user.getAnswer();
	   String save="INSERT INTO UserInformation (Name, EmailAddress, PhoneNumber, Password, SecurityQuestion, Answer,status) " +
               "VALUES ('" + name + "', '" + emailAddress + "', '" + phoneNumber + "', '" + passwordValue + "', '" + securityQuestion + "', '" + answer + "','false')";
      db_operations.updatedb(save,"user saved successfully");
   }
   public static User login(String email,String password) {
	   String query="select * from UserInformation where emailaddress='"+email+"' and password ='"+password+"';";  
	   User user=null;
	   try {
		   ResultSet rs=db_operations.getdata(query);
		   while(rs.next()) {
			   user=new User();
			   user.setStatus(rs.getString("status"));
		   }
		   return user;
	   }catch(Exception e) {
		   JOptionPane.showMessageDialog(null, e);
		   return user;
	   }
	   
   }
}
