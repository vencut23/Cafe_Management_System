package database;

public class Queries {
    
	public final static String CREATE_TABLE="CREATE TABLE UserInformation ("
			+ "    UserID INT PRIMARY KEY AUTO_INCREMENT,"
			+ "    Name VARCHAR(255) NOT NULL,"
			+ "    EmailAddress VARCHAR(255) NOT NULL,"
			+ "    PhoneNumber VARCHAR(20),"
			+ "    Password VARCHAR(255) NOT NULL,"
			+ "    SecurityQuestion VARCHAR(255),"
			+ "    Answer VARCHAR(255)"
			+ ");";
	
	    
}
