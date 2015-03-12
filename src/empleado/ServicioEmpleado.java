package empleado;

import java.util.Collection;
import tarea.Tarea;


/**
 * Interfaz que indica las operaciones sobre los empleados
 * @author Daniel
 *
 */
public interface ServicioEmpleado {

	/**
	 * Permite crear empleados
	 * @param empleado la información del empleado a crear
	 * @return el id del empleado, 
	 * -1 si ya existe un empleado con ese dni
	 * -2 si se quiere crear un empleado en un departamento que no existe
	 */
	public int crearEmpleado(Empleado empleado);
	
	/**
	 * Permite dar de baja a un empleado (baja logica)
	 * @param id el id del empleado
	 * @return si se ha dado de baja o no
	 */
	public boolean bajaEmpleado(int id);
	
	/**
	 * Permite buscar el empleado en el sistema
	 * @param id el id del empleado a buscar
	 * @return el empleado (null sino lo encuentra)
	 */
	public Empleado buscarEmpleado(int id);
	
	/**
	 * Permite obtener los datos de todos los empleados
	 * @return la coleccion de todos los empleados
	 */
	public Collection<Empleado> buscarTodosEmpleados();
	
	/**
	 * Permite asignar una tarea a un empleado
	 * @return 
	 * -1 si empleado no existe o no está activo
	 * -2 si la tarea no existe o no está activa
	 * -3 si la tarea ya está asignada al empleado
	 * -4 si el empleado está asignado a la tarea
	 * >= 0 si se realiza correctamente
	 */
	public int asignarTarea(Tarea  tarea);
	
}
