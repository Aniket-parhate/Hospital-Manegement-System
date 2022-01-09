package com.example.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientRecord extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientRecord frame = new PatientRecord();
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
	public PatientRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1132, 579);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		getContentPane().setLayout(null);
		Image icon = new ImageIcon(this.getClass().getResource("/com/example/demo/images/logo.jpg")).getImage();
		this.setIconImage(icon);
		
		JLabel lblNewLabel = new JLabel("Patient Records");
		
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 36));
		lblNewLabel.setBounds(367, 35, 211, 42);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Admit New Patient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdmitPatient AP = new AdmitPatient();
				AP.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.RED);
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(153, 128, 196, 42);
		getContentPane().add(btnNewButton);
		
		JButton btnViewPatientDetails = new JButton("View Patient Details");
		btnViewPatientDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientDetails PD = new PatientDetails();
				PD.setVisible(true);
				dispose();
			}
		});
		btnViewPatientDetails.setBackground(Color.BLUE);
		btnViewPatientDetails.setForeground(Color.RED);
	
		btnViewPatientDetails.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnViewPatientDetails.setBounds(153, 209, 196, 42);
		getContentPane().add(btnViewPatientDetails);
		
		JButton btnDeletePatient = new JButton("Delete Patient");
		btnDeletePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletePatient DP = new DeletePatient();
				DP.setVisible(true);
				dispose();
			}
		});
		btnDeletePatient.setBackground(Color.BLUE);
		btnDeletePatient.setForeground(Color.RED);

		btnDeletePatient.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDeletePatient.setBounds(153, 290, 196, 42);
		getContentPane().add(btnDeletePatient);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.MAGENTA);
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnNewButton_1.setBounds(51, 388, 126, 48);
		getContentPane().add(btnNewButton_1);

	}

}
