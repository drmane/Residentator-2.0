package comandos_habitaciones;

import habitacion.ServicioHabitacion;
import habitacion.TransferHabitacion;
import selector_vista.EventoVista;
import servicios.FactoryServicios;
import comando.Comando;
import comando.RespuestaComando;

public class ComandoModificarHabitacion extends Comando{

	@Override
	public RespuestaComando ejecutar() {	
		//crea el servicio de departamentos, lo crea utilizando una fábrica
		ServicioHabitacion servicioHabitacion = FactoryServicios.obtenerInstancia().generarServicioHabitacion();
		
		TransferHabitacion transferHabitacionInformacionNueva = (TransferHabitacion)datos; //hacemos casting de los datos del comando
		
		int valorDevuelto = servicioHabitacion.modificarHabitacion(transferHabitacionInformacionNueva);
		
		RespuestaComando respuestaComando;

		if(valorDevuelto >= 0){
			respuestaComando = new RespuestaComando(EventoVista.MODIFICAR_HABITACION_EXITO,null); //crea la respuesta de comando
		}
		else if(valorDevuelto == -1){
			respuestaComando = new RespuestaComando(EventoVista.MODIFICAR_HABITACION_NO_EXISTE,null); //crea la respuesta de comando
		}
		else if(valorDevuelto == -2){
			respuestaComando = new RespuestaComando(EventoVista.MODIFICAR_HABITACION_CAPACIDAD_MENOR_OCUPANTES,null); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.MODIFICAR_HABITACION_FALLO,null); //crea la respuesta de comando
		}
		return respuestaComando;
	}

}
