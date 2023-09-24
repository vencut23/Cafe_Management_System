package cafe_management_system;
import model.User;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.user_db;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Signup extends JFrame {
	public String emailpattern="^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mbformat="^[0-9]*$";

	private JPanel contentPane;
	private JTextField nameTxtField;
	private JTextField mailTxtField;
	private JTextField MntxtField;
	private JTextField AddTxtField;
	private JTextField sqTxtField;
	private JTextField AnswerTxtField;
	private JPasswordField passwordField;
	private  JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
		nameTxtField.setText("");
		 mailTxtField.setText("");
		 MntxtField.setText("");
		AddTxtField.setText("");
		sqTxtField.setText("");
		AnswerTxtField.setText("");
		passwordField.setText("");
	}
	public void validate() {
		  String name=nameTxtField.getText();
	      String email=mailTxtField.getText();
	      String Address=AddTxtField.getText();
	      String passward=passwordField.getText();
	      String mobileNumber=MntxtField.getText();
	      String SecurityQuestion=sqTxtField.getText();
	      String answer=AnswerTxtField.getText();
	      if(!name.equals("")&&email.matches(emailpattern)&&!Address.equals("")&&!passward.equals("")&&mobileNumber.matches(mbformat)&&mobileNumber.length()==10&&
	     !SecurityQuestion.equals("")&&!answer.equals("")) {
	    	  btnSave.setEnabled(true);
	      }else {
	    	  btnSave.setEnabled(false);
	      }
	     
	}
	public Signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1366,768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel signuplabel = new JLabel("Sign Up");
		signuplabel.setHorizontalAlignment(SwingConstants.CENTER);
		signuplabel.setBackground(new Color(255, 0, 0));
		signuplabel.setFont(new Font("SansSerif", Font.BOLD, 38));
		signuplabel.setBounds(615, 98, 148, 63);
		contentPane.add(signuplabel);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(501, 182, 124, 14);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(501, 224, 124, 14);
		contentPane.add(lblEmail);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobileNumber.setBounds(501, 267, 124, 14);
		contentPane.add(lblMobileNumber);
		
		JLabel lblAddress = new JLabel("Address ");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(501, 315, 427, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPassword = new JLabel("PassWord");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(501, 354, 124, 14);
		contentPane.add(lblPassword);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSecurityQuestion.setBounds(501, 395, 124, 14);
		contentPane.add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer ");
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnswer.setBounds(501, 438, 124, 14);
		contentPane.add(lblAnswer);
		
		nameTxtField = new JTextField();
		nameTxtField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validate();
			}
		});
		nameTxtField.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameTxtField.setBounds(635, 179, 293, 20);
		contentPane.add(nameTxtField);
		nameTxtField.setColumns(10);
		
		mailTxtField = new JTextField();
		mailTxtField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validate();
			}
		});
		mailTxtField.setFont(new Font("Tahoma", Font.BOLD, 14));
		mailTxtField.setColumns(10);
		mailTxtField.setBounds(635, 221, 293, 20);
		contentPane.add(mailTxtField);
		
		MntxtField = new JTextField();
		MntxtField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validate();
			}
		});
		MntxtField.setFont(new Font("Tahoma", Font.BOLD, 14));
		MntxtField.setColumns(10);
		MntxtField.setBounds(635, 264, 293, 20);
		contentPane.add(MntxtField);
		
		AddTxtField = new JTextField();
		AddTxtField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validate();
			}
		});
		AddTxtField.setFont(new Font("Tahoma", Font.BOLD, 14));
		AddTxtField.setColumns(10);
		AddTxtField.setBounds(635, 312, 293, 20);
		contentPane.add(AddTxtField);
		
		sqTxtField = new JTextField();
		sqTxtField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validate();
			}
		});
		sqTxtField.setFont(new Font("Tahoma", Font.BOLD, 14));
		sqTxtField.setColumns(10);
		sqTxtField.setBounds(635, 392, 293, 20);
		contentPane.add(sqTxtField);
		
		AnswerTxtField = new JTextField();
		AnswerTxtField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validate();
			}
		});
		AnswerTxtField.setFont(new Font("Tahoma", Font.BOLD, 14));
		AnswerTxtField.setColumns(10);
		AnswerTxtField.setBounds(635, 435, 293, 20);
		contentPane.add(AnswerTxtField);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validate();
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(635, 351, 293, 20);
		contentPane.add(passwordField);
		
		 btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user=new User();
				user.setName(nameTxtField.getText());
				user.setEmail(mailTxtField.getText());
				user.setAddress(AddTxtField.getText());
				user.setAnswer(AnswerTxtField.getText());
				user.setSecurityQuestion(sqTxtField.getText());
				user.setMobileNumber(MntxtField.getText());
				user.setPassward(passwordField.getText());
				user_db.saveondb(user);
				clear();
			}
		});
		btnSave.setIcon(new ImageIcon(Signup.class.getResource("/image/save.png")));
		btnSave.setBounds(501, 510, 89, 23);
		btnSave.setEnabled(false);
		contentPane.add(btnSave);
		
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setIcon(new ImageIcon(Signup.class.getResource("/image/clear.png")));
		btnClear.setBounds(674, 510, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "do you want to exit?","select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					System.exit(0);
				}
			}
		});
		btnExit.setIcon(new ImageIcon(Signup.class.getResource("/image/exit small.png")));
		btnExit.setBounds(839, 510, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnForgetPassword = new JButton("FORGET PASSWORD?");
		btnForgetPassword.setBounds(501, 579, 170, 23);
		contentPane.add(btnForgetPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setIcon(new ImageIcon(Signup.class.getResource("/image/login.png")));
		btnLogin.setBounds(822, 579, 106, 23);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Signup.class.getResource("/image/first page background.PNG")));
		lblNewLabel.setBounds(0, 0, 1379, 729);
		contentPane.add(lblNewLabel);
	}
}
