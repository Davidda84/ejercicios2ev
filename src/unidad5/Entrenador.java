package unidad5;

import java.util.ArrayList;

public class Entrenador {
	private String Nombre;
	private int Insignias;
	private ArrayList<Pokemon> Coleccion;
	
	public Entrenador(String nombre) {
		this.Nombre = nombre;
		this.Insignias = 0;
		this.Coleccion = new ArrayList<Pokemon>();
	}
	
	public int getInsignias() {
		return Insignias;
	}
	public void setInsignias() {
		Insignias ++;
	}
	public ArrayList<Pokemon> getColeccion() {
		return Coleccion;
	}
	public void addPokemon(Pokemon pokemon) {
		Coleccion.add(pokemon);
	}
	public void deletePokemon(Pokemon pokemon) {
		Coleccion.remove(pokemon);
	}	
	public String getNombre() {
		return Nombre;
	}

	@Override
	public String toString() {
		return Nombre + " " + Insignias + " " +  Coleccion.size();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrenador other = (Entrenador) obj;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}
}
