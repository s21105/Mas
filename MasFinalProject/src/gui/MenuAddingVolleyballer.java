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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MenuAddingVolleyballer {
	private JFrame frame;
	private JTextField name;
	private JTextField surname;
	private JTextField birthPlace;

	private JTextField pesel;
	private JTextField address;
	private JTextField telephone;
	private JTextField email;
	private JTextField year;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAddingVolleyballer window = new MenuAddingVolleyballer();
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
	public MenuAddingVolleyballer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Adding a volleyball player");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 360, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		//extension loading
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"Extension"))) {
			ObjectPlus.Load(ois);
		} catch (Exception e) {
			System.out.println("No extension");
		}
		// labels and text fields

		JLabel volleyballer = new JLabel("Enter information about volleyballer");
		volleyballer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		volleyballer.setBounds(10, 11, 300, 23);
		frame.getContentPane().add(volleyballer);

		JLabel nameLabel = new JLabel("Name *");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nameLabel.setBounds(10, 45, 48, 14);
		frame.getContentPane().add(nameLabel);

		name = new JTextField();
		name.setBounds(168, 39, 170, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);

		JLabel surnameLabel = new JLabel("Surname *");
		surnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		surnameLabel.setBounds(10, 72, 71, 14);
		frame.getContentPane().add(surnameLabel);

		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(168, 66, 170, 20);
		frame.getContentPane().add(surname);

		JLabel placeLabel = new JLabel("Birth place *");
		placeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		placeLabel.setBounds(10, 133, 136, 14);
		frame.getContentPane().add(placeLabel);

		birthPlace = new JTextField();
		birthPlace.setColumns(10);
		birthPlace.setBounds(168, 131, 170, 20);
		frame.getContentPane().add(birthPlace);

		JLabel addressLabel = new JLabel("Address *");
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addressLabel.setBounds(10, 164, 70, 14);
		frame.getContentPane().add(addressLabel);

		address = new JTextField();
		address.setColumns(10);
		address.setBounds(168, 162, 170, 20);
		frame.getContentPane().add(address);

		JLabel peselLabel = new JLabel("Pesel *");
		peselLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		peselLabel.setBounds(10, 195, 48, 14);
		frame.getContentPane().add(peselLabel);

		pesel = new JTextField();
		pesel.setColumns(10);
		pesel.setBounds(168, 193, 170, 20);
		frame.getContentPane().add(pesel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("dat.png"));
		label.setBounds(367, 26, 150, 87);
		frame.getContentPane().add(label);

		JLabel telephoneLabel = new JLabel("Telephone number *");
		telephoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		telephoneLabel.setBounds(10, 220, 130, 14);
		frame.getContentPane().add(telephoneLabel);

		telephone = new JTextField();
		telephone.setColumns(10);
		telephone.setBounds(168, 218, 170, 20);
		frame.getContentPane().add(telephone);

		JLabel emailLabel = new JLabel("email");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emailLabel.setBounds(10, 245, 117, 14);
		frame.getContentPane().add(emailLabel);

		email = new JTextField("");
		email.setColumns(10);
		email.setBounds(168, 243, 170, 20);
		frame.getContentPane().add(email);

		JLabel yearLabel = new JLabel("Birth year *");
		yearLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		yearLabel.setBounds(10, 99, 136, 14);
		frame.getContentPane().add(yearLabel);

		year = new JTextField();
		year.setColumns(10);
		year.setBounds(168, 97, 170, 20);
		frame.getContentPane().add(year);

		JButton btnWr = new JButton("Add volleyballer");
		btnWr.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				
				if(Integer.parseInt(year.getText()) <1950 || Integer.parseInt(year.getText()) >2010){
					JOptionPane.showMessageDialog(null,"Date of birth shall not be less than 1950");
					return;
				}

				// check if year of birth is a number
				try {

					Integer.parseInt(year.getText());

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"year of birth must be number");
					return;

				}

				// error handling when we don't enter a field
				if (name.getText().isEmpty() || surname.getText().isEmpty()
						|| year.getText().isEmpty()
						|| birthPlace.getText().isEmpty()
						|| address.getText().isEmpty()
						|| pesel.getText().isEmpty()
						|| telephone.getText().isEmpty()) {

					JOptionPane
							.showMessageDialog(null, "You left empty fields");

				} else {

					//creating an object based on values entered in the gui
					Volleyballer p1 = new Volleyballer(name.getText(),
							surname.getText(), Integer.parseInt(year.getText()), birthPlace.getText(),
							address.getText(), pesel.getText(), telephone.getText());
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
					
					JOptionPane.showMessageDialog(null, "New volleyball player enrolled");
					
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
		btnWr.setBounds(10, 274, 137, 23);
		frame.getContentPane().add(btnWr);

		// button service to return
		JButton button = new JButton("return");
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
		button.setBounds(168, 274, 117, 23);
		frame.getContentPane().add(button);

	}

	// frame return method
	public Component getFrame() {
		return frame;
	}
}
