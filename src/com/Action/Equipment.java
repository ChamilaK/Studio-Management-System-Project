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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
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

public class Equipment {

	private JFrame frame;
	private JTextField txtContact;
	private JTextField txtDOP;
	private JTextField txtAdvance;
	private JTextField txtPrice;
	private JTextField txtDOPayed;
	private JTextField txtEquipID;
	private JComboBox cmbSuplier;
	private JComboBox cmbEquipName;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Equipment window = new Equipment();
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
	public Equipment() {
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
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(274, 206, 744, 321);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Equipment Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(114, 48, 135, 21);
		panel.add(lblNewLabel);
		
		JLabel lblSuplier = new JLabel("Suplier :");
		lblSuplier.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSuplier.setBounds(114, 80, 135, 21);
		panel.add(lblSuplier);
		
		JLabel lblNewLabel_1_1 = new JLabel(" Contact No. :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(114, 112, 135, 21);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Date of Purchase :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(114, 144, 135, 21);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Price :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(114, 176, 135, 21);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Advance Payment :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(114, 208, 135, 21);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Full Payed Date :");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(114, 240, 135, 37);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBounds(259, 114, 179, 20);
		panel.add(txtContact);
		
		txtDOP = new JTextField();
		txtDOP.setColumns(10);
		txtDOP.setBounds(259, 146, 179, 20);
		panel.add(txtDOP);
		
		txtAdvance = new JTextField();
		txtAdvance.setColumns(10);
		txtAdvance.setBounds(259, 210, 179, 20);
		panel.add(txtAdvance);
		
		JComboBox cmbSuplier = new JComboBox();
		cmbSuplier.setModel(new DefaultComboBoxModel(new String[] {"ASD Camera Rent", "Photo Guide Studio and Color Lab", "Smart Photo Studio", "Someone Studio", "Studio Seyavee"}));
		cmbSuplier.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbSuplier.setBounds(259, 81, 179, 22);
		panel.add(cmbSuplier);
		
		JComboBox cmbEquipName = new JComboBox();
		cmbEquipName.setModel(new DefaultComboBoxModel(new String[] {"Adjustable lighting kits", "Computer", "LED lights", "Lenses", "Photography backdrops", "Softboxes and Umbrellas", "Strobes"}));
		cmbEquipName.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbEquipName.setBounds(259, 49, 179, 22);
		panel.add(cmbEquipName);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(259, 178, 179, 20);
		panel.add(txtPrice);
		
		txtDOPayed = new JTextField();
		txtDOPayed.setColumns(10);
		txtDOPayed.setBounds(259, 242, 179, 20);
		panel.add(txtDOPayed);
		
		JButton btnAdd = new JButton("Save");
		btnAdd.setBounds(569, 50, 107, 37);
		panel.add(btnAdd);
		btnAdd.setBackground(new Color(253, 245, 230));
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;				
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					
					
					String query = "INSERT INTO `equipment`(`Equipment_name`, `Suplier`, `Suplier_contact`, `Date_of_purchase/rent`, `Price`, `Advance_payment`, `Full_payment_release`) VALUES (?, ?, ?, ?, ?, ?, ?)";
					pst = con.prepareStatement(query);
					pst.setString(1, cmbEquipName.getSelectedItem().toString());
					pst.setString(2, cmbSuplier.getSelectedItem().toString());
					pst.setString(3, txtContact.getText());
					pst.setString(4, txtDOP.getText());
					pst.setString(5, txtPrice.getText());
					pst.setString(6, txtAdvance.getText());			
					pst.setString(7, txtDOPayed.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "DATA INSERTED SUCCESSFULLY");
					
					cmbEquipName.setSelectedItem("");
					cmbSuplier.setSelectedItem("");
					txtContact.setText("");
					txtDOP.setText("");
					txtPrice.setText("");
					txtAdvance.setText("");
					txtDOPayed.setText("");
					
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `equipment`";
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
		btnNewButton_1_1.setBounds(569, 114, 107, 37);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");	
					
					String query = "UPDATE `equipment` SET `Equipment_name`=?,`Suplier`=?,`Suplier_contact`=?,`Date_of_purchase/rent`=?,`Price`=?,`Advance_payment`=?,`Full_payment_release`=? WHERE `Equipment_id`=?";
					pst = con.prepareStatement(query);
					pst.setString(1, cmbEquipName.getSelectedItem().toString());
					pst.setString(2, cmbSuplier.getSelectedItem().toString());
					pst.setString(3, txtContact.getText());
					pst.setString(4, txtDOP.getText());
					pst.setString(5, txtPrice.getText());
					pst.setString(6, txtAdvance.getText());
					pst.setString(7, txtDOPayed.getText());
					pst.setInt(8, Integer.parseInt(txtEquipID.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "RECORD UPDATED SUCCESSFULLY");
					
					cmbEquipName.setSelectedItem("");
					cmbSuplier.setSelectedItem("");
					txtContact.setText("");
					txtDOP.setText("");
					txtPrice.setText("");
					txtAdvance.setText("");
					txtDOPayed.setText("");
					txtEquipID.setText("");
					
										
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `equipment`";
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
		btnNewButton_1_1_1.setBounds(569, 192, 107, 37);
		panel.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                 Connection con = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "DELETE FROM `equipment` WHERE Equipment_id = ?";					
					PreparedStatement pst = con.prepareStatement(query);					
					pst.setInt(1, Integer.parseInt(txtEquipID.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "RECORD DELETED SUCCESSFULLY");
					
					cmbEquipName.setSelectedItem("");
					cmbSuplier.setSelectedItem("");
					txtContact.setText("");
					txtDOP.setText("");
					txtPrice.setText("");
					txtAdvance.setText("");
					txtDOPayed.setText("");
					txtEquipID.setText("");
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String query = "SELECT * FROM `equipment`";
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
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(299, 125, 667, 63);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Equipment ID :");
		lblNewLabel_1_1_1_1_1_1_1.setBounds(89, 23, 135, 21);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Search");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT * FROM `equipment` WHERE Equipment_id=?";
				pst = con.prepareStatement(query);
				int Equipment_id = Integer.parseInt(txtEquipID.getText());
				pst.setInt(1, Equipment_id);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()==false)  {
					JOptionPane.showMessageDialog(null, "The equipment id number is not available");						
				}
				else  {
					cmbEquipName.setSelectedItem(rs.getString("Equipment_name"));
					cmbSuplier.setSelectedItem(rs.getString("Suplier"));
					txtContact.setText(rs.getString("Suplier_contact"));
					txtDOP.setText(rs.getString("Date_of_purchase/rent"));
					txtPrice.setText(rs.getString("Price"));
					txtAdvance.setText(rs.getString("Advance_payment"));
					txtDOPayed.setText(rs.getString("Full_payment_release"));
															
				}				
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT * FROM `equipment`";
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
		btnNewButton_1_1_1_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1_1_1_1.setBounds(397, 13, 107, 37);
		panel_1.add(btnNewButton_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Clear");
		btnNewButton_1_1_1_1.setBounds(526, 13, 107, 37);
		panel_1.add(btnNewButton_1_1_1_1);
		btnNewButton_1_1_1_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cmbEquipName.setSelectedItem("");
				cmbSuplier.setSelectedItem("");
				txtContact.setText("");
				txtDOP.setText("");
				txtPrice.setText("");
				txtAdvance.setText("");
				txtDOPayed.setText("");
				txtEquipID.setText("");
			}
		});
		btnNewButton_1_1_1_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		txtEquipID = new JTextField();
		txtEquipID.setColumns(10);
		txtEquipID.setBounds(201, 25, 157, 20);
		panel_1.add(txtEquipID);
		
		JLabel lblNewLabel_1 = new JLabel("Equipment Registration");
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(486, 45, 339, 45);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(243, 557, 882, 77);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Equipment ID", "Equipment Name", "Suplier", "Suplier Contact No.", "Date of Purchase/Rent", "Price", "Advance Payment", "Full Payed Date"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
	}
}
