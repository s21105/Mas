package voleyballers;

import java.io.Serializable;
import java.util.Vector;


public class NationalTournament extends Tournament implements Serializable{
	
	private double organisationCost;

	public NationalTournament(String name, String startDate,
							  String endDate, String status, double awardAmount,
							  double organisationCost) throws Exception {
		super(name, startDate, endDate, status, awardAmount);
		this.organisationCost = organisationCost;
	}

	public double getOrganisationCost() {
		return organisationCost;
	}

	public void setOrganisationCost(double organisationCost) {
		this.organisationCost = organisationCost;
	}

	// extension method, using Objectplus
	public static Vector showExtension() throws Exception {
		return ObjectPlus.Show(NationalTournament.class);
	}
	

}
