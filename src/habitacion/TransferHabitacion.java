package habitacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite transportar la informaci�n de las habitaciones
 * @author Daniel
 *
 */
public class TransferHabitacion {
	
	//id de la habitaci�n
	private int id;
	
	//atributos propios de la habitaci�n
	private int numero_hab;
	
	private int capacidad;
	
	private int numero_ocupantes;
	
	//si est� activa la habitaci�n o no
	private boolean activo;
	
	//relaciones
	private List<String> dni_residentes_ocupantes;
	
	private List<Integer> id_facturas_habitaci�n;

	public TransferHabitacion(){
		
		//Crea las listas
		dni_residentes_ocupantes = new ArrayList<String>();
		id_facturas_habitaci�n = new ArrayList<Integer>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero_hab() {
		return numero_hab;
	}

	public void setNumero_hab(int numero_hab) {
		this.numero_hab = numero_hab;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getNumero_ocupantes() {
		return numero_ocupantes;
	}

	public void setNumero_ocupantes(int numero_ocupantes) {
		this.numero_ocupantes = numero_ocupantes;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<String> getDni_residentes_ocupantes() {
		return dni_residentes_ocupantes;
	}

	public void setDni_residentes_ocupantes(List<String> dni_residentes_ocupantes) {
		this.dni_residentes_ocupantes = dni_residentes_ocupantes;
	}

	public List<Integer> getId_facturas_habitaci�n() {
		return id_facturas_habitaci�n;
	}

	public void setId_facturas_habitaci�n(List<Integer> id_facturas_habitaci�n) {
		this.id_facturas_habitaci�n = id_facturas_habitaci�n;
	}
	
	/**
	 * Permite saber si la habitaci�n est� llena o no
	 * @return si la habitaci�n est� llena o no
	 */
	public boolean estaLlena(){
		return capacidad == numero_ocupantes;
	}
}
