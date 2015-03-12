package comandos_habitaciones;

import habitacion.TransferHabitacion;

import java.util.Collection;
import java.util.List;

import selector_vista.EventoVista;
import servicios.FactoryServicios;
import comando.Comando;
import comando.RespuestaComando;
import departamento.Departamento;

public class ComandoMostrarHabitaciones extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		
		List<TransferHabitacion> lista_habitaciones = FactoryServicios.obtenerInstancia().generarServicioHabitacion().mostrarHabitaciones();
		
		RespuestaComando respuestaComando;

		if(lista_habitaciones.size() > 0){
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_HABITACIONES_EXITO,lista_habitaciones); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_HABITACIONES_FALLO,lista_habitaciones); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}
}
