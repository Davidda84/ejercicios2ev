package unidad7;

public class EmpresaServicios extends Empresa implements Pago {

	private String Servicio;
	private String NumCuenta;

	public EmpresaServicios(String nombre, String servicio, String cuenta) {
		super(nombre);
		this.Servicio = servicio;
		this.NumCuenta = cuenta;
	}

	public String getServicio() {
		return Servicio;
	}

	public String getNumCuenta() {
		return NumCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		NumCuenta = numCuenta;
	}

	@Override
	public String toString() {
		return "EmpresaServicios [" + super.toString() + ", " + Servicio + ", " + NumCuenta + "]";
	}

	@Override
	public String realizarPago(double total, String concepto) {
		String mensaje = "Pago de " + total + " a " + super.getName() 
				+ " en concepto de " + concepto 
				+ " en la cuenta " + this.NumCuenta;
		return mensaje;
	}

	@Override
	public String ingresoNomina(double nomina) {
		return null;
	}

}
