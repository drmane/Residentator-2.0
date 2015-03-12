package comandos_residentes;

import residente.ServicioResidente;
import residente.TransferResidente;
import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

public class ComandoMostrarResidente extends Comando{


	@Override
	public RespuestaComando ejecutar() {
		//crea el servicio de habitaciones, lo crea utilizando una fábrica
		ServicioResidente servicioResidente = FactoryServicios.obtenerInstancia().generarServicioResidente();
		
		TransferResidente transferResidente = servicioResidente.buscarResidente((String)datos);
		
		RespuestaComando respuestaComando;
		
		if((transferResidente != null)&&(transferResidente.isActivo())){
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_RESIDENTE_EXITO,transferResidente); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_RESIDENTE_FALLO,transferResidente); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}
}
