package comandos_empleados;

import selector_vista.EventoVista;
import servicios.FactoryServicios;
import comando.Comando;
import comando.RespuestaComando;
import empleado.Empleado;
import empleado.ServicioEmpleado;

public class ComandoNuevoEmpleado extends Comando {

		@Override
		public RespuestaComando ejecutar() {
			int id;
			
			//crea el servicio de empleados, lo crea utilizando una fábrica
			ServicioEmpleado servicioEmpleado = FactoryServicios.obtenerInstancia().generarServicioEmpleado();
			
			Empleado empleado = (Empleado)datos; //hacemos casting de los datos del comando
			
			id = servicioEmpleado.crearEmpleado(empleado);
			
			RespuestaComando respuestaComando;
	
			if(id >= 0){
				respuestaComando = new RespuestaComando(EventoVista.NUEVO_EMPLEADO_EXITO,id); //crea la respuesta de comando
			}
			else if(id == -1){
				respuestaComando = new RespuestaComando(EventoVista.NUEVO_EMPLEADO_DEPARTAMENTO_NO_EXISTE,id); //crea la respuesta de comando
			}
			else{
				respuestaComando = new RespuestaComando(EventoVista.NUEVO_EMPLEADO_FALLO,id); //crea la respuesta de comando
			}
			
			return respuestaComando;
		}
	}


