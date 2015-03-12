package departamento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import empleado.Empleado;

/**
 * Objeto de negocio que simula un departamento
 * @author Daniel
 *
 */
@Entity
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	@Version
	int version;

	@Column(name="ACTIVO")
	private boolean activo;
	
	@OneToMany(mappedBy = "departamento" )
	
	private List<Empleado> lista_empleados; // lado 1 de la relación
	
	/**
	 * Constructor por defecto del departamento
	 */
	public Departamento(){
		lista_empleados = new ArrayList<Empleado>();
		
		activo = true;
	}
	
	/**
	 * Constructor de Departamento
	 * @param nombre_departamento el nombre del departamento
	 */
	public Departamento(String nombre_departamento){
		
		this.nombre = nombre_departamento;
		lista_empleados = new ArrayList<Empleado>();
		
		activo = true;
	}
	
	public void addEmpleado(Empleado e)
	{
		this.lista_empleados.add(e);
		if(e.getDepartamento() != this){
			e.setDepartamento(this);
		}
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

	public List<Empleado> getLista_empleados() {
		return lista_empleados;
	}

	public void setLista_empleados(List<Empleado> lista_empleados) {
		this.lista_empleados = lista_empleados;
	}

	public String toString() {
		return "ID " + getId() + "Nombre " + getNombre();
	}

}
