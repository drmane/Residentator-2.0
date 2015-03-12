package residente;

/**
 * Clase que permite transportar la información de los residentes estudiantes 
 * @author Daniel
 *
 */
public class TransferResidenteEstudiante extends TransferResidente{

	private String email;

	public TransferResidenteEstudiante(){
		//Constructor de la clase residente estudiante
		super();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
