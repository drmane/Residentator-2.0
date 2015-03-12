package comandos_habitaciones;

import habitacion.ServicioHabitacion;
import habitacion.TransferHabitacion;
import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

public class ComandoNuevaHabitacion extends Comando {

	@Override
	public RespuestaComando ejecutar() {
		int id;
		
		//crea el servicio de departamentos, lo crea utilizando una fábrica
		ServicioHabitacion servicioHabitacion = FactoryServicios.obtenerInstancia().generarServicioHabitacion();
		
		TransferHabitacion transferHabitacion = (TransferHabitacion)datos; //hacemos casting de los datos del comando
		
		id = servicioHabitacion.altaHabitacion(transferHabitacion);
		
		RespuestaComando respuestaComando;

		if(id >= 0){
			respuestaComando = new RespuestaComando(EventoVista.NUEVA_HABITACION_EXITO,id); //crea la respuesta de comando
		}
		else if(id == -1){
			respuestaComando = new RespuestaComando(EventoVista.NUEVA_HABITACION_CAPACIDAD_NO_VALIDA,id); //crea la respuesta de comando
		}
		else if(id == -2){
			respuestaComando = new RespuestaComando(EventoVista.NUEVA_HABITACION_NUMERO_YA_EXISTE,id); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.NUEVA_HABITACION_FALLO,id); //crea la respuesta de comando
		}
		return respuestaComando;
	}
}
