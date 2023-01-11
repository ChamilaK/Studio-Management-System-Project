package com.Action;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.UIManager;

public class Bookings_Bill {

	private JFrame frame;
	private JTextField txtCusID;
	private JRDesignQuery lblCusName;
	private JRDesignQuery lblContact;
	private JRDesignQuery lblDate;
	private JRDesignQuery lblPType;
	private JRDesignQuery lblBookingDate;
	private JRDesignQuery lblProName;
	private JRDesignQuery lblPSize;
	private JRDesignQuery lblPrice;
	private JRDesignQuery lblQuantity;
	private JRDesignQuery lblTotal;
	private JRDesignQuery lblAdvance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bookings_Bill window = new Bookings_Bill();
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
	public Bookings_Bill() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("InternalFrame.borderLight"));
		frame.setBounds(0, 0, 1350, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(140, 11, 862, 639);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCustomerId = new JLabel("Customer ID :");
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomerId.setBounds(194, 176, 126, 30);
		panel.add(lblCustomerId);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer Name :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(66, 224, 126, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contact No. :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(66, 265, 126, 30);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Date :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(66, 306, 126, 30);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Product Type :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(66, 347, 126, 30);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Product Name :");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(66, 388, 126, 30);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Photo Size :");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(451, 217, 126, 30);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Price :");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(451, 258, 126, 30);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("Quantity :");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(451, 299, 126, 30);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1 = new JLabel("Total :");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1_1_1_1.setBounds(451, 340, 126, 30);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("Advance :");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1.setBounds(451, 381, 126, 30);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1_1_1_1);
		
		JLabel lblCusName = new JLabel("");
		lblCusName.setForeground(new Color(0, 0, 255));
		lblCusName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCusName.setBounds(202, 234, 178, 20);
		panel.add(lblCusName);
		
		JLabel lblContact = new JLabel("");
		lblContact.setForeground(new Color(0, 0, 255));
		lblContact.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblContact.setBounds(202, 275, 178, 20);
		panel.add(lblContact);
		
		JLabel lblDate = new JLabel("");
		lblDate.setForeground(new Color(0, 0, 255));
		lblDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDate.setBounds(202, 316, 178, 20);
		panel.add(lblDate);
		
		JLabel lblPType = new JLabel("");
		lblPType.setForeground(new Color(0, 0, 255));
		lblPType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPType.setBounds(202, 357, 178, 20);
		panel.add(lblPType);
		
		JLabel lblProName = new JLabel("");
		lblProName.setForeground(new Color(0, 0, 255));
		lblProName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblProName.setBounds(202, 398, 178, 20);
		panel.add(lblProName);
		
		JLabel lblBookingDate = new JLabel("");
		lblBookingDate.setForeground(new Color(0, 0, 255));
		lblBookingDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblBookingDate.setBounds(194, 439, 178, 20);
		panel.add(lblBookingDate);
		
		JLabel lblPSize = new JLabel("");
		lblPSize.setForeground(new Color(0, 0, 255));
		lblPSize.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPSize.setBounds(553, 227, 178, 20);
		panel.add(lblPSize);
		
		JLabel lblPrice = new JLabel("");
		lblPrice.setForeground(new Color(0, 0, 255));
		lblPrice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPrice.setBounds(553, 268, 178, 20);
		panel.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("");
		lblQuantity.setForeground(new Color(0, 0, 255));
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblQuantity.setBounds(553, 309, 178, 20);
		panel.add(lblQuantity);
		
		JLabel lblTotal = new JLabel("");
		lblTotal.setForeground(new Color(0, 0, 255));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTotal.setBounds(553, 350, 178, 20);
		panel.add(lblTotal);
		
		JLabel lblAdvance = new JLabel("");
		lblAdvance.setForeground(new Color(0, 0, 255));
		lblAdvance.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAdvance.setBounds(553, 391, 178, 20);
		panel.add(lblAdvance);
		
		
		txtCusID = new JTextField();
		txtCusID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT `Customer_name`, `Contact_No`, `Date`, `Product_type`, `Booking_date`, `Photo/Video_type`, `Photo_size`, `Price`, `Quantity`, `Total`, `Advance_payment` FROM `bookings` WHERE Customer_id=?";
				pst = con.prepareStatement(query);
				int Customer_id = Integer.parseInt(txtCusID.getText());
				pst.setInt(1, Customer_id);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()==true)  {
					
					lblCusName.setText(rs.getString("Customer_name"));
					lblContact.setText(String.format(0 + "%s",rs.getString("Contact_No")));
					lblDate.setText(rs.getString("Date"));
					lblPType.setText(rs.getString("Product_type"));
					lblBookingDate.setText(rs.getString("Booking_date"));
					lblProName.setText(rs.getString("Photo/Video_type"));
					lblPSize.setText(rs.getString("Photo_size"));
					lblPrice.setText(rs.getString("Price"));
					lblQuantity.setText(rs.getString("Quantity"));
					lblTotal.setText(rs.getString("Total"));
					lblAdvance.setText(rs.getString("Advance_payment"));
								
				}
				
				else  {
					JOptionPane.showMessageDialog(null, "The Customer id number is not available");
										
				}				
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
			}
		});
		txtCusID.setColumns(10);
		txtCusID.setBounds(330, 183, 178, 20);
		panel.add(txtCusID);
		
		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("Booking Date :");
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(66, 429, 126, 30);
		panel.add(lblNewLabel_1_1_1_1_1_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("   Contact Us : ");
		lblNewLabel_3.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 14));
		lblNewLabel_3.setBounds(253, 501, 130, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("   077-2345678 / 033-2234567");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(364, 501, 243, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("No. 84/2, Kirindiwela Road, Gampaha.");
		lblNewLabel_5.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 18));
		lblNewLabel_5.setBounds(232, 511, 411, 56);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("    THANK YOU !!!");
		lblNewLabel_7.setFont(new Font("Segoe UI Emoji", Font.BOLD, 22));
		lblNewLabel_7.setBounds(301, 556, 217, 56);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_2 = new JLabel("   Photo and Video Studio");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_2.setBounds(243, 47, 352, 56);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("   Amasha");
		lblNewLabel_1.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel_1.setBounds(310, 22, 172, 46);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("   Identity and Passport Photos/Photo frame/");
		lblNewLabel_6.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_6.setBounds(232, 103, 376, 34);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("   Wedding and Pre-Wedding Photos and Videos/Album Creation/Mug Printing.");
		lblNewLabel_6_1.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_6_1.setBounds(149, 124, 563, 34);
		panel.add(lblNewLabel_6_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(264, 90, 289, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(149, 148, 563, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(264, 519, 280, 2);
		panel.add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(219, 556, 376, 2);
		panel.add(separator_2_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
										
					String query = "INSERT INTO `customer_bill`(`Customer_id`, `Customer_name`, `Contact_No`, `Date`, `Booking_date`, `Product_type`, `Product_name`, `Photo_size`, `Price`, `Quantity`, `Total`, `Advance_payment`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					pst = con.prepareStatement(query);
					pst.setString(1, txtCusID.getText());
					pst.setString(2, lblCusName.getText());
					pst.setString(3, lblContact.getText());
					pst.setString(4, lblDate.getText());
					pst.setString(5, lblBookingDate.getText());
					pst.setString(6, lblPType.getText());
					pst.setString(7, lblProName.getText());
					pst.setString(8, lblPSize.getText());
					pst.setString(9, lblPrice.getText());
					pst.setString(10, lblQuantity.getText());
					pst.setString(11, lblTotal.getText());
					pst.setString(12, lblAdvance.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "DATA INSERTED SUCCESSFULLY");
										
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(1100, 24, 150, 48);
		frame.getContentPane().add(btnNewButton);
	}
}
