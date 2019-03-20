package com.zubiri.matchesGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

public class AddGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGui window = new AddGui();
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
	public AddGui() {
		initialize();
	}
	
	public JFrame getFrame() {
		return this.frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 317, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblModify = new JLabel("Add");
		lblModify.setFont(new Font("Verdana", Font.PLAIN, 39));
		lblModify.setBounds(101, 20, 98, 49);
		frame.getContentPane().add(lblModify);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(86, 80, 113, 37);
		comboBox.addItem("Team");
		comboBox.addItem("Player");
		comboBox.addItem("Match");
		frame.getContentPane().add(comboBox);
	}
}
