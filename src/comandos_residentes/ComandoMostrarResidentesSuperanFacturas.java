package comandos_residentes;

import java.util.List;

import residente.TransferResidente;
import selector_vista.EventoVista;
import servicios.FactoryServicios;
import comando.Comando;
import comando.RespuestaComando;

public class ComandoMostrarResidentesSuperanFacturas extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		List<TransferResidente> lista_residentes = FactoryServicios.obtenerInstancia().generarServicioResidente().mostrarResidentesSuperanFacturas();
		
		RespuestaComando respuestaComando;

		if(lista_residentes.size() > 0){
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_RESIDENTES_SUPERAN_FACTURAS_EXITO,lista_residentes); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_RESIDENTES_SUPERAN_FACTURAS_FALLO,lista_residentes); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}
}
