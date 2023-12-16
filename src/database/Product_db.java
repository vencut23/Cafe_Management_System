package database;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Product;
public class Product_db {
    
	public static void Save(Product p) { 
		String Query="INSERT INTO product (name, category, price) VALUES " +
                "('" + p.getName()+ "', '" + p.getCategory()+ "', '" +p.getPrice() + "')";
        db_operations.updatedb(Query, "Product saved Succesfully");
	}
	public static ArrayList<Product> getAllRecords(){
		ArrayList<Product> l = new ArrayList<>();
		String Query="select * from product";
		try {
			ResultSet rs=db_operations.getdata(Query);
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setCategory(rs.getString("category"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getString("price"));
				l.add(p);
			}
		}catch(Exception e) {
			
		}
		return l;
	}
	public static void delete(int id) {
		String Query="DELETE FROM product WHERE id = " + id+";";
		db_operations.updatedb(Query, "deleted succesfully");
	}
	public static void update(Product p) {
		String Query="UPDATE product SET name = '" + p.getName()+
                "', category = '" + p.getCategory() +
                "', price = '" + p.getPrice() +
                "' WHERE id = " +p.getId()+";";
		db_operations.updatedb(Query, "Updated succesfully");
	}
	public static ArrayList<Product> getBycategory(String cat){
		String Query="select * from product where category='"+cat+"';";
		ArrayList<Product> al = new ArrayList<>();
		try {
			ResultSet rs = db_operations.getdata(Query);
			while(rs.next()) {
				Product p = new Product();
				p.setName(rs.getString("name"));
				al.add(p);
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return al;
	}
	public static ArrayList<Product> getByname(String cat,String name){
		String Query="select * from product where name like '%"+name+"%' and category='"+cat+"'";
		ArrayList<Product> al = new ArrayList<>();
		try {
			ResultSet rs = db_operations.getdata(Query);
			while(rs.next()) {
				Product p = new Product();
				p.setName(rs.getString("name"));
				al.add(p);
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return al;
	}
	public static Product getproductdetail(String name) {
		Product p= new Product();
		String Query= "select * from product where name='"+name+"'";
		try {
			ResultSet rs = db_operations.getdata(Query);
			while(rs.next()) {
				p.setName(rs.getString("name"));
				p.setCategory(rs.getString("category"));
	            p.setPrice(rs.getString("price"));
	            p.setId(Integer.parseInt(rs.getString("id")));
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return p;
	}
}
