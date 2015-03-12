package residente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import transaction_manager.Transaction;
import transaction_manager.TransactionManager;

public class DAOResidenteImp implements DAOResidente{

	@Override
	public int crearResidente(TransferResidente t) {
		//Si no se cambia el valor, devuelve error
		int valorDevuelto = -1;
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		//Si no esta activada y tiene id, es decir, que ya existía
		//Se hace Update
		if((!t.isActivo()&&t.getId() >= 0)){
			
			PreparedStatement statementPrepared;
			try {
				statementPrepared = connection.prepareStatement(
						"UPDATE Residentes SET ID_Habitacion = ?, Nombre = ? , Apellidos = ?, Sexo = ?, Activo = 1 WHERE ? = ID_Residente");
				
				statementPrepared.setInt(1, t.getNum_hab());
				
				statementPrepared.setString(2, t.getNombre());
				
				statementPrepared.setString(3, t.getApellidos());
				
				statementPrepared.setString(4, String.valueOf(t.getSexo()));
				
				statementPrepared.setInt(5, t.getId());
				
				statementPrepared.executeUpdate();
				
				//La información de si es residente o no se descarta
				
				//Obtiene el ID de la habitación activada, el cual ya existía
				valorDevuelto = t.getId();
			} catch (SQLException e) {
				System.err.println("ERROR!! El Residente No se ha activado");
				valorDevuelto = -1;
				e.printStackTrace();
			}
			
			
		}
		else{

			//Sino, se hace Insert
			
			//Parte general de todos los residentes
			try {
				PreparedStatement statementPrepared = connection.prepareStatement(
						"INSERT INTO Residentes (ID_Habitacion,DNI,Nombre,Apellidos,Sexo,Activo) VALUES (?,?,?,?,?,?)");
			
				statementPrepared.setInt(1, t.getNum_hab());
				
				statementPrepared.setString(2, t.getDni());
				
				statementPrepared.setString(3, t.getNombre());
				
				statementPrepared.setString(4, t.getApellidos());
				
				statementPrepared.setString(5, String.valueOf(t.getSexo()));
				
				//Se crea activada la habitación
				statementPrepared.setBoolean(6, true);
				
				statementPrepared.executeUpdate();
				
				statementPrepared = null;
				
				//Obtiene el ID del residente creado
				valorDevuelto = getId(t.getDni());
				
				//Comprueba si el residente es estudiante o no
				if(t.getClass() == TransferResidenteEstudiante.class){
					PreparedStatement statementPrepared2 = connection.prepareStatement(
							"INSERT INTO ResidentesEstudiantes (ID_Residente,Email) VALUES (?,?)");
					
					//Se pone el ID del residente
					statementPrepared2.setInt(1, valorDevuelto);
					
					statementPrepared2.setString(2, ((TransferResidenteEstudiante)t).getEmail());
					
					statementPrepared2.executeUpdate();
				}
				else{
					//Caso de Residente no estudiante
					
					PreparedStatement statementPrepared2 = connection.prepareStatement(
							"INSERT INTO ResidentesNoEstudiantes (ID_Residente,Telefono,Domicilio) VALUES (?,?,?)");
					
					//Se pone el ID del residente
					statementPrepared2.setInt(1, valorDevuelto);
					
					statementPrepared2.setInt(2, ((TransferResidenteNoEstudiante)t).getTelefono());
					
					statementPrepared2.setString(3, ((TransferResidenteNoEstudiante)t).getDomicilio());
					
					statementPrepared2.executeUpdate();
				}
				
			} catch (SQLException e) {
				System.err.println("ERROR!! El Residente no se ha creado");
				valorDevuelto = -1;
				e.printStackTrace();
			}
			
		}
		
		return valorDevuelto;
	}

