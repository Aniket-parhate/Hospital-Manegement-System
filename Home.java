package com.example.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1238, 663);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image icon = new ImageIcon(this.getClass().getResource("/com/example/demo/images/logo.jpg")).getImage();
		this.setIconImage(icon);
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/com/example/demo/images/HMS.jpg")));;
		contentPane.setLayout(null);
		
		lblNewLabel.setBounds(0, -46, 835, 495);
		contentPane.add(lblNewLabel);
		JButton btnNewButton = new JButton("Doctor's Record");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorRecord DR = new DoctorRecord();
				DR.setVisible(true);
				dispose();
				
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(889, 47, 203, 58);
		contentPane.add(btnNewButton);
		
		JButton btnPatientsRecord = new JButton("Patient's Record");
		btnPatientsRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientRecord PR = new PatientRecord();
				PR.setVisible(true);
				dispose();
			}
		});
		btnPatientsRecord.setForeground(Color.MAGENTA);
		btnPatientsRecord.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPatientsRecord.setBackground(Color.BLUE);
		btnPatientsRecord.setBounds(889, 159, 203, 58);
		contentPane.add(btnPatientsRecord);
		
	}
}
