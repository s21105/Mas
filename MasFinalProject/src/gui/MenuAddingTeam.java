package gui;

import voleyballers.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class MenuAddingTeam {
	private JFrame frame;
	private JTextField name;
	int noExtension=0;
	private String data = Calendar.getInstance().get(Calendar.YEAR) + "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAddingTeam window = new MenuAddingTeam();
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
	public MenuAddingTeam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Adding a team");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 315, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"Extension"))) {
			ObjectPlus.Load(ois);
		 
		} catch (Exception e) {
			
			System.out.println("No extension");
			 
		}
		// labels and text fields

		JLabel pilkarz = new JLabel("Enter a team data");
		pilkarz.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pilkarz.setBounds(10, 11, 239, 23);
		frame.getContentPane().add(pilkarz);

		JLabel nameLabel = new JLabel("Team name *");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nameLabel.setBounds(10, 45, 127, 14);
		frame.getContentPane().add(nameLabel);

		name = new JTextField();
		name.setBounds(122, 43, 163, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("dat.png"));
		label.setBounds(367, 26, 150, 87);
		frame.getContentPane().add(label);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Beginner");
		comboBox.addItem("Intermediate");
		comboBox.addItem("Advanced");
		comboBox.setBounds(10, 93, 275, 20);
		frame.getContentPane().add(comboBox);

		JButton btnWr = new JButton("add team");
		btnWr.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {

			 	
				try {
					//check name unique
					for (TrainingTeam k : ObjectPlus.getExtension(TrainingTeam.class)) {
						if(name.getText().equals(k.getName())){
							JOptionPane.showMessageDialog(null, "The attribute must be unique");
							
							return;
						}
					}
					
					
				} catch (NullPointerException e) {
					 
				}
				
			
				TrainingTeam zt1 = new TrainingTeam(name.getText(),
						comboBox.getSelectedItem().toString(), data);

				// error handling when we don't enter a field
				if (name.getText().isEmpty()) {

					JOptionPane
							.showMessageDialog(null, "You left empty fields");

				} else {

					try {
						FileOutputStream file2 = new FileOutputStream(
								"Extension");

						ObjectOutputStream save2 = new ObjectOutputStream(file2);

						ObjectPlus.Save(save2);
						save2.close();
					} catch (Exception e) {

					}

					JOptionPane.showMessageDialog(null, "New team saved");

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

			}
		});
		btnWr.setBounds(10, 140, 117, 23);
		frame.getContentPane().add(btnWr);

		// button service to return
		JButton button = new JButton("Return");
		button.addActionListener(new ActionListener() {
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
		button.setBounds(160, 140, 117, 23);
		frame.getContentPane().add(button);

		JLabel lblTeamLevel = new JLabel("Team level *");
		lblTeamLevel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTeamLevel.setBounds(10, 68, 127, 14);
		frame.getContentPane().add(lblTeamLevel);

	}

	// frame return method
	public Component getFrame() {
		return frame;
	}
}
