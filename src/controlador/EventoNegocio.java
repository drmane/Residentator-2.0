package controlador;

/**
 * Clase que contiene el id de los eventos producidos
 * 
 * @author Daniel
 * 
 */
public class EventoNegocio {
	
	/*
	 * Sintaxis evento negocio:
	 * #######################
	 * 
	 * - el primer número indica el modulos de la aplicación
	 * - Los dos siguientes números indican el id del caso de uso
	 * 
	 */
	
	
	//Primera Entrega
	public final static int NUEVA_HABITACIÓN = 101;
	public final static int BAJA_HABITACIÓN = 102;
	public final static int MODIFICAR_HABITACIÓN = 103;
	public final static int MOSTRAR_HABITACIÓN = 104;
	public final static int MOSTRAR_HABITACIONES = 105;

	public final static int NUEVO_RESIDENTE = 201;
	public final static int BAJA_RESIDENTE = 202;
	public final static int MODIFICAR_RESIDENTE = 203;
	public final static int MOSTRAR_RESIDENTE = 204;
	public final static int MOSTRAR_RESIDENTES = 205;
	public final static int MOSTRAR_RESIDENTES_SUPERAN_FACTURAS = 206;

	public final static int NUEVA_FACTURA = 301;
	public final static int BAJA_FACTURA = 302;
	public final static int MODIFICAR_FACTURA = 303;
	public final static int MOSTRAR_FACTURA = 304;
	public final static int MOSTRAR_FACTURAS = 305;
	public final static int ASIGNAR_FACTURA = 306;
	
	//Segunda Entrega
	public final static int NUEVO_DEPARTAMENTO = 401;
	public final static int BAJA_DEPARTAMENTO = 402;
	public final static int MOSTAR_DEPARTAMENTO = 403;
	public final static int MOSTRAR_DEPARTAMENTOS = 404;

	public final static int NUEVO_EMPLEADO = 501;
	public final static int BAJA_EMPLEADO = 502;
	public final static int MOSTRAR_EMPLEADO = 503;
	public final static int MOSTRAR_EMPLEADOS = 504;
	public final static int ASIGNAR_TAREA = 505;

	public final static int NUEVA_TAREA = 601;
	public final static int BAJA_TAREA = 602;
	public final static int MOSTRAR_TAREA = 603;
	public final static int MOSTRAR_TAREAS = 604;

}
