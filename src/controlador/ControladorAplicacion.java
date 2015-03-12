package controlador;


/**
 * Clase abstracta singleton que gestiona el controlador de la aplicacion
 * @author Daniel
 *
 */
public abstract class ControladorAplicacion {

	private static ControladorAplicacion controladorAplicacion;

	/**
	 * Constructor privado por ser singleton
	 */
	protected ControladorAplicacion(){}
	
	/**
	 * Obtiene una instancia de la clase
	 * @return la instancia de la clase
	 */
	public static ControladorAplicacion obtenerInstancia() {
	
		if(controladorAplicacion == null){
			controladorAplicacion = new ControladorAplicacionImp();
		}
		
		return controladorAplicacion;
	
	}

	/**
	 * Realiza la respuesta del evento sucedido
	 * @param id_evento el id del evento sucedido
	 * @param datos los datos con los que trabaja
	 */
	public abstract void accion(int id_evento, Object datos);
	
}