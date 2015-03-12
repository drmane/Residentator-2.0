package habitacion;

/**
 * Interfaz de las operaciones de la capa de integración de las habitaciones
 * @author Daniel
 *
 */
public interface DAOHabitacion {
	
	/**
	 * Crea una habitación
	 * En el caso de que esté desactivada, la activa
	 * @param t la información de la habitación que se quiere crear
	 * @return el id de la nueva habitación creada
	 */
	public int crearHabitacion (TransferHabitacion t);
	
	/**
	 * Permite dar de baja una habitación
	 * @param id el id de la habitación a dar de baja
	 * @return si se ha dado de baja la habitación o no
	 */
	public boolean bajaHabitacion(int id);
	
	/**
	 * Permite buscar una habitación en el sistema
	 * Busca habitaciones aunque estén desactivadas
	 * @param id el id de la habitación a buscar
	 * @return la habitación (null sino existe)
	 */
	public TransferHabitacion buscarHabitacion(int id);
	
	/**
	 * Permite modificar los datos de una habitación
	 * @param transferHabitacion los datos modificados de la habitación
	 * @return si se ha podido modificar la habitación o no
	 */
	public boolean modificarHabitacion(TransferHabitacion transferHabitacion);
	
	/**
	 * Obtiene el ID correspondiente al número de habitación deseado
	 * @param numero_hab el número de habitación para el cual se quiere encontrar el ID
	 * @return el ID asociado al número de habitación
	 */
	public int getId(int numero_hab);

}
