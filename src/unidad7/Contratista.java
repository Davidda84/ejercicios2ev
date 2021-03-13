package unidad7;

import java.util.ArrayList;

public class Contratista extends Empleado {
	
	private ArrayList <SociedadAnonima> Empresa = new ArrayList <SociedadAnonima>();

	public Contratista(String nombre, String apellidos, String cuenta, ArrayList <SociedadAnonima> empresa) {
		super(nombre, apellidos, cuenta);
		this.Empresa = empresa;
	}

	@Override
	public String toString() {
		return "Contratista [" + super.toString() + ", (" + Empresa.toString().replace("[", "").replace("]","") + ")]";
	}

	@Override
	public String realizarPago(double total, String concepto) {
		String mensaje = "Pago de " + total + " a " + super.getApellidos() + ", " 
				+ super.getNombre() + " en  concepto de " 
				+ concepto + " en la cuenta " 
				+ super.getNumeroCuenta();
		for (SociedadAnonima sa: this.Empresa) {
			if(sa.getListaTrabajos().contains(concepto)) {
				mensaje += " en la empresa " + sa.getName();
			}
			else {
				mensaje = "No hay ninguna empresa que realice ese servicio";
			}
		}
		return mensaje;
	}

	@Override
	public String ingresoNomina(double nomina) {
		return null;
	}
	
	

}
