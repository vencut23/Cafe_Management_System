package database;

import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	
	public static ArrayList<Bill> getByDateInc(String Date) {
		String Query="select * from billtable where date like '%"+Date+"%'";
		ArrayList<Bill> al = new ArrayList<>();
		try {
			ResultSet rs = db_operations.getdata(Query);
			
			while(rs.next()) {
				Bill bill = new Bill();
				bill.setId(Integer.parseInt(rs.getString("id")));
				bill.setName(rs.getString("name"));
				bill.setMobileNumber(rs.getString("MobileNumber"));
				bill.setDate(rs.getString("date"));
				bill.setEmail(rs.getString("Email"));
				bill.setCreatedby(rs.getString("CreatedBy"));
				bill.setTotal(rs.getString("Total"));
				al.add(bill);
			}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		return al;
	}
	
	public static ArrayList<Bill> getByDateDesc(String Date) {
		String Query="select * from billtable where date like '%"+Date+"%' order by id DESC";
		ArrayList<Bill> al = new ArrayList<>();
		try {
			ResultSet rs = db_operations.getdata(Query);
			
			while(rs.next()) {
				Bill bill = new Bill();
				bill.setId(Integer.parseInt(rs.getString("id")));
				bill.setName(rs.getString("name"));
				bill.setMobileNumber(rs.getString("MobileNumber"));
				bill.setDate(rs.getString("date"));
				bill.setEmail(rs.getString("Email"));
				bill.setCreatedby(rs.getString("CreatedBy"));
				bill.setTotal(rs.getString("Total"));
				al.add(bill);
			}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		return al;
	}
}
