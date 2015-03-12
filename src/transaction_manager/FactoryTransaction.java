package transaction_manager;


/**
 * La fábrica que permite crear transacciones
 * @author Daniel
 *
 */
public abstract class FactoryTransaction {
	
	private static FactoryTransaction factoryTransaction;

	/**
	 * Constructor privado por ser singleton
	 */
	protected FactoryTransaction() {
	}

	/**
	 * Obtiene una instancia de la clase
	 * 
	 * @return la instancia de la clase
	 */
	public static FactoryTransaction obtenerInstancia() {

		if (factoryTransaction == null) {
			factoryTransaction = new FactoryTransactionImp();
		}

		return factoryTransaction;
	}
	
	/**
	 * Permite obtener una transacción
	 * @return la Transaction generada
	 */
	public abstract Transaction generateTransaction();
}
