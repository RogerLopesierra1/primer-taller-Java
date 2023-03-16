package facturas;

public class Factura extends Precio{
	private String emisor;
	private String cliente;
	
	public Factura(double valor, int cantidad, double impuestos, double descuentos,
			String categoria, String emisor, String cliente) {
		super(valor, cantidad, impuestos, descuentos, categoria);
		this.emisor = emisor;
		this.cliente = cliente;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public void imprimirFactura() {
		double bruto = getValor()*getCantidad();
		double iva = bruto*getImpuestos()/100;
		double desc = bruto*getDescuentos()/100;
		double resultado = bruto + iva - desc;
		System.out.println("Impresion de factura");
		System.out.println("valor bruto: +"+bruto);		
		System.out.println("Iva        : +"+iva);
		System.out.println("Descuento  : -"+desc);
		System.out.println("Categoria  : "+getCategoria());
		System.out.println("Emisor     : "+this.emisor);
		System.out.println("Cliente    : "+this.cliente);
		System.out.println("Neto	   : "+resultado);
	}
	
}
