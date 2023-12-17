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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Common.OpenPDF;
import database.Bill_db;
import database.Product_db;
import database.category_db;
import model.Bill;
import model.Product;
import model.category;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class PlaceOrder extends JFrame {
    public int billid=1;
    public int price=0;
    public int total=0;
    public int grandtotal=0;
    private String mailformat="^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    private String passformat="^[0-9]*$";
	private JPanel contentPane;
	private JTextField tfname;
	private JTextField tfmobilenumber;
	private JTextField tfemail;
	private JTextField tfsearch;
	private JTable tablename;
	private JTextField tfname2;
	private JTextField tfprice;
	private JTextField tftotal;
	private JTable tablebill;
    private String usermail;
    private JComboBox comboBox;
    private JSpinner spinner;
    private JButton btnClear;
    private JButton btnaddtocart;
    private JButton btngeneretebill;
    private JLabel lbltotal;
    private JLabel lblid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlaceOrder frame = new PlaceOrder();
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
	public PlaceOrder(String email) {
		this();
		btngeneretebill.setEnabled(false);
		//btnClear.setEnabled(false);
		btnaddtocart.setEnabled(false);
		tfprice.setEditable(false);
		tftotal.setEditable(false);
		tfname2.setEditable(false);
		JFormattedTextField tf=((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
		tf.setEditable(false);
		usermail=email;
	}
	public PlaceOrder() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			
				loadcategory();
				loadbycategory();
				billid=Integer.parseInt(Bill_db.getId())+billid;
				lblid.setText(billid+"");
				btnClear.setEnabled(true);
			}
		});
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btngeneretebill = new JButton("Generate and View Bill");
		btngeneretebill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tfname.getText();
				String mail=tfemail.getText();
				String number=tfmobilenumber.getText();
				String total=lbltotal.getText();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				Date date=new Date(22,33,44);
				String todaydate=format.format(date);
				String creaatedby= usermail;
				Bill bill=new Bill();
				bill.setName(name);
				bill.setEmail(mail);
				bill.setCreatedby(creaatedby);
				bill.setDate(todaydate);
				bill.setMobileNumber(number);
				bill.setTotal(total);
				bill.setId(billid);
				Bill_db.save(bill);
				
				String path="C:\\";;
				com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
				try {
					PdfWriter.getInstance(doc, new FileOutputStream(path+""+billid+".pdf"));
					doc.open();
					Paragraph star=new Paragraph("**********************************************************************************************");
					doc.add(star);
					Paragraph cafe=new Paragraph("                                          Cafe Project\n");
					doc.add(cafe);
					doc.add(star);
					PdfPTable table=new PdfPTable(4);
					table.addCell("Name");
					table.addCell("Price");
					table.addCell("Quantity");
					table.addCell("Total");
					for(int a=0;a<tablebill.getRowCount();a++) {
						String n=tablebill.getValueAt(a, 0).toString();
						String p=tablebill.getValueAt(a, 1).toString();
						String q=tablebill.getValueAt(a, 2).toString();
						String v=tablebill.getValueAt(a, 3).toString();
						table.addCell(n);
						table.addCell(p);
						table.addCell(q);
						table.addCell(v);
					}
					doc.add(table);
					doc.add(star);
					Paragraph totalpara=new Paragraph("Grand Total"+grandtotal+"");
					doc.add(star);
					doc.add(totalpara);
					doc.add(star);
					Paragraph thanks = new Paragraph("Thanks for Coming...!Visit Again..!");
					doc.add(thanks);
					doc.close();
					OpenPDF.openByid(String.valueOf(billid));
					
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
				setVisible(false);
				new PlaceOrder(usermail).setVisible(true);
			}
		});
		btngeneretebill.setIcon(new ImageIcon(PlaceOrder.class.getResource("/image/generate bill & print.png")));
		btngeneretebill.setBounds(1132, 721, 178, 23);
		contentPane.add(btngeneretebill);
		
		lbltotal = new JLabel("0000");
		lbltotal.setBounds(685, 725, 78, 14);
		contentPane.add(lbltotal);
		
		JLabel lblNewLabel_19 = new JLabel("Grand Total");
		lblNewLabel_19.setBounds(601, 725, 72, 14);
		contentPane.add(lblNewLabel_19);
		
		JLabel lblNewLabel = new JLabel("Place Order");
		lblNewLabel.setIcon(new ImageIcon(PlaceOrder.class.getResource("/image/place order.png")));
		lblNewLabel.setBounds(10, 21, 186, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home(usermail).setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(PlaceOrder.class.getResource("/image/close.png")));
		btnNewButton.setBounds(1327, 21, 29, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Bill ID:");
		lblNewLabel_1.setBounds(49, 96, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblid = new JLabel("00");
		lblid.setBounds(121, 96, 46, 14);
		contentPane.add(lblid);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Details:");
		lblNewLabel_3.setBounds(49, 127, 99, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setBounds(49, 166, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		tfname = new JTextField();
		tfname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				vaildatee();
			}
		});
		tfname.setBounds(49, 195, 186, 20);
		contentPane.add(tfname);
		tfname.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile Number");
		lblNewLabel_5.setBounds(49, 247, 99, 14);
		contentPane.add(lblNewLabel_5);
		
		tfmobilenumber = new JTextField();
		tfmobilenumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				vaildatee();
			}
		});
		tfmobilenumber.setBounds(49, 282, 186, 20);
		contentPane.add(tfmobilenumber);
		tfmobilenumber.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setBounds(49, 334, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		tfemail = new JTextField();
		tfemail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				vaildatee();
			}
		});
		tfemail.setBounds(49, 377, 186, 20);
		contentPane.add(tfemail);
		tfemail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Category");
		lblNewLabel_7.setBounds(314, 96, 72, 14);
		contentPane.add(lblNewLabel_7);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				loadbycategory();
			}
		});
		comboBox.setBounds(314, 138, 194, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_8 = new JLabel("Search");
		lblNewLabel_8.setBounds(314, 198, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		tfsearch = new JTextField();
		tfsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadbyName();
			}
		});
		tfsearch.setBounds(314, 244, 194, 20);
		contentPane.add(tfsearch);
		tfsearch.setColumns(10);
		
		tablename = new JTable();
		tablename.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				showbyname();
			}
		});
		tablename.setForeground(new Color(0, 0, 0));
		tablename.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablename.setBounds(314, 326, 194, 372);
		tablename.setModel(new DefaultTableModel(
				new Object[][] {
				{"iii"}
				},
				new String[] {
					"New column"
				}
			));
		contentPane.add(tablename);
		
		JLabel lblNewLabel_9 = new JLabel("Name");
		lblNewLabel_9.setBounds(601, 96, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		tfname2 = new JTextField();
		tfname2.setBounds(685, 93, 204, 20);
		contentPane.add(tfname2);
		tfname2.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Price");
		lblNewLabel_10.setBounds(965, 96, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		tfprice = new JTextField();
		tfprice.setText("");
		tfprice.setBounds(1040, 93, 204, 20);
		contentPane.add(tfprice);
		tfprice.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Quantity");
		lblNewLabel_11.setBounds(601, 166, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int quantity=(int) spinner.getValue();
				if(quantity<=0) {
					quantity=1;
					spinner.setValue(1);
				}
				total=quantity*price;
				tftotal.setText(total+"");
			}
		});
		spinner.setBounds(685, 163, 204, 20);
		contentPane.add(spinner);
		
		JLabel lblNewLabel_12 = new JLabel("Total");
		lblNewLabel_12.setBounds(965, 166, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		tftotal = new JTextField();
		tftotal.setText("");
		tftotal.setBounds(1040, 163, 204, 20);
		contentPane.add(tftotal);
		tftotal.setColumns(10);
		
		btnClear = new JButton("Clear");
		btnClear.setIcon(new ImageIcon(PlaceOrder.class.getResource("/image/clear.png")));
		btnClear.setBounds(601, 243, 89, 23);
		contentPane.add(btnClear);
		
		btnaddtocart = new JButton("Add To Cart");
		btnaddtocart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tfname2.getText();
				String price=tfprice.getText();
				String quantity= String.valueOf(spinner.getValue());
				String total=tftotal.getText();
				DefaultTableModel dtm =(DefaultTableModel) tablebill.getModel();
				dtm.addRow(new Object[] {name,price,quantity,total});
				grandtotal=grandtotal+Integer.parseInt(total);
				lbltotal.setText(grandtotal+"");
				clear();
				vaildatee();
			}
		});
		btnaddtocart.setIcon(new ImageIcon(PlaceOrder.class.getResource("/image/add to cart.png")));
		btnaddtocart.setBounds(1113, 243, 131, 23);
		contentPane.add(btnaddtocart);
		
		tablebill = new JTable();
		tablebill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=tablebill.getSelectedRow();
				TableModel tm = tablebill.getModel();
				String total = tm.getValueAt(index, 3).toString();
				int a=JOptionPane.showConfirmDialog(null, "Do you want to delete item","select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
			    grandtotal=grandtotal-Integer.parseInt(total);
			    lbltotal.setText(grandtotal+"");
			    
				((DefaultTableModel)tablebill.getModel()).removeRow(index);
				}
			}
		});
		tablebill.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablebill.setBounds(601, 326, 709, 372);
		tablebill.setModel(new DefaultTableModel(
				new Object[][] {
				{"iii","yyy","jjggtf","hvhggf"}
				},
				new String[] {
					"New column", "New column","New column", "New column"
				}
			));
		contentPane.add(tablebill);
		
		JLabel lblNewLabel_13 = new JLabel("Name");
		lblNewLabel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_13.setBounds(314, 308, 194, 14);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Name");
		lblNewLabel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_14.setBounds(601, 308, 174, 14);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Price");
		lblNewLabel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_15.setBounds(777, 308, 174, 14);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Quantity");
		lblNewLabel_16.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_16.setBounds(954, 308, 174, 14);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Total");
		lblNewLabel_17.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_17.setBounds(1132, 308, 174, 14);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(PlaceOrder.class.getResource("/image/full-page-background.PNG")));
		lblNewLabel_18.setBounds(0, -17, 1366, 785);
		contentPane.add(lblNewLabel_18);
	}
	public void loadbycategory() {
		DefaultTableModel dtm = (DefaultTableModel) tablename.getModel();
		dtm.setRowCount(0);
		ArrayList<Product> al = Product_db.getBycategory(comboBox.getSelectedItem().toString());
		System.out.println(comboBox.getSelectedItem().toString()+al);
		for(Product p:al) {
			dtm.addRow(new Object[]{p.getName()});
		}
	}
	public void loadbyName() {
		DefaultTableModel dtm = (DefaultTableModel) tablename.getModel();
		dtm.setRowCount(0);
		ArrayList<Product> al = Product_db.getByname(comboBox.getSelectedItem().toString(),tfsearch.getText());
		
		for(Product p:al) {
			dtm.addRow(new Object[]{p.getName()});
		}
	}
	public void showbyname() {
		TableModel tm = tablename.getModel();
	    Product p= Product_db.getproductdetail((String)tm.getValueAt(tablename.getSelectedRow(),0));
	    tfname2.setText(p.getName());
	    tfprice.setText(p.getPrice());
	    price=Integer.parseInt(p.getPrice());
	    total=Integer.parseInt(p.getPrice());
	    tftotal.setText(String.valueOf(total));
	    spinner.setValue(1);
	    btnaddtocart.setEnabled(true);
	}
	public void loadcategory() {
		ArrayList<category> al =category_db.getallrecords();
		for(category cat:al) {
			comboBox.addItem(cat.getName());
		}
	}
	public void clear() {
		btnaddtocart.setEnabled(false);
		tfname2.setText("");
		spinner.setValue(1);
		tfprice.setText("");
		tftotal.setText("");
	}
	public void vaildatee() {
		String name=tfname.getText();
		String email=tfemail.getText();
		String number=tfmobilenumber.getText();
		if(!name.equals("")&&!email.equals("")&&!number.equals("")&&email.matches(mailformat)&&number.matches(passformat)&&grandtotal>0) {
			btngeneretebill.setEnabled(true);
		}else {
			btngeneretebill.setEnabled(false);
		}
	}
}
