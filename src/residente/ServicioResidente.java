package residente;

import java.util.List;

/**
 * Interfaz que indica las operaciones sobre los residentes
 * @author Daniel
 *
 */
public interface ServicioResidente {

	/**
	 * Permite dar de alta un residente en el sistema
	 * Hace dos comprobaciones de ID:
	 * 1: Para ver si existe es ID en el sistema
	 * 2: Para obtener el ID en el caso de que no exista
	 * Si está desactivada la habitación, la activa con la capacidad anterior
	 * 
	 * @param transferResidente La información del residente que se desea dar de alta
	 * @return Un flag indicando si se ha dado el residente de alta o no 
	 *  Un número mayor o igual que 0, Alta exitosa (devuelve el ID en ese caso)
	 * -1 dni ya existe y activo
	 * -2 habitacion no existe o no activa
	 * -3 habitacion existe pero está llena 
	 * -4 Otro fallo
	 */
	public int altaResidente(TransferResidente transferResidente);
	
	/**
	 * Permite borrar un residente en el sistema (borrado lógico)
	 * Se puede borrar si no tiene facturas (tanto físicas o lógicas) 
	 * Para ello se comprueba el numero de elementos de las listas correspondientes
	 * Debe ajustar lo correspondiente de las habitaciones (ocupantes)
	 * @param dni El dni del residente que se desea dar de baja
	 * @return flag indicando si se ha borrado la habitación o no
	 *  0 Borrado exitoso
	 * -1 No existe el residente con ese dni
	 * -2 Ese residente tiene facturas asociadas
	 * -3 Otro fallo
	 */
	public int borrarResidente(String dni);
	
	/**
	 * Permite modificar un residente ya existente
	 * Solo se puede modifcar aqullo que se considere modificable en residentes existentes y activos
	 * La habitación no se puede modificar.
	 * @param transferResidenteInformacionNueva la nueva información del residente
	 * @return Un flag indicando si se ha modificado la habitación o no
	 *   0 Modificación exitosa
	 *  -1 No existe el residente con ese dni
	 *  -2 Otro fallo
	 */
	public int modificarResidente(TransferResidente transferResidenteInformacionNueva);
	
	/**
	 * Permite buscar una habitación en el sistema y mostrar su información
	 * En el caso de que esa habitación esté activa
	 * @param num_hab El número de la habitación que se desea buscar
	 * @return La información de la habitación buscada (null si no la encuentra)
	 */
	public TransferResidente buscarResidente (String dni);
	
	/**
	 * Permite obtener la información de los residentes del sistema
	 * Exclusivamente de los residentes activos
	 * Devuelve una lista vacia en el caso de que no haya residentes
	 * @return Una lista con la información de los residentes en el sistema
	 */
	public List<TransferResidente> mostrarResidentes();
	
	/**
	 * Permite obtener la información de los residentes del sistema
	 * Los cuales la suma de sus facturas superan los 1000 euros
	 * Exclusivamente de los residentes activos
	 * Devuelve una lista vacia en el caso de que no haya residentes
	 * @return Una lista con la información de los residentes en el sistema
	 */
	public List<TransferResidente> mostrarResidentesSuperanFacturas();
}
