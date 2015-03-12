package comandos_departamentos;

import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

import departamento.ServicioDepartamento;

public class ComandoBajaDepartamento extends Comando {

	@Override
	public RespuestaComando ejecutar() {

		//crea el servicio de departamentos, lo crea utilizando una fábrica
		ServicioDepartamento servicioDepartamento = FactoryServicios.obtenerInstancia().generarServicioDepartamento();
		
		boolean correcto = servicioDepartamento.bajaDepartamento((int)datos); //llama al método de baja departamentos
		
		RespuestaComando respuestaComando;

		if(correcto){
			respuestaComando = new RespuestaComando(EventoVista.BAJA_DEPARTAMENTO_EXITO,null); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.BAJA_DEPARTAMENTO_FALLO,null); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}
}
