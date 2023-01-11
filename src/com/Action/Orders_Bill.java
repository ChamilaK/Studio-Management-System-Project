package com.Action;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
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
import javax.swing.JSeparator;
import javax.swing.UIManager;

public class Orders_Bill {

	private JFrame frame;
	private JTextField txtCusID;
	private JLabel lblCusName;
	private JLabel lblContact;
	private JLabel lblOrderDate;
	private JLabel lblProName;
	private JLabel lblSize;
	private JLabel lblPrice;
	private JLabel lblQuantity;
	private JLabel lblTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orders_Bill window = new Orders_Bill();
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
	public Orders_Bill() {
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
		panel.setForeground(new Color(0, 0, 255));
		panel.setBackground(new Color(32, 178, 170));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(287, 33, 705, 604);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(197, 194, 108, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer Name :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(68, 245, 130, 20);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contact No. :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(68, 276, 108, 20);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Order Date :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(68, 307, 108, 20);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Size :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(390, 245, 108, 20);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Price :");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(390, 276, 108, 20);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Quantity :");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(390, 307, 108, 20);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Total :");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(390, 338, 108, 20);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("Product Name :");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(68, 338, 119, 20);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1_1);
		
		JLabel lblProName = new JLabel("");
		lblProName.setForeground(new Color(0, 0, 255));
		lblProName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblProName.setBounds(197, 338, 158, 20);
		panel.add(lblProName);
		
		JLabel lblOrderDate = new JLabel("");
		lblOrderDate.setForeground(new Color(0, 0, 255));
		lblOrderDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblOrderDate.setBounds(197, 307, 158, 20);
		panel.add(lblOrderDate);
		
		JLabel lblContact = new JLabel("");
		lblContact.setForeground(new Color(0, 0, 255));
		lblContact.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblContact.setBounds(197, 276, 158, 20);
		panel.add(lblContact);
		
		JLabel lblCusName = new JLabel("");
		lblCusName.setForeground(new Color(0, 0, 255));
		lblCusName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblCusName.setBounds(197, 245, 158, 20);
		panel.add(lblCusName);
		
		JLabel lblQuantity = new JLabel("");
		lblQuantity.setForeground(new Color(0, 0, 255));
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblQuantity.setBounds(473, 308, 158, 20);
		panel.add(lblQuantity);
		
		JLabel lblTotal = new JLabel("");
		lblTotal.setForeground(new Color(0, 0, 255));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTotal.setBounds(473, 339, 158, 20);
		panel.add(lblTotal);
		
		JLabel lblPrice = new JLabel("");
		lblPrice.setForeground(new Color(0, 0, 255));
		lblPrice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPrice.setBounds(473, 277, 158, 20);
		panel.add(lblPrice);
		
		JLabel lblSize = new JLabel("");
		lblSize.setForeground(new Color(0, 0, 255));
		lblSize.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblSize.setBounds(473, 245, 158, 20);
		panel.add(lblSize);
		
		txtCusID = new JTextField();
		txtCusID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				Connection con = null;
				PreparedStatement pst = null;
				
				
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
				
				String query = "SELECT `Customer_name`, `Contact_No`, `Order_date`, `Product_name`, `Size`, `Price`, `Quantity`, `Total` FROM `orders` WHERE Customer_id=?";
				pst = con.prepareStatement(query);
				int Customer_id = Integer.parseInt(txtCusID.getText());
				pst.setInt(1, Customer_id);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()==true)  {
					
					lblCusName.setText(rs.getString("Customer_name"));
					lblContact.setText(String.format(0 + "%s",rs.getString("Contact_No")));
					lblOrderDate.setText(rs.getString("Order_date"));
					lblProName.setText(rs.getString("Product_name"));
					lblSize.setText(rs.getString("Size"));
					lblPrice.setText(rs.getString("Price"));
					lblQuantity.setText(rs.getString("Quantity"));
					lblTotal.setText(rs.getString("Total"));
								
				}
				
				else  {
					JOptionPane.showMessageDialog(null, "The Customer id number is not available");
										
				}				
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				
			}
			}
		});
		txtCusID.setBounds(315, 196, 152, 20);
		panel.add(txtCusID);
		txtCusID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("   Amasha");
		lblNewLabel_1.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel_1.setBounds(229, 29, 172, 46);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("   Photo and Video Studio");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_2.setBounds(162, 54, 352, 56);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("   Contact Us : ");
		lblNewLabel_3.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 14));
		lblNewLabel_3.setBounds(175, 407, 130, 34);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("   077-2345678 / 033-2234567");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(284, 414, 243, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("No. 84/2, Kirindiwela Road, Gampaha.");
		lblNewLabel_5.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 18));
		lblNewLabel_5.setBounds(151, 434, 411, 56);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("   Identity and Passport Photos/Photo frame/");
		lblNewLabel_6.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_6.setBounds(151, 110, 376, 34);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("   Wedding and Pre-Wedding Photos and Videos/Album Creation/Mug Printing.");
		lblNewLabel_6_1.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_6_1.setBounds(68, 131, 563, 34);
		panel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7 = new JLabel("    THANK YOU !!!");
		lblNewLabel_7.setFont(new Font("Segoe UI Emoji", Font.BOLD, 22));
		lblNewLabel_7.setBounds(220, 501, 217, 56);
		panel.add(lblNewLabel_7);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(175, 97, 297, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(81, 162, 541, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(197, 434, 258, 2);
		panel.add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(151, 480, 352, 2);
		panel.add(separator_2_1);
		
		/*JLabel lblProName = new JLabel("New label");
		lblProName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblProName.setBounds(160, 206, 158, 20);
		panel.add(lblProName);
		
		JLabel lblOrderDate = new JLabel("New label");
		lblOrderDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblOrderDate.setBounds(160, 175, 158, 20);
		panel.add(lblOrderDate);
		
		JLabel lblContact = new JLabel("New label");
		lblContact.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblContact.setBounds(160, 144, 158, 20);
		panel.add(lblContact);
		
		JLabel lblCusName = new JLabel("New label");
		lblCusName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblCusName.setBounds(160, 113, 158, 20);
		panel.add(lblCusName);
		
		JLabel lblOrderID = new JLabel("");
		lblOrderID.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblOrderID.setBounds(160, 82, 158, 20);
		panel.add(lblOrderID);
		
		JLabel lblQuantity = new JLabel("New label");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblQuantity.setBounds(436, 145, 158, 20);
		panel.add(lblQuantity);
		
		JLabel lblTotal = new JLabel("New label");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTotal.setBounds(436, 176, 158, 20);
		panel.add(lblTotal);
		
		JLabel lblPrice = new JLabel("New label");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPrice.setBounds(436, 114, 158, 20);
		panel.add(lblPrice);
		
		JLabel lblSize = new JLabel("New label");
		lblSize.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblSize.setBounds(436, 82, 158, 20);
		panel.add(lblSize);*/
		
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
					pst.setString(4, lblOrderDate.getText());
					pst.setString(5, null);
					pst.setString(6, null);
					pst.setString(7, lblProName.getText());
					pst.setString(8, lblSize.getText());
					pst.setString(9, lblPrice.getText());
					pst.setString(10, lblQuantity.getText());
					pst.setString(11, lblTotal.getText());
					pst.setString(12, null);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "DATA INSERTED SUCCESSFULLY");
										
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton.setBounds(1100, 33, 129, 37);
		frame.getContentPane().add(btnNewButton);
	}
}
