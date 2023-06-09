package voleyballers;

import java.io.Serializable;
import java.util.Vector;

public class ForeignTournament extends Tournament implements Serializable{
	private String country;

	public ForeignTournament(String name, String startDate,
							 String endDate, String status, double awardAmount,
							 String country) throws Exception {
		super(name, startDate, endDate, status, awardAmount);
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		if(country == null || country.isBlank()) {
			throw new IllegalArgumentException("country cannot be null or blank");
		}
		this.country = country;
	}

	// extension method, using Objectplus
	public static Vector showExtension() throws Exception {
		return ObjectPlus.Show(ForeignTournament.class);
	}
}