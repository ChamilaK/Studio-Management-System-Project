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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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

public class Bookings {

	private JFrame frame;
	private JTextField txtBDate;
	private JTextField txtQuantity;
	private JTextField txtTotal;
	private JTextField txtAdvance;
	private JTextField txtPrice;
	private JTextField txtCusName;
	private JTextField txtContact;
	private JTextField txtCusID;
	private JLabel lblDate;
	private JLabel lblBID;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bookings window = new Bookings();
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
	public Bookings() {
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
		panel.setBounds(495, 92, 789, 372);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(436, 46, 92, 22);
		panel.add(lblNewLabel);
		
		JLabel lblBookingType = new JLabel("Product Type :");
		lblBookingType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookingType.setBounds(58, 123, 109, 22);
		panel.add(lblBookingType);
		
		JLabel lblNewLabel_1_1 = new JLabel("Booking Date :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(58, 156, 109, 22);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Photo Size :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(58, 222, 92, 22);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Photo / Video Type :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(58, 189, 144, 22);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Price :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(490, 90, 92, 22);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Quantity :");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(490, 123, 92, 22);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Total :");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(490, 156, 92, 22);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Advance :");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(490, 222, 92, 22);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		txtBDate = new JTextField();
		txtBDate.setBounds(212, 157, 136, 20);
		panel.add(txtBDate);
		txtBDate.setColumns(10);
		
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
		txtQuantity.setBounds(569, 125, 136, 20);
		panel.add(txtQuantity);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(569, 158, 136, 46);
		panel.add(txtTotal);
		
		txtAdvance = new JTextField();
		txtAdvance.setColumns(10);
		txtAdvance.setBounds(569, 224, 136, 20);
		panel.add(txtAdvance);
		
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
		txtPrice.setBounds(569, 92, 136, 20);
		panel.add(txtPrice);
		
		JLabel lblDate = new JLabel("");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(490, 48, 136, 20);
		panel.add(lblDate);
		
		JLabel lblBID = new JLabel("");
		lblBID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBID.setBounds(212, 47, 136, 20);
		panel.add(lblBID);
		
		JComboBox cmbPType = new JComboBox();
		cmbPType.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbPType.setModel(new DefaultComboBoxModel(new String[] {"Photo", "Video"}));
		cmbPType.setBounds(212, 123, 136, 22);
		panel.add(cmbPType);
		
		JComboBox cmbPSize = new JComboBox();
		cmbPSize.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbPSize.setModel(new DefaultComboBoxModel(new String[] {"None", "3 * 2 inches", "3 * 5 inches", "4 * 6 inches", "5 * 7 inches", "8 * 8 inches", "8 * 10 inches", "11 * 14 inches", "11 * 14 inches"}));
		cmbPSize.setBounds(212, 222, 136, 22);
		panel.add(cmbPSize);
		
		JComboBox cmbPVType = new JComboBox();
		cmbPVType.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbPVType.setModel(new DefaultComboBoxModel(new String[] {"Wedding", "Pre-Wedding", "Baby Photoshoot", "Fashion Photoshoot", "Birthday Photoshoot"}));
		cmbPVType.setBounds(212, 189, 136, 22);
		panel.add(cmbPVType);
		
		JButton btnAdd = new JButton("Save");
		btnAdd.setBackground(new Color(253, 245, 230));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					
					
					String query = "INSERT INTO `bookings`(`Customer_id`, `Customer_name`, `Contact_No`, `Product_type`, `Booking_date`, `Photo/Video_type`, `Photo_size`, `Price`, `Quantity`, `Total`, `Advance_payment`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					pst = con.prepareStatement(query);
					pst.setString(1, txtCusID.getText());
					pst.setString(2, txtCusName.getText());
					pst.setString(3, txtContact.getText());
					pst.setString(4, cmbPType.getSelectedItem().toString());
					pst.setString(5, txtBDate.getText());
					pst.setString(6, cmbPVType.getSelectedItem().toString());
					pst.setString(7, cmbPSize.getSelectedItem().toString());
					pst.setString(8, txtPrice.getText());
					pst.setString(9, txtQuantity.getText());
					pst.setString(10, txtTotal.getText());
					pst.setString(11, txtAdvance.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "DATA INSERTED SUCCESSFULLY");
					
					txtCusID.setText("");
					txtCusName.setText("");
					txtContact.setText("");
					cmbPType.setSelectedItem("");
					txtBDate.setText("");
					cmbPVType.setSelectedItem("");
					cmbPSize.setSelectedItem("");					
					txtPrice.setText("");
					txtQuantity.setText("");
					txtTotal.setText("");
					txtAdvance.setText("");
										
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `bookings`";
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
		btnAdd.setBounds(176, 292, 101, 39);
		panel.add(btnAdd);
		
		JButton btnNewButton_1_1 = new JButton("Update");
		btnNewButton_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
								
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");	
					
