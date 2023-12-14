package database;
import java.sql.ResultSet;
import java.util.ArrayList;

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
}
