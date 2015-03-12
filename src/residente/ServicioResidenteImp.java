package residente;

import habitacion.DAOHabitacion;
import habitacion.TransferHabitacion;

import java.util.List;

import query.FactoryQuery;
import transaction_manager.Transaction;
import transaction_manager.TransactionManager;
import dao.FactoryDAO;

public class ServicioResidenteImp implements ServicioResidente{

	@Override
	public int altaResidente(TransferResidente transferResidente) {

		//Siempre deber�a cambiarse este valor
		int valorDevuelto = 0;
		
		//Obtiene una transacci�n y la empieza
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
			
		transaccion.start();
			
		DAOResidente daoResidente = FactoryDAO.obtenerInstancia().generarDAOResidente();
		
		//Comprobar si esa habitaci�n existe, est� activa y no est� llena
		DAOHabitacion daoHabitacion = FactoryDAO.obtenerInstancia().generarDAOHabitacion();
			
		int id_res = daoResidente.getId(transferResidente.getDni());
		
		//Comprobaci�n de si existe ese residente con ese id
		TransferResidente transferBuscadoResidente = daoResidente.buscarResidente(id_res);
	
		if((transferBuscadoResidente != null)&&(transferBuscadoResidente.getDni().equals(transferResidente.getDni()))&&(transferBuscadoResidente.isActivo())){
			
			//Ese residente ya existe
			
			//Actualizamos el id del transfer con el que ya ten�a
			transferBuscadoResidente.setId(id_res);
	
			/*
			//Se le pasa el transfer buscado porque ya existe, solo tiene que activarlo usando esa info
			int valorCreacion = daoResidente.crearHabitacion(transferBuscado);
			
			//Si devuelve un id correcto
			if(valorCreacion != 0){
				valorDevuelto = transferResidente.getId();
				transaccion.commit();
			}
			*/
				
			valorDevuelto = -1;
			transaccion.rollback();
		}
		else{
			
			//El residente no existe o est� activo
			
			//Se comprueba si la habitaci�n existe
			
			int id_hab = daoHabitacion.getId(transferResidente.getNum_hab());
			
			//Comprobaci�n de si existe esa habitacion con ese id
			TransferHabitacion transferBuscadoHabitacion = daoHabitacion.buscarHabitacion(id_hab);
			
			if((transferBuscadoHabitacion != null)&&(transferBuscadoHabitacion.getNumero_hab() == transferResidente.getNum_hab())){
				
				//Comprueba si la habitaci�n est� activa
				if(transferBuscadoHabitacion.isActivo()){
					
					//Compruebo si la habitaci�n est� llena
					if(transferBuscadoHabitacion.estaLlena()){
						//Si lo est�, error
						valorDevuelto = -3; //habitaci�n llena
						transaccion.rollback();
						
					}
					else{
						transferResidente.setNum_hab(id_hab);
						
						//este if se ejecuta solo si no est� activo el residente
						if(transferBuscadoResidente != null){
							transferResidente.setId(transferBuscadoResidente.getId());
							
							transferResidente.setActivo(false);
						}
						
						int valorCreacion = daoResidente.crearResidente(transferResidente);
						
						//Si devuelve un id correcto
						if(valorCreacion >= 0){
							valorDevuelto = valorCreacion;
							
							//modifica el n�mero de ocupantes de la habitaci�n
							transferBuscadoHabitacion.setNumero_ocupantes(transferBuscadoHabitacion.getNumero_ocupantes() + 1);
							daoHabitacion.modificarHabitacion(transferBuscadoHabitacion);
							transaccion.commit();
						}
					}
				}
				else{
					valorDevuelto = -2; //no existe la habitacion
					transaccion.rollback();
				}
				
			}
			else{
				valorDevuelto = -2; //no existe la habitacion
				transaccion.rollback();
			}
		}

		//Elimina la transaccion
		TransactionManager.obtenerInstancia().eliminarTransaccion();
		
		return valorDevuelto;
	}

