package unidad6;

public class PokemonV2 {
	private String Nombre;
	private ElementoPokemon Elemento;
	private int Salud;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokemonV2 other = (PokemonV2) obj;
		if (Elemento == null) {
			if (other.Elemento != null)
				return false;
		} else if (!Elemento.equals(other.Elemento))
			return false;
		return true;
	}

	public String getNombre() {
		return Nombre;
	}

	public PokemonV2(String nombre, ElementoPokemon elemento, int salud) {
		this.Nombre = nombre;
		this.Elemento = elemento;
		this.Salud= salud;		
	}

	public ElementoPokemon getElemento() {
		return Elemento;
	}

	public int getSalud() {
		return Salud;
	}

	public void setSalud() {
		Salud = Salud - 10;
	}
}