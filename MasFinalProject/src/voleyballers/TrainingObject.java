package voleyballers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TrainingObject extends ObjectPlus implements Serializable{
	private int number;
	private String surface, baseType;

	public TrainingObject(int number, String surface, String baseType) throws Exception {
		setNumber(number);
		setSurface(surface);
		setBaseType(baseType);
	}
	
	// association for training
		private List<Training> trainings = new ArrayList<>();

		public void addTraining(Training training) throws Exception {
			if (trainings != null) {

				if (!trainings.contains(training)) {
					trainings.add(training);

					training.setTrainingObject(this);

				}
			} else {
				throw new Exception("Incorrect team value");

			}

		}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("number of training object can't be smaller than 0.");
		}
			this.number = number;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		if(surface == null || surface.isBlank()) {
			throw new IllegalArgumentException("surface cannot be null or blank");
		}
			this.surface = surface;
	}

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) throws Exception {
		if(baseType == null || baseType.isBlank()) {
			throw new IllegalArgumentException("Type of base cannot be null or blank");
		} else if (surface != "parquet" && surface != "sand"
				&& surface != "lining") {
			throw new Exception("Invalid surface attribute value");
		}
		this.baseType = baseType;
	}

	// extension method, using Objectplus
	public static Vector showExtension() throws Exception {
		return ObjectPlus.Show(TrainingObject.class);
	}

}
