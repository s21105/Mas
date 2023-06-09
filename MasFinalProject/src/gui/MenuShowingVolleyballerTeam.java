package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import voleyballers.*;

import javax.swing.JButton;

public class MenuShowingVolleyballerTeam {

	private JFrame frame;

	private List<Object> ob;
	// list to post things later on Jlist
	private final DefaultListModel<Volleyballer> listVolleyballers = new DefaultListModel<>();
	private final DefaultListModel<TrainingTeam> listTeams = new DefaultListModel<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuShowingVolleyballerTeam window = new MenuShowingVolleyballerTeam();
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
	public MenuShowingVolleyballerTeam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("The Menu to show the player's teams");
		frame.setBounds(100, 100, 534, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"Extension"))) {
			ObjectPlus.Load(ois);
		} catch (Exception e) {
			System.out.println("No extension");
		}

		try {

			for (Volleyballer p : ObjectPlus.getExtension(Volleyballer.class)) {
				listVolleyballers.addElement(p);
			}
		} catch (NullPointerException e) {

		}

		// lists, labels etc.
		JList<Volleyballer> volleyballerList = new JList<>(listVolleyballers);
		JScrollPane scroll = new JScrollPane(volleyballerList);
		scroll.setBounds(15, 31, 222, 269);
		frame.getContentPane().add(scroll);

		JList<TrainingTeam>teamsList = new JList<>(listTeams);
		JScrollPane scroll2 = new JScrollPane(teamsList);
		scroll2.setBounds(262, 32, 232, 269);
		frame.getContentPane().add(scroll2);

        JLabel labelTeam = new JLabel("Choose team");
        labelTeam.setBounds(262, 7, 107, 20);
        labelTeam.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(labelTeam);

		JLabel labelVolleyballer = new JLabel("Choose a volleyball player");
		labelVolleyballer.setBounds(15, 7, 195, 20);
		labelVolleyballer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(labelVolleyballer);

		volleyballerList.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					JOptionPane.showMessageDialog(null,
							"You can select only one item");
				}
			}
		});

		volleyballerList.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
					JOptionPane.showMessageDialog(null,
							"You can select only one item");
				}
			}
		});

		JButton btnNewButton = new JButton("Show team of the volleyballer");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {

				// service if we do not mark anything on the list
				if ((volleyballerList.getSelectedValue() == null)) {

					JOptionPane.showMessageDialog(null, "Select the player");
				} else {

					// we create an object based on a selection from the list
					Volleyballer p = (Volleyballer) volleyballerList.getSelectedValue();

			 
					// clear jlist from the right side
					listTeams.clear();

					if (p.showTeams().size() == 0) {
						JOptionPane.showMessageDialog(null,
								"The player does not belong to any team");
						return;
					}

					// in the loop we throw all the teams of the player on the yellow
					for (int x = 0; x < p.showTeams().size(); x++) {
						listTeams.addElement(p.showTeams().get(x));

					}

				}

			}
		});
		btnNewButton.setBounds(50, 311, 222, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnWr = new JButton("Return");
		btnWr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuStart menu = null;
				try {
					menu = new MenuStart();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menu.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		btnWr.setBounds(290, 311, 107, 23);
		frame.getContentPane().add(btnWr);

	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
