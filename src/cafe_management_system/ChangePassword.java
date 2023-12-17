package cafe_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.user_db;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String useremail;
	private JPasswordField pfold;
	private JPasswordField pfnew;
	private JPasswordField pfconfirm;
	private JButton btnupdate;
	private JButton btnclear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword(String email) {
		this();
		useremail=email;
		btnupdate.setEnabled(false);
	}
	public ChangePassword() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 158, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setIcon(new ImageIcon(ChangePassword.class.getResource("/image/change Password.png")));
		lblNewLabel.setBounds(10, 21, 129, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		btnNewButton.setIcon(new ImageIcon(ChangePassword.class.getResource("/image/close.png")));
		btnNewButton.setBounds(660, 24, 30, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Old PassWord");
		lblNewLabel_1.setBounds(166, 100, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New PassWord");
		lblNewLabel_2.setBounds(166, 160, 82, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm PassWord");
		lblNewLabel_3.setBounds(166, 229, 110, 14);
		contentPane.add(lblNewLabel_3);
		
		pfold = new JPasswordField();
		pfold.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validatee();
			}
		});
		pfold.setBounds(277, 97, 230, 20);
		contentPane.add(pfold);
		
		pfnew = new JPasswordField();
		pfnew.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validatee();
			}
		});
		pfnew.setBounds(277, 157, 230, 20);
		contentPane.add(pfnew);
		
		pfconfirm = new JPasswordField();
		pfconfirm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validatee();
			}
		});
		pfconfirm.setBounds(277, 226, 230, 20);
		contentPane.add(pfconfirm);
		
		btnupdate = new JButton("Update");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldp=pfold.getText();
				String newp=pfnew.getText();
				String cp=pfconfirm.getText();
				user_db.changepassword(useremail, oldp, newp);
				setVisible(false);
				new ChangePassword(useremail).setVisible(true);		
				}
		});
		btnupdate.setIcon(new ImageIcon(ChangePassword.class.getResource("/image/save.png")));
		btnupdate.setBounds(166, 299, 110, 23);
		contentPane.add(btnupdate);
		
		btnclear = new JButton("Clear");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnclear.setIcon(new ImageIcon(ChangePassword.class.getResource("/image/clear.png")));
		btnclear.setBounds(418, 299, 89, 23);
		contentPane.add(btnclear);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ChangePassword.class.getResource("/image/small-page-background.png")));
		lblNewLabel_4.setBounds(0, 0, 700, 389);
		contentPane.add(lblNewLabel_4);
	}
	public void validatee() {
		String oldp=pfold.getText();
		String newp=pfnew.getText();
		String cp=pfconfirm.getText();
		if(!oldp.equals("")&&!newp.equals("")&&!cp.equals("")&&newp.equals(cp)) {
			btnupdate.setEnabled(true);
		}else {
			btnupdate.setEnabled(false);
		}
	}
	public void clear() {
		pfold.setText("");
		pfnew.setText("");
		pfconfirm.setText("");
		btnupdate.setEnabled(false);
	}
}
