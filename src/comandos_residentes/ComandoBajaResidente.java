package comandos_residentes;

import residente.ServicioResidente;
import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

public class ComandoBajaResidente extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		String dni;
		
		//crea el servicio de departamentos, lo crea utilizando una fábrica
		ServicioResidente servicioResidente = FactoryServicios.obtenerInstancia().generarServicioResidente();
		
		dni = (String)datos; //hacemos casting de los datos del comando
		
		int valorDevuelto = servicioResidente.borrarResidente(dni);
		
		RespuestaComando respuestaComando;

		if(valorDevuelto >= 0){
			respuestaComando = new RespuestaComando(EventoVista.BAJA_RESIDENTE_EXITO,dni); //crea la respuesta de comando
		}
		else if(valorDevuelto == -1){
			respuestaComando = new RespuestaComando(EventoVista.BAJA_RESIDENTE_NO_EXISTE,dni); //crea la respuesta de comando
		}
		else if(valorDevuelto == -2){
			respuestaComando = new RespuestaComando(EventoVista.BAJA_RESIDENTES_FACTURAS_ASOCIADAS,dni); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.BAJA_RESIDENTE_FALLO,dni); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}
}
