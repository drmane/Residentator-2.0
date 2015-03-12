package comandos_empleados;

import selector_vista.EventoVista;
import servicios.FactoryServicios;
import comando.Comando;
import comando.RespuestaComando;
import empleado.ServicioEmpleado;

public class ComandoBajaEmpleado extends Comando {

	@Override
	public RespuestaComando ejecutar() {
		
		//crea el servicio de empleados, lo crea utilizando una fábrica
				ServicioEmpleado servicioEmpleado = FactoryServicios.obtenerInstancia().generarServicioEmpleado();
				
				boolean correcto = servicioEmpleado.bajaEmpleado((int)datos); //llama al método de baja tareas
				
				RespuestaComando respuestaComando;

				if(correcto){
					respuestaComando = new RespuestaComando(EventoVista.BAJA_EMPLEADO_EXITO,null); //crea la respuesta de comando
				}
				else{
					respuestaComando = new RespuestaComando(EventoVista.BAJA_EMPLEADO_FALLO,null); //crea la respuesta de comando
				}
				
				return respuestaComando;
			}
	}


