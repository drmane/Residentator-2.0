package comandos_empleados;

import selector_vista.EventoVista;
import servicios.FactoryServicios;
import tarea.Tarea;

import comando.Comando;
import comando.RespuestaComando;

import empleado.ServicioEmpleado;

public class ComandoAsignarTarea extends Comando {

	@Override
	public RespuestaComando ejecutar() {
		
		
	
		
		//crea el servicio de empleados, lo crea utilizando una fábrica
		ServicioEmpleado servicioEmpleado = FactoryServicios.obtenerInstancia().generarServicioEmpleado();
		
		int id = servicioEmpleado.asignarTarea((Tarea)datos); //llama al método de baja tareas
		
		RespuestaComando respuestaComando = null;

		if(id >= 0){
			respuestaComando = new RespuestaComando(EventoVista.ASIGNAR_TAREA_EXITO,id); //crea la respuesta de comando
		}
		else if(id == -1){
			respuestaComando = new RespuestaComando(EventoVista.ASIGNAR_TAREA_FALLO_EMPLEADO_NO_EXISTE,id); //crea la respuesta de comando
		}
		else if(id == -2){
			respuestaComando = new RespuestaComando(EventoVista.ASIGNAR_TAREA_FALLO_TAREA_NO_EXISTE,id);
		}
		else if(id == -3){
			respuestaComando = new RespuestaComando(EventoVista.ASIGNAR_TAREA_FALLO_TAREA_YA_ASIGNADA_EMPLEADO,id);
		}
		else if(id == -4){
			respuestaComando = new RespuestaComando(EventoVista.ASIGNAR_TAREA_FALLO_EMPLEADO_YA_ASIGNADO_TAREA,id);
		}
		
		return respuestaComando;
	}

}
