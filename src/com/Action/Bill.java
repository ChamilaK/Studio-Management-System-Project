package com.Action;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Bill {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill window = new Bill();
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
	public Bill() {
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
		panel.setBounds(10, 11, 1314, 104);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Final Bill");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(96, 41, 284, 52);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(189, 183, 107));
		panel_1.setBounds(10, 113, 1314, 537);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Bookings Bill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Bookings_Bill window = new Bookings_Bill();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}	
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(186, 85, 211));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		btnNewButton.setBounds(756, 139, 317, 162);
		panel_1.add(btnNewButton);
		
		JButton btnOrdersBill = new JButton("Orders Bill");
		btnOrdersBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Orders_Bill window = new Orders_Bill();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}	
			}
		});
		btnOrdersBill.setForeground(new Color(255, 255, 255));
		btnOrdersBill.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		btnOrdersBill.setBackground(new Color(186, 85, 211));
		btnOrdersBill.setBounds(321, 139, 317, 162);
		panel_1.add(btnOrdersBill);
	}

}
