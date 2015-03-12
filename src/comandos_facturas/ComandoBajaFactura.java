package comandos_facturas;

import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

import factura.ServicioFactura;

public class ComandoBajaFactura extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		int id_fac;
		
		ServicioFactura servicioFactura = FactoryServicios.obtenerInstancia().generarServicioFactura();
		
		id_fac = (int)datos; //hacemos casting de los datos del comando
		
		int valorDevuelto = servicioFactura.borrarFactura(id_fac);
		
		RespuestaComando respuestaComando;

		if(valorDevuelto == 0){
			respuestaComando = new RespuestaComando(EventoVista.BAJA_FACTURA_EXITO,id_fac); //crea la respuesta de comando
		}
		else if(valorDevuelto == -1){
			respuestaComando = new RespuestaComando(EventoVista.BAJA_FACTURA_NO_EXISTE,id_fac); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.BAJA_FACTURA_FALLO,id_fac); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}
}
