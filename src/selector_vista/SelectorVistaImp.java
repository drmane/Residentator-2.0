package selector_vista;

import vista_departamentos.BajaDepartamento;
import vista_departamentos.MostrarDepartamento;
import vista_departamentos.MostrarDepartamentos;
import vista_departamentos.NuevoDepartamento;
import vista_empleados.AsignarTarea;
import vista_empleados.BajaEmpleado;
import vista_empleados.MostrarEmpleado;
import vista_empleados.MostrarEmpleados;
import vista_empleados.NuevoEmpleado;
import vista_facturas.AsignarFactura;
import vista_facturas.BorrarFactura;
import vista_facturas.ModificarFactura;
import vista_facturas.MostrarFactura;
import vista_facturas.MostrarFacturas;
import vista_facturas.NuevaFactura;
import vista_habitaciones.BorrarHabitacion;
import vista_habitaciones.ModificarHabitacion;
import vista_habitaciones.MostrarHabitacion;
import vista_habitaciones.MostrarHabitaciones;
import vista_habitaciones.NuevaHabitacion;
import vista_residentes.BorrarResidente;
import vista_residentes.ModificarResidente;
import vista_residentes.MostrarResidente;
import vista_residentes.MostrarResidentes;
import vista_residentes.MostrarResidentesSuperanFacturas;
import vista_residentes.NuevoResidente;
import vista_tareas.BajaTarea;
import vista_tareas.MostrarTarea;
import vista_tareas.MostrarTareas;
import vista_tareas.NuevaTarea;

public class SelectorVistaImp extends SelectorVista {

