package voleyballers;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Vector;


public abstract class Person extends ObjectPlus implements Serializable{
	
	private String name, surname, birthPlace, residenceAddress;
	private int yearOfBirth;

	public Person(String name, String surname, int yearOfBirth,
				  String birthPlace, String residenceAddress) {
		super();
		this.name = name;
		this.surname = surname;
		this.yearOfBirth = yearOfBirth;
		this.birthPlace = birthPlace;
		this.residenceAddress = residenceAddress;
	}

	public int calculateAge(){
		return Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}   //date of birth

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}
	
	public String toString(){
		return name+ " " + surname;
	}

	// extension method, using Objectplus
	public static Vector showExtension() throws Exception {
		return ObjectPlus.Show(Person.class);
	}
}