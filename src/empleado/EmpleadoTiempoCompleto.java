package empleado;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import tarea.Tarea;
import departamento.Departamento;


@Entity
public class EmpleadoTiempoCompleto extends Empleado {

	
	EmpleadoTiempoCompleto(){
		
	}// constructor por defecto necesario para el mapeado que realiza jpa
	
	public EmpleadoTiempoCompleto(String dni, String nombre_apellidos,
			double salario, String nombreDepartamento,String contrato) {
		
		super(dni, nombre_apellidos, salario, nombreDepartamento);
		this.codigoDeContrato=contrato;
	
	}

	private String codigoDeContrato;

	public String getCodigoDeContrato() {
		return codigoDeContrato;
	}

	public void setCodigoDeContrato(String codigoDeContrato) {
		this.codigoDeContrato = codigoDeContrato;
	}	
}
