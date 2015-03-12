package transaction_manager;

/**
 * Interfaz de las transacciones de la aplicación
 * @author Daniel
 *
 */
public interface Transaction {

	/**
	 * Permite empezar la transaccion
	 */
	public void start();
	
	/**
	 * Permite realizar los cambios en la BD
	 */
	public void commit();
	
	/**
	 * Permite deshacer los cambios en la BD
	 */
	public void rollback();
	
	/**
	 * Permite obtener la conexión a la BD
	 */
	public Object getResource();
}
