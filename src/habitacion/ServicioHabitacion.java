package habitacion;

import java.util.List;

/**
 * Interfaz que indica las operaciones sobre las habitaciones
 * @author Daniel
 *
 */
public interface ServicioHabitacion {
	
	/**
	 * Permite dar de alta una habitación en el sistema
	 * Hace dos comprobaciones de ID:
	 * 1: Para ver si existe es ID en el sistema
	 * 2: Para obtener el ID en el caso de que no exista
	 * Si está desactivada la habitación, la activa con la capacidad anterior
	 * 
	 * @param transferHabitacion La información de la habitación que se desea dar de alta
	 * @return Un flag indicando si se ha dado la habitación de alta o no 
	 *  Un número mayor o igual que 0, Alta exitosa (devuelve el ID en ese caso)
	 * -1 Fallo capacidad
	 * -2 Número ya existe
	 * -3 Otro fallo
	 */
	public int altaHabitacion(TransferHabitacion transferHabitacion);
	
	/**
	 * Permite borrar una habitación en el sistema (borrado lógico)
	 * Se puede borrar si no tiene facturas (tanto físicas o lógicas) ni residentes (tanto fisicos como lógicos)
	 * Para ello se comprueba el numero de elementos de las listas correspondientes
	 * @param num_hab El número de la habitación que se desea dar de baja
	 * @return flag indicando si se ha borrado la habitación o no
	 *  0 Borrado exitoso
	 * -1 No existe la habitación con ese numero
	 * -2 Esa habitación tiene residentes asociados
	 * -3 Esa habitación tiene facturas asociadas
	 * -4 Otro fallo
	 */
	public int borrarHabitacion(int num_hab);
	
	/**
	 * Permite modificar una habitación ya existente
	 * Solo se puede modifcar la capacidad de las habitaciones existentes y activas
	 * @param transferHabitacionInformacionNueva la nueva información de la habitación
	 * @return Un flag indicando si se ha modificado la habitación o no
	 *   0 Modificación exitosa
	 *  -1 No existe la habitación con ese numero
	 *  -2 La capacidad es menor que el número de ocupantes
	 *  -3 Otro fallo
	 */
	public int modificarHabitacion(TransferHabitacion transferHabitacionInformacionNueva);
	
	/**
	 * Permite buscar una habitación en el sistema y mostrar su información
	 * En el caso de que esa habitación esté activa
	 * @param num_hab El número de la habitación que se desea buscar
	 * @return La información de la habitación buscada (null si no la encuentra)
	 */
	public TransferHabitacion buscarHabitacion (int num_hab);
	
	/**
	 * Permite obtener la información de las habitaciones del sistema
	 * Exclusivamente de las habitaciones activas
	 * Devuelve una lista vacia en el caso de que no haya habitaciones
	 * @return Una lista con la información de las habitaciones en el sistema
	 */
	public List<TransferHabitacion> mostrarHabitaciones();
}
