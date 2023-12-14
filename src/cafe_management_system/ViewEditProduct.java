package cafe_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ViewEditProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textPrice;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEditProduct frame = new ViewEditProduct();
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
	public ViewEditProduct() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366,766);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Edit Delete Product");
		lblNewLabel.setIcon(new ImageIcon(ViewEditProduct.class.getResource("/image/view edit delete product.png")));
		lblNewLabel.setBounds(26, 22, 163, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ViewEditProduct.class.getResource("/image/close.png")));
		btnNewButton.setBounds(1315, 11, 30, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(143, 163, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("00");
		lblNewLabel_2.setBounds(238, 163, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setBounds(143, 215, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("category");
		lblNewLabel_4.setBounds(143, 262, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Price");
		lblNewLabel_5.setBounds(143, 305, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textName = new JTextField();
		textName.setBounds(238, 212, 247, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(238, 258, 247, 22);
		contentPane.add(comboBox);
		
		textPrice = new JTextField();
		textPrice.setBounds(238, 302, 247, 20);
		contentPane.add(textPrice);
		textPrice.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon(ViewEditProduct.class.getResource("/image/save.png")));
		btnUpdate.setBounds(143, 358, 102, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(ViewEditProduct.class.getResource("/image/delete.png")));
		btnDelete.setBounds(276, 358, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setIcon(new ImageIcon(ViewEditProduct.class.getResource("/image/clear.png")));
		btnClear.setBounds(396, 358, 89, 23);
		contentPane.add(btnClear);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(616, 163, 664, 406);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				//{"iii","yyy","iii","iii"}
				},
				new String[] {
					"New column", "New column","New column", "New column"
				}
			));

		contentPane.add(table);
		
		JLabel lblNewLabel_6 = new JLabel("ID");
		lblNewLabel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6.setBounds(616, 147, 163, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Name");
		lblNewLabel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7.setBounds(781, 147, 163, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Category");
		lblNewLabel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8.setBounds(947, 147, 163, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Price");
		lblNewLabel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9.setBounds(1113, 147, 167, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon(ViewEditProduct.class.getResource("/image/full-page-background.PNG")));
		lblNewLabel_10.setBounds(0, 0, 1366, 755);
		contentPane.add(lblNewLabel_10);
	}
}
