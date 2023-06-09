package voleyballers;

import java.io.Serializable;
import java.util.*;

public class Volleyballer extends Person implements Serializable{

	private String pesel, telephoneNumber, email;
	private TrainingTeam team;

	private static Set<String> pesels = new TreeSet<String>();

	// 2 constructors for the optional attribute
	public Volleyballer(String name, String surname, int yearOfBirth,
						String birthPlace, String residenceAddress, String pesel,
						String telephoneNumber, String email) {
		super(name, surname, yearOfBirth, birthPlace, residenceAddress);
		setPesel(pesel);
		setTelephoneNumber(telephoneNumber);
		setEmail(email);
	}

	public Volleyballer(String name, String surname, int yearOfBirth,
						String birthPlace, String residenceAddress, String pesel,
						String telephoneNumber) {
		super(name, surname, yearOfBirth, birthPlace, residenceAddress);
		this.pesel = pesel;
		this.telephoneNumber = telephoneNumber;
	}
	
	// association 1 for the captain
	public void setTrainingTeam(TrainingTeam team) throws Exception{
		this.team=team;
		team.addVolleyballer(this);
	}

	// aggregation to training team
	private List<TrainingTeam> teams = new ArrayList<>();

	public void addTrainingTeam(TrainingTeam team) throws Exception {
		if (team != null) {

			if (!teams.contains(team)) {
				teams.add(team);

				team.addVolleyballer(this);
			}
		} else {
			throw new Exception("Incorrect value of the team");

		}
	}
	
	public List<TrainingTeam> showTeams() {
		return teams;
	}

	// attribute association
	private List<VoleyballerTraining> attributeAssociation = new ArrayList<>();

	public void addAttributeAssociation(VoleyballerTraining training) throws Exception {
		if (attributeAssociation != null) {

			if (!attributeAssociation.contains(training)) {
				attributeAssociation.add(training);

			}
		} else {
			throw new Exception("Incorrect value of the team");

		}

	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		if(peselUsed(pesel))
			throw new IllegalArgumentException("This pesel is already used");
		else if(!pesel.matches("\\d{11}"))
			throw new IllegalArgumentException("wrong format of pesel");
		this.pesel = pesel;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		if(telephoneNumber == null || telephoneNumber.isBlank()) {
			throw new IllegalArgumentException("telephone number cannot be null or blank");
		}
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email == null || email.isBlank()) {
			throw new IllegalArgumentException("email cannot be null or blank");
		}
		this.email = email;
	}
	
	// extension method, using Objectplus
	public static Vector showExtension() throws Exception {
		return ObjectPlus.Show(Volleyballer.class);
	}
	
	public String toString(){
		return getName() + " " + getSurname();
	}
	private static boolean peselUsed(String pesel){
		return pesels.contains(pesel);
	}
}
