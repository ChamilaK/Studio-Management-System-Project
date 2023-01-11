package com.Action;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class User_Registration {

	private JFrame frame;
	private JTextField txtFullName;
	private JTextField txtAge;
	private JTextField txtUsername;
	private JTextField txtContact;
	private JPasswordField pswPassword;
	private JTextField txtDOB;
	private JTextArea textAreaAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Registration window = new User_Registration();
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
	public User_Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(222, 184, 135));
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(0, 0, 1350, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(234, 49, 837, 524);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Username :");
		lblNewLabel_1_1_1_1_1_1.setBounds(473, 158, 79, 22);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Password :");
		lblNewLabel_1_1_1_1_1_1_1.setBounds(473, 191, 79, 22);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Contact No. :");
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(473, 224, 92, 22);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("Address :");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(473, 257, 79, 22);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JComboBox cmbGender = new JComboBox();
		cmbGender.setBounds(200, 193, 170, 22);
		panel.add(cmbGender);
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		
		txtUsername = new JTextField();
		txtUsername.setBounds(575, 161, 170, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		pswPassword = new JPasswordField();
		pswPassword.setBounds(575, 194, 170, 20);
		panel.add(pswPassword);
		
		txtContact = new JTextField();
		txtContact.setBounds(575, 227, 170, 20);
		panel.add(txtContact);
		txtContact.setColumns(10);
		
		JTextArea textAreaAddress_1 = new JTextArea();
		textAreaAddress_1.setBounds(575, 258, 170, 49);
		panel.add(textAreaAddress_1);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(297, 359, 107, 38);
		panel.add(btnRegister);
		btnRegister.setForeground(new Color(0, 0, 205));
		btnRegister.setBackground(new Color(253, 245, 230));
		btnRegister.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					
					
					String query = "INSERT INTO `user`(`Full_name`, `Gender`, `Date_of_Birth`, `Age`, `Username`, `Password`, `Contact_No`, `Address`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
					pst = con.prepareStatement(query);
					pst.setString(1, txtFullName.getText());
					pst.setString(2, cmbGender.getSelectedItem().toString());
					pst.setString(3, txtDOB.getText());
					pst.setString(4, txtAge.getText());
					pst.setString(5, txtUsername.getText());
					pst.setString(6, pswPassword.getText());
					pst.setString(7, txtContact.getText());
					pst.setString(8, textAreaAddress_1.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "REGISTERED SUCCESSFULLY");
					
					txtFullName.setText("");
					cmbGender.setSelectedItem("");
					txtDOB.setText("");
					txtAge.setText("");
					txtUsername.setText("");
					pswPassword.setText("");
					txtContact.setText("");
					textAreaAddress_1.setText("");
					
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(464, 359, 107, 38);
		panel.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					Admin_MainMenu window = new Admin_MainMenu();
					window.main(null);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);					
				}			
				
			}
		});
		btnExit.setForeground(new Color(255, 0, 0));
		btnExit.setBackground(new Color(253, 245, 230));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Full Name :");
		lblNewLabel_1.setBounds(93, 158, 79, 22);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("Gender :");
		lblNewLabel_1_1.setBounds(93, 191, 79, 22);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Date of Birth :");
		lblNewLabel_1_1_1.setBounds(93, 224, 97, 22);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Age :");
		lblNewLabel_1_1_1_1.setBounds(93, 257, 79, 22);
		panel.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtFullName = new JTextField();
		txtFullName.setBounds(200, 161, 170, 20);
		panel.add(txtFullName);
		txtFullName.setColumns(10);
		
		txtDOB = new JTextField();
		txtDOB.setBounds(200, 227, 170, 20);
		panel.add(txtDOB);
		txtDOB.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setBounds(200, 260, 170, 20);
		panel.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Registration");
		lblNewLabel.setBounds(297, 52, 268, 49);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 30));
		
		
	}
}
