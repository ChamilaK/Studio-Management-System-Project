package com.Action;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;



public class Internal_Photographer {

	protected static final String Age = null;
	protected static final String Gender = null;
	protected static final String Contact_No = null;
	protected static final String Address = null;
	protected static final String Date_of_Birth = null;
	protected static final String Full_name = null;
	protected static final String Emp_id = null;
	private JFrame frame;
	private JTextField txtDOB;
	private JTextField txtAge;
	private JTextField txtContact;
	private JTextField txtFullName;
	private JTextField txtEmpID;
	private JTable table;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Internal_Photographer window = new Internal_Photographer();
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
	public Internal_Photographer() {
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
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 0, 0)));
		panel.setBounds(400, 173, 629, 361);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Full Name :");
		lblNewLabel.setBounds(76, 77, 79, 21);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setBounds(76, 109, 97, 21);
		panel.add(lblDateOfBirth);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("Age :");
		lblNewLabel_1_1.setBounds(76, 141, 79, 21);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gender :");
		lblNewLabel_1_1_1.setBounds(76, 173, 79, 21);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Contact No. :");
		lblNewLabel_1_1_1_1.setBounds(76, 205, 97, 21);
		panel.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Address :");
		lblNewLabel_1_1_1_1_1.setBounds(76, 237, 79, 21);
		panel.add(lblNewLabel_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtDOB = new JTextField();
		txtDOB.setBounds(182, 111, 158, 20);
		panel.add(txtDOB);
		txtDOB.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(182, 143, 158, 20);
		panel.add(txtAge);
		
		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBounds(183, 207, 157, 20);
		panel.add(txtContact);
		
		txtFullName = new JTextField();
		txtFullName.setColumns(10);
		txtFullName.setBounds(182, 79, 158, 20);
		panel.add(txtFullName);
		
		JTextArea textAreaAddress = new JTextArea();
		textAreaAddress.setBounds(183, 237, 157, 55);
		panel.add(textAreaAddress);
		
		JComboBox cmbGender = new JComboBox();
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cmbGender.setBounds(183, 174, 157, 22);
		panel.add(cmbGender);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBackground(new Color(253, 245, 230));
		btnNewButton.setBounds(419, 102, 99, 31);
		panel.add(btnNewButton);
		btnNewButton.setForeground(new Color(0, 0, 205));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "INSERT INTO `internal_photographer`(`Full_name`, `Date_of_Birth`, `Age`, `Gender`, `Contact_No`, `Address`) VALUES (?, ?, ?, ?, ?, ?)";
					pst = con.prepareStatement(query);
					pst.setString(1, txtFullName.getText());
					pst.setString(2, txtDOB.getText());
					pst.setString(3, txtAge.getText());
					pst.setString(4, cmbGender.getSelectedItem().toString());
					pst.setString(5, txtContact.getText());
					pst.setString(6, textAreaAddress.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "DATA INSERTED SUCCESSFULLY");
					
					txtFullName.setText("");
					txtDOB.setText("");
					txtAge.setText("");
					cmbGender.setSelectedItem("");
					txtContact.setText("");
					textAreaAddress.setText("");
					
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `internal_photographer`";
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
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1.setBounds(419, 166, 109, 31);
		panel.add(btnNewButton_1);
		btnNewButton_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");	
					
					String query = "UPDATE `internal_photographer` SET `Full_name`= ?,`Date_of_Birth`= ?,`Age`= ?,`Gender`= ?,`Contact_No`= ?,`Address`= ? WHERE Emp_id=?";
					pst = con.prepareStatement(query);
					pst.setString(1, txtFullName.getText());
					pst.setString(2, txtDOB.getText());
					pst.setString(3, txtAge.getText());
					pst.setString(4, cmbGender.getSelectedItem().toString());
					pst.setString(5, txtContact.getText());
					pst.setString(6, textAreaAddress.getText());
					pst.setInt(7, Integer.parseInt(txtEmpID.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "RECORD UPDATED SUCCESSFULLY");
					
					txtFullName.setText("");
					txtDOB.setText("");
					txtAge.setText("");
					cmbGender.setSelectedItem("");
					txtContact.setText("");
					textAreaAddress.setText("");
					txtEmpID.setText("");
					
										
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}	
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `internal_photographer`";
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1.setBounds(419, 230, 97, 31);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
								
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "DELETE FROM `internal_photographer` WHERE Emp_id = ?";					
					PreparedStatement pst = con.prepareStatement(query);					
					pst.setInt(1, Integer.parseInt(txtEmpID.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "RECORD DELETED SUCCESSFULLY");
					
					txtFullName.setText("");
					txtDOB.setText("");
					txtAge.setText("");
					cmbGender.setSelectedItem("");
					txtContact.setText("");
					textAreaAddress.setText("");
					txtEmpID.setText("");
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `internal_photographer`";
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 232, 170));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel_1.setBounds(400, 99, 629, 63);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(63, 23, 105, 22);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Search");
		btnNewButton_1_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1_1.setBounds(336, 17, 111, 31);
		panel_1.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT * FROM `internal_photographer` WHERE Emp_id=?";
				pst = con.prepareStatement(query);
				int Emp_id = Integer.parseInt(txtEmpID.getText());
				pst.setInt(1, Emp_id);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()==false)  {
					JOptionPane.showMessageDialog(null, "The employee id number is not available");						
				}
				else  {
					txtFullName.setText(rs.getString("Full_name"));
					txtDOB.setText(rs.getString("Date_of_Birth"));
					txtAge.setText(rs.getString("Age"));
					cmbGender.setSelectedItem(rs.getString("Gender"));
					txtContact.setText(String.format(0 + "%s",rs.getString("Contact_No")));
					textAreaAddress.setText(rs.getString("Address"));
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}				
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT * FROM `internal_photographer`";
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
		
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		txtEmpID = new JTextField();
		txtEmpID.setColumns(10);
		txtEmpID.setBounds(166, 26, 144, 20);
		panel_1.add(txtEmpID);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Clear");
		btnNewButton_1_1_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtFullName.setText("");
				txtDOB.setText("");
				txtAge.setText("");
				cmbGender.setSelectedItem("");
				txtContact.setText("");
				textAreaAddress.setText("");
				txtEmpID.setText("");
				
			}
		});
		btnNewButton_1_1_1_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_1_1_1_1.setBounds(467, 17, 97, 31);
		panel_1.add(btnNewButton_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Internal Employee Registration");
		lblNewLabel_2.setForeground(new Color(139, 0, 0));
		lblNewLabel_2.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(505, 29, 440, 38);
		frame.getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 544, 800, 94);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee ID", "Full Name", "Date of Birth", "Age", "Gender", "Contact No.", "Address"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(300);
		
	}
}
