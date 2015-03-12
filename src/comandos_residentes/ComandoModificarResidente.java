package comandos_residentes;

import residente.ServicioResidente;
import residente.TransferResidente;
import selector_vista.EventoVista;
import servicios.FactoryServicios;
import comando.Comando;
import comando.RespuestaComando;

public class ComandoModificarResidente extends Comando{
	
	@Override
	public RespuestaComando ejecutar() {
		//crea el servicio de departamentos, lo crea utilizando una fábrica
		ServicioResidente servicioResidente = FactoryServicios.obtenerInstancia().generarServicioResidente();
		
		TransferResidente transferResidenteInformacionNueva = (TransferResidente)datos; //hacemos casting de los datos del comando
		
		int valorDevuelto = servicioResidente.modificarResidente(transferResidenteInformacionNueva);
		
		RespuestaComando respuestaComando;
	
		if(valorDevuelto >= 0){
			respuestaComando = new RespuestaComando(EventoVista.MODIFICAR_RESIDENTE_EXITO,null); //crea la respuesta de comando
		}
		else if(valorDevuelto == -1){
			respuestaComando = new RespuestaComando(EventoVista.MODIFICAR_RESIDENTE_NO_EXISTE,null); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.MODIFICAR_HABITACION_FALLO,null); //crea la respuesta de comando
		}
		return respuestaComando;
	}
}
