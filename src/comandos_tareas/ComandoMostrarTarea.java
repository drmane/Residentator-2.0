package comandos_tareas;

import selector_vista.EventoVista;
import servicios.FactoryServicios;
import tarea.ServicioTarea;
import tarea.Tarea;
import comando.Comando;
import comando.RespuestaComando;


public class ComandoMostrarTarea extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		
		ServicioTarea servicioTarea = FactoryServicios.obtenerInstancia().generarServicioTarea();
		
		Tarea tarea = servicioTarea.buscarTarea((int)datos);
			
			RespuestaComando respuestaComando;

			if(tarea != null){
				respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_TAREA_EXITO,tarea); //crea la respuesta de comando
			}
			else{
				respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_TAREA_FALLO,tarea); //crea la respuesta de comando
			}
			
			return respuestaComando;
		}

}
