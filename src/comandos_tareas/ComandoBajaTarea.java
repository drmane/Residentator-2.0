package comandos_tareas;

import selector_vista.EventoVista;
import servicios.FactoryServicios;
import tarea.ServicioTarea;
import comando.Comando;
import comando.RespuestaComando;

public class ComandoBajaTarea extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		//crea el servicio de tareas, lo crea utilizando una fábrica
		ServicioTarea servicioTarea = FactoryServicios.obtenerInstancia().generarServicioTarea();
		
		boolean correcto = servicioTarea.bajaTarea((int)datos); //llama al método de baja tareas
		
		RespuestaComando respuestaComando;

		if(correcto){
			respuestaComando = new RespuestaComando(EventoVista.BAJA_TAREA_EXITO,null); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.BAJA_TAREA_FALLO,null); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}

}
