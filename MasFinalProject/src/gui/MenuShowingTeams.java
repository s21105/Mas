package gui;

import voleyballers.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

public class MenuShowingTeams {

	private JFrame frame;
	// same as in class add item
	private DefaultListModel<TrainingTeam> trainingTeams = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuShowingTeams window = new MenuShowingTeams();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws Exception
	 */
	public MenuShowingTeams() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		frame = new JFrame("Team display menu ");
		frame.setBounds(100, 100, 299, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Extension"))) {
			ObjectPlus.Load(ois);
		} catch (Exception e) {
			System.out.println("No extension");
		}

		try {
			for (TrainingTeam zt : ObjectPlus.getExtension(TrainingTeam.class)) {
				trainingTeams.addElement(zt);
			}

		} catch (NullPointerException e) {
			System.out.println("No extension");
		}

		// we add jlists and immediately throw them as a parameter
		// default list of models so you can add something to them later
		JList<TrainingTeam> list = new JList<>(trainingTeams);
		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(10, 50, 264, 253);
		frame.getContentPane().add(scroll);

		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

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
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(184, 314, 85, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel labelClient = new JLabel("Teams at the base:");
		labelClient.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelClient.setBounds(10, 11, 158, 28);
		frame.getContentPane().add(labelClient);

		list.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					JOptionPane.showMessageDialog(null, "You can select only one item");
				}
			}
		});

		list.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
					JOptionPane.showMessageDialog(null, "You can select only one item");
				}
			}
		});

		JButton button = new JButton("Show team level");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (list.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "You must select a team");
				} else {

					TrainingTeam zt1 = (TrainingTeam) list.getSelectedValue();

					JOptionPane.showMessageDialog(null, zt1 + " is level " + zt1.getLevel());

				}

			}
		});
		button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button.setBounds(10, 315, 158, 23);
		frame.getContentPane().add(button);

	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
