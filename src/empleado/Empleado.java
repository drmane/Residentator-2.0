package empleado;




import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import tarea.Tarea;
import departamento.Departamento;

/**
 * Objeto de negocio que simula un empleado
 * @author Daniel
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // se genera automaticamente
	
	private String dni;
	private String nombre_apellidos;
	private double salario;
	
	@Version
	int version; //para la concurrencia

	@Column(name="ACTIVO")
	private boolean activo; // para realizar el borrado logico de la entidad


	
	@ManyToOne
	 private Departamento departamento; // estamos en el lado n para esta
	
	// relacion
	@ManyToMany
	private Collection<Tarea> lista_tareas;

	public Empleado() {
		departamento = new Departamento();
		
		lista_tareas = new ArrayList<Tarea>();
		
		activo = true;
	} // constructor por defecto necesario para el mapeado que realiza jpa
	
	/**
	 * Constructor de empleado
	 * @param dni el dni del empleado
	 * @param nombre_apellidos el nombre y apellidos del empleado
	 * @param salario el salario del empleado
	 */
	public Empleado(String dni, String nombre_apellidos, double salario,String nombreDepartamento){
		this.dni = dni;
		this.nombre_apellidos = nombre_apellidos;
		this.salario = salario;
		
		departamento = new Departamento();
		departamento.setNombre(nombreDepartamento);
		
		lista_tareas = new ArrayList<Tarea>();
		
		activo = true;
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

	public String getNombre_apellidos() {
		return nombre_apellidos;
	}

	public void setNombre_apellidos(String nombre_apellidos) {

		this.nombre_apellidos = nombre_apellidos;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
		if(!departamento.getLista_empleados().contains(this)){
			departamento.getLista_empleados().add(this);
		}
	}

	public Collection<Tarea> getLista_tareas() {
		return lista_tareas;
	}

	public void setLista_tareas(List<Tarea> lista_tareas) {
		this.lista_tareas = lista_tareas;
	}

	public String toString() {

		return "ID Empleado " + getId() + "Nombre " + getNombre_apellidos()
				+ "Salario " + getSalario() + "Departamento "
				+ getDepartamento().toString() + "Tareas "
				+ lista_tareas.toString();
	}

}
