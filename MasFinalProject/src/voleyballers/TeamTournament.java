package voleyballers;

import java.io.Serializable;
import java.util.Vector;

public class TeamTournament extends ObjectPlus implements Serializable {

	private String place, goalBalance, results;
	private Tournament tournament;
	private TrainingTeam team;

	public TeamTournament(String place, String goalBalance, String results,
						  Tournament tournament, TrainingTeam team) throws Exception {
		super();
		this.place = place;
		this.goalBalance = goalBalance;
		this.results = results;
		this.tournament = tournament;
		tournament.addTrainingTeam(this);
		this.team = team;
		team.addTrainingTeam(this);
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getGoalBalance() {
		return goalBalance;
	}

	public void setGoalBalance(String goalBalance) {
		this.goalBalance = goalBalance;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public TrainingTeam getTeam() {
		return team;
	}

	public void setTeam(TrainingTeam team) {
		this.team = team;
	}

	// extension method, using Objectplus
	public static Vector showExtension() throws Exception {
		return ObjectPlus.Show(TeamTournament.class);
	}
}