package database;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.category;

public class category_db {
    
	public static void save(category cat) {
		int id=cat.getId();
		String name=(String) cat.getName();
		String query="INSERT INTO category (name) VALUES ('"+name+"');";
		db_operations.updatedb(query, "categary saved successfully");
	}
	
	public static ArrayList<category> getallrecords(){
		ArrayList<category> arraylist = new ArrayList<>();
		String Query="select * from category;";
		try {
			ResultSet rs=db_operations.getdata(Query);
			while(rs.next()) {
				category cat=new category();
				cat.setId(rs.getInt("id"));
				cat.setName(rs.getString("name"));
				arraylist.add(cat);
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return arraylist;
	}
	public static void delete_category(String id) {
		String Query="delete from category where id='"+id+"'";
		db_operations.updatedb(Query, "Category deleted sucessfully");
	}
}
