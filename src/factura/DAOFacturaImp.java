package factura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import transaction_manager.Transaction;
import transaction_manager.TransactionManager;

public class DAOFacturaImp implements DAOFactura{

	@Override
	public int crearFactura(TransferFactura t) {
		//Si no se cambia el valor, devuelve error
		int valorDevuelto = -1;
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		//Si no esta activada y tiene id, es decir, que ya existía
		//Se hace Update
		if(t.isActivo()){
			/*
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
			*/
		}
		else{

			//Sino, se hace Insert
			try {
				PreparedStatement statementPrepared = connection.prepareStatement(
						"INSERT INTO Facturas (ID_Residente,Pagado,Fecha_hora,Cuota,En_metalico,NumeroCuenta,Activo) VALUES (?,?,?,?,?,?,?)");
			
				statementPrepared.setInt(1, t.getId());
				
				statementPrepared.setBoolean(2, t.isEstaPagado());
				
				//Se mete la fecha y hora de la factura
				
			    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			    Date now = new Date();
			    String strDate = sdfDate.format(now);
			    
				statementPrepared.setString(3,strDate);
				
				statementPrepared.setDouble(4, t.getCutoa());
				
				statementPrepared.setBoolean(5, t.isEnMetalico());
				
				statementPrepared.setString(6, t.getNumeroCuenta());
				
				statementPrepared.setBoolean(7, true);
				
				statementPrepared.executeUpdate();
				
				statementPrepared = null;
				
				//Obtengo el ID de la factura
				valorDevuelto = getId(strDate);
				
				/*
				//Insertar la información en la otra tabla de las facturas
				statementPrepared = connection.prepareStatement(
						"INSERT INTO HabitacionFactura (ID_Factura,ID_Habitacion) VALUES (?,?)");
			
				statementPrepared.setInt(1,valorDevuelto);
				
				//En la posición 1 de la lista de las habitaciones está el ID, en la 0 está el número de la habitación
				statementPrepared.setInt(2,t.getNumero_habitaciones_facturas().get(1));
				
				statementPrepared.executeUpdate();
				
				statementPrepared = null;
				*/
				
			} catch (SQLException e) {
				System.err.println("ERROR!! La Factura no se ha creado");
				valorDevuelto = -1;
				e.printStackTrace();
			}
			
		}
		
		return valorDevuelto;
	}

