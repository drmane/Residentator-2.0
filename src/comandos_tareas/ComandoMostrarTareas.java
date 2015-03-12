package comandos_tareas;

import java.util.Collection;

import selector_vista.EventoVista;
import servicios.FactoryServicios;
import tarea.ServicioTarea;
import tarea.Tarea;
import comando.Comando;
import comando.RespuestaComando;


public class ComandoMostrarTareas extends Comando {

	@Override
	public RespuestaComando ejecutar() {
		
		ServicioTarea servicioTarea = FactoryServicios.obtenerInstancia().generarServicioTarea();
	
		Collection<Tarea> lista_tareas = servicioTarea.buscarTodasTareas();
		
		RespuestaComando respuestaComando;

		if(lista_tareas != null){
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_TAREAS_EXITO,lista_tareas); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_TAREAS_FALLO,lista_tareas); //crea la respuesta de comando
		}
		
		return respuestaComando;
	
	}
	
}



