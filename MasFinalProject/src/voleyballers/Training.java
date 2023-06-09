package voleyballers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Training extends ObjectPlus implements Serializable{

	private int numberID, duration;
	private double pricePerHour;
	private String name, level;
	private Trainer trainer;
	private TrainingObject object;

	public Training(int numberID, int duration, double pricePerHour, String name, String level) throws Exception {
		setNumberID(numberID);
		setDuration(duration);
		setPricePerHour(pricePerHour);
		setName(name);
		setLevel(level);
	}

	// association 1 to trainer class
	public void setTrainer(Trainer trainer) throws Exception {
		if (trainer != null) {
			this.trainer = trainer;
			trainer.addTraining(this);
		} else {
			throw new Exception("Incorrect trainer value");
		}
	}

	// attribute association
	private List<VoleyballerTraining> attributeAssociations = new ArrayList<>();

	public void addAttributeAssociation(VoleyballerTraining training) throws Exception {
		if (attributeAssociations != null) {

			if (!attributeAssociations.contains(training)) {
				attributeAssociations.add(training);
			}
		} else {
			throw new Exception("Incorrect team value");
		}
	}

	public void setTrainingObject(TrainingObject object) throws Exception {
		if (object != null) {
			this.object = object;
		} else {
			throw new Exception("Invalid object value");
		}
	}

	public int getNumberID() {
		return numberID;
	}

	public void setNumberID(int numberID) {
		if (numberID < 0) {
			throw new IllegalArgumentException("number ID can't be smaller than 0.");
		}
		this.numberID = numberID;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		if (duration < 0) {
			throw new IllegalArgumentException("duration can't be smaller than 0.");
		}
		this.duration = duration;
	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		if (pricePerHour < 0) {
			throw new IllegalArgumentException("price can't be smaller than 0.");
		}
		this.pricePerHour=pricePerHour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("Name cannot be null or blank");
		}
		this.name = name;
	}

	public String getLevel() {
		return level;
	} 
	public TrainingObject getObject() {
		return object;
	}

	public void setObject(TrainingObject object) {
		this.object = object;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setLevel(String level) throws Exception {
		if (level == null || level.isBlank()){
			throw new IllegalArgumentException("Level cannot be null or blank");
		}else if (level != "beginner" && level != "intermediate" && level != "advanced") {
			throw new Exception("Invalid level attribute value");
		}
		this.level = level;
	}

	// extension method, using Objectplus
	public static Vector showExtension() throws Exception {
		return ObjectPlus.Show(Training.class);
	}
}