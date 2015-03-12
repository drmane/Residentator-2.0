package factura;

import habitacion.DAOHabitacion;
import habitacion.TransferHabitacion;

import java.util.ArrayList;
import java.util.List;

import query.FactoryQuery;
import residente.DAOResidente;
import residente.TransferResidente;
import transaction_manager.Transaction;
import transaction_manager.TransactionManager;
import dao.FactoryDAO;

public class ServicioFacturaImp implements ServicioFactura{

	@Override
	public int altaFactura(TransferFactura transferFactura) {
		//Siempre debería cambiarse este valor
		int valorDevuelto = 0;
		
		//Obtiene una transacción y la empieza
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		DAOFactura daoFactura = FactoryDAO.obtenerInstancia().generarDAOFactura();
		
		//Comprobación del residente
		DAOResidente daoResidente = FactoryDAO.obtenerInstancia().generarDAOResidente();
		
		//Comprobación de la Habitación
		DAOHabitacion daoHabitacion = FactoryDAO.obtenerInstancia().generarDAOHabitacion();
		
		int id_res = daoResidente.getId(transferFactura.getDni_residente_propietario_factura());
		
		//Comprobación de si existe ese residente con ese id
		TransferResidente transferBuscadoRes = daoResidente.buscarResidente(id_res);
	
		if((transferBuscadoRes != null)&&(transferBuscadoRes.getDni().equals(transferFactura.getDni_residente_propietario_factura()))){
			
			//Actualizamos el id del transfer con el que ya tenía
			transferBuscadoRes.setId(id_res);
			
			//Si esta activo
			if(transferBuscadoRes.isActivo()){
				
				//Comprueba la habitación
				
				//En el campo id, ponemos el ID del residente
				transferFactura.setId(id_res);
				
				int valorCreacion = daoFactura.crearFactura(transferFactura);
				
				//Si devuelve un id correcto
				if(valorCreacion != 0){
					valorDevuelto = valorCreacion;
					transaccion.commit();
				}
				else{
					valorDevuelto = -2;
					transaccion.rollback();
				}
			}
			else{
			//No existe residente o no está activo
			valorDevuelto = -1;
			transaccion.rollback();
			}
		}
		else{
			//No existe residente o no está activo
			valorDevuelto = -1;
			transaccion.rollback();
		}
	
	
		//Elimina la transaccion
		TransactionManager.obtenerInstancia().eliminarTransaccion();
		
		return valorDevuelto;
	}

	@Override
	public int borrarFactura(int id) {
		int valorDevuelto = 0;
		
		//Obtiene una transacción y la empieza
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		DAOFactura daoFactura = FactoryDAO.obtenerInstancia().generarDAOFactura();
		
		TransferFactura transferBuscado = daoFactura.buscarFactura(id);
		
		//Si ha encontrado algo y esta activado
		if((transferBuscado != null)&&transferBuscado.isActivo()){
			
			transferBuscado.setId(id);
			
			boolean valorModificado = daoFactura.bajaFactura(id);
			
			if(valorModificado){
				transaccion.commit();
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
	public int modificarFactura(TransferFactura transferFacturaInformacionNueva) {
		int valorDevuelto = 0;
		
		//Obtiene una transacción y la empieza
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		DAOFactura daoFactura = FactoryDAO.obtenerInstancia().generarDAOFactura();
		
		TransferFactura transferBuscado = daoFactura.buscarFactura(transferFacturaInformacionNueva.getId());
		
		//Si ha encontrado algo y esta activado
		if((transferBuscado != null)&&transferBuscado.isActivo()){
			
			transferBuscado.setId(transferFacturaInformacionNueva.getId());
			
			boolean valorModificado = daoFactura.modificarFactura(transferFacturaInformacionNueva);
			
			if(valorModificado){
				transaccion.commit();
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
	public TransferFactura buscarFactura(int id) {
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		DAOFactura daoFactura = FactoryDAO.obtenerInstancia().generarDAOFactura();
		
		TransferFactura transferBuscado = daoFactura.buscarFactura(id);
		
		//Si no está activa, es como si no la encuentra
		
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
	public List<TransferFactura> mostrarFacturas() {
		//Obtiene una transacción y la empieza
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		//Ejecuta la Query
		List<TransferFactura> lista_facturas = (List<TransferFactura>) FactoryQuery.obtenerInstancia().generateQueryMostrarFacturas().execute(null);
		
		//En los mostrar para evitar bloqueos
		transaccion.commit();
		
		//Elimina la transaccion
		TransactionManager.obtenerInstancia().eliminarTransaccion();
		
		return lista_facturas;
	}

	@Override
	public int asignarFactura(int id_fac, int num_hab) {
		//Siempre debería cambiarse este valor
		int valorDevuelto = 0;
		
		//Obtiene una transacción y la empieza
		Transaction transaccion = TransactionManager.obtenerInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		DAOFactura daoFactura = FactoryDAO.obtenerInstancia().generarDAOFactura();
		
		//Comprobación de la Habitación
		DAOHabitacion daoHabitacion = FactoryDAO.obtenerInstancia().generarDAOHabitacion();
		

		TransferFactura transferBuscadoFac = daoFactura.buscarFactura(id_fac);
	
		if((transferBuscadoFac != null)&&(transferBuscadoFac.getId() == id_fac)){
			
			//Actualizamos el id del transfer con el que ya tenía
			transferBuscadoFac.setId(id_fac);
			
			//Si esta activo
			if(transferBuscadoFac.isActivo()){
				
				int id_hab = daoHabitacion.getId(num_hab);

				TransferHabitacion transferBuscadoHab = daoHabitacion.buscarHabitacion(id_hab);
			
				if((transferBuscadoHab != null)&&(transferBuscadoHab.getNumero_hab() == num_hab)){
					
					//Actualizamos el id del transfer con el que ya tenía
					transferBuscadoHab.setId(id_hab);
					
					//Si esta activo
					if(transferBuscadoFac.isActivo()){
						List<Integer> lista = new ArrayList<Integer>();
				    	
				    	// ID posición 0, Número Habitación posición 1
				    	
				    	lista.add(Integer.valueOf(id_fac));
				    	lista.add(Integer.valueOf(id_hab));
						
						int valorCreacion = (int) FactoryQuery.obtenerInstancia().generateQueryAsignarFacturas().execute(lista);
						
						//Si devuelve un id correcto
						if(valorCreacion != 0){
							valorDevuelto = valorCreacion;
							transaccion.commit();
						}
						else{
							valorDevuelto = -2;
							transaccion.rollback();
						}
					}
					else{
						valorDevuelto = -2;
						transaccion.rollback();
					}
				}
				else{
					valorDevuelto = -2;
					transaccion.rollback();
				}
			
			}
			else{
				//No existe factura
				valorDevuelto = -1;
				transaccion.rollback();
			}
		}
		else{
			//No existe factura
			valorDevuelto = -1;
			transaccion.rollback();
		}
		
		return valorDevuelto;
	}
}
