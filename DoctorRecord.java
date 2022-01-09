package com.example.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class DoctorRecord extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorRecord frame = new DoctorRecord();
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
	public DoctorRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1229, 634);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image icon = new ImageIcon(this.getClass().getResource("/com/example/demo/images/logo.jpg")).getImage();
		this.setIconImage(icon);
		JLabel lblNewLabel = new JLabel("Doctor's Record");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 36));
		lblNewLabel.setBounds(506, 10, 315, 87);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Doctor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDoctor AD = new AddDoctor();
				AD.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(335, 194, 220, 39);
		getContentPane().add(btnNewButton);
		
		JButton btnViewDoctorDetails = new JButton("View Doctors Details");
		btnViewDoctorDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorDeatails DD = new DoctorDeatails();
				DD.setVisible(true);
				dispose();
			}
		});
		btnViewDoctorDetails.setForeground(Color.MAGENTA);
		btnViewDoctorDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewDoctorDetails.setBackground(Color.GREEN);
		btnViewDoctorDetails.setBounds(335, 274, 220, 39);
		getContentPane().add(btnViewDoctorDetails);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(84, 393, 126, 50);
		getContentPane().add(btnNewButton_1);

	}

}
