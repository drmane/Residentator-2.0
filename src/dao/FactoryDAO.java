package dao;

import factura.DAOFactura;
import habitacion.DAOHabitacion;
import residente.DAOResidente;

/**
 * La fábrica que genera DAOs
 * @author Daniel
 *
 */
public abstract class FactoryDAO {
	
	private static FactoryDAO factoryDAO;

	/**
	 * Constructor privado por ser singleton
	 */
	protected FactoryDAO() {
	}

	/**
	 * Obtiene una instancia de la clase
	 * 
	 * @return la instancia de la clase
	 */
	public static FactoryDAO obtenerInstancia() {

		if (factoryDAO == null) {
			factoryDAO = new FactoryDAOImp();
		}

		return factoryDAO;

	}

	/**
	 * Permite crear DAOs de habitaciones
	 * @return el DAO de la habitación
	 */
	public abstract DAOHabitacion generarDAOHabitacion();
	
	/**
	 * Permite crear DAOs de residentes
	 * @return el DAO del residente
	 */
	public abstract DAOResidente generarDAOResidente();
	
	/**
	 * Permite crear DAOs de facturas
	 * @return el DAO de la factura
	 */
	public abstract DAOFactura generarDAOFactura();
}
