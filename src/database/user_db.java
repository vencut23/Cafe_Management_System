package database;

import model.User;
import java.sql.*;
import java.util.ArrayList;

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
   public static User search(String email) {
	   String Query= "select * from UserInformation where emailaddress='"+email+"';";
	   User user=null;
	   try {
		   ResultSet rs=db_operations.getdata(Query);
		   while(rs.next()) {
			   user=new User(); 
		   user.setSecurityQuestion(rs.getString("SecurityQuestion"));
		   user.setAnswer(rs.getString("answer"));
		   }
		   return user;
	   }catch(Exception e) {
		   JOptionPane.showMessageDialog(null, e);
	   }
	   return user;
   }
   public static void update(String email,String password) {
	   String Query="update UserInformation set password ='"+password+"' where emailaddress='"+email+"';";
	   db_operations.updatedb(Query,"User password updated succesfully");
   }
   public static ArrayList<User> getAllRecords(String Email){
	   ArrayList<User> l = new ArrayList<>();
	    try {
	    	ResultSet rs=db_operations.getdata("select * from UserInformation where emailaddress like '%"+Email+"%';");
	    	while(rs.next()) {
	    		User u= new User();
	    		u.setId(Integer.parseInt(rs.getString("UserID")));
	    	    u.setName(rs.getString("Name"));
	    	    u.setEmail(rs.getString("EmailAddress"));
	    		u.setMobileNumber(rs.getString("PhoneNumber"));
	    		u.setPassward(rs.getString("Password"));
	    		u.setSecurityQuestion(rs.getString("SecurityQuestion"));
	    		u.setStatus(rs.getString("Status"));
	    		l.add(u);;
	    	}
	    }catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, e);
	    }
	    return l;
   }
   public static void update_status(String Email,String Status) {
	   String Query="update UserInformation set Status ='"+Status+"' where EmailAddress='"+Email+"';";
	   db_operations.updatedb(Query, "Status Changed successfully");
   }
   
   public static void changepassword(String email,String oldpassword,String newpassword) {
	   try {
		   ResultSet rs = db_operations.getdata("select * from userInformation where emailaddress='"+email+"' and password='"+oldpassword+"';");
		   if(rs.next()) {
			   update(email,newpassword);
		   }else {
			   JOptionPane.showMessageDialog(null, "old password is wrong");
		   }
	   }catch(Exception e) {
		   JOptionPane.showMessageDialog(null, e);
	   }
   }
   
   public static void changeSecurityQuestion(String email,String question,String answer,String password) {
	    String Query="select * from userInformation where emailaddress='"+email+"' and password='"+password+"'";
	    try {
	    	ResultSet rs = db_operations.getdata(Query);
	    	if(rs.next()) {
	    		update(email,question,answer);
	    	}else {
	    		JOptionPane.showMessageDialog(null, "Password is  wrong");
	    	}
	    }catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, e);
	    }
	    
   }
   public static void update(String email,String sq,String answer) {
	   String query="update userInformation set SecurityQuestion='"+sq+"',answer ='"+answer+"' where emailaddress ='"+email+"';";
	   db_operations.updatedb(query,"user security question updated sucessfully");
   }
   public static String getsq(String email) {
	   String Query="select * from userInformation where emailaddress='"+email+"';";
	   String ans="";
	    try {
	    	ResultSet rs = db_operations.getdata(Query);
	    	if(rs.next()) {
	    		ans=rs.getString("SecurityQuestion");
	    	}else {
	    		JOptionPane.showMessageDialog(null, "Password is  wrong");
	    	}
	    }catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, e);
	    }
	    return ans;
   }
}
