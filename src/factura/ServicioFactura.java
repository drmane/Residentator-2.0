package factura;

import java.util.List;

/**
 * Interfaz que indica las operaciones sobre las facturas
 * @author Daniel
 *
 */
public interface ServicioFactura {
	/**
	 * Permite dar de alta una factura en el sistema
	 * Hace dos comprobaciones de ID:
	 * 1: Para ver si existe es ID en el sistema
	 * 2: Para obtener el ID en el caso de que no exista
	 * Si est� desactivada la factura, la activa 
	 * 
	 * @param transerFactura La informaci�n de la factura que se desea dar de alta
	 * @return Un flag indicando si se ha dado la factura de alta o no 
	 *  Un n�mero mayor o igual que 0, Alta exitosa (devuelve el ID en ese caso)
	 * -1 DNI residente no existe o no activo
	 * -2 Otro fallo
	 */
	public int altaFactura(TransferFactura transferFactura);
	
	/**
	 * Permite borrar una factura en el sistema (borrado l�gico)
	 * Solo se va a poder borrar las facturas que est�n activas y pagadas
	 * Para ello se comprueban los flags correspondientes
	 * @param id El ID de la factura que se desea dar de baja
	 * @return flag indicando si se ha borrado la factura o no
	 *  0 Borrado exitoso
	 * -1 No existe la factura con ese ID
	 * -2 Esa factura tno est� pagada
	 * -3 Otro fallo
	 */
	public int borrarFactura(int id);
	
	/**
	 * Permite modificar una factura ya existente
	 * Solo se puede modifcar aquello modificable de las facturas
	 * @param transferFacturaInformacionNueva la nueva informaci�n de la factura
	 * @return Un flag indicando si se ha modificado la factura o no
	 *   0 Modificaci�n exitosa
	 *  -1 No existe la factura con ese ID
	 *  -2 Otro fallo
	 */
	public int modificarFactura(TransferFactura transferFacturaInformacionNueva);
	
	/**
	 * Permite buscar una factura en el sistema y mostrar su informaci�n
	 * En el caso de que esa factura est� activa
	 * @param id El ID de la factura que se desea buscar
	 * @return La informaci�n de la factura buscada (null si no la encuentra)
	 */
	public TransferFactura buscarFactura (int id);
	
	/**
	 * Permite obtener la informaci�n de las facturas del sistema
	 * Exclusivamente de las facturas activas
	 * Devuelve una lista vacia en el caso de que no haya facturas
	 * @return Una lista con la informaci�n de las facturas en el sistema
	 */
	public List<TransferFactura> mostrarFacturas();
	
	/**
	 * Permite asignar habitaciones a la factura
	 * @param id_fac El id de la factura
	 * @param num_hab El n�mero de la habitaci�n
	 * @return Un Flag indicando si se ha asignado la factura o no
	 *  0 Asignaci�n exitosa
	 * -1 Factura no existe o no activa
	 * -2 Habitaci�n no existe o no activa
	 * -3 Otro fallo
	 */
	public int asignarFactura(int id_fac,int num_hab);
}
