package voleyballers;

import java.io.Serializable;
import java.util.Vector;

public class TrainingWithPsychologist extends Training implements Serializable{

	private int numberOfSessions;

	public TrainingWithPsychologist(int numberID, int duration,
									double pricePerHour, String name, String level, int numberOfSessions)
			throws Exception {
		super(numberID, duration, pricePerHour, name, level);
		setNumberOfSessions(numberOfSessions);
	}

	public int getNumberOfSessions() {
		return numberOfSessions;
	}

	public void setNumberOfSessions(int numberOfSessions) {
		if(numberOfSessions > 0) {
			throw new IllegalArgumentException("Number of sessions for player cannot be null or blank");
		}
		this.numberOfSessions = numberOfSessions;
	}

	// extension method, using Objectplus
	public static Vector showExtension() throws Exception {
		return ObjectPlus.Show(TrainingWithPsychologist.class);
	}
}
