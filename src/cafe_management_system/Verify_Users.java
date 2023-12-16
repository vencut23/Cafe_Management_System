package cafe_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import model.User;
import database.user_db;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Verify_Users extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Verify_Users frame = new Verify_Users();
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
	public Verify_Users() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				getAllRecords("");
				
			}
		});
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Verify Users");
		lblNewLabel.setIcon(new ImageIcon(Verify_Users.class.getResource("/image/verify users.png")));
		lblNewLabel.setBounds(23, 11, 128, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Verify_Users.class.getResource("/image/close.png")));
		btnNewButton.setBounds(1325, 16, 31, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setBounds(445, 79, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String Email=textField.getText();
				getAllRecords(Email);
			}
		});
		textField.setBounds(501, 76, 304, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table.getSelectedRow();
				TableModel tm = table.getModel();
				String email=(String) tm.getValueAt(index,2);
				String Status = (String) tm.getValueAt(index, 6);
				if(Status.equals("false")) {
					Status="true";
				}else {
					Status="true";
				}
				int a=JOptionPane.showConfirmDialog(null, "Do you want to change status..?","select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					user_db.update_status(email,Status);
					setVisible(false);
					new Verify_Users().setVisible(true);
				}
			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(10, 138, 1346, 577);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				{"iii","yyy","iii","yyy","iii","yyy","iii"}
				},
				new String[] {
					"New column", "New column","New column", "New column","New column", "New column","New column"
				}
			));
		contentPane.add(table);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2.setBounds(10, 120, 192, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name");
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setBounds(201, 120, 192, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email");
		lblNewLabel_2_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setBounds(393, 120, 192, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Address");
		lblNewLabel_2_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_3.setBounds(780, 120, 192, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Security Question");
		lblNewLabel_2_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_4.setBounds(972, 120, 192, 14);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Status");
		lblNewLabel_2_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_5.setBounds(1164, 120, 192, 14);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Mobile Number");
		lblNewLabel_2_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_6.setBounds(587, 120, 187, 14);
		contentPane.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_4 = new JLabel("*Click a row to Change the Status");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(414, 726, 432, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Verify_Users.class.getResource("/image/full-page-background.PNG")));
		lblNewLabel_3.setBounds(0, 0, 1366, 768);
		contentPane.add(lblNewLabel_3);
	}
	public void getAllRecords(String Email) {
		ArrayList<User> l = user_db.getAllRecords(Email);
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		for(User u:l) {
			if(!u.getEmail().equals("admin@gmail.com")) {
				dtm.addRow(new Object[] {u.getId(),u.getName(),u.getEmail(),u.getMobileNumber(),u.getAddress(),u.getSecurityQuestion(),u.getStatus()});
			}
		}
		
	}
}
