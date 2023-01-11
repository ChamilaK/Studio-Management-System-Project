package com.Action;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JScrollPane;

public class Orders {

	private JFrame frame;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	private JTextField txtTotal;
	protected JComboBox cmbProName;
	private JTextField txtCusName;
	private JTextField txtContact;
	private JTextField txtCusID;
	private JLabel lblOrderDate;
	private JLabel lblOrderID;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orders window = new Orders();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Orders() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(0, 0, 1350, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Product Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel.setBounds(588, 177, 674, 310);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Order Date :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(375, 33, 90, 25);
		panel.add(lblNewLabel);
		
		JLabel lblProductName = new JLabel("Product Name :");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProductName.setBounds(153, 79, 111, 25);
		panel.add(lblProductName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Size :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(153, 115, 90, 25);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Price :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(153, 151, 90, 25);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Quantity :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(153, 187, 90, 25);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Total :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(153, 223, 90, 25);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		txtQuantity = new JTextField();
		txtQuantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				double price = Double.parseDouble(txtPrice.getText());
				int quantity = Integer.parseInt(txtQuantity.getText());
				double totalPrice = price * quantity;
				
			    String total = String.valueOf(totalPrice);
			    txtTotal.setText(total);
				
			}
		});
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(274, 193, 148, 20);
		panel.add(txtQuantity);
		
		txtPrice = new JTextField();
		txtPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				double price = Double.parseDouble(txtPrice.getText());
				int quantity = Integer.parseInt(txtQuantity.getText());
				double totalPrice = price * quantity;
				
			    String total = String.valueOf(totalPrice);
			    txtTotal.setText(total);
			    
			}
		});
		txtPrice.setColumns(10);
		txtPrice.setBounds(274, 155, 148, 20);
		panel.add(txtPrice);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(274, 229, 148, 36);
		panel.add(txtTotal);
		

		JLabel lblOrderDate = new JLabel("");
		lblOrderDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrderDate.setBounds(467, 33, 148, 25);
		panel.add(lblOrderDate);
		
		JLabel lblOrderID = new JLabel("");
		lblOrderID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrderID.setBounds(183, 33, 123, 25);
		panel.add(lblOrderID);
		
		JComboBox cmbSize = new JComboBox();
		cmbSize.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbSize.setModel(new DefaultComboBoxModel(new String[] {"3 * 2 inches", "3 * 5 inches", "4 * 6 inches", "5 * 7 inches ", "8 * 8 inches", "8 * 10 inches", "11 * 14 inches", "11 * 16 inches"}));
		cmbSize.setBounds(274, 118, 148, 22);
		panel.add(cmbSize);
		
		JComboBox cmbProName = new JComboBox();
		cmbProName.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbProName.setModel(new DefaultComboBoxModel(new String[] {"Album Print", "Identity Photo", "Passport Photo", "Mug Printable", "Photo Frame"}));
		cmbProName.setBounds(274, 82, 148, 22);
		panel.add(cmbProName);
		
		JLabel lblOrderId = new JLabel("Order ID :");
		lblOrderId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOrderId.setBounds(100, 33, 90, 25);
		panel.add(lblOrderId);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(253, 245, 230));
		btnAdd.setBounds(507, 85, 98, 36);
		panel.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					
					
					String query = "INSERT INTO `orders`(`Customer_id`, `Customer_name`, `Contact_No`, `Product_name`, `Size`, `Price`, `Quantity`, `Total`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
					pst = con.prepareStatement(query);
					pst.setString(1, txtCusID.getText());
					pst.setString(2, txtCusName.getText());
					pst.setString(3, txtContact.getText());
					pst.setString(4, cmbProName.getSelectedItem().toString());
					pst.setString(5, cmbSize.getSelectedItem().toString());
					pst.setString(6, txtPrice.getText());
					pst.setString(7, txtQuantity.getText());
					pst.setString(8, txtTotal.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "DATA INSERTED SUCCESSFULLY");
					
					txtCusID.setText("");
					txtCusName.setText("");
					txtContact.setText("");
					cmbProName.setSelectedItem("");
					cmbSize.setSelectedItem("");					
					txtPrice.setText("");
					txtQuantity.setText("");
					txtTotal.setText("");
										
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `orders`";
					pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()==false)  {
						JOptionPane.showMessageDialog(null, e);						
					}
					else  {

						table.setModel(DbUtils.resultSetToTableModel(rs));
					}				
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnAdd.setForeground(new Color(0, 0, 205));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JButton btnNewButton_1_1 = new JButton("Update");
		btnNewButton_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1.setBounds(503, 157, 111, 36);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");	
					
					String query = "UPDATE `orders` SET `Customer_name`=?,`Contact_No`=?,`Order_date`=?,`Product_name`=?,`Size`=?,`Price`=?,`Quantity`=?,`Total`=?, `Order_id`=? WHERE Customer_id=?";
					pst = con.prepareStatement(query);
					pst.setString(1, txtCusName.getText());
					pst.setString(2, txtContact.getText());
					pst.setString(3, lblOrderDate.getText());
					pst.setString(4, cmbProName.getSelectedItem().toString());
					pst.setString(5, cmbSize.getSelectedItem().toString());
					pst.setString(6, txtPrice.getText());
					pst.setString(7, txtQuantity.getText());
					pst.setString(8, txtTotal.getText());
					pst.setInt(9,Integer.parseInt(lblOrderID.getText()));
					pst.setInt(10, Integer.parseInt(txtCusID.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "RECORD UPDATED SUCCESSFULLY");
					
					txtCusID.setText("");
					txtCusName.setText("");
					txtContact.setText("");
					lblOrderDate.setText("");
					cmbProName.setSelectedItem("");
					cmbSize.setSelectedItem("");					
					txtPrice.setText("");
					txtQuantity.setText("");
					txtTotal.setText("");
					lblOrderID.setText("");
					txtCusID.setText("");
										
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `orders`";
					pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()==false)  {
						JOptionPane.showMessageDialog(null, e);						
					}
					else  {

						table.setModel(DbUtils.resultSetToTableModel(rs));
					}				
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JButton btnNewButton_1_1_1 = new JButton("Delete");
		btnNewButton_1_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1_1.setBounds(507, 229, 98, 36);
		panel.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "DELETE FROM `orders` WHERE Customer_id = ?";					
					PreparedStatement pst = con.prepareStatement(query);					
					pst.setInt(1, Integer.parseInt(txtCusID.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "RECORD DELETED SUCCESSFULLY");
					
					txtCusID.setText("");
					txtCusName.setText("");
					txtContact.setText("");
					lblOrderDate.setText("");
					cmbProName.setSelectedItem("");
					cmbSize.setSelectedItem("");					
					txtPrice.setText("");
					txtQuantity.setText("");
					txtTotal.setText("");
					lblOrderID.setText("");
					txtCusID.setText("");
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `orders`";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()==false)  {
						JOptionPane.showMessageDialog(null, e);						
					}
					else  {

						table.setModel(DbUtils.resultSetToTableModel(rs));
					}				
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnNewButton_1_1_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 232, 170));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel_1.setBounds(119, 177, 415, 310);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Customer ID :");
		lblNewLabel_1_1_1_1_1_1.setBounds(70, 60, 104, 25);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Customer Name :");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(70, 96, 130, 25);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Contact No. : ");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(70, 132, 96, 25);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		txtCusName = new JTextField();
		txtCusName.setColumns(10);
		txtCusName.setBounds(206, 100, 161, 20);
		panel_1.add(txtCusName);
		
		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBounds(206, 136, 161, 20);
		panel_1.add(txtContact);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Clear");
		btnNewButton_1_1_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1_1_1.setBounds(218, 210, 98, 36);
		panel_1.add(btnNewButton_1_1_1_1);
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCusID.setText("");
				txtCusName.setText("");
				txtContact.setText("");
				lblOrderDate.setText("");
				cmbProName.setSelectedItem("");
				cmbSize.setSelectedItem("");					
				txtPrice.setText("");
				txtQuantity.setText("");
				txtTotal.setText("");
				lblOrderID.setText("");
				txtCusID.setText("");
				
			}
		});
		btnNewButton_1_1_1_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Search");
		btnNewButton_1_1_1_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT * FROM `orders` WHERE Customer_id=?";
				pst = con.prepareStatement(query);
				int Customer_id = Integer.parseInt(txtCusID.getText());
				pst.setInt(1, Customer_id);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()==false)  {
					JOptionPane.showMessageDialog(null, "The Customer id number is not available");						
				}
				else  {
					lblOrderID.setText(rs.getString("Order_id"));
					txtCusName.setText(rs.getString("Customer_name"));
					txtContact.setText(String.format(0 + "%s",rs.getString("Contact_No")));
					lblOrderDate.setText(rs.getString("Order_date"));
					cmbProName.setSelectedItem(rs.getString("Product_name"));
					cmbSize.setSelectedItem(rs.getString("Size"));
					txtPrice.setText(rs.getString("Price"));
					txtQuantity.setText(rs.getString("Quantity"));
					txtTotal.setText(rs.getString("Total"));
										
				}				
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT * FROM `orders`";
				pst = con.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()==false)  {
					JOptionPane.showMessageDialog(null, "The equipment id number is not available");						
				}
				else  {

					table.setModel(DbUtils.resultSetToTableModel(rs));
				}				
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
				
							}
		});
		btnNewButton_1_1_1_1_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_1_1_1_1_1.setBounds(70, 210, 98, 36);
		panel_1.add(btnNewButton_1_1_1_1_1);
		
		txtCusID = new JTextField();
		txtCusID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT `Customer_name`,  `Contact_No` FROM `customer` WHERE Customer_id=?";
				pst = con.prepareStatement(query);
				int Customer_id = Integer.parseInt(txtCusID.getText());
				pst.setInt(1, Customer_id);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()==false)  {
					JOptionPane.showMessageDialog(null, "The customer id number is not available");						
				}
				else  {
					txtCusName.setText(rs.getString("Customer_name"));
					txtContact.setText(String.format(0 + "%s",rs.getString("Contact_No")));
														
				}				
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
			}
		});
		txtCusID.setColumns(10);
		txtCusID.setBounds(206, 65, 161, 20);
		panel_1.add(txtCusID);
		
		JLabel lblNewLabel_1 = new JLabel("Order Details");
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(557, 63, 192, 46);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(294, 530, 761, 92);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order ID", "Customer ID", "Customer Name", "Contact No", "Order Date", "Product Name", "Size", "Price", "Quantity", "Total"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(300);
		table.getColumnModel().getColumn(6).setPreferredWidth(180);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(8).setPreferredWidth(130);
		table.getColumnModel().getColumn(9).setPreferredWidth(150);
	}
}
