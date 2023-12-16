package database;

public class Tables {
  public static void main(String args[]) {
	  try {
		  //db_operations.updatedb(Queries.CREATE_TABLE,"created a table");
		  //db_operations.updatedb(Queries.INSERT_ADMIN,"Admin added sucessfully");
		  //db_operations.updatedb(Queries.CATAGORY_TABLE, "catagory table craeated succesfully");
		  //db_operations.updatedb(Queries.Product_Table, "product table craeated succesfully");
		  db_operations.updatedb(Queries.BILL_TABLE, "Bill table craeated succesfully");
	  }catch(Exception e) {
		  
	  }
  }
}
