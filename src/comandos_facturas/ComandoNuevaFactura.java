package comandos_facturas;

import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

import factura.ServicioFactura;
import factura.TransferFactura;

public class ComandoNuevaFactura extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		
		int id;
		
		//crea el servicio de departamentos, lo crea utilizando una fábrica
		ServicioFactura servicioFactura = FactoryServicios.obtenerInstancia().generarServicioFactura();
		
		TransferFactura transferFactura = (TransferFactura)datos; //hacemos casting de los datos del comando
		
		id = servicioFactura.altaFactura(transferFactura);
		
		RespuestaComando respuestaComando;

		if(id >= 0){
			respuestaComando = new RespuestaComando(EventoVista.NUEVA_FACTURA_EXITO,id); //crea la respuesta de comando
		}
		else if(id == -1){
			respuestaComando = new RespuestaComando(EventoVista.NUEVA_FACTURAE_RESIDENTE_NO_EXISTE,id); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.NUEVA_FACTURA_FALLO,id); //crea la respuesta de comando
		}
		return respuestaComando;
	}
}
