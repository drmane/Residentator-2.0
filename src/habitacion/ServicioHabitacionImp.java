package habitacion;

import java.util.List;

import query.FactoryQuery;
import transaction_manager.Transaction;
import transaction_manager.TransactionManager;
import dao.FactoryDAO;

public class ServicioHabitacionImp implements ServicioHabitacion{

	@Override
	public int altaHabitacion(TransferHabitacion transferHabitacion) {
		
		//Siempre deber�a cambiarse este valor
		int valorDevuelto = 0;
		
		//Comprobaci�n de capacidad correcta
		if(transferHabitacion.getCapacidad() < 1){
			valorDevuelto = -1;
			//No se hace rollback por que no se ha tocado la BD
		}
		else{
			//Obtiene una transacci�n y la empieza
			Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
			
			transaccion.start();
			
			DAOHabitacion daoHabitacion = FactoryDAO.obtenerInstancia().generarDAOHabitacion();
			
			int id_hab = daoHabitacion.getId(transferHabitacion.getNumero_hab());
			
			//Comprobaci�n de si existe esa habitaci�n con ese id
			TransferHabitacion transferBuscado = daoHabitacion.buscarHabitacion(id_hab);
		
			if((transferBuscado != null)&&(transferBuscado.getNumero_hab() == transferHabitacion.getNumero_hab())){
				
				//Actualizamos el id del transfer con el que ya ten�a
				transferBuscado.setId(id_hab);
				
				//Si no esta activo, lo activa
				if(!transferBuscado.isActivo()){
					//Se le pasa el transfer buscado porque ya existe, solo tiene que activarlo usando esa info
					int valorCreacion = daoHabitacion.crearHabitacion(transferBuscado);
					
					//Si devuelve un id correcto
					if(valorCreacion != 0){
						valorDevuelto = transferHabitacion.getNumero_hab();
						transaccion.commit();
					}
				}
				else{
					//Existe y est� activo 
					valorDevuelto = -2;
					transaccion.rollback();
				}
			}
			else{
				int valorCreacion = daoHabitacion.crearHabitacion(transferHabitacion);
				
				//Si devuelve un id correcto
				if(valorCreacion != 0){
					valorDevuelto = transferHabitacion.getNumero_hab();
					transaccion.commit();
				}
				else{
					transaccion.rollback();
				}
			}
		}
	
		//Elimina la transaccion
		TransactionManager.obtenerInstancia().eliminarTransaccion();
		
		return valorDevuelto;
	}

	@Override
	public int borrarHabitacion(int num_hab) {
		int valorDevuelto = 0;
		
		//Obtiene una transacci�n y la empieza
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		DAOHabitacion daoHabitacion = FactoryDAO.obtenerInstancia().generarDAOHabitacion();
		
		int id_hab = daoHabitacion.getId(num_hab);
		
		//Comprobaci�n de si existe esa habitaci�n con ese n�mero
		TransferHabitacion transferBuscado = daoHabitacion.buscarHabitacion(id_hab);
		
		//Si ha encontrado algo y esta activado
		if((transferBuscado != null)&&transferBuscado.isActivo()){
			
			if(transferBuscado.getDni_residentes_ocupantes().size() > 0){
				//Comprueba si tiene residentes
				transaccion.rollback();
				valorDevuelto = -2;
			}
			else if(transferBuscado.getId_facturas_habitaci�n().size() > 0){
				//Comprueba si tiene facturas
				transaccion.rollback();
				valorDevuelto = -3;
			}
			else{
				
				boolean bajaHabitacion = daoHabitacion.bajaHabitacion(id_hab);
				if(!bajaHabitacion){
					transaccion.rollback();
					valorDevuelto = -4;
				}
				
				//Aplica los cambios 
				transaccion.commit();
			}
		}
		else{
			//Si no lo encuentra
			transaccion.rollback();
			valorDevuelto = -1;
		}
		
		
		//Elimina la transaccion
		TransactionManager.obtenerInstancia().eliminarTransaccion();
			
		return valorDevuelto;
	}

	@Override
	public int modificarHabitacion(TransferHabitacion transferHabitacion) {
		int valorDevuelto = 0;
		
		//Obtiene una transacci�n y la empieza
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		DAOHabitacion daoHabitacion = FactoryDAO.obtenerInstancia().generarDAOHabitacion();
		
		int id_hab = daoHabitacion.getId(transferHabitacion.getNumero_hab());
		
		//Comprobaci�n de si existe esa habitaci�n con ese n�mero
		TransferHabitacion transferBuscado = daoHabitacion.buscarHabitacion(id_hab);
		
		//Si ha encontrado algo y esta activado
		if((transferBuscado != null)&&transferBuscado.isActivo()){
			
			//Mete en el DAO el ID de la Habitaci�n
			transferHabitacion.setId(id_hab);
			
			transferHabitacion.setNumero_ocupantes(transferBuscado.getNumero_ocupantes());
			
			//Si la nueva capacidad es mayor que el n�mero de ocupantes
			//se permite hacer la operaci�n, sino no
			if(transferBuscado.getNumero_ocupantes() <= transferHabitacion.getCapacidad()){
				boolean valorModificado = daoHabitacion.modificarHabitacion(transferHabitacion);
			
				if(valorModificado){
					transaccion.commit();
				}
				else{
					transaccion.rollback();
					valorDevuelto = -3;
				}
			}
			else{
				transaccion.rollback();
				valorDevuelto = -2;
			}	
		}
		else{
			//Si no lo encuentra
			transaccion.rollback();
			valorDevuelto = -1;
		}
		
		//Elimina la transaccion
		TransactionManager.obtenerInstancia().eliminarTransaccion();
		
		return valorDevuelto;
	}

	@Override
	public TransferHabitacion buscarHabitacion(int num_hab) {
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		DAOHabitacion daoHabitacion = FactoryDAO.obtenerInstancia().generarDAOHabitacion();
		
		TransferHabitacion transferBuscado = daoHabitacion.buscarHabitacion(daoHabitacion.getId(num_hab));
		
		//Si no est� activa, es como si no la encuentra
		
		if(transferBuscado != null){
			if(!transferBuscado.isActivo()){
				transferBuscado = null;
			}
		}
		
		//En los mostrar para evitar bloqueos
		transaccion.commit();
		
		//Elimina la transaccion
		TransactionManager.obtenerInstancia().eliminarTransaccion();
	
		return transferBuscado;
	}

	@Override
	public List<TransferHabitacion> mostrarHabitaciones() {
		//Obtiene una transacci�n y la empieza
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		//Ejecuta la Query
		List<TransferHabitacion> lista_habitaciones = (List<TransferHabitacion>) FactoryQuery.obtenerInstancia().generateQueryMostrarHabitaciones().execute(null);
		
		//En los mostrar para evitar bloqueos
		transaccion.commit();
		
		//Elimina la transaccion
		TransactionManager.obtenerInstancia().eliminarTransaccion();
		
		return lista_habitaciones;
	}
}
