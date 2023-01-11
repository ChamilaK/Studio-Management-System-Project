package com.Action;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
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
import javax.swing.border.EtchedBorder;

public class Customer {

	private JFrame frame;
	private JTextField txtCusName;
	private JTextField txtContact;
	private JTextField txtCusID;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
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
	public Customer() {
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
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel.setBounds(293, 250, 669, 223);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(42, 37, 126, 23);
		panel.add(lblNewLabel);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(42, 71, 126, 23);
		panel.add(lblGender);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contact No. :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(42, 105, 126, 23);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(42, 139, 126, 23);
		panel.add(lblNewLabel_1_1_1);
		
		txtCusName = new JTextField();
		txtCusName.setBounds(171, 40, 195, 20);
		panel.add(txtCusName);
		txtCusName.setColumns(10);
		
		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBounds(171, 108, 195, 20);
		panel.add(txtContact);
		
		JComboBox cmbGender = new JComboBox();
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cmbGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbGender.setBounds(171, 73, 195, 22);
		panel.add(cmbGender);
		
		JTextArea textAreaAddress = new JTextArea();
		textAreaAddress.setBounds(171, 140, 195, 60);
		panel.add(textAreaAddress);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setForeground(new Color(0, 0, 205));
		btnNewButton.setBackground(new Color(253, 245, 230));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;				
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
										
					String query = "INSERT INTO `customer`(`Customer_name`, `Gender`, `Contact_No`, `Address`) VALUES (?, ?, ?, ?)";
					pst = con.prepareStatement(query);
					pst.setString(1, txtCusName.getText());
					pst.setString(2, cmbGender.getSelectedItem().toString());
					pst.setString(3, txtContact.getText());
					pst.setString(4, textAreaAddress.getText());								
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "DATA INSERTED SUCCESSFULLY");
					
					txtCusName.setText("");
					cmbGender.setSelectedItem("");
					txtContact.setText("");
					textAreaAddress.setText("");
					
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `customer`";
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton.setBounds(430, 39, 109, 35);
		panel.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(0, 0, 205));
		btnUpdate.setBackground(new Color(253, 245, 230));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");	
					
					String query = "UPDATE `customer` SET `Customer_name`=?,`Gender`=?,`Contact_No`=?,`Address`=? WHERE Customer_id=?";
					pst = con.prepareStatement(query);
					pst.setString(1, txtCusName.getText());
					pst.setString(2, cmbGender.getSelectedItem().toString());
					pst.setString(3, txtContact.getText());
					pst.setString(4, textAreaAddress.getText());
					pst.setInt(5, Integer.parseInt(txtCusID.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "RECORD UPDATED SUCCESSFULLY");
					
					txtCusName.setText("");
					cmbGender.setSelectedItem("");
					txtContact.setText("");
					textAreaAddress.setText("");
					txtCusID.setText("");
										
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `customer`";
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
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnUpdate.setBounds(430, 105, 109, 35);
		panel.add(btnUpdate);
		
		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "DELETE FROM `customer` WHERE Customer_id = ?";					
					PreparedStatement pst = con.prepareStatement(query);					
					pst.setInt(1, Integer.parseInt(txtCusID.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "RECORD DELETED SUCCESSFULLY");
					
					txtCusName.setText("");
					cmbGender.setSelectedItem("");
					txtContact.setText("");
					textAreaAddress.setText("");
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `customer`";
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
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_1_1.setBounds(430, 165, 109, 35);
		panel.add(btnNewButton_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 232, 170));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel_1.setBounds(293, 154, 669, 71);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Customer ID :");
		lblNewLabel_1_1_1_1.setBounds(35, 26, 126, 23);
		panel_1.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtCusID = new JTextField();
		txtCusID.setBounds(141, 29, 195, 20);
		panel_1.add(txtCusID);
		txtCusID.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(new Color(0, 0, 205));
		btnSearch.setBackground(new Color(253, 245, 230));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT * FROM `customer` WHERE Customer_id=?";
				pst = con.prepareStatement(query);
				int Customer_id = Integer.parseInt(txtCusID.getText());
				pst.setInt(1, Customer_id);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()==false)  {
					JOptionPane.showMessageDialog(null, "The customer id number is not available");						
				}
				else  {
					txtCusName.setText(rs.getString("Customer_name"));
					cmbGender.setSelectedItem(rs.getString("Gender"));
					txtContact.setText(String.format(0 + "%s",rs.getString("Contact_No")));
					textAreaAddress.setText(rs.getString("Address"));
										
				}				
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT * FROM `customer`";
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
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnSearch.setBounds(363, 18, 109, 35);
		panel_1.add(btnSearch);
		
		JButton btnNewButton_1_2 = new JButton("Clear");
		btnNewButton_1_2.setForeground(new Color(0, 0, 205));
		btnNewButton_1_2.setBackground(new Color(253, 245, 230));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCusName.setText("");
				cmbGender.setSelectedItem("");
				txtContact.setText("");
				textAreaAddress.setText("");
				txtCusID.setText("");
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_1_2.setBounds(482, 18, 109, 35);
		panel_1.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Registration");
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(512, 55, 306, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(233, 508, 885, 85);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Customer Name", "Gender", "Contact No.", "Address"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(300);
	}
}
