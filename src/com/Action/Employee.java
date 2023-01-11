package com.Action;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Employee {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee();
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
	public Employee() {
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
		panel.setBounds(10, 11, 1314, 93);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(163, 22, 198, 71);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(189, 183, 107));
		panel_1.setBounds(10, 101, 1314, 549);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Internal_Photographer window = new Internal_Photographer();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}		
			}
		});
		btnNewButton.setIcon(new ImageIcon(this.getClass().getResource("/external-word-paper-concept-words-external-wooden-background-external-word-paper-concept-words-103990055.jpg")));
		btnNewButton.setBounds(157, 102, 450, 263);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					External_Photographer window = new External_Photographer();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}		
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(this.getClass().getResource("/internal-word-paper-concept-words-wooden-background-103999742.jpg")));
		btnNewButton_1.setBounds(716, 102, 445, 263);
		panel_1.add(btnNewButton_1);
	}
}
