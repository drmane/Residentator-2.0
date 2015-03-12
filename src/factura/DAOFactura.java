package factura;

import java.sql.Date;

/**
 * Interfaz de las operaciones de las facturas
 * @author Daniel
 *
 */
public interface DAOFactura {
	
	/**
	 * Crea una factura 
	 * En el caso de que esté desactivada, la activa
	 * @param t la información de la factura que se quiere crear
	 * @return el id de la nueva factura creada
	 */
	public int crearFactura (TransferFactura t);
	
	/**
	 * Permite dar de baja una factura
	 * @param id el id de la factura a dar de baja
	 * @return si se ha dado de baja la factura o no
	 */
	public boolean bajaFactura(int id);
	
	/**
	 * Permite buscar una factura en el sistema
	 * Busca facturas aunque estén desactivadas
	 * @param id el id de la factura a buscar
	 * @return la factura (null sino existe)
	 */
	public TransferFactura buscarFactura(int id);
	
	/**
	 * Permite modificar los datos de una factura
	 * @param transferFactura los datos modificados de la factura
	 * @return si se ha podido modificar la factura o no
	 */
	public boolean modificarFactura(TransferFactura transferFactura);
	
	
	
	/**
	 * Obtiene el ID correspondiente a la fecha y hora de la factura deseada
	 * Trabajamos considerando las fechas como del tipo String
	 * @param fecha la fecha de la factura a buscar
	 * @return el ID asociado a la fecha de la factura
	 */
	public int getId(String fecha_hora);
}