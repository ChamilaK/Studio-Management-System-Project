package com.Action;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Login_Form {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private Object pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Form window = new Login_Form();
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
	public Login_Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textText);
		frame.setBounds(0, 0, 1350, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 133, 63));
		panel.setBounds(10, 11, 459, 639);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(this.getClass().getResource("/Background2.jpg")));
		lblNewLabel_3.setBounds(0, 0, 459, 639);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 222, 179));
		panel_1.setBounds(466, 11, 858, 639);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(193, 370, 125, 21);
		panel_1.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPassword.setBounds(193, 421, 125, 21);
		panel_1.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUsername.setBounds(310, 372, 212, 20);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		pwdPassword.setBounds(312, 423, 214, 20);
		panel_1.add(pwdPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					String username = txtUsername.getText();
					String password = pwdPassword.getText();
					
					String query = "SELECT * FROM `user` WHERE Username=? and Password=?";
					pst = con.prepareStatement(query);
					pst.setString(1, username);
					pst.setString(2, password);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) {
						
						String uname = rs.getString("Username");
						String pass = rs.getString("Password");
						
						if(username.equals("Admin") && password.equals(pass)) {
						
						Admin_MainMenu window = new Admin_MainMenu();
						window.main(null);									
						
					}	else if(username.equals("User") && password.equals(pass)) {
										
						User_MainMenu window = new User_MainMenu();
						window.main(null);
						
					} else {						
						JOptionPane.showMessageDialog(null, "Invalid Username or Password");
						
						txtUsername.setText("");
						pwdPassword.setText("");
					}
						}
					
				} catch (SQLException e1) {
					e1.printStackTrace();					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBounds(245, 467, 111, 38);
		panel_1.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnCancel.setBounds(381, 467, 120, 38);
		panel_1.add(btnCancel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(this.getClass().getResource("/user-login.png")));
		lblNewLabel_2.setBounds(244, 106, 226, 223);
		panel_1.add(lblNewLabel_2);
	}
}
