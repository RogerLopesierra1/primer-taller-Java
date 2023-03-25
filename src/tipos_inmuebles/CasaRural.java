package tipos_inmuebles;

public class CasaRural extends Casa{
	protected float dist_cab_municipal;
	protected float altitud;
	public CasaRural(int identificador, int area, String direccion, int numHabitaciones, int numBanios,
			int pisos, float dist_cab_municipal, float altitud) {
		super(identificador, area, direccion, numHabitaciones, numBanios, pisos);
		this.dist_cab_municipal = dist_cab_municipal;
		this.altitud = altitud;
	}
	
	
}
