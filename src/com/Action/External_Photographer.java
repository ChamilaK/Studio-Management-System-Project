package com.Action;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
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
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JTabbedPane;

public class External_Photographer {

	private JFrame frame;
	private JTextField txtContact;
	private JTextField txtDOPayment;
	private JTextField txtFullName;
	private JTextField txtPayment;
	private JTextField txtDOH;
	private JTextField txtEmpID;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					External_Photographer window = new External_Photographer();
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
	public External_Photographer() {
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
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel.setBounds(271, 90, 709, 70);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(53, 27, 113, 21);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 232, 170));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel_1.setBounds(271, 171, 709, 335);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(148, 42, 84, 23);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gender :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(148, 76, 84, 23);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contact No. :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(148, 110, 98, 23);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Address :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(148, 144, 84, 23);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Date of hire :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(148, 213, 98, 23);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Payment :");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(148, 247, 84, 23);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Date of payed :");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(148, 275, 133, 23);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);
		
		txtContact = new JTextField();
		txtContact.setBounds(278, 116, 141, 20);
		panel_1.add(txtContact);
		txtContact.setColumns(10);
		
		txtDOPayment = new JTextField();
		txtDOPayment.setColumns(10);
		txtDOPayment.setBounds(278, 278, 141, 20);
		panel_1.add(txtDOPayment);
		
		txtFullName = new JTextField();
		txtFullName.setColumns(10);
		txtFullName.setBounds(278, 48, 141, 20);
		panel_1.add(txtFullName);
		
		txtPayment = new JTextField();
		txtPayment.setColumns(10);
		txtPayment.setBounds(278, 250, 141, 20);
		panel_1.add(txtPayment);
		
		txtDOH = new JTextField();
		txtDOH.setColumns(10);
		txtDOH.setBounds(278, 216, 141, 20);
		panel_1.add(txtDOH);
		
		JComboBox cmbGender = new JComboBox();
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cmbGender.setBounds(278, 81, 141, 22);
		panel_1.add(cmbGender);
		
		JTextArea textAreaAddress = new JTextArea();
		textAreaAddress.setBounds(278, 148, 141, 57);
		panel_1.add(textAreaAddress);
		
		JButton btnAdd = new JButton("Save");
		btnAdd.setBounds(519, 68, 89, 35);
		panel_1.add(btnAdd);
		btnAdd.setBackground(new Color(253, 245, 230));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;				
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					
					
					String query = "INSERT INTO `external_photographer`(`Full_name`, `Gender`, `Contact_No`, `Address`, `Date_of_hire`, `Payment`, `Date_of_payed`) VALUES (?, ?, ?, ?, ?, ?, ?)";
					pst = con.prepareStatement(query);
					pst.setString(1, txtFullName.getText());
					pst.setString(2, cmbGender.getSelectedItem().toString());
					pst.setString(3, txtContact.getText());
					pst.setString(4, textAreaAddress.getText());
					pst.setString(5, txtDOH.getText());
					pst.setString(6, txtPayment.getText());
					pst.setString(7, txtDOPayment.getText());										
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "DATA INSERTED SUCCESSFULLY");
					
					txtFullName.setText("");
					cmbGender.setSelectedItem("");
					txtContact.setText("");
					textAreaAddress.setText("");
					txtDOH.setText("");
					txtPayment.setText("");
					txtDOPayment.setText("");
					
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `external_photographer`";
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
		btnNewButton_1_1.setBounds(519, 136, 114, 35);
		panel_1.add(btnNewButton_1_1);
		btnNewButton_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");	
					
					String query = "UPDATE `external_photographer` SET `Full_name`= ?,`Gender`= ?,`Contact_No`= ?,`Address`= ?,`Date_of_hire`= ?,`Payment`= ?, `Date_of_payed` = ? WHERE Emp_id=?";
					pst = con.prepareStatement(query);
					pst.setString(1, txtFullName.getText());
					pst.setString(2, cmbGender.getSelectedItem().toString());
					pst.setString(3, txtContact.getText());
					pst.setString(4, textAreaAddress.getText());
					pst.setString(5, txtDOH.getText());
					pst.setString(6, txtPayment.getText());
					pst.setString(7, txtDOPayment.getText());
					pst.setInt(8, Integer.parseInt(txtEmpID.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "RECORD UPDATED SUCCESSFULLY");
					
					txtFullName.setText("");
					cmbGender.setSelectedItem("");
					txtContact.setText("");
					textAreaAddress.setText("");
					txtDOH.setText("");
					txtPayment.setText("");
					txtDOPayment.setText("");
					txtEmpID.setText("");
					
										
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `external_photographer`";
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
		btnNewButton_1_1_1.setBounds(519, 213, 98, 35);
		panel_1.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "DELETE FROM `external_photographer` WHERE Emp_id = ?";					
					PreparedStatement pst = con.prepareStatement(query);					
					pst.setInt(1, Integer.parseInt(txtEmpID.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "RECORD DELETED SUCCESSFULLY");
					
					txtFullName.setText("");
					cmbGender.setSelectedItem("");
					txtContact.setText("");
					textAreaAddress.setText("");
					txtDOH.setText("");
					txtPayment.setText("");
					txtDOPayment.setText("");
					txtEmpID.setText("");
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `external_photographer`";
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
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Search");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT * FROM `external_photographer` WHERE Emp_id=?";
				pst = con.prepareStatement(query);
				int Emp_id = Integer.parseInt(txtEmpID.getText());
				pst.setInt(1, Emp_id);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()==false)  {
					JOptionPane.showMessageDialog(null, "The employee id number is not available");						
				}
				else  {
					txtFullName.setText(rs.getString("Full_name"));
					cmbGender.setSelectedItem(rs.getString("Gender"));
					txtContact.setText(String.format(0 + "%s",rs.getString("Contact_No")));
					textAreaAddress.setText(rs.getString("Address"));
					txtDOH.setText(rs.getString("Date_of_hire"));
					txtPayment.setText(rs.getString("Payment"));
					txtDOPayment.setText(rs.getString("Date_of_payed"));
										
				}				
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT * FROM `external_photographer`";
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
		btnNewButton_1_1_1_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1_1_1_1.setBounds(353, 18, 105, 35);
		panel.add(btnNewButton_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Clear");
		btnNewButton_1_1_1_1.setBounds(480, 18, 89, 35);
		panel.add(btnNewButton_1_1_1_1);
		btnNewButton_1_1_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtFullName.setText("");
				cmbGender.setSelectedItem("");
				txtContact.setText("");
				textAreaAddress.setText("");
				txtDOH.setText("");
				txtPayment.setText("");
				txtDOPayment.setText("");
				txtEmpID.setText("");
			}
		});
		btnNewButton_1_1_1_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		txtEmpID = new JTextField();
		txtEmpID.setColumns(10);
		txtEmpID.setBounds(158, 29, 141, 20);
		panel.add(txtEmpID);
		
		JLabel lblNewLabel_2 = new JLabel("External Employee Registration");
		lblNewLabel_2.setForeground(new Color(139, 0, 0));
		lblNewLabel_2.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(407, 25, 462, 38);
		frame.getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(195, 531, 850, 92);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee ID", "Full Name", "Gender", "Contact No.", "Address", "Date of Hire", "Payment", "Date of Payed"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(300);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
	}
}

