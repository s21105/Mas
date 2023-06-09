package voleyballers;

import java.io.Serializable;
import java.util.Vector;

public class TrainingWithBall extends Training implements Serializable{

	private String trainingType, playerPosition;

	public TrainingWithBall(int numberID, int duration, double pricePerHour,
							String name, String level, String trainingType,
							String playerPosition) throws Exception {
		super(numberID, duration, pricePerHour, name, level);
		setTrainingType(trainingType);
		setPlayerPosition(playerPosition);
	}

	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		if(trainingType == null || trainingType.isBlank()) {
			throw new IllegalArgumentException("Training type cannot be null or blank");
		}this.trainingType = trainingType;
	}

	public String getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(String playerPosition) {
		if(playerPosition == null || playerPosition.isBlank()) {
			throw new IllegalArgumentException("Position of player cannot be null or blank");
		}
		this.playerPosition = playerPosition;
	}

	// extension method, using Objectplus
	public static Vector showExtension() throws Exception {
		return ObjectPlus.Show(TrainingWithBall.class);
	}
}