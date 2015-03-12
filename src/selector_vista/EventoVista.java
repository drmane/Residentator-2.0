package selector_vista;

public class EventoVista {
	
	/*
	 * Sintaxis evento vista:
	 * ######################
	 * 
	 * - el primer número indica el modulos de la aplicación
	 * - los dos siguientes indican el id del caso de uso
	 * - el último número indica 0 para éxito y 1 para fallo y en adelante para flujos alternativos
	 * 
	 */

	
	//PRIMERA ENTREGA
	
	//EVENTOS DE ÉXITO
	
	public final static int NUEVA_HABITACION_EXITO = 1010;
	public final static int BAJA_HABITACION_EXITO = 1020;
	public final static int MODIFICAR_HABITACION_EXITO = 1030;
	public final static int MOSTAR_HABITACION_EXITO = 1040;
	public final static int MOSTRAR_HABITACIONES_EXITO = 1050;
	
	public final static int NUEVO_RESIDENTE_EXITO = 2010;
	public final static int BAJA_RESIDENTE_EXITO = 2020;
	public final static int MODIFICAR_RESIDENTE_EXITO = 2030;
	public final static int MOSTRAR_RESIDENTE_EXITO = 2040;
	public final static int MOSTRAR_RESIDENTES_EXITO = 2050;
	public final static int MOSTRAR_RESIDENTES_SUPERAN_FACTURAS_EXITO = 2060;
	
	public final static int NUEVA_FACTURA_EXITO = 3010;
	public final static int BAJA_FACTURA_EXITO = 3020;
	public final static int MODIFICAR_FACTURA_EXITO = 3030;
	public final static int MOSTRAR_FACTURA_EXITO = 3040;
	public final static int MOSTRAR_FACTURAS_EXITO = 3050;
	public final static int ASIGNAR_FACTURA_EXITO = 3060;
	
	//EVENTOS DE FALLO
	
	public final static int NUEVA_HABITACION_FALLO = 1011;
	public final static int BAJA_HABITACION_FALLO = 1021;
	public final static int MODIFICAR_HABITACION_FALLO = 1031;
	public final static int MOSTAR_HABITACION_FALLO = 1041;
	public final static int MOSTRAR_HABITACIONES_FALLO = 1051;
	
	public final static int NUEVO_RESIDENTE_FALLO = 2011;
	public final static int BAJA_RESIDENTE_FALLO = 2021;
	public final static int MODIFICAR_RESIDENTE_FALLO = 2031;
	public final static int MOSTRAR_RESIDENTE_FALLO = 2041;
	public final static int MOSTRAR_RESIDENTES_FALLO= 2051;
	public final static int MOSTRAR_RESIDENTES_SUPERAN_FACTURAS_FALLO = 2061;
	
	public final static int NUEVA_FACTURA_FALLO = 3011;
	public final static int BAJA_FACTURA_FALLO = 3021;
	public final static int MODIFICAR_FACTURA_FALLO = 3031;
	public final static int MOSTRAR_FACTURA_FALLO = 3041;
	public final static int MOSTRAR_FACTURAS_FALLO = 3051;
	public final static int ASIGNAR_FACTURA_FALLO = 3061;
	
	//EVENTOS DE FLUJO ALTERNATIVO
	public final static int NUEVA_HABITACION_CAPACIDAD_NO_VALIDA = 1012;
	public final static int NUEVA_HABITACION_NUMERO_YA_EXISTE = 1013;
	
	public final static int BAJA_HABITACION_NO_EXISTE = 1022;
	public final static int BAJA_HABITACION_RESIDENTES_ASOCIADOS = 1023;
	public final static int BAJA_HABITACION_FACTURAS_ASOCIADOS = 1024;
	
	public final static int MODIFICAR_HABITACION_NO_EXISTE = 1032;
	public final static int MODIFICAR_HABITACION_CAPACIDAD_MENOR_OCUPANTES = 1033;
	
	public final static int NUEVO_RESIDENTE_DNI_YA_EXISTE = 2012;
	public final static int NUEVO_RESIDENTE_HABITACION_NO_EXISTE = 2013;
	public final static int NUEVO_RESIDENTE_HABITACION_LLENA = 2014;
	
	public final static int BAJA_RESIDENTE_NO_EXISTE = 2022;
	public final static int BAJA_RESIDENTES_FACTURAS_ASOCIADAS = 2023;
	
	public final static int MODIFICAR_RESIDENTE_NO_EXISTE = 2032;
	
	public final static int NUEVA_FACTURAE_RESIDENTE_NO_EXISTE = 3012;
	
	public final static int BAJA_FACTURA_NO_EXISTE = 3022;
	
	public final static int MODIFICAR_FACTURA_NO_EXISTE = 3032;
	
	public final static int ASGNAR_FACTURA_NO_EXISTE = 3062;
	public final static int ASGNAR_HABITACION_NO_EXISTE = 3063;
	
	//SEGUNDA ENTREGA
	
	//EVENTOS DE ÉXITO
	public final static int NUEVO_DEPARTAMENTO_EXITO = 4010;
	public final static int BAJA_DEPARTAMENTO_EXITO = 4020;
	public final static int MOSTAR_DEPARTAMENTO_EXITO = 4030;
	public final static int MOSTRAR_DEPARTAMENTOS_EXITO = 4040;
	
	public final static int NUEVO_EMPLEADO_EXITO = 5010;
	public final static int BAJA_EMPLEADO_EXITO = 5020;
	public final static int MOSTRAR_EMPLEADO_EXITO = 5030;
	public final static int MOSTRAR_EMPLEADOS_EXITO = 5040;
	public final static int ASIGNAR_TAREA_EXITO = 5050;
	
	public final static int NUEVA_TAREA_EXITO = 6010;
	public final static int BAJA_TAREA_EXITO = 6020;
	public final static int MOSTRAR_TAREA_EXITO = 6030;
	public final static int MOSTRAR_TAREAS_EXITO = 6040;
	
	//EVENTOS DE FALLO
	public final static int NUEVO_DEPARTAMENTO_FALLO = 4011;
	public final static int BAJA_DEPARTAMENTO_FALLO = 4021;
	public final static int MOSTAR_DEPARTAMENTO_FALLO = 4031;
	public final static int MOSTRAR_DEPARTAMENTOS_FALLO = 4041;
	
	public final static int NUEVO_EMPLEADO_FALLO = 5011;
	public final static int BAJA_EMPLEADO_FALLO = 5021;
	public final static int MOSTRAR_EMPLEADO_FALLO = 5031;
	public final static int MOSTRAR_EMPLEADOS_FALLO = 5041;
	
	public final static int NUEVA_TAREA_FALLO = 6011;
	public final static int BAJA_TAREA_FALLO = 6021;
	public final static int MOSTRAR_TAREA_FALLO = 6031;
	public final static int MOSTRAR_TAREAS_FALLO = 6041;
	
	//EVENTOS DE FLUJO ALTERNATIVO
	public final static int NUEVO_DEPARTAMENTO_NOMBRE_EXISTE = 4012;
	public final static int NUEVO_EMPLEADO_DEPARTAMENTO_NO_EXISTE = 5012;
	
	public final static int ASIGNAR_TAREA_FALLO_EMPLEADO_NO_EXISTE = 5051;
	public final static int ASIGNAR_TAREA_FALLO_TAREA_NO_EXISTE = 5052;
	public final static int ASIGNAR_TAREA_FALLO_TAREA_YA_ASIGNADA_EMPLEADO = 5053;
	public final static int ASIGNAR_TAREA_FALLO_EMPLEADO_YA_ASIGNADO_TAREA = 5054;
	
}
