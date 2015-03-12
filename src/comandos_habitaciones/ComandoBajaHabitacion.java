package comandos_habitaciones;

import habitacion.ServicioHabitacion;
import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

public class ComandoBajaHabitacion extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		int num_hab;
		
		//crea el servicio de departamentos, lo crea utilizando una fábrica
		ServicioHabitacion servicioHabitacion = FactoryServicios.obtenerInstancia().generarServicioHabitacion();
		
		num_hab = (int)datos; //hacemos casting de los datos del comando
		
		int valorDevuelto = servicioHabitacion.borrarHabitacion(num_hab);
		
		RespuestaComando respuestaComando;

		if(valorDevuelto == 0){
			respuestaComando = new RespuestaComando(EventoVista.BAJA_HABITACION_EXITO,num_hab); //crea la respuesta de comando
		}
		else if(valorDevuelto == -1){
			respuestaComando = new RespuestaComando(EventoVista.BAJA_HABITACION_NO_EXISTE,num_hab); //crea la respuesta de comando
		}
		else if(valorDevuelto == -2){
			respuestaComando = new RespuestaComando(EventoVista.BAJA_HABITACION_RESIDENTES_ASOCIADOS,num_hab); //crea la respuesta de comando
		}
		else if(valorDevuelto == -3){
			respuestaComando = new RespuestaComando(EventoVista.BAJA_HABITACION_FACTURAS_ASOCIADOS,num_hab); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.BAJA_HABITACION_FALLO,num_hab); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}
}
