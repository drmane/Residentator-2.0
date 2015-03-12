package comandos_departamentos;

import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

import departamento.Departamento;
import departamento.ServicioDepartamento;

public class ComandoMostrarDepartamento extends Comando {

	@Override
	public RespuestaComando ejecutar() {
		//crea el servicio de departamentos, lo crea utilizando una fábrica
		ServicioDepartamento servicioDepartamento = FactoryServicios.obtenerInstancia().generarServicioDepartamento();
		
		Departamento departamento = servicioDepartamento.buscarDepartamento((int)datos);
		
		RespuestaComando respuestaComando;

		if(departamento != null){
			respuestaComando = new RespuestaComando(EventoVista.MOSTAR_DEPARTAMENTO_EXITO,departamento); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.MOSTAR_DEPARTAMENTO_FALLO,departamento); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}

}
