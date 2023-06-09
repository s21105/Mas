package gui;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MenuStart {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuStart window = new MenuStart();
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
	public MenuStart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("System BVT");
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 460, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("11.png"));
		label.setBounds(232, 11, 212, 200);
		frame.getContentPane().add(label);
		
		JButton btnDisplayThem = new JButton("Add a volleyball player");
		btnDisplayThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				 
				MenuAddingVolleyballer menu = null;
				try {
					menu = new MenuAddingVolleyballer();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				menu.getFrame().setVisible(true);
				frame.setVisible(false);
				 
				
			}
		});
		btnDisplayThem.setBounds(10, 13, 200, 23);
		frame.getContentPane().add(btnDisplayThem);
		
		JButton button = new JButton("Show the volleyball players");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuShowingVolleyballers menu = null;
				try {
					menu = new MenuShowingVolleyballers();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menu.getFrame().setVisible(true);
				frame.setVisible(false);
			 
				
			}
		});
		button.setBounds(10, 47, 200, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Add a player to team");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuAddingVolleyballerToTeam menu = null;
				try {
					menu = new MenuAddingVolleyballerToTeam();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menu.getFrame().setVisible(true);
				frame.setVisible(false);
			 
			}
		});
		button_1.setBounds(10, 146, 200, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Add team");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuAddingTeam menu = null;
				try {
					menu = new MenuAddingTeam();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menu.getFrame().setVisible(true);
				frame.setVisible(false);
	 
			}
		});
		button_2.setBounds(10, 81, 200, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Show teams");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuShowingTeams menu = null;
				try {
					menu = new MenuShowingTeams();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menu.getFrame().setVisible(true);
				frame.setVisible(false);
				
				
			}
		});
		button_3.setBounds(10, 115, 200, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Show team players");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 MenuShowingVolleyballersInTeam menu = null;
				try {
					menu = new MenuShowingVolleyballersInTeam();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menu.getFrame().setVisible(true);
				frame.setVisible(false);
				
			}
		});
		button_4.setBounds(10, 180, 200, 23);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("Show player's teams");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuShowingVolleyballerTeam menu = null;
				try {
					menu = new MenuShowingVolleyballerTeam();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menu.getFrame().setVisible(true);
				frame.setVisible(false);
				
				
			}
		});
		button_5.setBounds(10, 214, 200, 23);
		frame.getContentPane().add(button_5);
	}

	public Window getFrame() {
	
		return frame;
	}

}
