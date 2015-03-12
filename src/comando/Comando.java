package comando;

/**
 * Clase abstracta que indica los metodos de los comandos
 * @author Daniel
 *
 */
public abstract class Comando {

	protected Object datos;
	
	/**
	 * Ejecuta el comando
	 * @return devuelve la respuesta del comando tras su ejecucion
	 */
	public abstract RespuestaComando ejecutar();
	
	/**
	 * Permite cambiar los datos del comando
	 * @param datos los datos del comando
	 */
	public void setDatos(Object datos){
		this.datos = datos;
	}
	
	/**
	 * Permite obtener los datos del comando
	 * @return
	 */
	public Object getDatos(){
		return this.datos;
	}
}
