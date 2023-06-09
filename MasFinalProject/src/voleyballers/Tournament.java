package voleyballers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Tournament extends ObjectPlus implements Serializable{

	private String name, startDate, endDate, status;
	private double awardAmount;

	// multiple inheritance

	// constructor from the professional tournament
	public Tournament(String name, String startDate,
					  String endDate, String status, double awardAmount)
			throws Exception {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		if (status != "planned" && status != "in the process"
				&& status != "completed") {
			throw new Exception("Invalid status attribute value");
		}
		this.status = status;
		this.awardAmount = awardAmount;
	}

	// constructor from amateur tournament
	public Tournament(String name, String startDate,
					  String endDate, String status) throws Exception {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;

		if (status != "planned" && status != "in the process"
				&& status != "completed") {
			throw new Exception("Invalid status attribute value");
		}
		this.status = status;
	}

	// association * to Team Tournament association with attribute
	private List<TeamTournament> teams = new ArrayList<>();

	public void addTrainingTeam(TeamTournament team) throws Exception {
		if (team != null) {

			if (!teams.contains(team)) {
				teams.add(team);

			}
		} else {
			throw new Exception("Incorrect team value");
		}
	}

	// extension method, using Objectplus
	public static Vector showExtension() throws Exception {
		return ObjectPlus.Show(Tournament.class);
	}
	
	public String toString(){
		return name;
	}

}
