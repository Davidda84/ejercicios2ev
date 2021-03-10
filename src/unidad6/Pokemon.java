package unidad6;

public class Pokemon {
	private String Nombre;
	private Elemento elemento;
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
		if (elemento == null) {
			if (other.elemento != null)
				return false;
		} else if (!elemento.equals(other.elemento))
			return false;
		return true;
	}

	public String getNombre() {
		return Nombre;
	}

	public Pokemon(String nombre, Elemento elemento, int salud) {
		this.Nombre = nombre;
		this.elemento = elemento;
		this.Salud= salud;		
	}

	public Elemento getElemento() {
		return elemento;
	}

	public int getSalud() {
		return Salud;
	}

	public void setSalud() {
		Salud = Salud - 10;
	}
}