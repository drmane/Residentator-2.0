package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transaction_manager.Transaction;
import transaction_manager.TransactionManager;
import factura.TransferFactura;

public class QueryMostrarFacturas implements Query{

	@Override
	public Object execute(Object datos) {
		List<TransferFactura> listaFacturas = new ArrayList<TransferFactura>();
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		try {
			
			//Recoge las habitaciones activas
			PreparedStatement statementPrepared = connection.prepareStatement(
					"SELECT * FROM Facturas WHERE Facturas.Activo = 1 FOR UPDATE");
			
			statementPrepared.execute();
			
			ResultSet rs = statementPrepared.getResultSet();
			
			boolean resultadoConsulta = rs.next();
			
			if((rs != null)&&(resultadoConsulta)){	
				
				//Reajustamos el puntero
				rs.beforeFirst();
				
				//A�ade las habitaciones a la lista
				while(rs.next()){
					//Crea un nuevo transfer
					TransferFactura t = new TransferFactura();
					
					t.setId(rs.getInt("ID_Factura"));
					t.setFecha(rs.getString("Fecha_hora"));
					t.setCutoa(rs.getDouble("Cuota"));
					//Obtiene los datos del resultado de la consulta y los a�ade al transfer
					
					//Lo a�ade a la lista
					listaFacturas.add(t);
				}
			}
		} catch (SQLException e) {
			System.err.println("ERROR!! La conexi�n con la BD ha fallado");
			e.printStackTrace();
		}
		
		return listaFacturas;
	}
}
