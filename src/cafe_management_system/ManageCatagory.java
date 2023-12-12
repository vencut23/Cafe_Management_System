package cafe_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.category;
import database.category_db;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
public class ManageCatagory extends JFrame {

	private JPanel contentPane;
	private  JTable table;
	private  JTextField textField;
	private  JButton btnSave;
	private  JButton btnDelete;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCatagory frame = new ManageCatagory();
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
	public ManageCatagory() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(350, 134, 700,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Catagory");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setIcon(new ImageIcon(ManageCatagory.class.getResource("/image/category.png")));
		lblNewLabel.setBounds(10, 12, 156, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setIcon(new ImageIcon(ManageCatagory.class.getResource("/image/close.png")));
		lblNewLabel_1.setBounds(657, 11, 61, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("View catogory");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(422, 28, 106, 24);
		contentPane.add(lblNewLabel_2);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table.getSelectedRow();
				TableModel tm = table.getModel();
				String id=tm.getValueAt(index, 0).toString();
				String name=tm.getValueAt(index, 1).toString();
				int a=JOptionPane.showConfirmDialog(null, "Do you want to delete "+name+"catagory");
				if(a==0) {
					category_db.delete_category(id);
					setVisible(false);
					new ManageCatagory().setVisible(true);
				}
				
			}
		});
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(64, 0, 64));
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			//	{"iii","yyy"}
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		table.setBounds(322, 77, 301, 256);
		contentPane.add(table);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(322, 53, 152, 24);
		 lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Catagory");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(473, 53, 150, 24);
		lblNewLabel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("*click on row to delete the catagory");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(342, 336, 260, 24);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_5 = new JLabel("Catagory");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(112, 95, 70, 24);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validatee();
				
			}
		});
		textField.setBounds(26, 130, 253, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category cat = new category();
				cat.setName(textField.getText());
				category_db.save(cat);
			//	setEnabled(false);
				setVisible(false);
				new ManageCatagory().setVisible(true);
				
			}
		});
		btnSave.setFocusable(false);
		btnSave.setBounds(26, 179, 89, 23);
		btnSave.setEnabled(false);
		contentPane.add(btnSave);
		
		 btnDelete = new JButton("Delete");
		 btnDelete.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		textField.setText("");
		 		btnSave.setEnabled(false);
		 	}
		 });
		btnDelete.setFocusable(false);
		btnDelete.setBounds(190, 179, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			//	DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				//ArrayList<category> al = category_db.getallrecords();
			//	System.out.println(al);
			//	for(category cat:al) {
			//		dtm.addRow(new Object[]{cat.getId(), cat.getName()});
			//	}
			}
			
		});
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setIcon(new ImageIcon(ManageCatagory.class.getResource("/image/full-page-background.PNG")));
		lblNewLabel_4.setBounds(20, 0, 700, 400);
		contentPane.add(lblNewLabel_4);

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		ArrayList<category> al = category_db.getallrecords();
		//System.out.println(al);
		for(category catt:al) {
			dtm.addRow(new Object[]{catt.getId(), catt.getName()});
		}
	}
	
	public void validatee() {
		String name=textField.getText();
		if(!name.equals("")) {
			btnSave.setEnabled(true);
		}else {
			btnSave.setEnabled(false);
		}
	}
	
}
