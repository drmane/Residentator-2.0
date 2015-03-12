package habitacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import transaction_manager.Transaction;
import transaction_manager.TransactionManager;


public class DAOHabitacionImp implements DAOHabitacion {

	@Override
	public int crearHabitacion(TransferHabitacion t) {
		//Si no se cambia el valor, devuelve error
		int valorDevuelto = -1;
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		//Si no esta activada y tiene id, es decir, que ya existía
		//Se hace Update
		if((!t.isActivo()&&t.getId() != 0)){
			PreparedStatement statementPrepared;
			try {
				statementPrepared = connection.prepareStatement(
						"UPDATE Habitaciones SET Activo = 1 WHERE ? = Numero_Habitacion");
				
				statementPrepared.setInt(1, t.getNumero_hab());
				
				statementPrepared.executeUpdate();
				
				//Obtiene el ID de la habitación activada, el cual ya existía
				valorDevuelto = t.getId();
			} catch (SQLException e) {
				System.err.println("ERROR!! La habitación no se ha activado");
				valorDevuelto = -1;
				e.printStackTrace();
			}
			
			
		}
		else{

			//Sino, se hace Insert
			try {
				PreparedStatement statementPrepared = connection.prepareStatement(
						"INSERT INTO Habitaciones (Numero_Habitacion,Capacidad,Numero_Ocupantes,Activo) VALUES (?,?,?,?)");
			
				statementPrepared.setInt(1, t.getNumero_hab());
				
				statementPrepared.setInt(2, t.getCapacidad());
				
				//Cuando se crea la habitación, no puede haber ocupantes
				statementPrepared.setInt(3, 0);
				
				//Se crea activada la habitación
				statementPrepared.setBoolean(4, true);
				
				statementPrepared.executeUpdate();
				
				statementPrepared = null;
				
				//Obtiene el ID de la habitación creada
				valorDevuelto = getId(t.getNumero_hab());
				
				
			} catch (SQLException e) {
				System.err.println("ERROR!! La habitación no se ha creado");
				valorDevuelto = -1;
				e.printStackTrace();
			}
			
		}
		
		return valorDevuelto;
	}

	@Override
	public boolean bajaHabitacion(int id) {
		boolean valorDevuelto;
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		

		try {
				PreparedStatement statementPrepared = connection.prepareStatement(
						"UPDATE Habitaciones SET Activo = false WHERE ? = ID_Habitacion");
				
				statementPrepared.setInt(1, id);
				
				statementPrepared.executeUpdate();
				
				valorDevuelto = true;
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				valorDevuelto = false;
				e.printStackTrace();
		}
		
		return valorDevuelto;
	}

	@Override
	public TransferHabitacion buscarHabitacion(int id) {
		TransferHabitacion transferHabitación = new TransferHabitacion();
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();
		
		//Introduce el ID en el Transfer en este momento
		transferHabitación.setId(id);

		Connection connection = (Connection) transaction.getResource();
		

		try {
			PreparedStatement statementPrepared = connection.prepareStatement(
					"SELECT * FROM Habitaciones WHERE ID_Habitacion = ? FOR UPDATE");
			
			statementPrepared.setInt(1, id);
			
			statementPrepared.execute();
			
			ResultSet rs = statementPrepared.getResultSet();
		
			boolean resultadoConsulta = rs.next();
			
			//Comprueba si se ha devuelto algo en la consulta
			if((rs != null)&&(resultadoConsulta)){					
				
				//Aplica los datos que había en la BD al transfer
				transferHabitación.setNumero_hab(rs.getInt("Numero_Habitacion"));	
				transferHabitación.setCapacidad(rs.getInt("Capacidad"));
				transferHabitación.setNumero_ocupantes(rs.getInt("Numero_Ocupantes"));
				
				if(rs.getInt("Activo") == 1){
					transferHabitación.setActivo(true);
				}
				else{
					transferHabitación.setActivo(false);
				}
				
				statementPrepared = null;
				
				//Obtiene el ID de los Residentes de esa habitación
				statementPrepared = connection.prepareStatement(
						"SELECT DNI FROM Residentes WHERE ID_Habitacion = ? AND Activo = 1 FOR UPDATE");
				
				statementPrepared.setInt(1, id);
				
				statementPrepared.execute();
				
				ResultSet rs1 = statementPrepared.getResultSet();
				
				boolean resultadoConsulta1 = rs1.next();
				
				if((rs1 != null)&&(resultadoConsulta1)){	
					
					//Reajustamos el puntero
					rs1.beforeFirst();
					
					//Recorre los residentes de esa habitación y añade sus id al transfer
					while((rs1.next()&&(resultadoConsulta))){
						transferHabitación.getDni_residentes_ocupantes().add(rs1.getString("DNI"));
					}
				}
				
				statementPrepared = null;
				
				//Obtiene el ID de las Facturas de esa habitación
				
				//Lo de activo = 1 en esta no se pone por que si se da de baja, se borrará de esta tabla
				statementPrepared = connection.prepareStatement(
						"SELECT * FROM HabitacionFactura WHERE ID_Habitacion = ? FOR UPDATE");
				
				statementPrepared.setInt(1, id);
				
				statementPrepared.execute();
				
				ResultSet rs2 = statementPrepared.getResultSet();
				
				boolean resultadoConsulta2 = rs2.next();
				
				if((rs2 != null)&&(resultadoConsulta2)){	
					
					//Reajustamos el puntero
					rs2.beforeFirst();
					
					//Recorre las facturas de esa habitación y añade sus id al transfer
					while(rs2.next()){
						int i = rs2.getInt("ID_Factura");
						
						transferHabitación.getId_facturas_habitación().add(i);
					}
				}
			}

		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		//Si los datos no son correctos, se devuelve null
		if(transferHabitación.getId() < 0){
			transferHabitación = null;
		}
		
		return transferHabitación;
	}

	@Override
	public boolean modificarHabitacion(TransferHabitacion transferHabitacion) {
		boolean valorDevuelto;
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		

		try {
				PreparedStatement statementPrepared = connection.prepareStatement(
						"UPDATE Habitaciones SET Capacidad = ?, Numero_Ocupantes = ? WHERE ? = ID_Habitacion");
				
				statementPrepared.setInt(1, transferHabitacion.getCapacidad());
				
				statementPrepared.setInt(2, transferHabitacion.getNumero_ocupantes());
				
				statementPrepared.setInt(3, transferHabitacion.getId());
				
				statementPrepared.executeUpdate();
				
				valorDevuelto = true;
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				valorDevuelto = false;
				e.printStackTrace();
		}
		
		return valorDevuelto;
	}

	@Override
	public int getId(int numero_hab) {
		int valorDevuelto;
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		PreparedStatement statementPrepared;
		try {
			statementPrepared = connection.prepareStatement("SELECT ID_Habitacion FROM Habitaciones WHERE Numero_Habitacion = ? FOR UPDATE");
		
			statementPrepared.setInt(1, numero_hab);
		
			statementPrepared.execute();
		
			ResultSet rs = statementPrepared.getResultSet();
		
			//Obtiene el ID de la fila devuelta
			
			//Avanzar el cursor, sino error
			rs.next();
			valorDevuelto = rs.getInt("ID_Habitacion");	
		} catch (SQLException e) {
			valorDevuelto = -1;
			// TODO Auto-generated catch block
			System.err.println("Ese Número de Habitación no existe en el sistema");
		}
		
		return valorDevuelto;
	}
}
