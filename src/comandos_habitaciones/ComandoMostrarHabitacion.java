package comandos_habitaciones;

import habitacion.ServicioHabitacion;
import habitacion.TransferHabitacion;
import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

public class ComandoMostrarHabitacion extends Comando {

	@Override
	public RespuestaComando ejecutar() {
		//crea el servicio de habitaciones, lo crea utilizando una fábrica
		ServicioHabitacion servicioHabitacion = FactoryServicios.obtenerInstancia().generarServicioHabitacion();
		
		TransferHabitacion transferHabitacion = servicioHabitacion.buscarHabitacion((int)datos);
		
		RespuestaComando respuestaComando;
		
		if((transferHabitacion != null)&&(transferHabitacion.isActivo())){
			respuestaComando = new RespuestaComando(EventoVista.MOSTAR_HABITACION_EXITO,transferHabitacion); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.MOSTAR_HABITACION_FALLO,transferHabitacion); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}
}

