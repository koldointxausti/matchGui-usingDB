package com.zubiri.matchesGui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javafx.scene.control.Alert.*;

public class AddGui{

	private JFrame frame;
	private JTextPane textPaneName;
	private JLabel lblName;
	private JPanel panel;
	private JTextPane textPaneStadium;
	private JLabel lblStadium;
	private JTextPane textPaneWonLeagues;
	private JLabel lblWonLeagues;
	private JTextPane textPaneShirtColor;
	private JLabel lblShirtColor;
	private JLabel label;
	private JTextPane textPanePlayerName;
	private JTextPane textPanePlayerTeam;
	private JLabel lblTeam;
	private JTextPane textPanePlayerAge;
	private JLabel lblAge;
	private JTextPane textPanePlayerHeight;

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
	private void fillTeamPanel() {
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblName.setBounds(10, 11, 81, 35);
		panel.add(lblName);

		frame.repaint();

		textPaneName = new JTextPane();
		textPaneName.setBackground(Color.LIGHT_GRAY);
		textPaneName.setBounds(163, 11, 122, 35);
		panel.add(textPaneName);

		lblStadium = new JLabel("Stadium");
		lblStadium.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblStadium.setBounds(10, 57, 81, 35);
		panel.add(lblStadium);

		textPaneStadium = new JTextPane();

		textPaneStadium.setEditable(false);
		textPaneStadium.setBackground(Color.LIGHT_GRAY);
		textPaneStadium.setBounds(163, 57, 122, 35);
		textPaneStadium.setEditable(true);
		panel.add(textPaneStadium);


		lblWonLeagues = new JLabel("Won leagues");
		lblWonLeagues.setText("Won leages");
		lblWonLeagues.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblWonLeagues.setBackground(Color.LIGHT_GRAY);
		lblWonLeagues.setBounds(10, 103, 122, 35);

		panel.add(lblWonLeagues);

		textPaneWonLeagues = new JTextPane();
		textPaneWonLeagues.setBounds(163, 103, 122, 35);
		textPaneWonLeagues.setBackground(Color.LIGHT_GRAY);
		panel.add(textPaneWonLeagues);


		lblShirtColor = new JLabel("Shirt color");
		lblShirtColor.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblShirtColor.setBounds(10, 150, 81, 35);
		panel.add(lblShirtColor);

		textPaneShirtColor = new JTextPane();
		textPaneShirtColor.setBackground(Color.LIGHT_GRAY);
		textPaneShirtColor.setBounds(163, 150, 122, 35);
		panel.add(textPaneShirtColor);
	}
	
	private void fillPlayerPanel() {
		label = new JLabel("Name");
		label.setFont(new Font("Verdana", Font.PLAIN, 14));
		label.setBounds(10, 11, 81, 35);
		label.setBackground(new Color(1, 25, 44));
		label.setEnabled(true); 

		panel.add(label);

		frame.repaint();

		textPanePlayerName = new JTextPane();
		textPanePlayerName.setBackground(Color.LIGHT_GRAY);
		textPanePlayerName.setBounds(163, 11, 122, 35);

		panel.add(textPanePlayerName);

		lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblAge.setBounds(10, 57, 81, 35);
		panel.add(lblAge);

		textPanePlayerAge = new JTextPane();
		textPanePlayerAge.setBackground(Color.LIGHT_GRAY);
		textPanePlayerAge.setBounds(163, 57, 122, 35);
		panel.add(textPanePlayerAge);

		JLabel lblHeight = new JLabel("Height");
		lblHeight.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblHeight.setBounds(10, 103, 122, 35);
		lblHeight.setBackground(new Color(204, 204, 204));
		panel.add(lblHeight);

		textPanePlayerHeight = new JTextPane();
		textPanePlayerHeight.setBackground(Color.LIGHT_GRAY);
		textPanePlayerHeight.setBounds(163, 103, 122, 35);
		panel.add(textPanePlayerHeight);

		lblTeam = new JLabel("Team");
		lblTeam.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTeam.setBounds(10, 149, 122, 35);
		panel.add(lblTeam);

		textPanePlayerTeam = new JTextPane();
		textPanePlayerTeam.setBackground(Color.LIGHT_GRAY);
		textPanePlayerTeam.setBounds(163, 149, 122, 35);

		panel.add(textPanePlayerTeam);
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
		lblModify.setFont(new Font("Verdana", Font.PLAIN, 31));
		lblModify.setBounds(53, 68, 96, 37);
		frame.getContentPane().add(lblModify);
		panel = new JPanel();
		panel.setBounds(0, 109, 301, 257);
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(comboBox.getSelectedItem().toString()){
				case "Team":
					panel.removeAll();
					panel.setVisible(true);
					fillTeamPanel();
					break;
				case "Player":
					panel.removeAll();
					panel.setVisible(true);
					fillPlayerPanel();
					break;
				case "Match":
					
					break;
			}
			}
		});
		comboBox.setBounds(159, 68, 113, 37);
		comboBox.addItem("Team");
		comboBox.addItem("Player");
		comboBox.addItem("Match");
		frame.getContentPane().add(comboBox);
		
		JButton btnAdd = new JButton("Confirm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(comboBox.getSelectedItem().toString()) {
				case "Team":
					if(textPaneName.getText().isEmpty()||
							textPaneStadium.getText().isEmpty()||
							textPaneWonLeagues.getText().isEmpty()||
							textPaneShirtColor.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Please, fill all the gaps");
					}else {
						FileWriter fw = new FileWriter();
					}
					break;
				case "Player":
					if(textPanePlayerName.getText().isEmpty()||
							textPanePlayerTeam.getText().isEmpty()||
							textPanePlayerAge.getText().isEmpty()||
							textPanePlayerHeight.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Please, fill all the gaps");
					}else {
						
					}
					break;
				case "Match":
					
					break;
				}
				
			}
		});
		btnAdd.setBounds(0, 368, 301, 37);
		frame.getContentPane().add(btnAdd);
		
		
		
	}
}
