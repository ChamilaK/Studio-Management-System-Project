package com.Action;

import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin_MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_MainMenu window = new Admin_MainMenu();
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
	public Admin_MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("CheckBox.foreground"));
		frame.setBounds(0, 0, 1350, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(85, 107, 47)); // uda
		panel.setBounds(10, 11, 1314, 57);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DASHBOARD");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(68, 11, 228, 35);
		panel.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(188, 183, 107));
		panel_6.setBounds(10, 68, 1314, 582);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBackground(new Color(255, 0, 102));
		panel_7.setBounds(141, 303, 217, 43);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Equipments");
		lblNewLabel_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Equipment window = new Equipment();
					window.main(null);
					
				} catch (SQLException e1) {
					e1.printStackTrace();					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}							
			}
		});
		lblNewLabel_1_1_1_1_1.setBounds(48, 0, 133, 43);
		panel_7.add(lblNewLabel_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1_1_1_1_1.setBackground(new Color(255, 153, 102));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(46, 139, 87));
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBounds(750, 303, 217, 43);
		panel_6.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("   Final Bill");
		lblNewLabel_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Bill window = new Bill();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}		
			}
		});
		lblNewLabel_1_1_1_1_1_1.setBounds(38, 0, 120, 43);
		panel_8.add(lblNewLabel_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1_1_1_1_1_1.setBackground(new Color(255, 153, 102));
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setLayout(null);
		panel_8_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8_1.setBackground(new Color(255, 255, 0));
		panel_8_1.setBounds(436, 303, 217, 43);
		panel_6.add(panel_8_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("   Report");
		lblNewLabel_1_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Reports window = new Reports();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}	
				
			}
		});
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1_1_1_1_1_1_1.setBackground(new Color(255, 153, 102));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(42, 0, 110, 43);
		panel_8_1.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(1038, 41, 203, 43);
		panel_6.add(panel_5);
		panel_5.setBackground(new Color(255, 102, 255));
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("   Employee");
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Employee window = new Employee();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}		
			}
		});
		lblNewLabel_1_1_1_1.setBounds(37, 0, 129, 43);
		panel_5.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1_1_1_1.setBackground(new Color(255, 153, 102));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(750, 38, 217, 43);
		panel_6.add(panel_4);
		panel_4.setBackground(new Color(204, 204, 51));
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("   Bookings");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Bookings window = new Bookings();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}			
			}
		});
		lblNewLabel_1_1_1.setBounds(47, 0, 130, 43);
		panel_4.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1_1_1.setBackground(new Color(153, 255, 153));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(436, 42, 217, 40);
		panel_6.add(panel_3);
		panel_3.setBackground(new Color(204, 255, 153));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("   Orders");
		lblNewLabel_1_1_1_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Orders window = new Orders();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}			
			}
		});
		lblNewLabel_1_1_1_1_1_2.setBounds(54, 0, 116, 40);
		panel_3.add(lblNewLabel_1_1_1_1_1_2);
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1_1_1_1_1_2.setBackground(new Color(255, 153, 102));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(this.getClass().getResource("/Customer.jpg"))); // customer
		lblNewLabel_2.setBounds(141, 83, 217, 166);
		panel_6.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(this.getClass().getResource("/Report.png")));// Report
		lblNewLabel_3.setBounds(436, 344, 217, 166);
		panel_6.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(this.getClass().getResource("/Equipment.jpg")));  // equipment
		lblNewLabel_4.setBounds(141, 344, 217, 166);
		panel_6.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(this.getClass().getResource("/Final Bill.jpg"))); // final bill
		lblNewLabel_5.setBounds(750, 344, 217, 166);
		panel_6.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(this.getClass().getResource("/Orders.jpg"))); // orders
		lblNewLabel_6.setBounds(436, 83, 217, 166);
		panel_6.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(this.getClass().getResource("/wedding.jpg")));  //bookings
		lblNewLabel_7.setBounds(750, 83, 217, 166);
		panel_6.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(this.getClass().getResource("/Employee.jpg"))); // employee
		lblNewLabel_8.setBounds(1038, 83, 203, 166);
		panel_6.add(lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(141, 41, 217, 43);
		panel_6.add(panel_2);
		panel_2.setBackground(new Color(255, 204, 204));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("   Customer");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Customer window = new Customer();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}
			}
		});
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(37, 0, 125, 40);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(255, 153, 102));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		
		JPanel panel_8_2 = new JPanel();
		panel_8_2.setLayout(null);
		panel_8_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8_2.setBackground(new Color(255, 140, 0));
		panel_8_2.setBounds(1024, 303, 230, 43);
		panel_6.add(panel_8_2);
		
		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("   User Registration");
		lblNewLabel_1_1_1_1_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					User_Registration window = new User_Registration();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}
			}
		});
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1_1_1_1_1_1_2.setBackground(new Color(255, 153, 102));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(10, 0, 197, 43);
		panel_8_2.add(lblNewLabel_1_1_1_1_1_1_2);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(this.getClass().getResource("/Registration.jpg")));  // user
		lblNewLabel_5_1.setBounds(1024, 344, 230, 166);
		panel_6.add(lblNewLabel_5_1);
	}
}
