package com.zubiri.matchesGui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javafx.scene.control.Alert.*;
import javax.swing.SwingConstants;

import com.zubiri.matches.FootballTeam;
import com.zubiri.matches.Teams;

public class AddGui {

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
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private JMenuItem menuItem_1;
	private JMenuItem menuItem_2;
	private JMenu menu_1;
	private JMenuItem menuItem_3;
	private JLabel lblLocalTeam;
	private JTextPane textPaneLocalTeam;
	private JLabel lblVisitorTeam;
	private JTextPane textPaneVisitorTeam;
	private JLabel lblLocalGoals;
	private JTextPane textPaneLocalGoals;
	private JLabel lblVisitorGoals;
	private JTextPane textPaneVisitorGoals;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGui window = new AddGui();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
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

	private void fillMatchPanel() {
		lblLocalTeam = new JLabel("Local Team's name");
		lblLocalTeam.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblLocalTeam.setBounds(10, 11, 181, 35);
		panel.add(lblLocalTeam);

		frame.repaint();

		textPaneLocalTeam = new JTextPane();
		textPaneLocalTeam.setBackground(Color.LIGHT_GRAY);
		textPaneLocalTeam.setBounds(163, 11, 122, 35);
		panel.add(textPaneLocalTeam);

		lblLocalGoals = new JLabel("Local team's goals");
		lblLocalGoals.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblLocalGoals.setBackground(Color.LIGHT_GRAY);
		lblLocalGoals.setBounds(10, 57, 181, 35);

		panel.add(lblLocalGoals);

		textPaneLocalGoals = new JTextPane();
		textPaneLocalGoals.setBounds(163, 57, 122, 35);
		textPaneLocalGoals.setBackground(Color.LIGHT_GRAY);
		panel.add(textPaneLocalGoals);

		lblVisitorTeam = new JLabel("Visitor Team's name");
		lblVisitorTeam.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblVisitorTeam.setBounds(10, 103, 181, 35);
		panel.add(lblVisitorTeam);

		textPaneVisitorTeam = new JTextPane();

		textPaneVisitorTeam.setEditable(false);
		textPaneVisitorTeam.setBackground(Color.LIGHT_GRAY);
		textPaneVisitorTeam.setBounds(163, 103, 122, 35);
		textPaneVisitorTeam.setEditable(true);
		panel.add(textPaneVisitorTeam);

		lblVisitorGoals = new JLabel("Visitor team's goals");
		lblVisitorGoals.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblVisitorGoals.setBounds(10, 150, 181, 35);
		panel.add(lblVisitorGoals);

		textPaneVisitorGoals = new JTextPane();
		textPaneVisitorGoals.setBackground(Color.LIGHT_GRAY);
		textPaneVisitorGoals.setBounds(163, 150, 122, 35);
		panel.add(textPaneVisitorGoals);
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

		textPaneStadium.setBackground(Color.LIGHT_GRAY);
		textPaneStadium.setBounds(163, 57, 122, 35);
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

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 303, 42);
		frame.getContentPane().add(menuBar);

		menu = new JMenu("Consult");
		menuBar.add(menu);

