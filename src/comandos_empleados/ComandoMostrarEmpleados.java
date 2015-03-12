package comandos_empleados;

import java.util.Collection;

import selector_vista.EventoVista;
import servicios.FactoryServicios;
import comando.Comando;
import comando.RespuestaComando;
import empleado.Empleado;
import empleado.ServicioEmpleado;

public class ComandoMostrarEmpleados extends Comando {

	@Override
	public RespuestaComando ejecutar() {
	
		ServicioEmpleado servicioEmpleado = FactoryServicios.obtenerInstancia().generarServicioEmpleado();
	
		Collection<Empleado> lista_empleados = servicioEmpleado.buscarTodosEmpleados();
		
		RespuestaComando respuestaComando;

		if(lista_empleados != null){
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_EMPLEADOS_EXITO,lista_empleados); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_EMPLEADOS_FALLO,lista_empleados); //crea la respuesta de comando
		}
		
		return respuestaComando;
	
	}
	

}