	@Override
	public boolean bajaFactura(int id) {
		boolean valorDevuelto;
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		

		try {
				PreparedStatement statementPrepared = connection.prepareStatement(
						"UPDATE Facturas SET Activo = false WHERE ? = ID_Factura");
				
				statementPrepared.setInt(1, id);
				
				statementPrepared.executeUpdate();
				
				statementPrepared = null;
				
				statementPrepared = connection.prepareStatement(
						"DELETE FROM HabitacionFactura WHERE ? = ID_Factura");
				
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
	public TransferFactura buscarFactura(int id) {
		TransferFactura transferFactura = new TransferFactura();
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();
		
		//Introduce el ID en el Transfer en este momento
		transferFactura.setId(id);

		Connection connection = (Connection) transaction.getResource();
		

		try {
			PreparedStatement statementPrepared = connection.prepareStatement(
					"SELECT * FROM Facturas WHERE ID_Factura = ? FOR UPDATE");
			
			statementPrepared.setInt(1, id);
			
			statementPrepared.execute();
			
			ResultSet rs = statementPrepared.getResultSet();
		
			boolean resultadoConsulta = rs.next();
			
			//Comprueba si se ha devuelto algo en la consulta
			if((rs != null)&&(resultadoConsulta)){					
				
				//Aplica los datos que había en la BD al transfer
				transferFactura.setFecha(rs.getString("Fecha_hora"));
				transferFactura.setCutoa(rs.getDouble("Cuota"));
				transferFactura.setNumeroCuenta(rs.getString("NumeroCuenta"));
				
				if(rs.getInt("Pagado") == 1){
					transferFactura.setEstaPagado(true);
				}
				else{
					transferFactura.setEstaPagado(false);
				}
				
				if(rs.getInt("En_metalico") == 1){
					transferFactura.setEnMetalico(true);
				}
				else{
					transferFactura.setEnMetalico(false);
				}
				
				if(rs.getInt("Activo") == 1){
					transferFactura.setActivo(true);
				}
				else{
					transferFactura.setActivo(false);
				}
				
				statementPrepared = null;
				
				//Obtiene el DNI del Residente asociado
				statementPrepared = connection.prepareStatement(
						"SELECT DNI FROM Residentes, Facturas WHERE ID_Factura = ? AND Residentes.ID_Residente = Facturas.ID_Residente AND Facturas.Activo = 1 FOR UPDATE");
				
				statementPrepared.setInt(1, id);
				
				statementPrepared.execute();
				
				ResultSet rs1 = statementPrepared.getResultSet();
				
				boolean resultadoConsulta1 = rs1.next();
				
				if((rs1 != null)&&(resultadoConsulta1)){	
					
					//Recorre los residentes de esa habitación y añade sus id al transfer
					if(resultadoConsulta){
						transferFactura.setDni_residente_propietario_factura(rs1.getString("DNI"));
					}
				}
				
				statementPrepared = null;
				
				//Obtiene el ID de las Facturas de esa habitación
				
				//Lo de activo = 1 en esta no se pone por que si se da de baja, se borrará de esta tabla
				statementPrepared = connection.prepareStatement(
						"SELECT Numero_Habitacion FROM HabitacionFactura, Habitaciones WHERE ID_Factura = ? AND Habitaciones.ID_Habitacion = HabitacionFactura.ID_Habitacion FOR UPDATE");
				
				statementPrepared.setInt(1, id);
				
				statementPrepared.execute();
				
				ResultSet rs2 = statementPrepared.getResultSet();
				
				boolean resultadoConsulta2 = rs2.next();
				
				if((rs2 != null)&&(resultadoConsulta2)){	
					
					//Reajustamos el puntero
					rs2.beforeFirst();
					
					//Recorre las habitaciones de la factura y añade sus id a una lista auxiliar
					while(rs2.next()){
						transferFactura.getNumero_habitaciones_facturas().add(rs2.getInt("Numero_Habitacion"));	
					}
				}
			}

		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		//Si los datos no son correctos, se devuelve null
		if(transferFactura.getId() < 0){
			transferFactura = null;
		}
		
		return transferFactura;
	}

	@Override
	public boolean modificarFactura(TransferFactura transferFactura) {
		boolean valorDevuelto;
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		

		try {
				PreparedStatement statementPrepared = connection.prepareStatement(
						"UPDATE Facturas SET Pagado = ?, Cuota = ?, En_metalico = ?, NumeroCuenta = ? WHERE ? = ID_Factura");
				
				statementPrepared.setBoolean(1, transferFactura.isEstaPagado());
				
				statementPrepared.setDouble(2, transferFactura.getCutoa());
				
				statementPrepared.setBoolean(3, transferFactura.isEnMetalico());
				
				statementPrepared.setString(4, transferFactura.getNumeroCuenta());
				
				statementPrepared.setInt(5, transferFactura.getId());
				
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
	public int getId(String fecha_hora) {
		int valorDevuelto;
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		PreparedStatement statementPrepared;
		try {
			statementPrepared = connection.prepareStatement("SELECT ID_Factura FROM Facturas WHERE Fecha_hora = ? FOR UPDATE");
		
			statementPrepared.setString(1, fecha_hora);
		
			statementPrepared.execute();
		
			ResultSet rs = statementPrepared.getResultSet();
		
			//Obtiene el ID de la fila devuelta
			
			//Avanzar el cursor, sino error
			rs.next();
			valorDevuelto = rs.getInt("ID_Factura");	
		} catch (SQLException e) {
			valorDevuelto = -1;
			// TODO Auto-generated catch block
			System.err.println("Esa Factura con esa fecha no existe en el sistema");
		}
		
		return valorDevuelto;
	}

}