	@Override
	public boolean bajaResidente(int id) {
		boolean valorDevuelto;
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		

		try {
				PreparedStatement statementPrepared = connection.prepareStatement(
						"UPDATE Residentes SET Activo = false WHERE ? = ID_Residente");
				
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
	public TransferResidente buscarResidente(int id) {
		TransferResidente transferResidente = null;
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		

		try {
			
			//Comprobamos si es estudiante o no
			PreparedStatement statementPrepared = connection.prepareStatement(
					"SELECT * FROM ResidentesEstudiantes WHERE ID_Residente = ? FOR UPDATE");
			
			statementPrepared.setInt(1, id);
			
			statementPrepared.execute();
			
			ResultSet rs3 = statementPrepared.getResultSet();
			
			boolean resultadoConsulta3 = rs3.next();
			
			if(rs3 != null){
				
				//Si devuelve algo es estudiante, sino no lo es
				if(resultadoConsulta3){
					transferResidente = new TransferResidenteEstudiante();
					
					((TransferResidenteEstudiante)transferResidente).setEmail(rs3.getString("Email"));
				}
				else{
					
					transferResidente = new TransferResidenteNoEstudiante();
					
					//Debemos obtener la información del residente no estudiante
					
					statementPrepared = null;
					
					statementPrepared = connection.prepareStatement(
							"SELECT * FROM ResidentesNoEstudiantes WHERE ID_Residente = ? FOR UPDATE");
					
					statementPrepared.setInt(1, id);
					
					statementPrepared.execute();
					
					ResultSet rs4 = statementPrepared.getResultSet();
					
					boolean resultadoConsulta4 = rs4.next();
					
					if((rs4 != null)&&(resultadoConsulta4)){
						((TransferResidenteNoEstudiante)transferResidente).setTelefono(rs4.getInt("Telefono"));
						((TransferResidenteNoEstudiante)transferResidente).setDomicilio(rs4.getString("Domicilio"));
					}
				}
				
				//Introduce el ID en el Transfer en este momento
				transferResidente.setId(id);
			}
	
			//Datos generales del residente
			statementPrepared = null;
			
			statementPrepared = connection.prepareStatement(
					"SELECT * FROM Residentes WHERE ID_Residente = ? FOR UPDATE");
			
			statementPrepared.setInt(1, id);
			
			statementPrepared.execute();
			
			ResultSet rs = statementPrepared.getResultSet();
		
			boolean resultadoConsulta = rs.next();
			
			//Comprueba si se ha devuelto algo en la consulta
			if((rs != null)&&(resultadoConsulta)){					
				
				//Aplica los datos que había en la BD al transfer
				transferResidente.setDni(rs.getString("DNI"));	
				transferResidente.setNombre(rs.getString("Nombre"));
				transferResidente.setApellidos(rs.getString("Apellidos"));
				transferResidente.setSexo(rs.getString("Sexo").charAt(0));
				
				if(rs.getInt("Activo") == 1){
					transferResidente.setActivo(true);
				}
				else{
					transferResidente.setActivo(false);
				}
				
				statementPrepared = null;
				
				//Relaciones 
				
				//Obtiene el id de la Habitación
				transferResidente.setNum_hab(rs.getInt("ID_Habitacion"));
				
				
				//Obtiene el ID de las Facturas de ese Residente
				statementPrepared = connection.prepareStatement(
						"SELECT * FROM Facturas WHERE ID_Residente = ? AND Activo = 1 FOR UPDATE");
				
				statementPrepared.setInt(1, id);
				
				statementPrepared.execute();
				
				ResultSet rs2 = statementPrepared.getResultSet();
				
				boolean resultadoConsulta2 = rs2.next();
				
				if((rs2 != null)&&(resultadoConsulta2)){	
					
					//Reajustamos el puntero
					rs2.beforeFirst();
					
					//Recorre las facturas de esa habitación y añade sus id al transfer
					while(rs2.next()){
						transferResidente.getId_facturas_residentes().add(rs2.getInt("ID_Factura"));
					}
				}
			}		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//Si los datos no son correctos, se devuelve null
		if(transferResidente.getId() < 0){
			transferResidente = null;
		}
		
		return transferResidente;
	}

	@Override
	public boolean modificarResidente(TransferResidente transferResidente) {
		boolean valorDevuelto;
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		

		try {
				PreparedStatement statementPrepared = connection.prepareStatement(
						"UPDATE Residentes SET Nombre = ?, Apellidos = ?, Sexo = ? WHERE ? = ID_Residente");
				
				statementPrepared.setString(1, transferResidente.getNombre());
				
				statementPrepared.setString(2, transferResidente.getApellidos());
				
				statementPrepared.setString(3, String.valueOf(transferResidente.getSexo()));
				
				statementPrepared.setInt(4, transferResidente.getId());
				
				statementPrepared.executeUpdate();
				
				statementPrepared = null;
				
				if(transferResidente.getClass() == TransferResidenteEstudiante.class){
					
					//Comprobamos si está en la tabla de Residentes estudiantes
					statementPrepared = connection.prepareStatement(
							"Select * From ResidentesEstudiantes WHERE ? = ID_Residente");
					
					statementPrepared.setInt(1, transferResidente.getId());
					
					statementPrepared.execute();
					
					ResultSet rs = statementPrepared.getResultSet();
					
					if(rs != null){
						boolean resultadoConsulta = rs.next();
						
						statementPrepared = null;
						
						if(resultadoConsulta){
							//Si hay algo, se hace un update
							
							statementPrepared = connection.prepareStatement(
									"UPDATE ResidentesEstudiantes SET Email = ? WHERE ? = ID_Residente");
							
							statementPrepared.setString(1, ((TransferResidenteEstudiante)transferResidente).getEmail());
							
							statementPrepared.setInt(2, ((TransferResidenteEstudiante)transferResidente).getId());
							
							statementPrepared.executeUpdate();
						}
						else{
							//Sino, se borra de la otra y se hace un insert (borrado físico)
							
							statementPrepared = connection.prepareStatement(
									"DELETE FROM ResidentesNoEstudiantes WHERE ? = ID_Residente");
							
							statementPrepared.setInt(1, transferResidente.getId());
							
							statementPrepared.executeUpdate();
							
							statementPrepared = null;
							
							statementPrepared = connection.prepareStatement(
									"INSERT INTO ResidentesEstudiantes (ID_Residente,Email) VALUES (?,?)");
							
							statementPrepared.setInt(1, transferResidente.getId());
							
							statementPrepared.setString(2, ((TransferResidenteEstudiante)transferResidente).getEmail());
							
							statementPrepared.executeUpdate();
						}
					}
				}
				else if (transferResidente.getClass() == TransferResidenteNoEstudiante.class){
					//Comprobamos si está en la tabla de Residentes no estudiantes
					statementPrepared = connection.prepareStatement(
							"Select * From ResidentesNoEstudiantes WHERE ? = ID_Residente");
					
					statementPrepared.setInt(1, transferResidente.getId());
					
					statementPrepared.execute();
					
					ResultSet rs = statementPrepared.getResultSet();
					
					if(rs != null){
						boolean resultadoConsulta = rs.next();
						
						statementPrepared = null;
						
						if(resultadoConsulta){
							//Si hay algo, se hace un update
							
							statementPrepared = connection.prepareStatement(
									"UPDATE ResidentesNoEstudiantes SET Telefono = ?, Domicilio = ?  WHERE ? = ID_Residente");
							
							statementPrepared.setInt(1, ((TransferResidenteNoEstudiante)transferResidente).getTelefono());
							
							statementPrepared.setString(2, ((TransferResidenteNoEstudiante)transferResidente).getDomicilio());
							
							statementPrepared.setInt(3, transferResidente.getId());
							
							statementPrepared.executeUpdate();
						}
						else{
							//Sino, se borra de la otra y se hace un insert (borrado físico)
							
							statementPrepared = connection.prepareStatement(
									"DELETE FROM ResidentesEstudiantes WHERE ? = ID_Residente");
							
							statementPrepared.setInt(1, transferResidente.getId());
							
							statementPrepared.executeUpdate();
							
							statementPrepared = null;
							
							statementPrepared = connection.prepareStatement(
									"INSERT INTO ResidentesNoEstudiantes (ID_Residente,Telefono,Domicilio) VALUES (?,?,?)");
							
							statementPrepared.setInt(1, transferResidente.getId());
							
							statementPrepared.setInt(2, ((TransferResidenteNoEstudiante)transferResidente).getTelefono());
							
							statementPrepared.setString(3, ((TransferResidenteNoEstudiante)transferResidente).getDomicilio());
							
							statementPrepared.executeUpdate();
						}
					}	
				}
				
				valorDevuelto = true;
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				valorDevuelto = false;
				e.printStackTrace();
		}
		
		return valorDevuelto;
	}

	@Override
	public int getId(String dni) {
		int valorDevuelto;
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		PreparedStatement statementPrepared;
		try {
			statementPrepared = connection.prepareStatement("SELECT ID_Residente FROM Residentes WHERE DNI = ? FOR UPDATE");
		
			statementPrepared.setString(1, dni);
		
			statementPrepared.execute();
		
			ResultSet rs = statementPrepared.getResultSet();
		
			//Obtiene el ID de la fila devuelta
			
			//Avanzar el cursor, sino error
			rs.next();
			valorDevuelto = rs.getInt("ID_Residente");	
		} catch (SQLException e) {
			valorDevuelto = -1;
			// TODO Auto-generated catch block
			System.err.println("Ese DNI no existe en el sistema");
		}
		
		return valorDevuelto;
	}

}
