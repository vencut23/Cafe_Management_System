package cafe_management_system;

import java.awt.EventQueue;

import model.Product;
import model.category;
import database.Product_db;
import database.category_db;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AddNewItem extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textPrice;
    private JButton btnSave;
    private JButton btnClear;
    private JComboBox comboBox ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewItem frame = new AddNewItem();
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
	public AddNewItem() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ArrayList<category> l = category_db.getallrecords();
				for(category a:l) {
					comboBox.addItem(a.getName());
				}
			}
		});
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 134, 700,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Product");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setIcon(new ImageIcon(AddNewItem.class.getResource("/image/new product.png")));
		lblNewLabel.setBounds(22, 21, 141, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really Want to close","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddNewItem.class.getResource("/image/close.png")));
		btnNewButton.setBounds(642, 22, 35, 24);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(170, 99, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Category");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(170, 150, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(170, 207, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textName = new JTextField();
		textName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validatee();
			}
		});
		textName.setBounds(268, 96, 248, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(268, 146, 248, 22);
		contentPane.add(comboBox);
		
		textPrice = new JTextField();
		textPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validatee();
			}
			
		});
		textPrice.setBounds(268, 201, 248, 20);
		contentPane.add(textPrice);
		textPrice.setColumns(10);
		
		 btnSave = new JButton("Save");
		 btnSave.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Product p = new Product();
		        p.setName(textName.getText());
		        p.setCategory(comboBox.getSelectedItem().toString());
		        p.setPrice(textPrice.getText());
		        Product_db.Save(p);
		        setVisible(false);
		        new AddNewItem().setVisible(true);
		 	}
		 });
		btnSave.setIcon(new ImageIcon(AddNewItem.class.getResource("/image/save.png")));
		btnSave.setBounds(170, 272, 89, 23);
		btnSave.setEnabled(false);
		contentPane.add(btnSave);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText("");
				textPrice.setText("");
				btnSave.setEnabled(false);
			}
		});
		btnClear.setIcon(new ImageIcon(AddNewItem.class.getResource("/image/clear.png")));
		btnClear.setBounds(427, 272, 89, 23);
		contentPane.add(btnClear);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setIcon(new ImageIcon(AddNewItem.class.getResource("/image/small-page-background.png")));
		lblNewLabel_4.setBounds(0, 0, 700, 400);
		contentPane.add(lblNewLabel_4);
	}
	public void validatee() {
		String name=textName.getText();
		String price=textPrice.getText();
		if(!name.equals("")&&!price.equals("")) {
			btnSave.setEnabled(true);
		}else {
			btnSave.setEnabled(false);
		}
	}
}
