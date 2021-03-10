package unidad6;

import java.util.ArrayList;

public class EntrenadorV2 {
	private String Nombre;
	private int Insignia;
	private ArrayList<PokemonV2> Coleccion;
	
	public EntrenadorV2(String nombre) {
		this.Nombre = nombre;
		this.Insignia = 0;
		this.Coleccion = new ArrayList<PokemonV2>();
	}
	
	public int getInsignias() {
		return Insignia;
	}
	public void setInsignias() {
		Insignia ++;
	}
	public ArrayList<PokemonV2> getColeccion() {
		return Coleccion;
	}
	public void addPokemon(PokemonV2 pokemon) {
		Coleccion.add(pokemon);
	}
	public void deletePokemon(PokemonV2 pokemon) {
		Coleccion.remove(pokemon);
	}	
	public String getNombre() {
		return Nombre;
	}

	@Override
	public String toString() {
		return Nombre + " " + Insignia + " " +  Coleccion.size();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntrenadorV2 other = (EntrenadorV2) obj;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}
}