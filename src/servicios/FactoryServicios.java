package servicios;

import habitacion.ServicioHabitacion;
import residente.ServicioResidente;
import tarea.ServicioTarea;
import departamento.ServicioDepartamento;
import empleado.ServicioEmpleado;
import factura.ServicioFactura;

/**
 * Clase abstracta singleton que gestiona la creacion de servicios
 * 
 * @author Daniel
 * 
 */
public abstract class FactoryServicios {

	private static FactoryServicios factoryServicios;

	/**
	 * Constructor privado por ser singleton
	 */
	protected FactoryServicios() {
	}

	/**
	 * Obtiene una instancia de la clase
	 * 
	 * @return la instancia de la clase
	 */
	public static FactoryServicios obtenerInstancia() {

		if (factoryServicios == null) {
			factoryServicios = new FactoryServiciosImp();
		}

		return factoryServicios;

	}

	/**
	 * Permite crear servicios de empledo
	 * @return el servicio de empleado
	 */
	public abstract ServicioEmpleado generarServicioEmpleado();

	/**
	 * Permite crear servicios de departamento
	 * @return el servicio de departamento
	 */
	public abstract ServicioDepartamento generarServicioDepartamento();

	/**
	 * Permite crear servicios de tarea
	 * @returnel servicio de tarea
	 */
	public abstract ServicioTarea generarServicioTarea();

	/**
	 * Permite crear servicios de habitación
	 * @return el servicio de habitación
	 */
	public abstract ServicioHabitacion generarServicioHabitacion();
	
	/**
	 * Permite crear servicios de residente
	 * @return el servicio de residente
	 */
	public abstract ServicioResidente generarServicioResidente();
	
	/**
	 * Permite crear servicios de factura
	 * @return el servicio de factura
	 */
	public abstract ServicioFactura generarServicioFactura();
}
