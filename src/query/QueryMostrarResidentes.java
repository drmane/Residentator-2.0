package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import residente.TransferResidente;
import transaction_manager.Transaction;
import transaction_manager.TransactionManager;

public class QueryMostrarResidentes implements Query {

	@Override
	public Object execute(Object datos) {
		List<TransferResidente> listaResidentes = new ArrayList<TransferResidente>();
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		try {
			
			//Recoge los residentes activos
			PreparedStatement statementPrepared = connection.prepareStatement(
					"SELECT * FROM Residentes WHERE Residentes.Activo = 1 FOR UPDATE");
			
			statementPrepared.execute();
			
			ResultSet rs = statementPrepared.getResultSet();
			
			boolean resultadoConsulta = rs.next();
			
			if((rs != null)&&(resultadoConsulta)){	
				
				//Reajustamos el puntero
				rs.beforeFirst();
				
				//Añade los residentes a la lista
				while(rs.next()){
					//Crea un nuevo transfer
					TransferResidente t = new TransferResidente();
					
					t.setId(rs.getInt("ID_Residente"));
					t.setDni(rs.getString("DNI"));
					t.setNombre(rs.getString("Nombre"));
					t.setApellidos(rs.getString("Apellidos"));
					//Obtiene los datos del resultado de la consulta y los añade al transfer
					
					//Lo añade a la lista
					listaResidentes.add(t);
				}
			}
		} catch (SQLException e) {
			System.err.println("ERROR!! La conexión con la BD ha fallado");
			e.printStackTrace();
		}
		
		return listaResidentes;
	}

}
