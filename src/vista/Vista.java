package vista;

/**
 * Interfaz con los métodos que tendrán todas las vistas
 * @author Daniel
 *
 */
public interface Vista {
	
	/**
	 * Permite actualizar la vista en función del evento producido
	 * @param id_evento_vista el id del evento de la vista producido
	 * @param datos los datos
	 */
	public void actualizar(int id_evento_vista, Object datos);

}
