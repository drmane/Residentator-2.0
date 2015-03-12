package servicios;

import habitacion.ServicioHabitacion;
import habitacion.ServicioHabitacionImp;
import residente.ServicioResidente;
import residente.ServicioResidenteImp;
import tarea.ServicioTarea;
import tarea.ServicioTareaImp;
import departamento.ServicioDepartamento;
import departamento.ServicioDepartamentoImp;
import empleado.ServicioEmpleado;
import empleado.ServicioEmpleadoImp;
import factura.ServicioFactura;
import factura.ServicioFacturaImp;

public class FactoryServiciosImp extends FactoryServicios{

	@Override
	public ServicioEmpleado generarServicioEmpleado() {
		//crea el servicio de empleado, pequeña dependencia de la implementacion del servicio empleado
		return new ServicioEmpleadoImp();
	}

	@Override
	public ServicioDepartamento generarServicioDepartamento() {
		return new ServicioDepartamentoImp();
	}

	@Override
	public ServicioTarea generarServicioTarea() {
		return new ServicioTareaImp();
	}

	@Override
	public ServicioHabitacion generarServicioHabitacion() {
		return new ServicioHabitacionImp();
	}

	@Override
	public ServicioResidente generarServicioResidente() {
		return new ServicioResidenteImp();
	}

	@Override
	public ServicioFactura generarServicioFactura() {
		return new ServicioFacturaImp();
	}
}
