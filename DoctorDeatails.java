package com.example.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class DoctorDeatails extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorDeatails frame = new DoctorDeatails();
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
	public DoctorDeatails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 567);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 113, 966, 351);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Name", "specialization"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Doctor's Deatails");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 37));
		lblNewLabel.setBounds(397, 10, 264, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorRecord DR = new DoctorRecord();
				DR.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton.setBounds(10, 474, 137, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View record");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "AniketCoder25");
					java.sql.Statement st = conn.createStatement();
					String sql = "select * from doctor_record";
					java.sql.PreparedStatement ptst = conn.prepareStatement(sql);
					java.sql.ResultSet rs = ptst.executeQuery();
					
					DefaultTableModel dt = (DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
						Object o[]= {rs.getString("ID"), rs.getString("DoctorName"), rs.getString("specialization")};
						dt.addRow(o);
					}
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(420, 66, 120, 37);
		contentPane.add(btnNewButton_1);
		Image icon = new ImageIcon(this.getClass().getResource("/com/example/demo/images/logo.jpg")).getImage();
		this.setIconImage(icon);
	}
}
