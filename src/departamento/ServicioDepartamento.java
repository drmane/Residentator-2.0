package departamento;

import java.util.Collection;

/**
 * Interfaz que indica las operaciones sobre los departamentos
 * @author Daniel
 *
 */
public interface ServicioDepartamento {
	
	
	
	/**
	 * Crea un departamento
	 * @param departamento el departamento que se desea crear
	 * @return el id del departamento creado, -1 si existe un departamento con el mismo nombre.
	 */
	public int crearDepartamento(Departamento departamento);
	
	/**
	 * Permite dar de baja un departamento (baja logica)
	 * @param id el id del departamento
	 * @return si se ha dado de baja o no
	 */
	public boolean bajaDepartamento(int id);
	
	/**
	 * Permite buscar el departamento en el sistema si esta activo
	 * @param id el id del departamento a buscar
	 * @return el departamento (null sino lo encuentra)
	 */
	public Departamento buscarDepartamento(int id);
	
	/**
	 * Permite obtener los datos de todos los departamentos activos
	 * @return la coleccion de todos los departamentos
	 */
	public Collection<Departamento> buscarTodosDepartamentos();

}
