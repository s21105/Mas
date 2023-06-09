package gui;

import voleyballers.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javax.swing.ListSelectionModel;

public class MenuAddingVolleyballerToTeam {

	private JFrame frame;
 
 
	private List<Object> ob;
	// list to post things later on Jlist
	private final DefaultListModel<Volleyballer> volleyballers = new DefaultListModel<>();
	private final DefaultListModel<TrainingTeam> teams = new DefaultListModel<>();
	private List<Volleyballer> listObjects;
	private Volleyballer p1;
	private TrainingTeam zt;
 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAddingVolleyballerToTeam window = new MenuAddingVolleyballerToTeam();
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
	public MenuAddingVolleyballerToTeam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Adding a volleyball player to the team");
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
				volleyballers.addElement(p);
			}
			
			for (TrainingTeam zt : ObjectPlus.getExtension(TrainingTeam.class)) {
				teams.addElement(zt);
			} 
		}catch(NullPointerException e) {
			
		}


		// lists, labels etc.
		JList<TrainingTeam> listTeams = new JList(teams);
		JScrollPane scroll = new JScrollPane(listTeams);
		scroll.setBounds(7, 31, 222, 269);
		frame.getContentPane().add(scroll);
		
		//you can only select 1 option
		listTeams.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JList<Volleyballer> listVolleyballers = new JList(volleyballers);
		JScrollPane scroll2 = new JScrollPane(listVolleyballers);
		scroll2.setBounds(256, 32, 232, 269);
		frame.getContentPane().add(scroll2);

		JLabel labelTeam = new JLabel("Select team");
		labelTeam.setBounds(7, 7, 107, 20);
		labelTeam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(labelTeam);

		JLabel labelVolleyballer = new JLabel("Choose a volleyball player");
		labelVolleyballer.setBounds(256, 7, 185, 20);
		labelVolleyballer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(labelVolleyballer);
 

		JButton btnNewButton = new JButton("Add a player to your team");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				
				
		

				// service if we do not mark anything on the list
				if ((listTeams.getSelectedValue() == null || listVolleyballers.getSelectedValue() == null)) {

					JOptionPane.showMessageDialog(null,"Select the player and team");
					return;
				} else {
					
					  p1 = (Volleyballer) listVolleyballers.getSelectedValue();
					
					  zt = (TrainingTeam) listTeams.getSelectedValue();
					
					  if(zt.getVolleyballers().contains(p1)) {
						  JOptionPane.showMessageDialog(null,"The selected player already belongs to the selected team");
						  return;
					  }
					  
					  //all selected objects of class volleyballer
					  //we assign to the list of type volleyballer
					listObjects = listVolleyballers.getSelectedValuesList();
					 
					 //for each, 
					 for(Volleyballer p: listObjects){
						 try {
							 //we create associations between the team and selected players
							zt.addVolleyballer(p);
						} catch (Exception e1) {
						 
							e1.printStackTrace();
						}
					 }
					 
					 
					//open the stream and save the extensions to a file
					FileOutputStream file2;
					try {
						file2 = new FileOutputStream("Extension");
						ObjectOutputStream save2 = new ObjectOutputStream(file2);						 
	 			    	ObjectPlus.Save(save2);
	 					save2.close();
	 
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
 				  
				}
				
				//operation of one or more additional players
				if(listObjects.size()==1){
					JOptionPane.showMessageDialog(null, "The player was added to the team " + zt.getName());
				}
				if(listObjects.size()>1){
					JOptionPane.showMessageDialog(null, "Players were added to the team " + zt.getName());
				}
 
			}
		});
		btnNewButton.setBounds(7, 311, 222, 23);
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
		btnWr.setBounds(239, 311, 107, 23);
		frame.getContentPane().add(btnWr);


	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
