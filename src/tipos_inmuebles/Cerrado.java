package tipos_inmuebles;

public class Cerrado extends Casa{
	protected int valor_admin;
	protected boolean isAreas;
	public Cerrado(int identificador, int area, String direccion, int numHabitaciones, int numBanios,
			int pisos, int valor_admin, boolean isAreas) {
		super(identificador, area, direccion, numHabitaciones, numBanios, pisos);
		this.valor_admin = valor_admin;
		this.isAreas = isAreas;
	}
	
	
	
}
