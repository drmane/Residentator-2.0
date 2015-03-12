package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import transaction_manager.Transaction;
import transaction_manager.TransactionManager;

public class QueryAsignarFactura implements Query{

	@Override
	public Object execute(Object datos) {
		
		int valorDevuelto = -1;
		
		List<Integer> lista = (List<Integer>)datos;
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		PreparedStatement statementPrepared;
		try {
			statementPrepared = connection.prepareStatement(
					"INSERT INTO HabitacionFactura (ID_Factura,ID_Habitacion) VALUES (?,?)");
		statementPrepared.setInt(1,lista.get(0));
		
		statementPrepared.setInt(2,lista.get(1));
		
		valorDevuelto = 1;
		
		statementPrepared.executeUpdate();
		
		statementPrepared = null;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return valorDevuelto;
	}

}
