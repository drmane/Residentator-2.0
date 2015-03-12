package transaction_manager;

/**
 * La implementación de la fábrica de transacciones
 * @author Daniel
 *
 */
public class FactoryTransactionImp extends FactoryTransaction{

	@Override
	public Transaction generateTransaction() {
		return new TransactionMySQL();
	}
}
