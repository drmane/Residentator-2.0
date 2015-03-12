package query;


/**
 * Clase abstracta de la Factory de Querys
 * @author Daniel
 *
 */
public abstract class FactoryQuery {

	private static FactoryQuery factoryQuery;

	/**
	 * Constructor privado por ser singleton
	 */
	protected FactoryQuery() {
	}

	/**
	 * Obtiene una instancia de la clase
	 * 
	 * @return la instancia de la clase
	 */
	public static FactoryQuery obtenerInstancia() {

		if (factoryQuery == null) {
			factoryQuery = new FactoryQueryImp();
		}

		return factoryQuery;
	}
	
	/**
	 * Permite producir Querys que permitan mostrar habitaciones
	 * No muestra información sobre las relaciones de la habitación con el resto de entidades
	 * Muestra solo las habitaciones activas
	 * @return La query que muestre habitaciones
	 */
	public abstract Query generateQueryMostrarHabitaciones();
	
	/**
	 * Permite producir Querys que permitan mostrar residentes
	 * No muestra información sobre las relaciones del residente con el resto de entidades
	 * Muestra solo los residentes activos
	 * @return La query que muestre residentes
	 */
	public abstract Query generateQueryMostrarResidentes();
	
	/**
	 * Permite producir Querys que permitan mostrar residentes
	 * Los cuales la suma de sus facturas superan los 1000 euros
	 * No muestra información sobre las relaciones del residente con el resto de entidades
	 * Muestra solo los residentes activos
	 * @return La query que muestre residentes
	 */
	public abstract Query generateQueryMostrarResidentesSuperanFacturas();
	
	/**
	 * Permite producir Querys que permitan mostrar facturas
	 * No muestra información sobre las relaciones de las facturas con el resto de entidades
	 * Muestra solo las facturas activas
	 * @return La query que muestre facturas
	 */
	public abstract Query generateQueryMostrarFacturas();
	
	/**
	 * Permite producir Querys que permitan asignar facturas a habitaciones
	 * No muestra información sobre las relaciones de las facturas con el resto de entidades
	 * @return La query que asigne facturas
	 */
	public abstract Query generateQueryAsignarFacturas();
}
