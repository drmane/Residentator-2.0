package residente;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite transportar la información de los residentes 
 * @author Daniel
 *
 */
public class TransferResidente {
	
	//id del residente
	private int id;
	
	//atributos propios del residente
	
	private String dni;
	
	private String nombre;
	
	private String apellidos;
	
	// M masculino, F femenino
	private char sexo;
	
	//si está activo el residente o no
	private boolean activo;
	
	//relaciones
	private int num_hab;
	
	private List<Integer> id_facturas_residentes;
	
	public TransferResidente(){
		
		//Crea la lista
		id_facturas_residentes = new ArrayList<Integer>();
		
		activo = true; //Se crea estando activo
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getNum_hab() {
		return num_hab;
	}

	public void setNum_hab(int num_hab) {
		this.num_hab = num_hab;
	}

	public List<Integer> getId_facturas_residentes() {
		return id_facturas_residentes;
	}

	public void setId_facturas_residentes(List<Integer> id_facturas_residentes) {
		this.id_facturas_residentes = id_facturas_residentes;
	}
}
