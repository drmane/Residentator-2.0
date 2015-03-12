package comandos_empleados;

import selector_vista.EventoVista;
import servicios.FactoryServicios;
import comando.Comando;
import comando.RespuestaComando;

import empleado.Empleado;
import empleado.ServicioEmpleado;

public class ComandoMostrarEmpleado extends Comando{

	@Override
	public RespuestaComando ejecutar() {
		
		
		
		
	ServicioEmpleado servicioEmpleado = FactoryServicios.obtenerInstancia().generarServicioEmpleado();
		
	Empleado empleado = servicioEmpleado.buscarEmpleado((int)datos);
		
		RespuestaComando respuestaComando;

		if(empleado != null){
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_EMPLEADO_EXITO,empleado); //crea la respuesta de comando
		}
		else{
			respuestaComando = new RespuestaComando(EventoVista.MOSTRAR_EMPLEADO_FALLO,empleado); //crea la respuesta de comando
		}
		
		return respuestaComando;
	}

}
