package comandos_facturas;

import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

import factura.ServicioFactura;
import factura.TransferFactura;

public class ComandoModificarFactura extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		//crea el servicio de departamentos, lo crea utilizando una fábrica
		ServicioFactura servicioFactura = FactoryServicios.obtenerInstancia().generarServicioFactura();
		
		TransferFactura transferFacturaInformacionNueva = (TransferFactura)datos; //hacemos casting de los datos del comando
		
		int valorDevuelto = servicioFactura.modificarFactura(transferFacturaInformacionNueva);
		
		RespuestaComando respuestaComando;

		if(valorDevuelto >= 0){
			respuestaComando = new RespuestaComando(EventoVista.MODIFICAR_FACTURA_EXITO,null); //crea la respuesta de comando
		}
		else if(valorDevuelto == -1){
			respuestaComando = new RespuestaComando(EventoVista.MODIFICAR_FACTURA_NO_EXISTE,null); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.MODIFICAR_FACTURA_FALLO,null); //crea la respuesta de comando
		}
		return respuestaComando;
	}

}
