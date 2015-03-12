package comandos_facturas;

import java.util.List;

import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

import factura.TransferFactura;

public class ComandoMostrarFacturas extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		
		List<TransferFactura> lista_facturas = FactoryServicios.obtenerInstancia().generarServicioFactura().mostrarFacturas();
		
		RespuestaComando respuestaComando;

		if(lista_facturas.size() > 0){
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_FACTURAS_EXITO,lista_facturas); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_FACTURAS_FALLO,lista_facturas); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}

}
