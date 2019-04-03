package com.zubiri.matchesGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.Component;

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
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	public MatchGui() throws ClassNotFoundException {
		initialize();
	}

	public JFrame getFrame() {
		return this.frame;
	}

	public JComboBox getCombobox() {
		return this.comboBox;
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
		panel.add(textPaneStadium);

		lblWonLeagues = new JLabel("Won leagues");
		lblWonLeagues.setText("Won leages");
		lblWonLeagues.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblWonLeagues.setBackground(Color.LIGHT_GRAY);
		lblWonLeagues.setBounds(10, 103, 122, 35);

		panel.add(lblWonLeagues);

		textPaneWonLeagues = new JTextPane();
		textPaneWonLeagues.setBounds(163, 103, 122, 35);
		textPaneWonLeagues.setBackground(new Color(204, 204, 204));
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
	 * 
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws ClassNotFoundException {
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

		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteGui deleteGui = new DeleteGui();
				deleteGui.getFrame().setVisible(true);

				frame.dispose();
			}
		});
		menu_1.add(mntmDelete);

		panel = new JPanel();
		panel.setBounds(0, 159, 295, 257);
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		txtFindForA = new JTextField();
		txtFindForA.setBounds(102, 61, 183, 35);
		txtFindForA.setToolTipText("");
		frame.getContentPane().add(txtFindForA);
		txtFindForA.setColumns(10);

		//CONNECTION WITH DATABASE
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/matchesdb?user=root&password=root&useSSL=false&serverTimezone=UTC");
			Statement st = conn.createStatement();

			JButton btnNewButton = new JButton("Find");
			frame.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						btnNewButton.getAction();
						System.out.println("OK");
					}
				}
			});
			btnNewButton.setBounds(10, 107, 275, 41);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switch (comboBox.getSelectedItem().toString().toLowerCase()) {
					case "team":
						panel.removeAll();
						panel.setVisible(true);
						ResultSet rs;
						try {
							rs = st.executeQuery("select * from team where name = '"+txtFindForA.getText().toLowerCase()+"'");
							if (rs.next()) {
								fillTeamPanel();
								lblName.setEnabled(true);
								textPaneName.setEditable(false);
								textPaneName.setText(rs.getString("name"));
								textPaneStadium.setEditable(false);
								textPaneStadium.setText(rs.getString("stadium"));
								textPaneWonLeagues.setEditable(false);
								textPaneWonLeagues.setText(Integer.toString(rs.getInt("wonLeagues")));
								textPaneShirtColor.setEditable(false);
								textPaneShirtColor.setText(rs.getString("shirtColor"));
							} else
								JOptionPane.showMessageDialog(frame, "Not found");
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					case "player":
						panel.removeAll();
						panel.setVisible(true);
						try {
							rs = st.executeQuery("select * from player where name ='"+txtFindForA.getText().toLowerCase()+"'");
							if (rs.next()) {
								fillPlayerPanel();
								textPanePlayerName.setEditable(false);
								textPanePlayerAge.setEditable(false);
								textPanePlayerHeight.setEditable(false);
								textPanePlayerTeam.setEditable(false);

								textPanePlayerName.setText(rs.getString("name"));
								textPanePlayerTeam.setText(rs.getString("team"));
								textPanePlayerAge.setText(Integer.toString(rs.getInt("age")));
								textPanePlayerHeight.setText(Integer.toString(rs.getInt("height")));
							} else
								JOptionPane.showMessageDialog(frame, "Not found");

						} catch (SQLException e) {
							e.printStackTrace();
						}
						
						break;
					case "match":
						panel.removeAll();
						panel.setVisible(true);
						JTextArea textArea = new JTextArea();
						textArea.setBounds(34, 0, 232, 257);
						textArea.setFont(new Font("Verdana", Font.PLAIN, 13));
						textArea.setEditable(false);
						textArea.setAutoscrolls(true);
						panel.add(textArea);
						
						try {
							rs = st.executeQuery("select * from matches where localTeam ='"+txtFindForA.getText()+"' or visitorTeam ='" + txtFindForA.getText()+"'");
							if(rs.next())
								while(rs.next()) {
									textArea.append(rs.getString("name") + " "
											+ rs.getString("goalsLocal") + " - " + rs.getString("goalsVisitor") + "  "
											+ rs.getString("visitorTeam") + "\n");
								}
							else
								JOptionPane.showMessageDialog(frame, "Not found");
							
						} catch (SQLException e) {
							e.printStackTrace();
						}
													
						frame.repaint();

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
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
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
