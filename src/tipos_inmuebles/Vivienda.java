package tipos_inmuebles;

public class Vivienda extends Inmueble{
	protected int numHabitaciones;
	protected int numBanios;
	
	public Vivienda(int identificador, int area, String direccion, int numHabitaciones, int numBanios) {
		super(identificador, area, direccion);
		this.numHabitaciones = numHabitaciones;
		this.numBanios = numBanios;
	}
	
	
}
