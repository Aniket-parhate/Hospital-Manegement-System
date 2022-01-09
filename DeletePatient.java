package com.example.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class DeletePatient extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField pid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePatient frame = new DeletePatient();
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
	public DeletePatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 947, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Discharge Patient");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 27));
		lblNewLabel.setBounds(346, 10, 228, 45);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 89, 933, 161);
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
		
		JButton btnNewButton = new JButton("View Record");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(665, 44, 144, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("To discharge a patient enter the ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(23, 253, 250, 33);
		contentPane.add(lblNewLabel_1);
		
		pid = new JTextField();
		pid.setBounds(20, 296, 115, 33);
		contentPane.add(pid);
		pid.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Discharge");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pi = pid.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "AniketCoder25");
					java.sql.Statement st = conn.createStatement();
					String sql = "DELETE FROM `patient_record` WHERE id = "+pi;
					java.sql.PreparedStatement ptst=conn.prepareStatement(sql);
					ptst.execute();
					JOptionPane.showMessageDialog(null, "Patient discharged successfully");
					conn.close();
					pid.setText("");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(176, 296, 115, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientRecord PR = new PatientRecord();
				PR.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(10, 390, 144, 45);
		contentPane.add(btnNewButton_2);
		Image icon = new ImageIcon(this.getClass().getResource("/com/example/demo/images/logo.jpg")).getImage();
		this.setIconImage(icon);
	}

}
