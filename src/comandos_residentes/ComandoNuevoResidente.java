package comandos_residentes;

import residente.ServicioResidente;
import residente.TransferResidente;
import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

public class ComandoNuevoResidente extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		int id;
		
		//crea el servicio de departamentos, lo crea utilizando una fábrica
		ServicioResidente servicioResidente = FactoryServicios.obtenerInstancia().generarServicioResidente();
		
		TransferResidente transferResidente = (TransferResidente)datos; //hacemos casting de los datos del comando
		
		id = servicioResidente.altaResidente(transferResidente);
		
		RespuestaComando respuestaComando;

		if(id >= 0){
			respuestaComando = new RespuestaComando(EventoVista.NUEVO_RESIDENTE_EXITO,id); //crea la respuesta de comando
		}
		else if(id == -1){
			respuestaComando = new RespuestaComando(EventoVista.NUEVO_RESIDENTE_DNI_YA_EXISTE,id); //crea la respuesta de comando
		}
		else if(id == -2){
			respuestaComando = new RespuestaComando(EventoVista.NUEVO_RESIDENTE_HABITACION_NO_EXISTE,id); //crea la respuesta de comando
		}
		else if(id == -3){
			respuestaComando = new RespuestaComando(EventoVista.NUEVO_RESIDENTE_HABITACION_LLENA,id); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.NUEVA_HABITACION_FALLO,id); //crea la respuesta de comando
		}
		return respuestaComando;
	}

}
