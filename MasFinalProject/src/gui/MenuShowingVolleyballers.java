package gui;

import voleyballers.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
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

public class MenuShowingVolleyballers {

	private JFrame frame;
	// same as in class add item
	private DefaultListModel<Volleyballer> listVolleyballers = new DefaultListModel();
	private List<Volleyballer> volleyballers = new ArrayList<>();
 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuShowingVolleyballers window = new MenuShowingVolleyballers();
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
	public MenuShowingVolleyballers() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		frame = new JFrame("Show volleyballers");
		frame.setBounds(100, 100, 289, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
 
		//extension loading
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"Extension"))) {
			ObjectPlus.Load(ois);
		} catch (Exception e) {
			System.out.println("No extension");
		}
		
		try {

			//for each, we go on the vector that stores us extension of class volleyballer

			for (Volleyballer p1 : ObjectPlus.getExtension(Volleyballer.class)) {
				listVolleyballers.addElement(p1);
			}
		} catch (NullPointerException e) {
			System.out.println("No extension");
		}


		// we add jlists and immediately throw them as a parameter
		// default list of models so you can add something to them later
		JList<Volleyballer> list = new JList<>(listVolleyballers);
		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(10, 50, 254, 253);
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
		btnNewButton.setBounds(179, 314, 85, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel labelKlient = new JLabel("Volleyballers at the base:");
		labelKlient.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelKlient.setBounds(10, 11, 210, 28);
		frame.getContentPane().add(labelKlient);

		//operation of the case by pressing control and shift on the list
		list.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					JOptionPane.showMessageDialog(null,
							"You can select only one item");
				}
			}
		});

		list.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
					JOptionPane.showMessageDialog(null,
							"You can select only one item");
				}
			}
		});

		JButton button = new JButton("Show player's age");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (list.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null,
							"You have to mark the player");
				} else {

					Volleyballer p1 = (Volleyballer) list.getSelectedValue();

					JOptionPane.showMessageDialog(null,
							p1 + " is " + p1.calculateAge() + " years old");

				}

			}
		});
		button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button.setBounds(10, 315, 159, 23);
		frame.getContentPane().add(button);

	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
