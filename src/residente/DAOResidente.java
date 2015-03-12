package residente;


/**
 * Interfaz de las operaciones de la capa de integración de los residentes
 * @author Daniel
 *
 */
public interface DAOResidente {
	/**
	 * Crea un residente
	 * En el caso de que esté desactivado, lo activa y cambia toda la información
	 * Excepto si es estudiante o no
	 * @param t la información del residente que se quiere crear
	 * @return el id del nuevo residente creado
	 */
	public int crearResidente (TransferResidente t);
	
	/**
	 * Permite dar de baja un residente
	 * @param id el id del residente a dar de baja
	 * @return si se ha dado de baja el residente o no
	 */
	public boolean bajaResidente(int id);
	
	/**
	 * Permite buscar un residente en el sistema
	 * Busca residentes aunque estén desactivadas
	 * @param id el id del residente a buscar
	 * @return el residente (null sino existe)
	 */
	public TransferResidente buscarResidente(int id);
	
	/**
	 * Permite modificar los datos de un residente
	 * @param transferResidente los datos modificados del residente
	 * @return si se ha podido modificar el residente o no
	 */
	public boolean modificarResidente(TransferResidente transferResidente);
	
	/**
	 * Obtiene el ID correspondiente al dni del residente deseado
	 * @param dni el dni del residente para el cual se quiere encontrar el ID
	 * @return el ID asociado al dni del residente
	 */
	public int getId(String dni);
}
