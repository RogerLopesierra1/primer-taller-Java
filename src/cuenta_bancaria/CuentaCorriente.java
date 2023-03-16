package cuenta_bancaria;

public class CuentaCorriente extends Cuenta{
	private float sobregiro;

	public CuentaCorriente(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
		this.sobregiro = 0;
	}
	
	@Override
	public void retirar(float cantidad) {
		if (cantidad <= saldo) {
			saldo -= cantidad;
			
		} else {
			sobregiro += (cantidad - saldo);
		}
		
		numRetiros++;
		
	}
	
	@Override
	public void consignar(float cantidad) {
		if (sobregiro > 0) {
            if (cantidad > sobregiro) {
                cantidad -= sobregiro;
                sobregiro = 0;
            } else {
                sobregiro -= cantidad;
                cantidad = 0;
            }
        }
		
        if (cantidad > 0) {
            super.consignar(cantidad);
        }
        
        numConsignaciones++;
	}
	
	@Override
    public void extractoMensual() {
        float comisionMensual = this.numRetiros > 4 ? (this.numRetiros - 4) * 1000 : 0;
        super.extractoMensual();        
        this.comisionMensual = comisionMensual;
    }

	@Override
    public void imprimir() {
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Comision mensual: " + this.comisionMensual);
        System.out.println("Transacciones realizadas: " + (numConsignaciones+numRetiros));
        System.out.println("Sobregiro: " + this.sobregiro);
    }
	
  
	
}
