package habitacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite transportar la información de las habitaciones
 * @author Daniel
 *
 */
public class TransferHabitacion {
	
	//id de la habitación
	private int id;
	
	//atributos propios de la habitación
	private int numero_hab;
	
	private int capacidad;
	
	private int numero_ocupantes;
	
	//si está activa la habitación o no
	private boolean activo;
	
	//relaciones
	private List<String> dni_residentes_ocupantes;
	
	private List<Integer> id_facturas_habitación;

	public TransferHabitacion(){
		
		//Crea las listas
		dni_residentes_ocupantes = new ArrayList<String>();
		id_facturas_habitación = new ArrayList<Integer>();
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

	public List<Integer> getId_facturas_habitación() {
		return id_facturas_habitación;
	}

	public void setId_facturas_habitación(List<Integer> id_facturas_habitación) {
		this.id_facturas_habitación = id_facturas_habitación;
	}
	
	/**
	 * Permite saber si la habitación está llena o no
	 * @return si la habitación está llena o no
	 */
	public boolean estaLlena(){
		return capacidad == numero_ocupantes;
	}
}
