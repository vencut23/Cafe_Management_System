package cafe_management_system;

import java.awt.EventQueue;
import model.Product;
import model.category;
import database.category_db;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import database.Product_db;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class ViewEditProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textPrice;
	private JTable table;
    private JButton btnUpdate;
    private JButton btnClear;
    private JButton btnDelete;
    private JComboBox comboBox;
    private JLabel IDlabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEditProduct frame = new ViewEditProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewEditProduct() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ArrayList<Product> l =Product_db.getAllRecords();
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				for(Product p:l) {
					dtm.addRow(new Object[] {p.getId(),p.getName(),p.getCategory(),p.getPrice()});
				}
				
			}
		});
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366,766);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Edit Delete Product");
		lblNewLabel.setIcon(new ImageIcon(ViewEditProduct.class.getResource("/image/view edit delete product.png")));
		lblNewLabel.setBounds(26, 22, 184, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ViewEditProduct.class.getResource("/image/close.png")));
		btnNewButton.setBounds(1315, 11, 30, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(143, 163, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		IDlabel = new JLabel("00");
		IDlabel.setBounds(238, 163, 46, 14);
		contentPane.add(IDlabel);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setBounds(143, 215, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("category");
		lblNewLabel_4.setBounds(143, 262, 67, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Price");
		lblNewLabel_5.setBounds(143, 305, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textName = new JTextField();
		textName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validatee();
			}
		});
		textName.setBounds(238, 212, 247, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(238, 258, 247, 22);
		contentPane.add(comboBox);
		
		textPrice = new JTextField();
		textPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validatee();
			}
		});
		textPrice.setBounds(238, 302, 247, 20);
		contentPane.add(textPrice);
		textPrice.setColumns(10);
		
		 btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product p = new Product();
				p.setId(Integer.parseInt(IDlabel.getText()));
				p.setCategory((String)comboBox.getSelectedItem());
				p.setName(textName.getText());
				p.setPrice(textPrice.getText());
				int a=JOptionPane.showConfirmDialog(null, "do you want to update the record","select", JOptionPane.YES_NO_OPTION);
				if(a==0) {
				Product_db.update(p);
				setVisible(false);
				new ViewEditProduct().setVisible(true);
				}
				
			}
		});
		btnUpdate.setIcon(new ImageIcon(ViewEditProduct.class.getResource("/image/save.png")));
		btnUpdate.setBounds(143, 358, 102, 23);
		btnUpdate.setEnabled(false);
		contentPane.add(btnUpdate);
		
		 btnDelete = new JButton("Delete");
		 btnDelete.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int id=Integer.parseInt(IDlabel.getText());
		 		int a=JOptionPane.showConfirmDialog(null, "do you want to Delete the record","select", JOptionPane.YES_NO_OPTION);
		 		if(a==0) {
		 		Product_db.delete(id);
		 		setVisible(false);
		 		new ViewEditProduct().setVisible(true);
		 		}
		 	}
		 });
		btnDelete.setIcon(new ImageIcon(ViewEditProduct.class.getResource("/image/delete.png")));
		btnDelete.setBounds(276, 358, 89, 23);
		btnDelete.setEnabled(false);
		contentPane.add(btnDelete);
		
		 btnClear = new JButton("Clear");
		 btnClear.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		IDlabel.setText("00");
		 		textName.setText("");
		 		textPrice.setText("");
		 		comboBox.setSelectedIndex(-1);
		 	}
		 });
		btnClear.setIcon(new ImageIcon(ViewEditProduct.class.getResource("/image/clear.png")));
		btnClear.setBounds(396, 358, 89, 23);
		contentPane.add(btnClear);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table.getSelectedRow();
			   TableModel tm = table.getModel();
			   int id= (int) tm.getValueAt(index, 0);
			   String name= (String) tm.getValueAt(index, 1);
			   String category=(String) tm.getValueAt(index, 2);
			   String price=(String) tm.getValueAt(index,3);
			   textName.setText(name);
			   textPrice.setText(price);
			   IDlabel.setText(id+"");
			   comboBox.setSelectedItem(category);
			   comboBox.removeAllItems();
			   comboBox.addItem(category);
			   ArrayList<category> l = category_db.getallrecords();
			   for(category p:l) {
				   if(!p.getName().equals(category)) comboBox.addItem(p.getName());
			   }
			   btnUpdate.setEnabled(true);
			   btnDelete.setEnabled(true);
			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(616, 163, 664, 406);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				//{"iii","yyy","iii","iii"}
				},
				new String[] {
					"New column", "New column","New column", "New column"
				}
			));

		contentPane.add(table);
		
		JLabel lblNewLabel_6 = new JLabel("ID");
		lblNewLabel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6.setBounds(616, 147, 163, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Name");
		lblNewLabel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7.setBounds(781, 147, 163, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Category");
		lblNewLabel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8.setBounds(947, 147, 163, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Price");
		lblNewLabel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9.setBounds(1113, 147, 167, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon(ViewEditProduct.class.getResource("/image/full-page-background.PNG")));
		lblNewLabel_10.setBounds(0, 0, 1366, 755);
		contentPane.add(lblNewLabel_10);
	}
	public void validatee() {
		String name=textName.getText();
		String catogory=(String)comboBox.getSelectedItem();
		String Price= textPrice.getText();
		if(!name.equals("")&&catogory!=null&&!Price.equals("")) {
			btnUpdate.setEnabled(true);
			btnDelete.setEnabled(true);
		}else {
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);
		}
	}
}
