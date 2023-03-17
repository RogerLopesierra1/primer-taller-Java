package cuenta_bancaria;

/**
 * La clase CuentaCorriente hereda de la clase Cuenta y representa 
 * una cuenta bancaria corriente.
 * Permite retirar y consignar dinero y tiene un campo adicional 
 * para manejar el sobregiro.
*/
public class CuentaCorriente extends Cuenta{
	private float sobregiro;
	
	/**
	 * Constructor de la clase CuentaCorriente.
	 * @param saldo: es el saldo inicial de la cuenta.
	 * @param tasaAnual: es la tasa de interés anual de la cuenta.
	 */
	public CuentaCorriente(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
		this.sobregiro = 0;
	}
	
	/**
	 * Este método sobrescribe el método retirar de la clase padre Cuenta.
	 * Método para retirar dinero de la cuenta corriente.
	 * Si la cantidad es menor o igual al saldo disponible, se realiza la operación.
	 * En caso contrario, se utiliza el sobregiro para cubrir el retiro.
	 * @param cantidad La cantidad de dinero a retirar.
	 */
	@Override
	public void retirar(float cantidad) {
		if (cantidad <= saldo) {
			saldo -= cantidad;
			
		} else {
			sobregiro += (cantidad - saldo);
		}
		
		numRetiros++;
		
	}
	
	/**
	 * Este método sobrescribe el método consignar de la clase padre Cuenta.
	 * Método para consignar dinero a la cuenta corriente.
	 * Si hay un sobregiro pendiente, se utiliza para cubrir la consignación.
	 * En caso contrario, se realiza la consignación normalmente.
	 * @param cantidad La cantidad de dinero a consignar.
	 */
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
	
	/**
	 * Este método sobrescribe el método extractoMensual de la clase padre Cuenta.
	 * Método para generar el extracto mensual de la cuenta corriente.
	 * Calcula la comisión mensual correspondiente y llama al método extractoMensual de la clase padre.
	 */
	@Override
    public void extractoMensual() {
        float comisionMensual = this.numRetiros > 4 ? (this.numRetiros - 4) * 1000 : 0;
        super.extractoMensual();        
        this.comisionMensual = comisionMensual;
    }
	
	/**
	 * Este método sobrescribe el método imprimiir de la clase padre Cuenta.
	 * Método para imprimir la información de la cuenta corriente.
	 * Imprime el saldo, la comisión mensual, el número de transacciones realizadas y el sobregiro.
	 */
	@Override
    public void imprimir() {
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Comision mensual: " + this.comisionMensual);
        System.out.println("Transacciones realizadas: " + (numConsignaciones+numRetiros));
        System.out.println("Sobregiro: " + this.sobregiro);
    }
	
  
	
}
