package transaction_manager;

import java.util.concurrent.ConcurrentHashMap;

/**
 * El gestor de las transacciones
 * @author Daniel
 *
 */
public class TransactionManager {
	
	ConcurrentHashMap<Long, Transaction> mapa_hilo_transaction;
	
	private static TransactionManager transactionManager;

	/**
	 * Constructor privado por ser singleton
	 */
	private TransactionManager() {
		mapa_hilo_transaction = new ConcurrentHashMap<Long, Transaction>();
	}

	/**
	 * Obtiene una instancia de la clase
	 * 
	 * @return la instancia de la clase
	 */
	public static TransactionManager obtenerInstancia() {

		if (transactionManager == null) {
			transactionManager = new TransactionManager();
		}

		return transactionManager;
	}
	
	/**
	 * Permite crear transacciones, en el caso de que este creada no hace nada
	 * @return la transaccion
	 */
	public  Transaction nuevaTransaccion(){
		//obtiene el id del hilo
		long id_hilo = Thread.currentThread().getId();
		
		Transaction transaction = null;
		
		//si en el mapa no está la transacción, la crea
		if(!mapa_hilo_transaction.contains(id_hilo)){
			FactoryTransaction factoryTransaction = FactoryTransaction.obtenerInstancia();
			transaction = factoryTransaction.generateTransaction();
			mapa_hilo_transaction.put(id_hilo, transaction);
		}
		
		return transaction;
	}
	
	/**
	 * Permite obtener transacciones ya creadas
	 * @return la transaccion
	 */
	public  Transaction getTransaccion(){
		//obtiene el id del hilo
		long id_hilo = Thread.currentThread().getId();
		
		Transaction transaction = null;
		
		//si en el mapa está la transacción, la obtiene
		if(mapa_hilo_transaction.containsKey(id_hilo)){
			transaction = (Transaction) mapa_hilo_transaction.get(id_hilo);
		}
		
		return transaction;
		
	}
	
	/**
	 * Permite borrar transacciones, en el caso de que no esté, no hace nada
	 */
	public  void eliminarTransaccion(){
		//obtiene el id del hilo
		long id_hilo = Thread.currentThread().getId();
		
		//si en el mapa está la transacción, la borra
		if(mapa_hilo_transaction.containsKey(id_hilo)){
			mapa_hilo_transaction.remove(id_hilo);
		}
	}
}