		menuItem = new JMenuItem("Team");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatchGui matchGui;
				try {
					matchGui = new MatchGui();
					matchGui.getFrame().setVisible(true);
					matchGui.getCombobox().setSelectedItem("Team");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				frame.dispose();
			}
		});
		menu.add(menuItem);

		menuItem_1 = new JMenuItem("Player");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatchGui matchGui;
				try {
					matchGui = new MatchGui();
					matchGui.getFrame().setVisible(true);
					matchGui.getCombobox().setSelectedItem("Player");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				frame.dispose();
			}
		});
		menu.add(menuItem_1);

		menuItem_2 = new JMenuItem("Match");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatchGui matchGui;
				try {
					matchGui = new MatchGui();
					matchGui.getFrame().setVisible(true);
					matchGui.getCombobox().setSelectedItem("Match");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				frame.dispose();
			}
		});
		menu.add(menuItem_2);

		menu_1 = new JMenu("Manage");
		menuBar.add(menu_1);

		menuItem_3 = new JMenuItem("Delete");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteGui deleteGui;
				try {
					deleteGui = new DeleteGui();
					deleteGui.getFrame().setVisible(true);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				frame.dispose();
			}
		});
		menu_1.add(menuItem_3);

		JLabel lblModify = new JLabel("Add");
		lblModify.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModify.setFont(new Font("Verdana", Font.PLAIN, 31));
		lblModify.setBounds(10, 68, 139, 37);
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
				switch (comboBox.getSelectedItem().toString()) {
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
					panel.removeAll();
					panel.setVisible(true);
					fillMatchPanel();
					break;
				}
			}
		});
		comboBox.setBounds(159, 68, 113, 37);
		comboBox.addItem("Team");
		comboBox.addItem("Player");
		comboBox.addItem("Match");
		frame.getContentPane().add(comboBox);
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/matchesdb?user=root&password=root&useSSL=false&serverTimezone=UTC");
			Statement st = conn.createStatement();

			JButton btnAdd = new JButton("Confirm");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switch (comboBox.getSelectedItem().toString()) {
					case "Team":
						if (textPaneName.getText().isEmpty() || textPaneStadium.getText().isEmpty()
								|| textPaneWonLeagues.getText().isEmpty() || textPaneShirtColor.getText().isEmpty()) {
							JOptionPane.showMessageDialog(frame, "Please, fill all the gaps");
						} else {
							try {
								st.executeUpdate("insert into team(name,stadium,wonLeagues,shirtColor) values('" + textPaneName.getText().toLowerCase()
										+ "','" + textPaneStadium.getText().toLowerCase() + "',"
										+ textPaneWonLeagues.getText() + ",'"
										+ textPaneShirtColor.getText().toLowerCase() + "');");
								JOptionPane.showMessageDialog(frame, "Information added correctly");
								textPaneName.setText("");
								textPaneStadium.setText("");
								textPaneWonLeagues.setText("");
								textPaneShirtColor.setText("");
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						break;
					case "Player":
						if (textPanePlayerName.getText().isEmpty() || textPanePlayerTeam.getText().isEmpty()
								|| textPanePlayerAge.getText().isEmpty() || textPanePlayerHeight.getText().isEmpty()) {
							JOptionPane.showMessageDialog(frame, "Please, fill all the gaps");
						} else {
							try {
								st.executeUpdate("insert into player(name,team,age,height) values('" + textPanePlayerName.getText().toLowerCase()
										+ "','" + textPanePlayerTeam.getText().toLowerCase() + "',"
										+ textPanePlayerAge.getText() + "," + textPanePlayerHeight.getText() + ");");
								JOptionPane.showMessageDialog(frame, "Information added correctly");
								textPanePlayerName.setText("");
								textPanePlayerTeam.setText("");
								textPanePlayerAge.setText("");
								textPanePlayerHeight.setText("");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
						break;
					case "Match":
						/*
						 * read the teams and save them, checking if the team entered already exists
						 */
						try {
							if (textPaneLocalTeam.getText().isEmpty() || textPaneVisitorTeam.getText().isEmpty()
									|| textPaneLocalGoals.getText().isEmpty()
									|| textPaneVisitorGoals.getText().isEmpty()) {
								JOptionPane.showMessageDialog(frame, "Please, fill all the gaps");
							} else {
								ResultSet rs = st.executeQuery("select * from team where name='" + textPaneLocalTeam.getText()+ "';");
								if (rs.next()) {
									ResultSet rsCounter = st.executeQuery("select * from matches");
									rsCounter.last();
									st.executeUpdate("insert into matches values('"
											+ textPaneLocalTeam.getText().toLowerCase() + "','"
											+ textPaneVisitorTeam.getText().toLowerCase() + "',"
											+ textPaneLocalGoals.getText() + "," + textPaneVisitorGoals.getText() + ","
											+(rsCounter.getInt("id")+1)+");");
									JOptionPane.showMessageDialog(frame, "Information added correctly");
									textPaneLocalTeam.setText("");
									textPaneVisitorTeam.setText("");
									textPaneLocalGoals.setText("");
									textPaneVisitorGoals.setText("");
								} else {
									JOptionPane.showMessageDialog(frame, "Enter an existing local team or create it before");
								}
							}
							/* Original code
							 * ResultSet rs = st.executeQuery("select * from team where name='" + textPaneLocalTeam.getText()+ "';");
							ResultSet rs2= st.executeQuery("select * from team where name='" + textPaneVisitorTeam.getText() + "';");
							if (textPaneLocalTeam.getText().isEmpty() || textPaneVisitorTeam.getText().isEmpty()
									|| textPaneLocalGoals.getText().isEmpty()
									|| textPaneVisitorGoals.getText().isEmpty()) {
								JOptionPane.showMessageDialog(frame, "Please, fill all the gaps");
							} else if (!rs.next()) {
								JOptionPane.showMessageDialog(frame, "Enter an existing local team or create it before");
							} else if (!rs2.next()) {
								JOptionPane.showMessageDialog(frame, "Enter an existing visitor team or create it before");
							}else {
								st.executeUpdate("insert into matches values('"
										+ textPaneLocalTeam.getText().toLowerCase() + "','"
										+ textPaneVisitorTeam.getText().toLowerCase() + "',"
										+ textPaneLocalGoals.getText() + "," + textPaneVisitorGoals.getText() + ");");
								JOptionPane.showMessageDialog(frame, "Information added correctly");
								textPaneLocalTeam.setText("");
								textPaneVisitorTeam.setText("");
								textPaneLocalGoals.setText("");
								textPaneVisitorGoals.setText("");
							}
							 */
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						break;
					}

				}

			});
			btnAdd.setBounds(0, 368, 301, 37);
			frame.getContentPane().add(btnAdd);
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
