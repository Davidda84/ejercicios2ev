package unidad6;

public class Pokemon {
	private String Nombre;
	private Elemento Elemento;
	private int Salud;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
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

	public Pokemon(String nombre, Elemento elemento, int salud) {
		this.Nombre = nombre;
		this.Elemento = elemento;
		this.Salud= salud;		
	}

	public Elemento getElemento() {
		return Elemento;
	}

	public int getSalud() {
		return Salud;
	}

	public void setSalud() {
		Salud = Salud - 10;
	}
}