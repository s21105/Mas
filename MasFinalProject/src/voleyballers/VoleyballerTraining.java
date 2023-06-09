package voleyballers;

import java.io.Serializable;
import java.util.Vector;


public class VoleyballerTraining extends ObjectPlus implements Serializable{

	private String startDate, startTime, endTime;
	private Volleyballer volleyballer;
	private Training training;
	
	public VoleyballerTraining(String startDate, String startTime,
							   String endTime, Volleyballer volleyballer, Training training) throws Exception {
		setStartDate(startDate);
		setStartTime(startTime);
		setEndTime(endTime);
		this.volleyballer = volleyballer;
		volleyballer.addAttributeAssociation(this);
		this.training = training;
		training.addAttributeAssociation(this);
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		if(startDate == null || startDate.isBlank()) {
			throw new IllegalArgumentException("start date of player cannot be null or blank");
		}
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		if(startTime == null || startTime.isBlank()) {
			throw new IllegalArgumentException("start time of player cannot be null or blank");
		}
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		if(endTime == null || endTime.isBlank()) {
			throw new IllegalArgumentException("end time of player cannot be null or blank");
		}
		this.endTime = endTime;
	}

	public Volleyballer getVolleyballer() {
		return volleyballer;
	}

	public void setVolleyballer(Volleyballer volleyballer) {
		this.volleyballer = volleyballer;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}


	// extension method, using Objectplus
	public static Vector showExtension() throws Exception {
		return ObjectPlus.Show(VoleyballerTraining.class);
	}
}