package comandos_departamentos;

import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

import departamento.Departamento;
import departamento.ServicioDepartamento;

public class ComandoNuevoDepartamento extends Comando {

	@Override
	public RespuestaComando ejecutar() {
		
		int id;
		
		//crea el servicio de departamentos, lo crea utilizando una fábrica
		ServicioDepartamento servicioDepartamento = FactoryServicios.obtenerInstancia().generarServicioDepartamento();
		
		Departamento departamento = (Departamento)datos; //hacemos casting de los datos del comando
		
		id = servicioDepartamento.crearDepartamento(departamento);
		
		RespuestaComando respuestaComando;

		if(id >= 0){
			respuestaComando = new RespuestaComando(EventoVista.NUEVO_DEPARTAMENTO_EXITO,id); //crea la respuesta de comando
		}
		else if(id == -1){
			respuestaComando = new RespuestaComando(EventoVista.NUEVO_DEPARTAMENTO_NOMBRE_EXISTE,id); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.NUEVO_DEPARTAMENTO_FALLO,id); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}
}

