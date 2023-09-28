package cafe_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.user_db;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ForgetPassword extends JFrame {

	private JPanel contentPane;
	private JTextField mailtextField;
	private JTextField sqtextField;
	private JTextField anstextField;
	private JPasswordField npasswordField;
 private  JButton searchbtn;
    private JButton updatebtn;
    private JButton clearbtn;
    private JButton btnCheck;
    private String mailformat="^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    private String sqanswer=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgetPassword frame = new ForgetPassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
    public void mailvalidate() {
    	if(mailtextField.getText().matches(mailformat)) {
    		searchbtn.setEnabled(true);
    	}else {
    		searchbtn.setEnabled(false);
    	}
         
    }
	public void clear() {
		searchbtn.setEnabled(false);
		npasswordField.setText("");
		mailtextField.setText("");
		anstextField.setText("");
		updatebtn.setEnabled(false);
		sqtextField.setEditable(false);
		anstextField.setEditable(false);
		npasswordField.setEnabled(false);
		btnCheck.setEnabled(false);
		sqtextField.setText("");
	}
	public ForgetPassword() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1379, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(anstextField.getText().equals(sqanswer)) {
					npasswordField.setEnabled(true);
					JOptionPane.showMessageDialog(null, "You can now Update the password");
				}else {
					JOptionPane.showMessageDialog(null, "Answer for Sequrity Question is Wrong\nTry Again..!");
				}
			}
		});
		btnCheck.setBounds(848, 288, 109, 23);
		contentPane.add(btnCheck);
		
		JLabel lblNewLabel = new JLabel("Forget Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(461, 94, 246, 73);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(341, 199, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sequirty Question");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(341, 245, 144, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Answer");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(341, 291, 76, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("New Password");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(341, 338, 129, 14);
		contentPane.add(lblNewLabel_1_3);
		
		mailtextField = new JTextField();
		mailtextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		mailtextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				mailvalidate();
			}
		});
		mailtextField.setBounds(480, 196, 318, 20);
		contentPane.add(mailtextField);
		mailtextField.setColumns(10);
		
		sqtextField = new JTextField();
		sqtextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		sqtextField.setColumns(10);
		sqtextField.setBounds(480, 242, 318, 20);
		contentPane.add(sqtextField);
		
		anstextField = new JTextField();
		anstextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		anstextField.setColumns(10);
		anstextField.setBounds(480, 288, 318, 20);
		contentPane.add(anstextField);
		
		npasswordField = new JPasswordField();
		npasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(!npasswordField.getText().equals("")) {
					updatebtn.setEnabled(true);
				}else {
					updatebtn.setEnabled(false);
				}
			}
		});
		npasswordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		npasswordField.setBounds(480, 335, 318, 20);
		contentPane.add(npasswordField);
		
		 searchbtn = new JButton("Search");
		searchbtn.setIcon(new ImageIcon(ForgetPassword.class.getResource("/image/search.png")));
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mail=mailtextField.getText();
				User user=user_db.search(mail);
			    if(user==null) {
			    	JOptionPane.showMessageDialog(null,"User is not available");
			    }else {
			    	String sq=user.getSecurityQuestion();
			    	sqanswer=user.getAnswer();
			    	sqtextField.setText(sq);
			    	anstextField.setEditable(true);
					npasswordField.setEnabled(false);
					btnCheck.setEnabled(true);
					mailtextField.setEnabled(false);
			    }
			}
		});
		searchbtn.setBounds(848, 195, 109, 23);
		contentPane.add(searchbtn);
		
		 updatebtn = new JButton("Update");
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_db.update(mailtextField.getText(),npasswordField.getText());
				clear();
			}
		});
		updatebtn.setIcon(new ImageIcon(ForgetPassword
				.class.getResource("/image/save.png")));
		updatebtn.setBounds(480, 390, 101, 23);
		contentPane.add(updatebtn);
		
		clearbtn = new JButton("Clear");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		clearbtn.setIcon(new ImageIcon(ForgetPassword.class.getResource("/image/clear.png")));
		clearbtn.setBounds(618, 390, 89, 23);
		contentPane.add(clearbtn);
		
		JButton exitbtn = new JButton("Exit");
		exitbtn.setIcon(new ImageIcon(ForgetPassword.class.getResource("/image/exit small.png")));
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 int a=JOptionPane.showConfirmDialog(null, "Do You want to Exit?","Select", JOptionPane.YES_NO_OPTION);
			 if(a==0) System.exit(0);
			}
		});
		exitbtn.setBounds(750, 390, 89, 23);
		contentPane.add(exitbtn);
		
		JButton signupbtn = new JButton("SignUp");
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new signin().setVisible(true);
			}
		});
		signupbtn.setBounds(480, 446, 89, 23);
		contentPane.add(signupbtn);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new login().setVisible(true);
			}
		});
		loginbtn.setBounds(750, 446, 89, 23);
		contentPane.add(loginbtn);
		btnCheck.setEnabled(false);
		searchbtn.setEnabled(false);
		sqtextField.setEditable(false);
		anstextField.setEditable(false);
		updatebtn.setEnabled(false);
		npasswordField.setEnabled(false);
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(ForgetPassword.class.getResource("/image/first page background.PNG")));
		lblNewLabel_2.setBounds(0, 0, 1363, 690);
		contentPane.add(lblNewLabel_2);
	}
}
