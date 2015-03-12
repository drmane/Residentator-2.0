package residente;

/**
 * Clase que permite transportar la información de los residentes no estudiantes 
 * @author Daniel
 *
 */
public class TransferResidenteNoEstudiante extends TransferResidente{

	private int telefono;
	
	private String domicilio;

	public TransferResidenteNoEstudiante(){
		//Constructor de la clase residente no estudiante
		super();
	}
	
	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
}
