package comandos_departamentos;

import java.util.Collection;

import selector_vista.EventoVista;
import servicios.FactoryServicios;

import comando.Comando;
import comando.RespuestaComando;

import departamento.Departamento;
import departamento.ServicioDepartamento;

public class ComandoMostrarDepartamentos extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		//crea el servicio de departamentos, lo crea utilizando una fábrica
		ServicioDepartamento servicioDepartamento = FactoryServicios.obtenerInstancia().generarServicioDepartamento();
		
		Collection<Departamento> lista_departamentos = servicioDepartamento.buscarTodosDepartamentos();
		
		RespuestaComando respuestaComando;

		if(lista_departamentos != null){
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_DEPARTAMENTOS_EXITO,lista_departamentos); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_DEPARTAMENTOS_FALLO,lista_departamentos); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}

}
