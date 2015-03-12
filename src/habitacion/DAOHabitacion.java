package habitacion;

/**
 * Interfaz de las operaciones de la capa de integraci�n de las habitaciones
 * @author Daniel
 *
 */
public interface DAOHabitacion {
	
	/**
	 * Crea una habitaci�n
	 * En el caso de que est� desactivada, la activa
	 * @param t la informaci�n de la habitaci�n que se quiere crear
	 * @return el id de la nueva habitaci�n creada
	 */
	public int crearHabitacion (TransferHabitacion t);
	
	/**
	 * Permite dar de baja una habitaci�n
	 * @param id el id de la habitaci�n a dar de baja
	 * @return si se ha dado de baja la habitaci�n o no
	 */
	public boolean bajaHabitacion(int id);
	
	/**
	 * Permite buscar una habitaci�n en el sistema
	 * Busca habitaciones aunque est�n desactivadas
	 * @param id el id de la habitaci�n a buscar
	 * @return la habitaci�n (null sino existe)
	 */
	public TransferHabitacion buscarHabitacion(int id);
	
	/**
	 * Permite modificar los datos de una habitaci�n
	 * @param transferHabitacion los datos modificados de la habitaci�n
	 * @return si se ha podido modificar la habitaci�n o no
	 */
	public boolean modificarHabitacion(TransferHabitacion transferHabitacion);
	
	/**
	 * Obtiene el ID correspondiente al n�mero de habitaci�n deseado
	 * @param numero_hab el n�mero de habitaci�n para el cual se quiere encontrar el ID
	 * @return el ID asociado al n�mero de habitaci�n
	 */
	public int getId(int numero_hab);

}
