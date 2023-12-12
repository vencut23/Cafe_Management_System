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
	public final static String INSERT_ADMIN="INSERT INTO UserInformation (Name, EmailAddress, PhoneNumber, Password, SecurityQuestion, Answer,status) values('Admin','admin@gmail.com','1234567890','admin','what is your name?','admin','true'); "; 
	public final static String CATAGORY_TABLE="CREATE TABLE category (\r\n"
			+ "    id INT NOT NULL AUTO_INCREMENT,\r\n"
			+ "    name VARCHAR(50) NOT NULL,\r\n"
			+ "    PRIMARY KEY (id)\r\n"
			+ "); ";
}
