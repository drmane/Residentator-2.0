package controlador;

import selector_vista.SelectorVista;

import comando.Comando;
import comando.FactoryComando;
import comando.RespuestaComando;


public class ControladorAplicacionImp extends ControladorAplicacion {
	
	@Override
	public void accion(int id_evento, Object datos) {
		
		Comando comando = FactoryComando.obtenerInstancia().producirComando(id_evento, datos);
		comando.setDatos(datos); //le da los datos al comando
		RespuestaComando respuesta = comando.ejecutar(); //lo ejecuta
		SelectorVista.obtenerInstancia().redirigirVista(respuesta.getId_evento_vista(), respuesta.getDatos()); 
		//redirige la vista en funcion de la respuesta
	}
}
