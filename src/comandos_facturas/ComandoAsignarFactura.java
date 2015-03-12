package comandos_facturas;

import java.util.List;

import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

import factura.ServicioFactura;
import factura.TransferFactura;

public class ComandoAsignarFactura extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		List<Integer> lista = (List<Integer>)datos;
		
		//crea el servicio de departamentos, lo crea utilizando una fábrica
		ServicioFactura servicioFactura = FactoryServicios.obtenerInstancia().generarServicioFactura();
		
		int valorDevuelto = servicioFactura.asignarFactura(lista.get(0), lista.get(1));
		
		RespuestaComando respuestaComando;

		if(valorDevuelto >= 0){
			respuestaComando = new RespuestaComando(EventoVista.ASIGNAR_FACTURA_EXITO,valorDevuelto); //crea la respuesta de comando
		}
		else if(valorDevuelto == -1){
			respuestaComando = new RespuestaComando(EventoVista.ASGNAR_FACTURA_NO_EXISTE,valorDevuelto); //crea la respuesta de comando
		}
		else if(valorDevuelto == -2){
			respuestaComando = new RespuestaComando(EventoVista.ASGNAR_HABITACION_NO_EXISTE,valorDevuelto); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.ASIGNAR_FACTURA_FALLO,valorDevuelto); //crea la respuesta de comando
		}
		return respuestaComando;
	}

}
