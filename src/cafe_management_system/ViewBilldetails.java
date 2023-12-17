package cafe_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Common.OpenPDF;
import database.Bill_db;
import model.Bill;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewBilldetails extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
    private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBilldetails frame = new ViewBilldetails();
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
	public ViewBilldetails() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			tableDetails();
			}
		});
		textField.setBounds(424, 110, 175, 20);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date(22,33,44);
		String todayDate= sdf.format(date);
		textField.setText(todayDate);
		contentPane.add(textField);
		textField.setColumns(10);textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				tableDetails();
			}
		});
		textField.setBounds(424, 110, 175, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ViewBill And Order Placed Details");
		lblNewLabel.setIcon(new ImageIcon(ViewBilldetails.class.getResource("/image/place order.png")));
		lblNewLabel.setBounds(26, 23, 202, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ViewBilldetails.class.getResource("/image/close.png")));
		btnNewButton.setBounds(1326, 30, 30, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Filter By Date ");
		lblNewLabel_1.setBounds(293, 113, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Change Order By ID");
		lblNewLabel_2.setBounds(695, 113, 125, 14);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				{"iii","iii","iii","iii","iii","iii","iii"}
				},
				new String[] {
					"New column","New column","New column","New column","New column","New column","New column"
				}
			));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TableModel tm =table.getModel();
				int index= table.getSelectedRow();
				String id=tm.getValueAt(index,0).toString();
				OpenPDF.openByid(id);
			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(26, 173, 1330, 527);
		
		contentPane.add(table);
		comboBox = new JComboBox();
		comboBox.setBounds(860, 109, 161, 22);
		comboBox.addItem("INC");
		comboBox.addItem("DESC");
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tableDetails();
			}
		});
		JLabel lblNewLabel_3 = new JLabel("*Click On Row To View Bill");
		lblNewLabel_3.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 16));
		lblNewLabel_3.setBounds(445, 725, 375, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setBounds(26, 155, 188, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("  Customer Name ");
		lblNewLabel_4_1.setBounds(215, 155, 188, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Mobile Number");
		lblNewLabel_4_2.setBounds(402, 155, 188, 14);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Email");
		lblNewLabel_4_3.setBounds(596, 155, 188, 14);
		contentPane.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("date");
		lblNewLabel_4_4.setBounds(786, 155, 188, 14);
		contentPane.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("Total");
		lblNewLabel_4_5.setBounds(979, 155, 188, 14);
		contentPane.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_4_6 = new JLabel("CreatedBy");
		lblNewLabel_4_6.setBounds(1168, 155, 188, 14);
		contentPane.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(ViewBilldetails.class.getResource("/image/full-page-background.PNG")));
		lblNewLabel_5.setBounds(0, 0, 1366, 768);
		contentPane.add(lblNewLabel_5);
		
	
	}
	
public void tableDetails() {
		String date = textField.getText();
		
		String incdec= comboBox.getSelectedItem().toString();
		if(incdec.equals("INC")) {
			ArrayList<Bill> al = Bill_db.getByDateInc(date);
			DefaultTableModel dtm =(DefaultTableModel) table.getModel();
			dtm.setRowCount(0);
			for(Bill bill:al) {
				dtm.addRow(new Object[] {bill.getId(),bill.getName(),bill.getMobileNumber(),bill.getEmail(),bill.getDate(),bill.getTotal(),bill.getCreatedby()});
			}
		}else {
			ArrayList<Bill> al = Bill_db.getByDateDesc(date);
			DefaultTableModel dtm =(DefaultTableModel) table.getModel();
			dtm.setRowCount(0);
			for(Bill bill:al) {
				dtm.addRow(new Object[] {bill.getId(),bill.getName(),bill.getMobileNumber(),bill.getEmail(),bill.getDate(),bill.getTotal(),bill.getCreatedby()});
			}

		}
	}
}
