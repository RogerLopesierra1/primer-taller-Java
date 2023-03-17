package cuenta_bancaria;

/**
 * Esta clase representa una cuenta bancaria con un saldo, tasa de interés anual,
 * y funciones para depositar, retirar, calcular intereses, generar un extracto 
 * mensual e imprimir la información de la cuenta.
 */
public class Cuenta {
	protected float saldo;
    protected int numConsignaciones = 0;
    protected int numRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;
    
    /**
     * Crea una nueva cuenta bancaria con el saldo inicial 
     * y tasa de interés anual especificados.
     * 
     * @param saldo: es el saldo inicial de la cuenta.
     * @param tasaAnual: es la tasa de interés anual de la cuenta.
     */
	public Cuenta(float saldo, float tasaAnual) {
		super();
		this.saldo = saldo;
		this.tasaAnual = tasaAnual;
	}
	
	/**
     * Deposita la cantidad especificada en la cuenta.
     * 
     * @param cantidad: es la cantidad a depositar.
     */
	public void consignar(float cantidad) {
		saldo += cantidad;
        numConsignaciones++;
	}
	
	/**
     * Retira la cantidad especificada de la cuenta, si es posible.
     * Si la cantidad a retirar es mayor que el saldo disponible, 
     * no se realiza la operación y se muestra un mensaje de error.
     * 
     * @param cantidad: es la cantidad a retirar.
     */
	public void retirar(float cantidad) {
		if (cantidad <= saldo) {
            saldo -= cantidad;
            numRetiros++;
        } else {
            System.out.println("Error: Maximo puede retirar "+this.saldo);
        }
	}
	
	/**
     * Calcula los intereses mensuales de la cuenta y los agrega al saldo.
     */
	public void calcularInteresMensual() {
		float interes = saldo * tasaAnual / (12*100);
        saldo += interes;
	}
    
	/**
     * Genera el extracto mensual de la cuenta, incluyendo la comisión mensual, los intereses generados y el número de consignaciones 
     * y retiros realizados en el mes.
     * 
     * Reinicia el contador de consignaciones y retiros, 
     * y establece la comisión mensual a cero.
     */
	public void extractoMensual() {
		saldo -= comisionMensual;
		calcularInteresMensual();
		numConsignaciones = 0;
        numRetiros = 0;
        comisionMensual = 0;
	}
	
	/**
     * Imprime la información de la cuenta, incluyendo el saldo actual,
     * el número de consignaciones y retiros realizados,
     * la tasa de interés anual y la comisión mensual.
     */
	public void imprimir() {
        System.out.println("                   Saldo: " + saldo);
        System.out.println("Número de consignaciones: " + numConsignaciones);
        System.out.println("       Número de retiros: " + numRetiros);
        System.out.println("              Tasa anual: " + tasaAnual);
        System.out.println("        Comisión mensual: " + comisionMensual);
    }
   
	
}
