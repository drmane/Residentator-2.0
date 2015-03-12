package tarea;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import empleado.Empleado;

/**
 * Objeto de negocio que simula una tarea
 * @author Daniel
 *
 */
@Entity
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;
	private String descripcion;

	@ManyToMany(mappedBy = "lista_tareas")
	private List<Empleado> lista_empleados;
	
	@Version
	int version;

	@Column(name="ACTIVO")
	private boolean activo;
	
	public Tarea(){
		lista_empleados = new ArrayList<Empleado>();
		
		activo = true;
	}

	public Tarea(String nombre, String descripcion){
		this.nombre=nombre;
		this.descripcion = descripcion;
		
		lista_empleados = new ArrayList<Empleado>();
	
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Empleado> getLista_empleados() {
		return lista_empleados;
	}

	public void setLista_empleados(List<Empleado> lista_empleados) {
		this.lista_empleados = lista_empleados;
	
		
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString() {
		return "ID " + getId() + "Nombre " + getNombre()+
				"Descripcion" +getDescripcion();
	}
}