	@Override
	public void redirigirVista(int id_evento_vista, Object datos) {
	
		switch(id_evento_vista){
		
							//HABITACIONES
		
			case EventoVista.NUEVA_HABITACION_EXITO: NuevaHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.NUEVA_HABITACION_CAPACIDAD_NO_VALIDA: NuevaHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.NUEVA_HABITACION_NUMERO_YA_EXISTE: NuevaHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.NUEVA_HABITACION_FALLO: NuevaHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.BAJA_HABITACION_EXITO: BorrarHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.BAJA_HABITACION_NO_EXISTE: BorrarHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.BAJA_HABITACION_RESIDENTES_ASOCIADOS: BorrarHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.BAJA_HABITACION_FACTURAS_ASOCIADOS: BorrarHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.BAJA_HABITACION_FALLO: BorrarHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MODIFICAR_HABITACION_EXITO: ModificarHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MODIFICAR_HABITACION_NO_EXISTE: ModificarHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MODIFICAR_HABITACION_CAPACIDAD_MENOR_OCUPANTES: ModificarHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MODIFICAR_HABITACION_FALLO: ModificarHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MOSTAR_HABITACION_EXITO: MostrarHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTAR_HABITACION_FALLO: MostrarHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MOSTRAR_HABITACIONES_EXITO: MostrarHabitaciones.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_HABITACIONES_FALLO: MostrarHabitaciones.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
							//RESIDENTES
			
			case EventoVista.NUEVO_RESIDENTE_EXITO: NuevoResidente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.NUEVO_RESIDENTE_DNI_YA_EXISTE: NuevoResidente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.NUEVO_RESIDENTE_HABITACION_NO_EXISTE: NuevoResidente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.NUEVO_RESIDENTE_HABITACION_LLENA: NuevoResidente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.NUEVO_RESIDENTE_FALLO: NuevoResidente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.BAJA_RESIDENTE_EXITO: BorrarResidente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.BAJA_RESIDENTE_NO_EXISTE: BorrarResidente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.BAJA_RESIDENTES_FACTURAS_ASOCIADAS: BorrarResidente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.BAJA_RESIDENTE_FALLO: BorrarResidente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MODIFICAR_RESIDENTE_EXITO: ModificarResidente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MODIFICAR_RESIDENTE_NO_EXISTE: ModificarResidente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MODIFICAR_RESIDENTE_FALLO: ModificarResidente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MOSTRAR_RESIDENTE_EXITO: MostrarResidente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_RESIDENTE_FALLO: MostrarResidente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MOSTRAR_RESIDENTES_EXITO: MostrarResidentes.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_RESIDENTES_FALLO: MostrarResidentes.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MOSTRAR_RESIDENTES_SUPERAN_FACTURAS_EXITO: MostrarResidentesSuperanFacturas.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_RESIDENTES_SUPERAN_FACTURAS_FALLO: MostrarResidentesSuperanFacturas.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
							//FACTURAS
			
			case EventoVista.NUEVA_FACTURA_EXITO: NuevaFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.NUEVA_FACTURAE_RESIDENTE_NO_EXISTE: NuevaFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.NUEVA_FACTURA_FALLO: NuevaFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.BAJA_FACTURA_EXITO: BorrarFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.BAJA_FACTURA_NO_EXISTE: BorrarFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.BAJA_FACTURA_FALLO: BorrarFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MODIFICAR_FACTURA_EXITO: ModificarFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MODIFICAR_FACTURA_NO_EXISTE: ModificarFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MODIFICAR_FACTURA_FALLO: ModificarFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MOSTRAR_FACTURA_EXITO: MostrarFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_FACTURA_FALLO: MostrarFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MOSTRAR_FACTURAS_EXITO: MostrarFacturas.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_FACTURAS_FALLO: MostrarFacturas.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.ASIGNAR_FACTURA_EXITO: AsignarFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.ASGNAR_FACTURA_NO_EXISTE: AsignarFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.ASGNAR_HABITACION_NO_EXISTE: AsignarFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.ASIGNAR_FACTURA_FALLO: AsignarFactura.obtenerInstancia().actualizar(id_evento_vista, datos); break;
							//DEPARTAMENTOS
		
			case EventoVista.NUEVO_DEPARTAMENTO_EXITO: NuevoDepartamento.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.NUEVO_DEPARTAMENTO_FALLO: NuevoDepartamento.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.NUEVO_DEPARTAMENTO_NOMBRE_EXISTE: NuevoDepartamento.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.BAJA_DEPARTAMENTO_EXITO: BajaDepartamento.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.BAJA_DEPARTAMENTO_FALLO: BajaDepartamento.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MOSTAR_DEPARTAMENTO_EXITO: MostrarDepartamento.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTAR_DEPARTAMENTO_FALLO: MostrarDepartamento.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MOSTRAR_DEPARTAMENTOS_EXITO: MostrarDepartamentos.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_DEPARTAMENTOS_FALLO: MostrarDepartamentos.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			
							//EMPLEADOS
			
			case EventoVista.NUEVO_EMPLEADO_EXITO: NuevoEmpleado.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.NUEVO_EMPLEADO_FALLO: NuevoEmpleado.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.NUEVO_EMPLEADO_DEPARTAMENTO_NO_EXISTE: NuevoEmpleado.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.BAJA_EMPLEADO_EXITO: BajaEmpleado.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			case EventoVista.BAJA_EMPLEADO_FALLO: BajaEmpleado.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MOSTRAR_EMPLEADO_EXITO: MostrarEmpleado.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			case EventoVista.MOSTRAR_EMPLEADO_FALLO: MostrarEmpleado.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			
			case EventoVista.MOSTRAR_EMPLEADOS_EXITO: MostrarEmpleados.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			case EventoVista.MOSTRAR_EMPLEADOS_FALLO: MostrarEmpleados.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			
						//TAREAS
			
			case EventoVista.NUEVA_TAREA_EXITO: NuevaTarea.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			case EventoVista.NUEVA_TAREA_FALLO:NuevaTarea.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			
			case EventoVista.BAJA_TAREA_EXITO: BajaTarea.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			case EventoVista.BAJA_TAREA_FALLO: BajaTarea.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			
			case EventoVista.MOSTRAR_TAREA_EXITO: MostrarTarea.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			case EventoVista.MOSTRAR_TAREA_FALLO: MostrarTarea.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			
			case EventoVista.MOSTRAR_TAREAS_EXITO: MostrarTareas.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			case EventoVista.MOSTRAR_TAREAS_FALLO: MostrarTareas.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			
			case EventoVista.ASIGNAR_TAREA_EXITO: AsignarTarea.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			case EventoVista.ASIGNAR_TAREA_FALLO_EMPLEADO_NO_EXISTE: AsignarTarea.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			case EventoVista.ASIGNAR_TAREA_FALLO_TAREA_NO_EXISTE: AsignarTarea.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			case EventoVista.ASIGNAR_TAREA_FALLO_TAREA_YA_ASIGNADA_EMPLEADO: AsignarTarea.obtenerInstancia().actualizar(id_evento_vista, datos);break;
			case EventoVista.ASIGNAR_TAREA_FALLO_EMPLEADO_YA_ASIGNADO_TAREA: AsignarTarea.obtenerInstancia().actualizar(id_evento_vista, datos);break;
					
		}	
	}

}
