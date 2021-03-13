package unidad7;

import java.util.ArrayList;

public class SociedadAnonima extends Empresa{
	
	private ArrayList <String> listaTrabajos = new ArrayList<String>();

	public SociedadAnonima(String nombre, ArrayList <String> trabajos) {
		super(nombre);
		this.listaTrabajos = trabajos;
	}

	public ArrayList<String> getListaTrabajos() {
		return listaTrabajos;
	}

	public void addTrabajo(String trabajo) {
		this.listaTrabajos.add(trabajo);
	}

	public void setListaTrabajos(ArrayList<String> listaTrabajos) {
		this.listaTrabajos.addAll(listaTrabajos);
	}

	@Override
	public String toString() {
		return "SociedadAnonima [" + super.toString() + ", (" + listaTrabajos.toString().replace("[", "").replace("]","") + ")]";
	}

}