	@Override
	public int borrarResidente(String dni) {
		//Siempre deber�a cambiarse este valor
		int valorDevuelto = 0;
		
		//Obtiene una transacci�n y la empieza
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
			
		transaccion.start();
			
		DAOResidente daoResidente = FactoryDAO.obtenerInstancia().generarDAOResidente();
		
		//Reducir el n�mero de ocupantes de la habitaci�n
		DAOHabitacion daoHabitacion = FactoryDAO.obtenerInstancia().generarDAOHabitacion();
			
		int id_res = daoResidente.getId(dni);
		
		//Comprobaci�n de si existe ese residente con ese id
		TransferResidente transferBuscadoResidente = daoResidente.buscarResidente(id_res);
	
		if((transferBuscadoResidente != null)&&(transferBuscadoResidente.getDni().equals(dni))){
			if(transferBuscadoResidente.isActivo()){
				if(transferBuscadoResidente.getId_facturas_residentes().size() > 0){
					valorDevuelto = -2; //Tiene Facturas asociadas
					transaccion.rollback();
				}
				else{
					
					//Se obtiene la habitaci�n
					
					//Comprobaci�n de si existe esa habitacion con ese id
					TransferHabitacion transferBuscadoHabitacion = daoHabitacion.buscarHabitacion(transferBuscadoResidente.getNum_hab());
					
					//El n�mero de la habitaci�n realmente es el ID de la habitaci�n en este punto
					if((transferBuscadoHabitacion != null)&&(transferBuscadoHabitacion.getId() == transferBuscadoResidente.getNum_hab())){
						
						//Comprueba si la habitaci�n est� activa
						if(transferBuscadoHabitacion.isActivo()){
							
							//Reduce el n�mero de ocupantes de la habitaci�n
							transferBuscadoHabitacion.setNumero_ocupantes(transferBuscadoHabitacion.getNumero_ocupantes() - 1);
							
							daoHabitacion.modificarHabitacion(transferBuscadoHabitacion);
							
							boolean valorCreacion =  daoResidente.bajaResidente(transferBuscadoResidente.getId());
							
							//Si devuelve un id correcto
							if(valorCreacion){
								valorDevuelto = transferBuscadoResidente.getId();

								transaccion.commit();
							}
						
						}
						else{
							valorDevuelto = -3; 
							transaccion.rollback();
						}
					}
					else{
						valorDevuelto = -3; 
						transaccion.rollback();
					}
				}
			}
			else{
				valorDevuelto = -1; //El Residente no existe
				transaccion.rollback();
			}
		}
		else{
			valorDevuelto = -1; //El Residente no existe
			transaccion.rollback();
		}
		
		return valorDevuelto;
	}

	@Override
	public int modificarResidente(
			TransferResidente transferResidenteInformacionNueva) {
		
		//Siempre deber�a cambiarse este valor
		int valorDevuelto = 0;
		
		//Obtiene una transacci�n y la empieza
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
			
		transaccion.start();
			
		DAOResidente daoResidente = FactoryDAO.obtenerInstancia().generarDAOResidente();
		
		int id_res = daoResidente.getId(transferResidenteInformacionNueva.getDni());
		
		//Comprobaci�n de si existe ese residente con ese id
		TransferResidente transferBuscadoResidente = daoResidente.buscarResidente(id_res);
	
		if((transferBuscadoResidente != null)&&(transferBuscadoResidente.getDni().equals(transferResidenteInformacionNueva.getDni()))){
			
			//Comprueba si el residente est� activo
			if(transferBuscadoResidente.isActivo()){
				transferResidenteInformacionNueva.setId(id_res); //se introduce el id al transfer
				
				boolean valorCreacion =daoResidente.modificarResidente(transferResidenteInformacionNueva);
				
				//Si devuelve un id correcto
				if(valorCreacion){
					valorDevuelto = transferBuscadoResidente.getId();
					
					transaccion.commit();
				}
				else{
					valorDevuelto = -2; //error de BD
					transaccion.rollback();
				}
			}
			else{
				//El residente no est� activo	
				valorDevuelto = -1; 
				transaccion.rollback();
			}
			
		}
		else{
			//El residente no existe
			valorDevuelto = -1; 
			transaccion.rollback();
		}
		return valorDevuelto;
	}

	@Override
	public TransferResidente buscarResidente(String dni) {
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		DAOResidente daoResidente = FactoryDAO.obtenerInstancia().generarDAOResidente();
		
		DAOHabitacion daoHabitacion = FactoryDAO.obtenerInstancia().generarDAOHabitacion();
		
		TransferResidente transferBuscado = daoResidente.buscarResidente(daoResidente.getId(dni));
		
		//Si no est� activa, es como si no la encuentra
		
		if(transferBuscado != null){
			transferBuscado.setNum_hab((daoHabitacion.buscarHabitacion(transferBuscado.getNum_hab())).getNumero_hab());
			
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
	public List<TransferResidente> mostrarResidentes() {
		//Obtiene una transacci�n y la empieza
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		//Ejecuta la Query
		List<TransferResidente> lista_residentes = (List<TransferResidente>) FactoryQuery.obtenerInstancia().generateQueryMostrarResidentes().execute(null);
		
		//En los mostrar para evitar bloqueos
		transaccion.commit();
		
		//Elimina la transaccion
		TransactionManager.obtenerInstancia().eliminarTransaccion();
		
		return lista_residentes;
	}

	@Override
	public List<TransferResidente> mostrarResidentesSuperanFacturas() {
		//Obtiene una transacci�n y la empieza
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		//Ejecuta la Query
		List<TransferResidente> lista_residentes = (List<TransferResidente>) FactoryQuery.obtenerInstancia().generateQueryMostrarResidentesSuperanFacturas().execute(null);
		
		//En los mostrar para evitar bloqueos
		transaccion.commit();
		
		//Elimina la transaccion
		TransactionManager.obtenerInstancia().eliminarTransaccion();
		
		return lista_residentes;
	}
}
