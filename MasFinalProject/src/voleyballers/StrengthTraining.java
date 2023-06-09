package voleyballers;

import java.io.Serializable;
import java.util.Vector;

public class StrengthTraining extends Training implements Serializable{

	private String trainingIntensity;
	private double maxTrainingLoad;

	public StrengthTraining(int numberID, int duration, double pricePerHour,
							String name, String level, String trainingIntensity,
							double maxTrainingLoad) throws Exception {
		super(numberID, duration, pricePerHour, name, level);
		this.trainingIntensity = trainingIntensity;
		this.maxTrainingLoad = maxTrainingLoad;
	}

	public String getTrainingIntensity() {
		return trainingIntensity;
	}

	public void setTrainingIntensity(String trainingIntensity) {
		this.trainingIntensity = trainingIntensity;
	}

	public double getMaxTrainingLoad() {
		return maxTrainingLoad;
	}

	public void setMaxTrainingLoad(double maxTrainingLoad) {
		this.maxTrainingLoad = maxTrainingLoad;
	}

	// extension method, using Objectplus
	public static Vector showExtension() throws Exception {
		return ObjectPlus.Show(StrengthTraining.class);
	}
}
