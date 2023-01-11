package com.Action;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Reports {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports window = new Reports();
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
	public Reports() {
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
		panel.setBounds(10, 11, 1314, 98);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reports");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(116, 22, 184, 52);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(189, 183, 107));
		panel_1.setBounds(10, 106, 1314, 544);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Final Bill Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\ne\\eclipse-workspace\\Studio_Management_System\\Final_Bill_Report.jrxml");
					
					String query = "SELECT * FROM `customer_bill`";
					
					JRDesignQuery updateQuery = new JRDesignQuery();
					updateQuery.setText(query);
					
					jdesign .setQuery(updateQuery);
					
					JasperReport jreport = JasperCompileManager.compileReport(jdesign);
					JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
					
					JasperViewer.viewReport(jprint);
										
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnNewButton.setBackground(new Color(143, 188, 143));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(575, 278, 378, 52);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/report-png-file.png")));
		lblNewLabel_1.setBounds(350, 42, 225, 225);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(this.getClass().getResource("/report-png-file.png")));
		lblNewLabel_1_1.setBounds(350, 263, 225, 199);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnEquipmentReport = new JButton("Equipment Report");
		btnEquipmentReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Connection con = null;
					
					try {
						
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
						
						JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\ne\\eclipse-workspace\\Studio_Management_System\\Equipment_Report.jrxml");
						
						String query = "SELECT * FROM `equipment`";
						
						JRDesignQuery updateQuery = new JRDesignQuery();
						updateQuery.setText(query);
						
						jdesign .setQuery(updateQuery);
						
						JasperReport jreport = JasperCompileManager.compileReport(jdesign);
						JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
						
						JasperViewer.viewReport(jprint);
											
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
						
					}
			}
		});
		btnEquipmentReport.setBackground(new Color(143, 188, 143));
		btnEquipmentReport.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnEquipmentReport.setBounds(575, 380, 378, 52);
		panel_1.add(btnEquipmentReport);
		
		JButton btnNewButton_1_1 = new JButton("Bookings Report");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
					
					JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\ne\\eclipse-workspace\\Studio_Management_System\\Bookings_Report.jrxml");
					
					String query = "SELECT * FROM `bookings`";
					
					JRDesignQuery updateQuery = new JRDesignQuery();
					updateQuery.setText(query);
					
					jdesign .setQuery(updateQuery);
					
					JasperReport jreport = JasperCompileManager.compileReport(jdesign);
					JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
					
					JasperViewer.viewReport(jprint);
										
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnNewButton_1_1.setBackground(new Color(143, 188, 143));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1_1.setBounds(575, 174, 378, 52);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Orders Report");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Connection con = null;
					
					try {
						
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
						
						JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\ne\\eclipse-workspace\\Studio_Management_System\\Orders_Report.jrxml");
						
						String query = "SELECT * FROM `orders`";
						
						JRDesignQuery updateQuery = new JRDesignQuery();
						updateQuery.setText(query);
						
						jdesign .setQuery(updateQuery);
						
						JasperReport jreport = JasperCompileManager.compileReport(jdesign);
						JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
						
						JasperViewer.viewReport(jprint);
											
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
						
					}
			}
		});
		btnNewButton_1_1_1.setBackground(new Color(143, 188, 143));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1_1_1.setBounds(575, 68, 378, 52);
		panel_1.add(btnNewButton_1_1_1);
	}

}