					String query = "UPDATE `bookings` SET `Customer_name`=?,`Contact_No`=?,`Date`=?,`Product_type`=?,`Booking_date`=?,`Photo/Video_type`=?,`Photo_size`=?,`Price`=?,`Quantity`=?,`Total`=?,`Advance_payment`=?, `Booking_id`=? WHERE Customer_id=?";
					pst = con.prepareStatement(query);
					pst.setString(1, txtCusName.getText());
					pst.setString(2, txtContact.getText());
					pst.setString(3, lblDate.getText());
					pst.setString(4, cmbPType.getSelectedItem().toString());
					pst.setString(5, txtBDate.getText());
					pst.setString(6, cmbPVType.getSelectedItem().toString());
					pst.setString(7, cmbPSize.getSelectedItem().toString());
					pst.setString(8, txtPrice.getText());
					pst.setString(9, txtQuantity.getText());
					pst.setString(10, txtTotal.getText());
					pst.setString(11, txtAdvance.getText());
					pst.setInt(12,Integer.parseInt(lblBID.getText()));
					pst.setInt(13, Integer.parseInt(txtCusID.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "RECORD UPDATED SUCCESSFULLY");
					
					txtCusID.setText("");
					txtCusName.setText("");
					txtContact.setText("");
					lblDate.setText("");
					cmbPType.setSelectedItem("");
					txtBDate.setText("");
					cmbPVType.setSelectedItem("");
					cmbPSize.setSelectedItem("");					
					txtPrice.setText("");
					txtQuantity.setText("");
					txtTotal.setText("");
					txtAdvance.setText("");
					lblBID.setText("");
					txtCusID.setText("");
										
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `bookings`";
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
		btnNewButton_1_1.setBounds(312, 292, 116, 39);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Delete");
		btnNewButton_1_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
								
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "DELETE FROM `bookings` WHERE Customer_id = ?";					
					PreparedStatement pst = con.prepareStatement(query);					
					pst.setInt(1, Integer.parseInt(txtCusID.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "RECORD DELETED SUCCESSFULLY");
					
					txtCusID.setText("");
					txtCusName.setText("");
					txtContact.setText("");
					lblDate.setText("");
					cmbPType.setSelectedItem("");
					txtBDate.setText("");
					cmbPVType.setSelectedItem("");
					cmbPSize.setSelectedItem("");					
					txtPrice.setText("");
					txtQuantity.setText("");
					txtTotal.setText("");
					txtAdvance.setText("");
					lblBID.setText("");
					txtCusID.setText("");
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `bookings`";
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
		btnNewButton_1_1_1.setBounds(462, 292, 101, 39);
		panel.add(btnNewButton_1_1_1);
		
		JLabel lblBookingId = new JLabel("Booking ID :");
		lblBookingId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookingId.setBounds(110, 46, 92, 22);
		panel.add(lblBookingId);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(203, 53, 46, -9);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 232, 170));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel_1.setBounds(98, 92, 387, 372);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCustomerId = new JLabel("Customer ID :");
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomerId.setBounds(53, 77, 109, 22);
		panel_1.add(lblCustomerId);
		
		JLabel lblBookingType_1_1 = new JLabel("Customer Name :");
		lblBookingType_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookingType_1_1.setBounds(53, 110, 128, 22);
		panel_1.add(lblBookingType_1_1);
		
		JLabel lblBookingType_1_1_1 = new JLabel("Contact No. :");
		lblBookingType_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookingType_1_1_1.setBounds(53, 143, 109, 22);
		panel_1.add(lblBookingType_1_1_1);
		
		txtCusName = new JTextField();
		txtCusName.setColumns(10);
		txtCusName.setBounds(191, 113, 136, 20);
		panel_1.add(txtCusName);
		
		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBounds(191, 146, 136, 20);
		panel_1.add(txtContact);
		
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
		txtCusID.setBounds(191, 80, 136, 20);
		panel_1.add(txtCusID);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Search");
		btnNewButton_1_1_1_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT * FROM `bookings` WHERE Customer_id=?";
				pst = con.prepareStatement(query);
				int Customer_id = Integer.parseInt(txtCusID.getText());
				pst.setInt(1, Customer_id);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()==false)  {
					JOptionPane.showMessageDialog(null, "The Customer id number is not available");						
				}
				else  {
					lblBID.setText(rs.getString("Booking_id"));
					txtCusName.setText(rs.getString("Customer_name"));
					txtContact.setText(String.format(0 + "%s",rs.getString("Contact_No")));
					lblDate.setText(rs.getString("Date"));
					cmbPType.setSelectedItem(rs.getString("Product_type"));
					txtBDate.setText(rs.getString("Booking_date"));
					cmbPVType.setSelectedItem(rs.getString("Photo/Video_type"));
					cmbPSize.setSelectedItem(rs.getString("Photo_size"));
					txtPrice.setText(rs.getString("Price"));
					txtQuantity.setText(rs.getString("Quantity"));
					txtTotal.setText(rs.getString("Total"));
					txtAdvance.setText(rs.getString("Advance_payment"));
										
				}				
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT * FROM `bookings`";
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
		btnNewButton_1_1_1_1_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_1_1_1_1_1.setBounds(69, 227, 101, 36);
		panel_1.add(btnNewButton_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Clear");
		btnNewButton_1_1_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1_1_1.setBounds(207, 227, 101, 36);
		panel_1.add(btnNewButton_1_1_1_1);
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCusID.setText("");
				txtCusName.setText("");
				txtContact.setText("");
				lblDate.setText("");
				cmbPType.setSelectedItem("");
				txtBDate.setText("");
				cmbPVType.setSelectedItem("");
				cmbPSize.setSelectedItem("");					
				txtPrice.setText("");
				txtQuantity.setText("");
				txtTotal.setText("");
				txtAdvance.setText("");
				lblBID.setText("");
				txtCusID.setText("");
				
			}
		});
		btnNewButton_1_1_1_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JLabel lblNewLabel_1 = new JLabel("Booking Details");
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(552, 22, 217, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(178, 504, 991, 92);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Booking ID", "Customer ID", "Customer Name", "Contact No.", "Date", "Product Type", "Booking Date", "Photo/Video Type", "Photo Size", "Price", "Quantity", "Total", "Advance Payment"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(300);
		table.getColumnModel().getColumn(8).setPreferredWidth(180);
		table.getColumnModel().getColumn(9).setPreferredWidth(150);
		table.getColumnModel().getColumn(10).setPreferredWidth(150);
		table.getColumnModel().getColumn(11).setPreferredWidth(150);
		table.getColumnModel().getColumn(12).setPreferredWidth(150);
	}
}
