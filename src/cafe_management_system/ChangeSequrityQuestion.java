package cafe_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.user_db;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ChangeSequrityQuestion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfosq;
	private JTextField tfnsq;
	private JTextField tfanswer;
	private JPasswordField password;
	private String usermail;
	private JButton btnclear;
	private JButton btnupdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeSequrityQuestion frame = new ChangeSequrityQuestion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ChangeSequrityQuestion(String email) {
		this();
		usermail=email;
		btnupdate.setEnabled(false);
		tfosq.setEditable(false);
	}

	/**
	 * Create the frame.
	 */
	public ChangeSequrityQuestion() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				tfosq.setText(user_db.getsq(usermail));
			}
		});
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 135, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change Security Question");
		lblNewLabel.setIcon(new ImageIcon(ChangeSequrityQuestion.class.getResource("/image/change Security Question.png")));
		lblNewLabel.setBounds(20, 21, 201, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ChangeSequrityQuestion.class.getResource("/image/close.png")));
		btnNewButton.setBounds(660, 23, 30, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Old Security Question");
		lblNewLabel_1.setBounds(148, 102, 112, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New Security Question");
		lblNewLabel_2.setBounds(148, 162, 127, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Answer");
		lblNewLabel_3.setBounds(148, 213, 112, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(148, 263, 73, 14);
		contentPane.add(lblNewLabel_4);
		
		tfosq = new JTextField();
		tfosq.setBounds(303, 103, 272, 20);
		contentPane.add(tfosq);
		tfosq.setColumns(10);
		
		tfnsq = new JTextField();
		tfnsq.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validatee();
			}
		});
		tfnsq.setColumns(10);
		tfnsq.setBounds(303, 163, 272, 20);
		contentPane.add(tfnsq);
		
		tfanswer = new JTextField();
		tfanswer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validatee();
			}
		});
		tfanswer.setColumns(10);
		tfanswer.setBounds(303, 214, 272, 20);
		contentPane.add(tfanswer);
		
		password = new JPasswordField();
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validatee();
			}
		});
		password.setBounds(303, 260, 272, 20);
		contentPane.add(password);
		
		btnupdate = new JButton("Update");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sq=tfnsq.getText();
				String answer=tfanswer.getText();
				String pass=password.getText();
				user_db.changeSecurityQuestion(usermail, sq, answer, pass);
				setVisible(false);
				new ChangeSequrityQuestion(usermail).setVisible(true);
			}
		});
		btnupdate.setIcon(new ImageIcon(ChangeSequrityQuestion.class.getResource("/image/save.png")));
		btnupdate.setBounds(303, 311, 112, 23);
		contentPane.add(btnupdate);
		
		btnclear = new JButton("Clear");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnclear.setIcon(new ImageIcon(ChangeSequrityQuestion.class.getResource("/image/clear.png")));
		btnclear.setBounds(486, 311, 89, 23);
		contentPane.add(btnclear);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(ChangeSequrityQuestion.class.getResource("/image/small-page-background.png")));
		lblNewLabel_5.setBounds(0, 0, 700, 400);
		contentPane.add(lblNewLabel_5);
	}
	public void validatee() {
		String sq=tfnsq.getText();
		String answer=tfanswer.getText();
		String pass=password.getText();
		if(!sq.equals("")&&!answer.equals("")&&!pass.equals("")) {
			btnupdate.setEnabled(true);
		}else {
			btnupdate.setEnabled(false);
		}
	}
	public void clear() {
		tfnsq.setText("");
		tfanswer.setText("");
		password.setText("");
		btnupdate.setEnabled(false);
	}
}
