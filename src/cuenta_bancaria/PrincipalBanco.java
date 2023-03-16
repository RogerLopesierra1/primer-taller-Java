package cuenta_bancaria;

public class PrincipalBanco {
	public static void main(String[] args) {
		CuentaDeAhorros cuenta = new CuentaDeAhorros(200000, 12);
		
		cuenta.consignar(300000);
		cuenta.retirar(100000);
		cuenta.imprimir();
		cuenta.extractoMensual();
		
	}
}
