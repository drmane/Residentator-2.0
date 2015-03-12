package selector_vista;

/**
 * Clase abstracta singleton que gestiona la seleccion de la vista a actualizar
 * @author Daniel
 *
 */
public abstract class SelectorVista {
	
	private static SelectorVista selectorVista;
	
	/**
	 * Constructor privado por ser singleton
	 */
	protected SelectorVista(){}
	
	/**
	 * Obtiene una instancia de la clase
	 * @return la instancia de la clase
	 */
	public static SelectorVista obtenerInstancia() {
	
		if(selectorVista == null){
			selectorVista = new SelectorVistaImp();
		}
		
		return selectorVista;
	
	}

	/**
	 * permite actualizar la vista en funcion de un evento producido
	 * @param id_evento_vista el id del evento de la vista
	 * @param datos los datos necesarios por si hay algun cambio
	 */
	public abstract void redirigirVista(int id_evento_vista, Object datos);
}
