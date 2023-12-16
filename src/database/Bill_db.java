package database;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Bill;

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
	public static void save(Bill bill) {
		String Query="insert into billtable (id,name,MobileNumber,Email,date,total,createdby) values('"+bill.getId()+"','"+bill.getName()+"','"+bill.getEmail()+"','"+bill.getMobileNumber()+"','"+bill.getDate()+"','"+bill.getTotal()+"','"+bill.getCreatedby()+"');";
		db_operations.updatedb(Query,"bill data added succesfully");
	}
	
}
