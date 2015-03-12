package factura;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite transportar la información de las facturas
 * @author Daniel
 *
 */
public class TransferFactura {
	
	//id de la factura
	private int id;
	
	//atributos propios de la factura
	private boolean estaPagado;
	
	private String fecha_hora;
	
	private double cutoa;
	
	private boolean enMetalico;
	
	private String numeroCuenta;
	
	//si está activa la habitación o no
	private boolean activo;
	
	//relaciones
	private String dni_residente_propietario_factura;
	
	private List<Integer> numero_habitaciones_facturas;
	
	public TransferFactura(){
		//Crea las lista
		numero_habitaciones_facturas = new ArrayList<Integer>();
		activo = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEstaPagado() {
		return estaPagado;
	}

	public void setEstaPagado(boolean estaPagado) {
		this.estaPagado = estaPagado;
	}

	public String getFecha() {
		return fecha_hora;
	}

	public void setFecha(String fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public double getCutoa() {
		return cutoa;
	}

	public void setCutoa(double cutoa) {
		this.cutoa = cutoa;
	}

	public boolean isEnMetalico() {
		return enMetalico;
	}

	public void setEnMetalico(boolean enMetalico) {
		this.enMetalico = enMetalico;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getDni_residente_propietario_factura() {
		return dni_residente_propietario_factura;
	}

	public void setDni_residente_propietario_factura(
			String dni_residente_propietario_factura) {
		this.dni_residente_propietario_factura = dni_residente_propietario_factura;
	}

	public List<Integer> getNumero_habitaciones_facturas() {
		return numero_habitaciones_facturas;
	}

	public void setNumero_habitaciones_facturas(
			List<Integer> numero_habitaciones_facturas) {
		this.numero_habitaciones_facturas = numero_habitaciones_facturas;
	}
}
