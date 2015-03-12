package comandos_facturas;

import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

import factura.ServicioFactura;
import factura.TransferFactura;

public class ComandoMostrarFactura extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		ServicioFactura servicioFactura = FactoryServicios.obtenerInstancia().generarServicioFactura();
		TransferFactura transferFactura = servicioFactura.buscarFactura((int)datos);
		
		RespuestaComando respuestaComando;
		
		if((transferFactura != null)&&(transferFactura.isActivo())){
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_FACTURA_EXITO,transferFactura); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_FACTURA_FALLO,transferFactura); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}

}
