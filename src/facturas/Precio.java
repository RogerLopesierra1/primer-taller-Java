package facturas;

public class Precio {
	private double valor;
	private int cantidad;
    private double impuestos;
    private double descuentos;    
    private String categoria;
    
	public Precio(double valor, int cantidad, double impuestos, double descuentos, String categoria) {
		super();
		this.valor = valor;
		this.cantidad = cantidad;
		this.impuestos = impuestos;
		this.descuentos = descuentos;
		this.categoria = categoria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}

	public double getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(double descuentos) {
		this.descuentos = descuentos;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
    
	   
    
}
