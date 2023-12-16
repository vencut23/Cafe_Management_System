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
	public static final String Product_Table="CREATE TABLE product (\r\n"
			+ "    id INT AUTO_INCREMENT PRIMARY KEY,\r\n"
			+ "    name VARCHAR(255) NOT NULL,\r\n"
			+ "    category VARCHAR(100),\r\n"
			+ "    price VARCHAR(100)\r\n"
			+ ");";
	public static final String BILL_TABLE= "Create table BillTable(id INT primary key,name varchar(200),MobileNumber varchar(200),Email varchar(200),date varchar(200),total varchar(200),createdby varchar(200));";

}
