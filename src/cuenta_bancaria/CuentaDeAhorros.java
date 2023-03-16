package cuenta_bancaria;

public class CuentaDeAhorros extends Cuenta{
	private boolean activa;

	public CuentaDeAhorros(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
		if (saldo >= 10000) {
			activa = true;
		} else {
			activa = false;
		}
	}
	
	@Override
	public void consignar(float cantidad) {
		if (activa) {
            super.consignar(cantidad);
        } else {
            System.out.println("Error: la cuenta está inactiva");
        }
	}
	
	@Override
	public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
            activa = saldo >= 10000;
        } else {
            System.out.println("Error: la cuenta está inactiva");
        }
    }
	
	@Override
	public void extractoMensual() {
		if (numRetiros > 4) {
            comisionMensual += (numRetiros - 4) * 1000;
        }
		
		if (saldo >= 10000) {
			activa = true;
		} else {
			activa = false;
		}
		
		super.extractoMensual();
	}
	
	@Override
	public void imprimir() {
		float comision = comisionMensual + (numRetiros - 4) * 1000;
		System.out.println("Por ahora mi saldo, comision y numtransacciones seria: ");
		System.out.println("saldo: "+(saldo-comision));
		System.out.println("comision mensual: "+comision);
		System.out.println("Numero de Transacciones: "+(numConsignaciones+numRetiros));
	}
	
}
