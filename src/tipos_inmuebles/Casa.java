package tipos_inmuebles;

public class Casa extends Vivienda{
	protected int pisos;

	public Casa(int identificador, int area, String direccion, int numHabitaciones, int numBanios,
			int pisos) {
		super(identificador, area, direccion, numHabitaciones, numBanios);
		this.pisos = pisos;
	}
	
	
}
