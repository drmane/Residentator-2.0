package dao;

import factura.DAOFactura;
import factura.DAOFacturaImp;
import habitacion.DAOHabitacion;
import habitacion.DAOHabitacionImp;
import residente.DAOResidente;
import residente.DAOResidenteImp;

public class FactoryDAOImp extends FactoryDAO {

	@Override
	public DAOHabitacion generarDAOHabitacion() {
		return new DAOHabitacionImp();
	}

	@Override
	public DAOResidente generarDAOResidente() {
		return new DAOResidenteImp();
	}

	@Override
	public DAOFactura generarDAOFactura() {
		return new DAOFacturaImp();
	}
}
