package tarea;

import java.util.Collection;

/**
 * Interfaz que indica las operaciones sobre las tareas
 * @author Daniel
 *
 */
public interface ServicioTarea {

	/**
	 * Permite crear una tarea
	 * @param nombre el nombre de la tarea
	 * @param descripcion la descripción de que consiste la tarea
	 * @return la nueva tarea creada
	 */
	public int crearTarea(Tarea tarea);

	/**
	 * Permite dar de baja una tarea
	 * @param id el id de la tarea a dar de baja
	 * @return si se ha dado de baja o no
	 */
	public boolean bajaTarea(int id);
	
	/**
	 * Permite buscar una tarea en el sistema
	 * @param id el id de la tarea a buscar
	 * @return la tarea (null sino lo encuentra)
	 */
	public Tarea buscarTarea(int id);
	
	/**
	 * Permite obtener los datos de todas las tareas
	 * @return la colección de datos de todas las tareas
	 */
	public Collection<Tarea> buscarTodasTareas();
	
	/**
	 * Permite relacionar una tarea con un empleado
	 * @return
	 */
	
	
}
