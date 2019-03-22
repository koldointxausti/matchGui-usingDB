package com.zubiri.matchesGui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.Action;
import com.zubiri.matches.*;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class MatchGui {

	private JFrame frame;
	private JTextField txtFindForA;
	private final Action action = new SwingAction();
	private JComboBox comboBox;
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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchGui window = new MatchGui();
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
	public MatchGui() {
		initialize();
	}

	public JFrame getFrame() {
		return this.frame;
	}
	
	public JComboBox getCombobox() {
		return this.comboBox;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 311, 455);
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
				MatchGui matchGui = new MatchGui();
				matchGui.getFrame().setVisible(true);
				matchGui.getCombobox().setSelectedItem("Team");
				frame.dispose();
			}
		});
		menu.add(menuItem);
		
		menuItem_1 = new JMenuItem("Player");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatchGui matchGui = new MatchGui();
				matchGui.getFrame().setVisible(true);
				matchGui.getCombobox().setSelectedItem("Player");
				frame.dispose();
			}
		});
		menu.add(menuItem_1);
		
		menuItem_2 = new JMenuItem("Match");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatchGui matchGui = new MatchGui();
				matchGui.getFrame().setVisible(true);
				matchGui.getCombobox().setSelectedItem("Match");
				frame.dispose();
			}
		});
		menu.add(menuItem_2);
		
		menu_1 = new JMenu("Edit");
		menuBar.add(menu_1);
		
		menuItem_3 = new JMenuItem("Add");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddGui modifyGUI = new AddGui();
				modifyGUI.getFrame().setVisible(true);

				frame.dispose();
			}
		});
		menu_1.add(menuItem_3);
		
		panel = new JPanel();
		panel.setBounds(0, 159, 295, 257);
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtFindForA = new JTextField();
		txtFindForA.setText("barcelona");
		txtFindForA.setBounds(102, 61, 183, 35);
		txtFindForA.setToolTipText("");
		frame.getContentPane().add(txtFindForA);
		txtFindForA.setColumns(10);
		
		JButton btnNewButton = new JButton("Find");
		btnNewButton.setBounds(10, 107, 275, 41);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(comboBox.getSelectedItem().toString().toLowerCase()){
					case "team":
					panel.removeAll();
					panel.setVisible(true);
			
								
					File toReadTeam = new File("src/TeamInfo.txt");
					Teams teams = new Teams();
					try {
						Scanner sc = new Scanner(toReadTeam);
						while (sc.hasNextLine()) {
							FootballTeam team1 = new FootballTeam();
							String lineValues[] = sc.nextLine().split("::");
							team1.setName(lineValues[0]);
							team1.setStadium(lineValues[1]);
							team1.setWonLeagues(Integer.parseInt(lineValues[2]));
							team1.setShirtColor(lineValues[3]);
							teams.add(team1);
						}
						
						int position = teams.findTeam(txtFindForA.getText().toLowerCase());
						if(position >= 0) {
							
							lblName = new JLabel("Name");
							lblName.setBackground(Color.cyan);
							lblName.setFont(new Font("Verdana", Font.PLAIN, 14));
							lblName.setBounds(10, 11, 81, 35);
							lblName.setEnabled(true); //Proba Sonia
							lblName.setName("Kaixo");
							panel.add(lblName);
							
							//Sonia
			                frame.repaint();
							//<-
							
							textPaneName = new JTextPane();
							textPaneName.setBackground(Color.LIGHT_GRAY);
							textPaneName.setBounds(163, 11, 122, 35);
							textPaneName.setEditable(false);
							panel.add(textPaneName);
							textPaneName.setText(teams.getTeam(position).getName());
							
							lblStadium = new JLabel("Stadium");
							lblStadium.setFont(new Font("Verdana", Font.PLAIN, 14));
							lblStadium.setBounds(10, 57, 81, 35);
							panel.add(lblStadium);
							
							textPaneStadium = new JTextPane();
							
							textPaneStadium.setEditable(false);
							textPaneStadium.setBackground(Color.LIGHT_GRAY);
							textPaneStadium.setBounds(163, 57, 122, 35);
							panel.add(textPaneStadium);
							
							textPaneStadium.setText(teams.getTeam(position).getStadium());
							
							lblWonLeagues = new JLabel("Won leagues");
							lblWonLeagues.setText("Won leages");
							lblWonLeagues.setFont(new Font("Verdana", Font.PLAIN, 14));
							lblWonLeagues.setBackground(Color.LIGHT_GRAY);
							lblWonLeagues.setBounds(10, 103, 122, 35);

							panel.add(lblWonLeagues);
							
							textPaneWonLeagues = new JTextPane();
							textPaneWonLeagues.setBounds(163, 103, 122, 35);
							textPaneWonLeagues.setBackground(new Color(204, 204, 204));
							textPaneWonLeagues.setEditable(false);
							panel.add(textPaneWonLeagues);
							
							
							textPaneWonLeagues.setText(Integer.toString(teams.getTeam(position).getWonLeagues()));
							
							lblShirtColor = new JLabel("Shirt color");
							lblShirtColor.setFont(new Font("Verdana", Font.PLAIN, 14));
							lblShirtColor.setBounds(10, 150, 81, 35);
							panel.add(lblShirtColor);
							
							textPaneShirtColor = new JTextPane();
							textPaneShirtColor.setBackground(Color.LIGHT_GRAY);
							textPaneShirtColor.setBounds(163, 150, 122, 35);
							textPaneShirtColor.setEditable(false);
							panel.add(textPaneShirtColor);
								
							textPaneShirtColor.setText(teams.getTeam(position).getShirtColor());
							
						}else {
							textPaneName.setText("Not found");
							textPaneStadium.setText("Not found");
							textPaneWonLeagues.setText("Not found");
							textPaneShirtColor.setText("Not found");
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println("Unable to check the sport");
					}
					break;
				case "player":
					panel.removeAll();
					panel.setVisible(true);
					File toReadPlayers = new File("src/Players.txt");
					Players players = new Players();
					try {
						Scanner sc = new Scanner(toReadPlayers);
						while (sc.hasNextLine()) {
							Player player1 = new Player();
							String lineValues[] = sc.nextLine().split("::");
							player1.setName(lineValues[0]);
							player1.setTeam(lineValues[1]);
							player1.setAge(Integer.parseInt(lineValues[2]));
							player1.setHeight(Integer.parseInt(lineValues[3]));
							player1.setSport("football");
							players.add(player1);
						}
						
						int position = players.findPlayer(txtFindForA.getText().toLowerCase());
						if(position >= 0) {
							JPanel a = new JPanel();
							
							label = new JLabel("Name");
							label.setFont(new Font("Verdana", Font.PLAIN, 14));
							label.setBounds(10, 11, 81, 35);
							label.setBackground(new Color(1, 25, 44));
							label.setEnabled(true); //Proba Sonia
							
							panel.add(label);
							
							frame.repaint();
							
							textPanePlayerName = new JTextPane();
							textPanePlayerName.setBackground(Color.LIGHT_GRAY);
							textPanePlayerName.setBounds(163, 11, 122, 35);
							textPanePlayerName.setEditable(false);

							panel.add(textPanePlayerName);
							
							lblAge = new JLabel("Age");
							lblAge.setFont(new Font("Verdana", Font.PLAIN, 14));
							lblAge.setBounds(10, 57, 81, 35);
							panel.add(lblAge);
							
							textPanePlayerAge = new JTextPane();
							textPanePlayerAge.setBackground(Color.LIGHT_GRAY);
							textPanePlayerAge.setBounds(163, 57, 122, 35);
							textPanePlayerAge.setEditable(false);
							panel.add(textPanePlayerAge);
									
							JLabel lblHeight = new JLabel("Height");
							lblHeight.setFont(new Font("Verdana", Font.PLAIN, 14));
							lblHeight.setBounds(10, 103, 122, 35);
							lblHeight.setBackground(new Color(204, 204, 204));
							panel.add(lblHeight);
							
							textPanePlayerHeight = new JTextPane();
							textPanePlayerHeight.setBackground(Color.LIGHT_GRAY);
							textPanePlayerHeight.setBounds(163, 103, 122, 35);
							textPanePlayerHeight.setEditable(false);
							panel.add(textPanePlayerHeight);
							
							lblTeam = new JLabel("Team");
							lblTeam.setFont(new Font("Verdana", Font.PLAIN, 14));
							lblTeam.setBounds(10, 149, 122, 35);
							panel.add(lblTeam);
							
							textPanePlayerTeam = new JTextPane();
							textPanePlayerTeam.setBackground(Color.LIGHT_GRAY);
							textPanePlayerTeam.setBounds(163, 149, 122, 35);
							textPanePlayerTeam.setEditable(false);

							panel.add(textPanePlayerTeam);
							
							textPanePlayerName.setText(players.getPlayer(position).getName());
							textPanePlayerTeam.setText(players.getPlayer(position).getTeam());
							textPanePlayerAge.setText(Integer.toString(players.getPlayer(position).getAge()));
							textPanePlayerHeight.setText(Integer.toString(players.getPlayer(position).getHeight()));
						}else {
							textPanePlayerName.setText("Not found");
							textPanePlayerTeam.setText("Not found");
							textPanePlayerAge.setText("Not found");
							textPanePlayerHeight.setText("Not found");
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println("Unable to check the sport");
					}
					break;
				case "match":
					panel.removeAll();
					panel.setVisible(true);
					frame.repaint();
					JTextArea textArea = new JTextArea();
					textArea.setBounds(0, 0, 295, 257);
					panel.add(textArea);
					File toReadMatches = new File("src/MatchInfo.txt");
					ArrayList<FootballMatch> matches = new ArrayList<FootballMatch>();
					
					try {
						Scanner sc = new Scanner(toReadMatches);
						while(sc.hasNextLine()) {
							FootballMatch match = new FootballMatch();
							String lineValues[] = sc.nextLine().split("::");
							match.setLocalTeam(lineValues[0]);
							match.setVisitorTeam(lineValues[1]);
							match.setGoalsLocal(Integer.parseInt(lineValues[2]));
							match.setGoalsVisitor(Integer.parseInt(lineValues[3]));
							matches.add(match);
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					break;
				}
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setBackground(Color.WHITE);
		frame.getContentPane().add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 61, 82, 35);
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setBackground(Color.WHITE);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Team");
		comboBox.addItem("Player");
		comboBox.addItem("Match");
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Find");
			putValue(SHORT_DESCRIPTION, "find information about the selected category");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
