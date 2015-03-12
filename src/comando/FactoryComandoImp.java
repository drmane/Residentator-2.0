package comando;

import comandos_departamentos.ComandoBajaDepartamento;
import comandos_departamentos.ComandoMostrarDepartamento;
import comandos_departamentos.ComandoMostrarDepartamentos;
import comandos_departamentos.ComandoNuevoDepartamento;
import comandos_empleados.ComandoAsignarTarea;
import comandos_empleados.ComandoBajaEmpleado;
import comandos_empleados.ComandoMostrarEmpleado;
import comandos_empleados.ComandoMostrarEmpleados;
import comandos_empleados.ComandoNuevoEmpleado;
import comandos_facturas.ComandoAsignarFactura;
import comandos_facturas.ComandoBajaFactura;
import comandos_facturas.ComandoModificarFactura;
import comandos_facturas.ComandoMostrarFactura;
import comandos_facturas.ComandoMostrarFacturas;
import comandos_facturas.ComandoNuevaFactura;
import comandos_habitaciones.ComandoBajaHabitacion;
import comandos_habitaciones.ComandoModificarHabitacion;
import comandos_habitaciones.ComandoMostrarHabitacion;
import comandos_habitaciones.ComandoMostrarHabitaciones;
import comandos_habitaciones.ComandoNuevaHabitacion;
import comandos_residentes.ComandoBajaResidente;
import comandos_residentes.ComandoModificarResidente;
import comandos_residentes.ComandoMostrarResidente;
import comandos_residentes.ComandoMostrarResidentes;
import comandos_residentes.ComandoMostrarResidentesSuperanFacturas;
import comandos_residentes.ComandoNuevoResidente;
import comandos_tareas.ComandoBajaTarea;
import comandos_tareas.ComandoMostrarTarea;
import comandos_tareas.ComandoMostrarTareas;
import comandos_tareas.ComandoNuevaTarea;
import controlador.EventoNegocio;


public class FactoryComandoImp extends FactoryComando {
	

	@Override
	public Comando producirComando(int id_comando, Object datos) {
		Comando comando = null;
		
		switch (id_comando){

		//Primera Entrega
		case EventoNegocio.NUEVA_HABITACIÓN: comando = new ComandoNuevaHabitacion(); break;
		case EventoNegocio.BAJA_HABITACIÓN: comando = new ComandoBajaHabitacion(); break;
		case EventoNegocio.MODIFICAR_HABITACIÓN: comando = new ComandoModificarHabitacion(); break;
		case EventoNegocio.MOSTRAR_HABITACIÓN: comando = new ComandoMostrarHabitacion(); break;
		case EventoNegocio.MOSTRAR_HABITACIONES: comando = new ComandoMostrarHabitaciones(); break;
		
		case EventoNegocio.NUEVO_RESIDENTE: comando = new ComandoNuevoResidente(); break;
		case EventoNegocio.BAJA_RESIDENTE: comando = new ComandoBajaResidente(); break;
		case EventoNegocio.MODIFICAR_RESIDENTE: comando = new ComandoModificarResidente(); break;
		case EventoNegocio.MOSTRAR_RESIDENTE: comando = new ComandoMostrarResidente(); break;
		case EventoNegocio.MOSTRAR_RESIDENTES: comando = new ComandoMostrarResidentes(); break;
		case EventoNegocio.MOSTRAR_RESIDENTES_SUPERAN_FACTURAS: comando = new ComandoMostrarResidentesSuperanFacturas(); break;
		
		case EventoNegocio.NUEVA_FACTURA: comando = new ComandoNuevaFactura(); break;
		case EventoNegocio.BAJA_FACTURA: comando = new ComandoBajaFactura(); break;
		case EventoNegocio.MODIFICAR_FACTURA: comando = new ComandoModificarFactura(); break;
		case EventoNegocio.MOSTRAR_FACTURA: comando = new ComandoMostrarFactura(); break;
		case EventoNegocio.MOSTRAR_FACTURAS: comando = new ComandoMostrarFacturas(); break;
		case EventoNegocio.ASIGNAR_FACTURA: comando = new ComandoAsignarFactura(); break;
		
		//Segunda Entrega
		case EventoNegocio.NUEVO_DEPARTAMENTO: comando = new ComandoNuevoDepartamento(); break;
		case EventoNegocio.BAJA_DEPARTAMENTO: comando = new ComandoBajaDepartamento(); break;
		case EventoNegocio.MOSTAR_DEPARTAMENTO: comando = new ComandoMostrarDepartamento(); break;
		case EventoNegocio.MOSTRAR_DEPARTAMENTOS: comando = new ComandoMostrarDepartamentos(); break;
		
		case EventoNegocio.NUEVO_EMPLEADO: comando = new ComandoNuevoEmpleado(); break;
		case EventoNegocio.BAJA_EMPLEADO: comando = new ComandoBajaEmpleado(); break;
		case EventoNegocio.MOSTRAR_EMPLEADO: comando = new ComandoMostrarEmpleado(); break;
		case EventoNegocio.MOSTRAR_EMPLEADOS: comando = new ComandoMostrarEmpleados(); break;
		
		case EventoNegocio.NUEVA_TAREA: comando = new ComandoNuevaTarea(); break;
		case EventoNegocio.BAJA_TAREA: comando = new ComandoBajaTarea(); break;
		case EventoNegocio.MOSTRAR_TAREA: comando = new ComandoMostrarTarea(); break;
		case EventoNegocio.MOSTRAR_TAREAS: comando = new ComandoMostrarTareas(); break;
		case EventoNegocio.ASIGNAR_TAREA: comando = new ComandoAsignarTarea(); break; //asignar tarea
		//13 eventos

		}
		
		return comando;
	}

}
