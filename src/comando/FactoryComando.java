package comando;
/**
 * Clase abstracta singleton que gestiona la creacion de comandos
 * @author Daniel
 *
 */
public abstract class FactoryComando {

	private static FactoryComando factoryComando;
	
	/**
	 * Constructor privado por ser singleton
	 */
	protected FactoryComando(){}

	/**
	 * Crea un comando dado el id del evento y los datos
	 * @param id_comando el id del evento
	 * @param datos los datos con los que trabaja
	 * @return el comando creado
	 */
	public abstract Comando producirComando(int id_comando, Object datos);
	
	/**
	 * Obtiene una instancia de la clase
	 * @return la instancia de la clase
	 */
	public static FactoryComando obtenerInstancia() {

		if (factoryComando == null) {
			factoryComando = new FactoryComandoImp();
		}

		return factoryComando;

	}
}
