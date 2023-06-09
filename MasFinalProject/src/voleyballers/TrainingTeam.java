package voleyballers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TrainingTeam extends ObjectPlus implements Serializable{

	private String name, level, creationDate;

	public TrainingTeam(String name, String level, String creationDate) {
		super();
		setName(name);
		setLevel(level);
		setCreationDate(creationDate);
	}

	private Volleyballer volleyballer;

	public void setVolleyballer(Volleyballer volleyballer) throws Exception {
		this.volleyballer = volleyballer;
		volleyballer.addTrainingTeam(this);
	}

	// Association to Team Tournament association with attribute
	private List<TeamTournament> teamsTournament = new ArrayList<>();

	public void addTrainingTeam(TeamTournament team) throws Exception {
		if (team != null) {

			if (!teamsTournament.contains(team)) {
				teamsTournament.add(team);

			}
		} else {
			throw new Exception("Incorrect team value");

		}
	}

	// association 1-2 to coach
	private List<Trainer> trainers = new ArrayList<>();

	public void addTrainer(Trainer trainer) throws Exception {
		if (trainer != null) {
			if (trainers.size() > 2) {
				throw new Exception(
						"You can't add another trainer to the team");
			} else {
				if (!trainers.contains(trainer)) {
					trainers.add(trainer);

					trainer.addTrainingTeam(this);
				}
			}
		} else {
			throw new Exception("Incorrect trainer value");

		}

	}

	// Association * to the volleyball player
	private List<Volleyballer> volleyballers = new ArrayList<>();

	public void addVolleyballer(Volleyballer volleyballer) throws Exception {
		if (volleyballers != null) {
				if (!volleyballers.contains(volleyballer)) {
					volleyballers.add(volleyballer);

					//feedback
					volleyballer.addTrainingTeam(this);
				}
			 
		} else {
			throw new Exception("Incorrect team value");

		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("name cannot be null or blank");
		}
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		if(level == null || level.isBlank()) {
			throw new IllegalArgumentException("level cannot be null or blank");
		}
		this.level = level;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		if(creationDate == null || creationDate.isBlank()) {
			throw new IllegalArgumentException("Date of creation cannot be null or blank");
		}
		this.creationDate = creationDate;
	}

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	public List<Volleyballer> getVolleyballers() {
		return volleyballers;
	}

	public void setVolleyballers(List<Volleyballer> volleyballers) {
		this.volleyballers = volleyballers;
	}

	public Volleyballer getVolleyballer() {
		return volleyballer;
	}

	// extension method, using Objectplus
	public static Vector showExtension() throws Exception {
		return ObjectPlus.Show(TrainingTeam.class);
	}

	public String toString() {
		return name;
	}
}
