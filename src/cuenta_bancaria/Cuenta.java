package cuenta_bancaria;

public class Cuenta {
	protected float saldo;
    protected int numConsignaciones = 0;
    protected int numRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;
    
	public Cuenta(float saldo, float tasaAnual) {
		super();
		this.saldo = saldo;
		this.tasaAnual = tasaAnual;
	}
	
	public void consignar(float cantidad) {
		saldo += cantidad;
        numConsignaciones++;
	}
	
	public void retirar(float cantidad) {
		if (cantidad <= saldo) {
            saldo -= cantidad;
            numRetiros++;
        } else {
            System.out.println("Error: Maximo puede retirar "+this.saldo);
        }
	}
	
	public void calcularInteresMensual() {
		float interes = saldo * (tasaAnual / 12);
        saldo += interes;
	}
    
	public void extractoMensual() {
		saldo -= comisionMensual;
		calcularInteresMensual();
		numConsignaciones = 0;
        numRetiros = 0;
        comisionMensual = 0;
	}
	
	public void imprimir() {
        System.out.println("                   Saldo: " + saldo);
        System.out.println("Número de consignaciones: " + numConsignaciones);
        System.out.println("       Número de retiros: " + numRetiros);
        System.out.println("              Tasa anual: " + tasaAnual);
        System.out.println("        Comisión mensual: " + comisionMensual);
    }
   
	
}
