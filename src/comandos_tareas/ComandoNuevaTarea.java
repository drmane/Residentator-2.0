package comandos_tareas;

import selector_vista.EventoVista;
import servicios.FactoryServicios;
import tarea.ServicioTarea;
import tarea.Tarea;

import comando.Comando;
import comando.RespuestaComando;

public class ComandoNuevaTarea extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		
		int id;
		
		//crea el servicio de tareas, lo crea utilizando una fábrica
		ServicioTarea servicioTarea = FactoryServicios.obtenerInstancia().generarServicioTarea();
		
		Tarea tarea = (Tarea)datos; //hacemos casting de los datos del comando
		
		id = servicioTarea.crearTarea(tarea);
		
		RespuestaComando respuestaComando;

		if(id >= 0){
			respuestaComando = new RespuestaComando(EventoVista.NUEVA_TAREA_EXITO,id); //crea la respuesta de comando
		}
		
		else{
			respuestaComando = new RespuestaComando(EventoVista.NUEVA_TAREA_FALLO,id); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}

}
