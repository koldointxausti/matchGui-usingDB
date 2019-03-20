import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.zubiri.matchesGui.MatchGui;
import com.zubiri.matchesGui.AddGui;

import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class MenuGui {

	private JFrame frame;
	private BufferedImage image;
	/*
	 * private final Action action = new SwingAction(); private final Action
	 * action_1 = new SwingAction_1(); private final Action action_2 = new
	 * SwingAction_2(); private final Action action_3 = new SwingAction_3();
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGui window = new MenuGui();
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
	public MenuGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 319, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 303, 42);
		frame.getContentPane().add(menuBar);

		JMenu mnConsult = new JMenu("Consult");
		menuBar.add(mnConsult);

		JMenuItem mntmTeam = new JMenuItem("Team");
		// mntmTeam.setAction(action);
		mntmTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatchGui matchGui = new MatchGui();
				matchGui.getFrame().setVisible(true);
				matchGui.getCombobox().setSelectedItem("Team");
				frame.dispose();
			}
		});
		mnConsult.add(mntmTeam);

		JMenuItem mntmPlayer = new JMenuItem("Player");
		// mntmPlayer.setAction(action_1);
		mntmPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatchGui matchGui = new MatchGui();
				matchGui.getFrame().setVisible(true);
				matchGui.getCombobox().setSelectedItem("Player");
				frame.dispose();
			}
		});
		mnConsult.add(mntmPlayer);

		JMenuItem mntmMatch = new JMenuItem("Match");
		// mntmMatch.setAction(action_3);
		mntmMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatchGui matchGui = new MatchGui();
				matchGui.getFrame().setVisible(true);
				matchGui.getCombobox().setSelectedItem("Match");
				frame.dispose();
			}
		});
		mnConsult.add(mntmMatch);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmModify = new JMenuItem("Add");
		mnEdit.add(mntmModify);
		// mntmModify.setAction(action_2);
		mntmModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddGui modifyGUI = new AddGui();
				modifyGUI.getFrame().setVisible(true);

				frame.dispose();
			}
		});

		JMenuItem mntmDelete = new JMenuItem("Delete");
		mnEdit.add(mntmDelete);
		/*
		 * private class SwingAction extends AbstractAction { public SwingAction() {
		 * putValue(NAME, "Team"); putValue(SHORT_DESCRIPTION, ""); }
		 * 
		 * public void actionPerformed(ActionEvent e) { } } class SwingAction_1 extends
		 * AbstractAction { public SwingAction_1() { putValue(NAME, "Player");
		 * putValue(SHORT_DESCRIPTION, "Some short description"); }
		 * 
		 * public void actionPerformed(ActionEvent e) { } } private class SwingAction_2
		 * extends AbstractAction { public SwingAction_2() { putValue(NAME, "Match");
		 * putValue(SHORT_DESCRIPTION, "Some short description"); }
		 * 
		 * public void actionPerformed(ActionEvent e) { } }
		 * 
		 */


	}
}
