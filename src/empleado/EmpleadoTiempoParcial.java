
package empleado;


	
	import javax.persistence.Entity;


	@Entity
	public class EmpleadoTiempoParcial  extends Empleado{


		EmpleadoTiempoParcial(){
			
		}// constructor por defecto necesario para el mapeado que realiza jpa
		
		
		
		private String correroElectronico;

		public EmpleadoTiempoParcial(String dni, String nombre_apellidos,
				double salario, String nombreDepartamento,String correo) {
			super(dni, nombre_apellidos, salario, nombreDepartamento);
			this.correroElectronico=correo;
			
		}

		public String getCorreroElectronico() {
			return correroElectronico;
		}

		public void setCorreroElectronico(String correroElectronico) {
			this.correroElectronico = correroElectronico;
		}


}
