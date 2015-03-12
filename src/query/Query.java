package query;

/**
 * Interfaz que define de forma genérica las Querys del sistema
 * @author Daniel
 *
 */
public interface Query {

	/**
	 * Permite ejecutar Querys
	 * @param datos Los datos necesarios para las Querys
	 * @return Los datos devueltos por las querys
	 */
	public Object execute (Object datos);
}
