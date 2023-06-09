package voleyballers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Trainer extends Person implements Serializable{
	private String alias;
	private double hourlyRate;

	// repeatable attribute
	private List<String> specializations = new ArrayList<>();

	public Trainer(String name, String surname, int yearOfBirth,
				   String birthPlace, String residenceAddress, String alias, double hourlyRate) {
		super(name, surname, yearOfBirth, birthPlace, residenceAddress);
		setAlias(alias);
		setHourlyRate(hourlyRate);
	}

	// method for a repeatable attribute
	public void addSpecializations(String specialization) {
		if (!specializations.contains(specialization)) {
			specializations.add(specialization);
		}
	}

	// association 1-3 to the team
	private List<TrainingTeam> teams = new ArrayList<>();

	public void addTrainingTeam(TrainingTeam team) throws Exception {
		if (team != null) {
			if (teams.size() > 3) {
				throw new Exception(
						"You can't add another team to the coach");
			} else {
				if (!teams.contains(team)) {
					teams.add(team);

					team.addTrainer(this);
				}
			}
		} else {
			throw new Exception("Incorrect team value");
		}
	}

	// association * for training
	private List<Training> trainings = new ArrayList<>();

	public void addTraining(Training training) throws Exception {
		if (trainings != null) {

			if (!trainings.contains(training)) {
				trainings.add(training);

				training.setTrainer(this);
			}
		} else {
			throw new Exception("Incorrect team value");
		}
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		if(alias == null || alias.isBlank()) {
			throw new IllegalArgumentException("Name cannot be null or blank");
		}
		this.alias = alias;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public void addTrainer() {

	}

	public void createReport() {

	}

	// extension method, using Objectplus
	public static Vector showExtension() throws Exception {
		return ObjectPlus.Show(Trainer.class);
	}
}