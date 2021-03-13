package unidad7;

import java.time.LocalDate;

public abstract class Empleado implements Pago{
	
	private String Nombre;
	private String Apellidos;
	private LocalDate FechaContratacion;
	private String NumeroCuenta;

	public Empleado(String nombre, String apellidos, String cuenta) {
		this.Nombre = nombre;
		this.Apellidos = apellidos;
		this.FechaContratacion = LocalDate.now();
		this.NumeroCuenta = cuenta;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public LocalDate getFechaContratacion() {
		return FechaContratacion;
	}

	public String getNumeroCuenta() {
		return NumeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		NumeroCuenta = numeroCuenta;
	}

	@Override
	public String toString() {
		return Nombre + ", " + Apellidos + ", " + FechaContratacion
				+ ", " + NumeroCuenta + "]";
	}
	
	

}
