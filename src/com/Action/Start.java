package com.Action;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Start {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
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
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(0, 0, 1350, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql:/localhost:3306//Studio_Management_System","root","");
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
				
				Login_Form window = new Login_Form();
				try {
					window.main(null);
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}			
			}
		});
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/Background.jpg")));
		lblNewLabel.setBounds(155, 124, 1000, 526);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("   Amasha Photo and Video Studio");
		lblNewLabel_1.setForeground(new Color(219, 112, 147));
		lblNewLabel_1.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 55));
		lblNewLabel_1.setBounds(281, 41, 764, 81);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
