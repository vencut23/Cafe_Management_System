package cafe_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Home extends JFrame {

	private JPanel contentPane;
  private String mail;
	/**
	 * Launch the application.
	 */
  JButton btnVierifyUser;
  private JButton btnVED;
  private JButton btnManageCatagory;
  private JButton btnNewProduct;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home(String mail) {
		this();
		this.mail=mail;
		if(mail.equals("admin@gmail.com")) {
			 btnVierifyUser.setVisible(true);
			  btnVED.setVisible(true);
			btnManageCatagory.setVisible(true);
			 btnNewProduct.setVisible(true);
			
		}
		 
	}
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1379, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/image/logout.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really Want to LogOut?...!","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					setVisible(false);
					new login().setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(221, 11, 110, 33);
		contentPane.add(btnNewButton);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setIcon(new ImageIcon(Home.class.getResource("/image/place order.png")));
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlaceOrder.setBounds(341, 11, 146, 33);
		contentPane.add(btnPlaceOrder);
		
		JButton btnViewOrderAnd = new JButton("view Order and order Placed Details");
		btnViewOrderAnd.setIcon(new ImageIcon(Home.class.getResource("/image/View Bills & Order Placed Details.png")));
		btnViewOrderAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewOrderAnd.setBounds(497, 11, 276, 33);
		contentPane.add(btnViewOrderAnd);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setIcon(new ImageIcon(Home.class.getResource("/image/change Password.png")));
		btnChangePassword.setBounds(783, 11, 195, 33);
		contentPane.add(btnChangePassword);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(Home.class.getResource("/image/exit small.png")));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do You Want to Exut?..!","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(988, 11, 89, 33);
		contentPane.add(btnExit);
		
	     btnManageCatagory = new JButton("Manage Catagory");
	     btnManageCatagory.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		new ManageCatagory().setVisible(true);
	     	}
	     });
		btnManageCatagory.setIcon(new ImageIcon(Home.class.getResource("/image/category.png")));
		btnManageCatagory.setBounds(303, 646, 153, 33);
		contentPane.add(btnManageCatagory);
		
		btnNewProduct = new JButton("New Product");
		btnNewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddNewItem().setVisible(true);
			}
		});
		btnNewProduct.setIcon(new ImageIcon(Home.class.getResource("/image/new product.png")));
		btnNewProduct.setBounds(466, 646, 142, 33);
		contentPane.add(btnNewProduct);
		
		btnVED = new JButton("View Edit and Delete Product");
		btnVED.setIcon(new ImageIcon(Home.class.getResource("/image/view edit delete product.png")));
		btnVED.setBounds(618, 646, 243, 33);
		contentPane.add(btnVED);
		
		btnVierifyUser = new JButton("Vierify User");
		btnVierifyUser.setIcon(new ImageIcon(Home.class.getResource("/image/verify users.png")));
		btnVierifyUser.setBounds(871, 646, 147, 33);
		contentPane.add(btnVierifyUser);
		 btnVED.setVisible(false);
		btnManageCatagory.setVisible(false);
		 btnNewProduct.setVisible(false);
		 btnVierifyUser.setVisible(false);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/image/home-background-image.png")));
		lblNewLabel.setBounds(0, 0, 1363, 690);
		contentPane.add(lblNewLabel);
	}
}
