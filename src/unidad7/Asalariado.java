package unidad7;

public class Asalariado extends Empleado {

	public Asalariado(String nombre, String apellidos, String cuenta) {
		super(nombre, apellidos, cuenta);
	}

	@Override
	public String toString() {
		return "Asalariado [" + super.toString() + "]";
	}

	@Override
	public String ingresoNomina(double total) {
		String mensaje = "Pago de " + total + " a " + super.getApellidos() + ", " 
				+ super.getNombre() + " en  concepto de Nomina " 
				+ " en la cuenta " + super.getNumeroCuenta();
		return mensaje;
	}

	@Override
	public String realizarPago(double total, String concepto) {
		return null;
	}}
