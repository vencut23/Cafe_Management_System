package cafe_management_system;
import database.user_db;
import model.User;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField mailfield;
	private JPasswordField passwordField;
	private JButton btnlogin;
	private JButton btnClear;
	private JButton btnExit;
	private JButton btnForgetPassword;
	private JButton btnSignUp;
	private JLabel lblNewLabel_1;
     private String mailformat="^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
     private String passformat="^[0-9]*$";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public void clear() {
		mailfield.setText("");
		passwordField.setText("");
		btnlogin.setEnabled(false);
	}
	public void validatefield() {
		if((mailfield.getText().matches(mailformat))&&!(passwordField.equals(""))) {
			btnlogin.setEnabled(true);
		}else {
			btnlogin.setEnabled(false);
		}
	}
	public login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1379, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblLogin.setBounds(562, 116, 186, 88);
 		contentPane.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(453, 249, 79, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(453, 303, 79, 14);
		contentPane.add(lblPassword);
		
		mailfield = new JTextField();
		mailfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validatefield();
			}
		});
		mailfield.setFont(new Font("Tahoma", Font.BOLD, 14));
		mailfield.setBounds(542, 246, 257, 20);
		contentPane.add(mailfield);
		mailfield.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validatefield();
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(542, 300, 257, 20);
		contentPane.add(passwordField);
		
		btnlogin = new JButton("Login");
		btnlogin.setIcon(new ImageIcon(login.class.getResource("/image/login.png")));
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email=mailfield.getText();
				String password=passwordField.getText();
				User user=null;
				user=user_db.login(email, password);
				if(user==null) {
					JOptionPane.showMessageDialog(null," <html><b style=\"color:red;\">the user name password is incorrect</b></html>","Message",JOptionPane.INFORMATION_MESSAGE);
					clear();
				}else {
					if(user.getStatus().equals("false")) {
						ImageIcon icon = new ImageIcon("/Cafe_management_System/src/popupicon/wait.png");
						JOptionPane.showMessageDialog(null,"<html><b>please wait for admin approval</b></html>","Message",JOptionPane.INFORMATION_MESSAGE,icon);
						clear();
					}else if(user.getStatus().equals("true")){
						setVisible(false);
						
					}
				}
			}
		});
		btnlogin.setBounds(448, 365, 89, 23);
		btnlogin.setEnabled(false);
		contentPane.add(btnlogin);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setIcon(new ImageIcon(login.class.getResource("/image/clear.png")));
		btnClear.setBounds(584, 365, 89, 23);
		contentPane.add(btnClear);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do you want to exit?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					System.exit(0);
				}
			}
		});
		btnExit.setIcon(new ImageIcon(login.class.getResource("/image/exit small.png")));
		btnExit.setBounds(710, 365, 89, 23);
		contentPane.add(btnExit);
		
		btnForgetPassword = new JButton("Forget Password");
		btnForgetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ForgetPassword().setVisible(true);
			}
		});
		btnForgetPassword.setBounds(448, 437, 143, 23);
		contentPane.add(btnForgetPassword);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new signin().setVisible(true);
			}
		});
		btnSignUp.setBounds(710, 437, 89, 23);
		contentPane.add(btnSignUp);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/image/first page background.PNG")));
		lblNewLabel_1.setBounds(0, 0, 1363, 690);
		contentPane.add(lblNewLabel_1);
	}
}
