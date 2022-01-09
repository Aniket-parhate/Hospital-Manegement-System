package com.example.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class PatientDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientDetails frame = new PatientDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PatientDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 536);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 114, 1059, 296);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Name", "Disease"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblPatientDeatails = new JLabel("Patient Deatails");
		lblPatientDeatails.setBounds(429, 0, 264, 46);
		lblPatientDeatails.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 37));
		contentPane.add(lblPatientDeatails);
		
		JButton btnNewButton_1 = new JButton("View record");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "AniketCoder25");
					java.sql.Statement st = conn.createStatement();
					String sql = "select * from patient_record";
					java.sql.PreparedStatement ptst = conn.prepareStatement(sql);
					java.sql.ResultSet rs = ptst.executeQuery();
					
					DefaultTableModel dt = (DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
						Object o[]= {rs.getString("ID"), rs.getString("PatientName"), rs.getString("Disease")};
						dt.addRow(o);
					}
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_1.setBounds(456, 67, 120, 37);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientRecord PR = new PatientRecord();
				PR.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 431, 137, 46);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(btnNewButton);
		Image icon = new ImageIcon(this.getClass().getResource("/com/example/demo/images/logo.jpg")).getImage();
		this.setIconImage(icon);
	}

}
