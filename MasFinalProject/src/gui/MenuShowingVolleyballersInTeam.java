package gui;

import voleyballers.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class MenuShowingVolleyballersInTeam {

	private JFrame frame;

	private List<Object> ob;
	// list to post things later on Jlist
	private final DefaultListModel<Volleyballer> listVolleyballers = new DefaultListModel<>();
	private final DefaultListModel<TrainingTeam> listTeams = new DefaultListModel<>();
	private JButton button = new JButton("Remove volleyballer from team");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuShowingVolleyballersInTeam window = new MenuShowingVolleyballersInTeam();
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
	public MenuShowingVolleyballersInTeam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Menu to show team players");
		frame.setBounds(100, 100, 515, 375);
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
			for (TrainingTeam zt : ObjectPlus.getExtension(TrainingTeam.class)) {
				listTeams.addElement(zt);
			}
		}catch(NullPointerException e) {
			
		}
		

		// lists, labels etc
		
		
		JList<TrainingTeam> teamsList = new JList<>(listTeams);
		JScrollPane scroll = new JScrollPane(teamsList);
		scroll.setBounds(13, 31, 222, 269);
		frame.getContentPane().add(scroll);

		JList<Volleyballer> volleyballersList = new JList<>(listVolleyballers);
		JScrollPane scroll2 = new JScrollPane(volleyballersList);
		scroll2.setBounds(256, 32, 232, 269);
		frame.getContentPane().add(scroll2);

		JLabel labelTeam = new JLabel("Choose team");
        labelTeam.setBounds(13, 7, 107, 20);
        labelTeam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(labelTeam);

		JLabel labelVolleyballer = new JLabel("Choose a volleyball player");
		labelVolleyballer.setBounds(256, 7, 195, 20);
		labelVolleyballer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(labelVolleyballer);
		
		JButton btnNewButton = new JButton("Show of team players");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
			
				
				// service if we do not mark anything on the list
				if ((teamsList.getSelectedValue() == null)) {

					JOptionPane.showMessageDialog(null, "Select a team");
				} else {

					// we create an object based on a selection from the list
					TrainingTeam zt = (TrainingTeam) teamsList.getSelectedValue();
					
					//if it has broken saws then we show the button to remove
					if (zt.getVolleyballers().size() > 0) {
						//we show the button from removing the player
						button.setVisible(true);
						}else{
							button.setVisible(false);
						}

					// clear jlist from the right side
					listVolleyballers.clear();

					if (zt.getVolleyballers().size() == 0) {
						JOptionPane.showMessageDialog(null,
								"The team has no assigned players");
						return;
					}

					// in the loop we put on the list all the players of the team
					for (int x = 0; x < zt.getVolleyballers().size(); x++) {
						listVolleyballers.addElement(zt.getVolleyballers().get(x));
					}

				}

			}
		});
		btnNewButton.setBounds(7, 311, 178, 23);
		frame.getContentPane().add(btnNewButton);

		//removing vollyballer
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if ((volleyballersList.getSelectedValue() == null)) {

					JOptionPane.showMessageDialog(null, "You have to mark the player");
				} else {
					
					//objects we create
					TrainingTeam zt = (TrainingTeam) teamsList.getSelectedValue();
					Volleyballer p1 = (Volleyballer) volleyballersList.getSelectedValue();
					
					//we remove the disgraced volleyball player
					zt.getVolleyballers().remove(p1);
					
					//clearing list
					listVolleyballers.clear();
					
					//we put on the list of volleyball players already without this removed
					for (int x = 0; x < zt.getVolleyballers().size(); x++) {
						listVolleyballers.addElement(zt.getVolleyballers().get(x));
					}
				 
					
					try {
						//we're opening the stream
						FileOutputStream file2 = new FileOutputStream(
								"Extension");

						ObjectOutputStream save2 = new ObjectOutputStream(file2);
						//we record the extensions and close the stream
						ObjectPlus.Save(save2);
						save2.close();
					} catch (Exception e) {

					}
					
					
				}
				
				
				
			}
		});
		button.setVisible(false);
		button.setBounds(269, 311, 225, 23);
		frame.getContentPane().add(button);


		teamsList.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					JOptionPane.showMessageDialog(null,
							"You can select only one item");
				}
			}
		});

		teamsList.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
					JOptionPane.showMessageDialog(null,
							"You can select only one item");
				}
			}
		});

		

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
		btnWr.setBounds(188, 311, 79, 23);
		frame.getContentPane().add(btnWr);
		
		

	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
