package cuenta_bancaria;

/**
 * La clase CuentaDeAhorros es una subclase de la clase Cuenta que representa 
 * una cuenta de ahorros bancaria.
 * Esta clase hereda los atributos y métodos de la clase Cuenta 
 * y agrega el atributo booleano "activa" que indica  * si la cuenta está activa o no,
 * y las funciones para validar la cuenta y cobrar comisiones por retiros adicionales.
 */
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
	
	/**
	 * Este método sobrescribe el método consignar de la clase padre Cuenta. 
	 * Si la cuenta de ahorros está activa, la cantidad especificada se consigna 
	 * a la cuenta; de lo contrario, se imprime un mensaje de error.
	 * 
	 * @param cantidad La cantidad que se va a consignar a la cuenta de ahorros.
	 */
	@Override
	public void consignar(float cantidad) {
		if (activa) {
            super.consignar(cantidad);            
        } else {
            System.out.println("Error: la cuenta está inactiva");
        }
	}
	
	/**
	 * Este método sobrescribe el método retirar de la clase padre Cuenta. 
	 * Si la cuenta de ahorros está activa, la cantidad especificada se retira 
	 * de la cuenta; de lo contrario, se imprime un mensaje de error. 
	 * Si la cuenta queda inactiva después de la retirada, 
	 * el atributo activa se actualiza a false.
	 * 
	 * @param cantidad: es la cantidad que se va a retirar de la cuenta de ahorros.
	 */
	@Override
	public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
            activa = saldo >= 10000;            
        } else {
            System.out.println("Error: la cuenta está inactiva");
        }
    }
	
	/**
	 * Este método sobrescribe el método extractoMensual de la clase padre Cuenta. 
	 * Calcula la comisión por retiros si el número de retiros es mayor que 4 y 
	 * actualiza el atributo activa en consecuencia. Luego llama
	 * al método extractoMensual de la clase padre Cuenta.
	 */
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
	
	/**
	 * Este método sobrescribe el método imprimir de la clase padre Cuenta.
	 * Imprime la información de la cuenta de ahorros, incluyendo el saldo actual después de aplicar 
	 * las comisiones correspondientes, la comisión mensual, y el número total 
	 * de transacciones (consignaciones y retiros) realizadas durante el mes.
	 * Si se realizaron más de 4 retiros durante el mes, se aplicará una comisión
	 * adicional de $1000 por cada retiro adicional.
	*/
	@Override
	public void imprimir() {
		float comision = numRetiros > 4 ? comisionMensual + (numRetiros - 4) * 1000: 0;
		System.out.println("Por ahora mi saldo, comision y numtransacciones seria: ");
		System.out.println("saldo: "+(saldo-comision));
		System.out.println("comision mensual: "+comision);
		System.out.println("Numero de Transacciones: "+(numConsignaciones+numRetiros));
	}
	
}
