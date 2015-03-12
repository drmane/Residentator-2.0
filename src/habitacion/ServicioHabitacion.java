package habitacion;

import java.util.List;

/**
 * Interfaz que indica las operaciones sobre las habitaciones
 * @author Daniel
 *
 */
public interface ServicioHabitacion {
	
	/**
	 * Permite dar de alta una habitaci�n en el sistema
	 * Hace dos comprobaciones de ID:
	 * 1: Para ver si existe es ID en el sistema
	 * 2: Para obtener el ID en el caso de que no exista
	 * Si est� desactivada la habitaci�n, la activa con la capacidad anterior
	 * 
	 * @param transferHabitacion La informaci�n de la habitaci�n que se desea dar de alta
	 * @return Un flag indicando si se ha dado la habitaci�n de alta o no 
	 *  Un n�mero mayor o igual que 0, Alta exitosa (devuelve el ID en ese caso)
	 * -1 Fallo capacidad
	 * -2 N�mero ya existe
	 * -3 Otro fallo
	 */
	public int altaHabitacion(TransferHabitacion transferHabitacion);
	
	/**
	 * Permite borrar una habitaci�n en el sistema (borrado l�gico)
	 * Se puede borrar si no tiene facturas (tanto f�sicas o l�gicas) ni residentes (tanto fisicos como l�gicos)
	 * Para ello se comprueba el numero de elementos de las listas correspondientes
	 * @param num_hab El n�mero de la habitaci�n que se desea dar de baja
	 * @return flag indicando si se ha borrado la habitaci�n o no
	 *  0 Borrado exitoso
	 * -1 No existe la habitaci�n con ese numero
	 * -2 Esa habitaci�n tiene residentes asociados
	 * -3 Esa habitaci�n tiene facturas asociadas
	 * -4 Otro fallo
	 */
	public int borrarHabitacion(int num_hab);
	
	/**
	 * Permite modificar una habitaci�n ya existente
	 * Solo se puede modifcar la capacidad de las habitaciones existentes y activas
	 * @param transferHabitacionInformacionNueva la nueva informaci�n de la habitaci�n
	 * @return Un flag indicando si se ha modificado la habitaci�n o no
	 *   0 Modificaci�n exitosa
	 *  -1 No existe la habitaci�n con ese numero
	 *  -2 La capacidad es menor que el n�mero de ocupantes
	 *  -3 Otro fallo
	 */
	public int modificarHabitacion(TransferHabitacion transferHabitacionInformacionNueva);
	
	/**
	 * Permite buscar una habitaci�n en el sistema y mostrar su informaci�n
	 * En el caso de que esa habitaci�n est� activa
	 * @param num_hab El n�mero de la habitaci�n que se desea buscar
	 * @return La informaci�n de la habitaci�n buscada (null si no la encuentra)
	 */
	public TransferHabitacion buscarHabitacion (int num_hab);
	
	/**
	 * Permite obtener la informaci�n de las habitaciones del sistema
	 * Exclusivamente de las habitaciones activas
	 * Devuelve una lista vacia en el caso de que no haya habitaciones
	 * @return Una lista con la informaci�n de las habitaciones en el sistema
	 */
	public List<TransferHabitacion> mostrarHabitaciones();
}
