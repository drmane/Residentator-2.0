package query;

import habitacion.TransferHabitacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transaction_manager.Transaction;
import transaction_manager.TransactionManager;

public class QueryMostrarHabitaciones implements Query{
	
	/**
	 * Permite obtener una lista de las habitaciones activas del sistema
	 */
	@Override
	public Object execute(Object datos) {
		List<TransferHabitacion> listaHabitaciones = new ArrayList<TransferHabitacion>();
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		try {
			
			//Recoge las habitaciones activas
			PreparedStatement statementPrepared = connection.prepareStatement(
					"SELECT * FROM Habitaciones WHERE Habitaciones.Activo = 1 FOR UPDATE");
			
			statementPrepared.execute();
			
			ResultSet rs = statementPrepared.getResultSet();
			
			boolean resultadoConsulta = rs.next();
			
			if((rs != null)&&(resultadoConsulta)){	
				
				//Reajustamos el puntero
				rs.beforeFirst();
				
				//Añade las habitaciones a la lista
				while(rs.next()){
					//Crea un nuevo transfer
					TransferHabitacion t = new TransferHabitacion();
					
					t.setId(rs.getInt("ID_Habitacion"));
					t.setNumero_hab(rs.getInt("Numero_Habitacion"));
					t.setCapacidad(rs.getInt("Capacidad"));
					t.setNumero_ocupantes(rs.getInt("Numero_Ocupantes"));
					//Obtiene los datos del resultado de la consulta y los añade al transfer
					
					//Lo añade a la lista
					listaHabitaciones.add(t);
				}
			}
		} catch (SQLException e) {
			System.err.println("ERROR!! La conexión con la BD ha fallado");
			e.printStackTrace();
		}
		
		return listaHabitaciones;
	}
}
