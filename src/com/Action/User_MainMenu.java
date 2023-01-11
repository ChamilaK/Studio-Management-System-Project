package com.Action;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class User_MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_MainMenu window = new User_MainMenu();
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
	public User_MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(0, 0, 1350, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(85, 107, 47));
		panel.setBounds(10, 11, 1314, 70);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DASHBOARD");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(65, 22, 206, 37);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(188, 183, 107));
		panel_1.setBounds(10, 80, 1314, 570);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(new Color(204, 204, 51));
		panel_3.setBounds(321, 64, 225, 47);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("   Customer");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Customer window = new Customer();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1.setBounds(44, 0, 129, 47);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_1.setBackground(new Color(255, 102, 51));
		panel_3_1.setBounds(321, 294, 225, 46);
		panel_1.add(panel_3_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("   Orders");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Orders window = new Orders();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}			
			}
		});
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1_1.setBounds(56, 0, 129, 46);
		panel_3_1.add(lblNewLabel_1_1);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_1_1.setBackground(new Color(204, 153, 153));
		panel_3_1_1.setBounds(733, 64, 225, 46);
		panel_1.add(panel_3_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("   Bookings");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Bookings window = new Bookings();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}			
			}
		});
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1_1_1.setBounds(46, 0, 129, 46);
		panel_3_1_1.add(lblNewLabel_1_1_1);
		
		JPanel panel_3_1_1_1 = new JPanel();
		panel_3_1_1_1.setLayout(null);
		panel_3_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_1_1_1.setBackground(new Color(0, 255, 153));
		panel_3_1_1_1.setBounds(733, 294, 225, 46);
		panel_1.add(panel_3_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("   Final Bill");
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Bill window = new Bill();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}		
			}
		});
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1_1_1_1.setBounds(49, 0, 129, 46);
		panel_3_1_1_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(this.getClass().getResource("/wedding.jpg")));  // booking
		lblNewLabel_2.setBounds(733, 112, 225, 143);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(this.getClass().getResource("/Orders.jpg")));   // orders
		lblNewLabel_2_1.setBounds(321, 342, 225, 143);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon(this.getClass().getResource("/Final Bill.jpg")));   // final bill
		lblNewLabel_2_1_1_1.setBounds(733, 342, 225, 143);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(this.getClass().getResource("/Customer.jpg")));  // customer
		lblNewLabel_2_2.setBounds(322, 112, 225, 143);
		panel_1.add(lblNewLabel_2_2);
	}
}
