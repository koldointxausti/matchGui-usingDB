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
import javax.swing.JTextArea;
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
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javafx.scene.control.Alert.*;
import javax.swing.SwingConstants;

import com.zubiri.matches.FootballMatch;
import com.zubiri.matches.FootballTeam;
import com.zubiri.matches.Player;
import com.zubiri.matches.Players;
import com.zubiri.matches.Teams;

import javax.swing.JTextField;

public class DeleteGui{

	private JFrame frame;
	private JTextPane textPaneName;
	private JLabel lblName;
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
	private JTextField textField;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteGui window = new DeleteGui();
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
	 * @throws ClassNotFoundException 
	 */
	public DeleteGui() throws ClassNotFoundException {
		initialize();
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException {
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

		menuItem_3 = new JMenuItem("Add");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddGui addGui = new AddGui();
				addGui.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		menu_1.add(menuItem_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(159, 68, 113, 37);
		comboBox.addItem("Team");
		comboBox.addItem("Player");
		frame.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBounds(10, 177, 170, 35);
		frame.getContentPane().add(textField);
		
		
		
		//CONNECTION TO DATABASE:
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/matchesdb?user=root&password=root&useSSL=false&serverTimezone=UTC");
			Statement st = conn.createStatement();
			
			button = new JButton("Find");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switch (comboBox.getSelectedItem().toString().toLowerCase()) {
					case "team":
						ResultSet rs;
						try {
							rs = st.executeQuery("select * from team where name = '"+textField.getText()+"';");
							if(rs.next()) {
								st.executeUpdate("delete from team where name='"+textField.getText()+"';");
								JOptionPane.showMessageDialog(frame, "Deleted succesfully");
							}else 
								JOptionPane.showMessageDialog(frame, "Not found");
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					case "player":
						try {
							rs = st.executeQuery("select * from player where name='"+textField.getText()+"';");
							if(rs.next()) {
								st.executeUpdate("delete from player where name='"+textField.getText()+"';");
								JOptionPane.showMessageDialog(frame, "Information deleted succesfully");
							}else 
								JOptionPane.showMessageDialog(frame, "Not found");
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					}
				}
			});
			button.setBackground(Color.WHITE);
			button.setBounds(190, 177, 101, 35);
			frame.getContentPane().add(button);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		JLabel lblModify = new JLabel("Delete");
		lblModify.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModify.setFont(new Font("Verdana", Font.PLAIN, 31));
		lblModify.setBounds(0, 68, 149, 37);
		frame.getContentPane().add(lblModify);
		
		
		
	}
}
