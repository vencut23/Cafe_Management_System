package database;

import model.User;
public class user_db {
   public static void saveondb(User user) {
	   String name=user.getName();
	   String emailAddress=user.getEmail();
	   String phoneNumber=user.getMobileNumber();
	   String passwordValue=user.getPassward();
	   String securityQuestion=user.getSecurityQuestion();
	   String answer=user.getAnswer();
	   String save="INSERT INTO UserInformation (Name, EmailAddress, PhoneNumber, Password, SecurityQuestion, Answer) " +
               "VALUES ('" + name + "', '" + emailAddress + "', '" + phoneNumber + "', '" + passwordValue + "', '" + securityQuestion + "', '" + answer + "')";
      db_operations.updatedb(save,"user saved successfully");
   }
}
