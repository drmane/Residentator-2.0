package transaction_manager;

/**
 * La implementaci�n de la f�brica de transacciones
 * @author Daniel
 *
 */
public class FactoryTransactionImp extends FactoryTransaction{

	@Override
	public Transaction generateTransaction() {
		return new TransactionMySQL();
	}
}
