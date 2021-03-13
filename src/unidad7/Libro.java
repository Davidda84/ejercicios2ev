package unidad7;

public class Libro extends Prestamo {

	private String Autor;
	
	public Libro(String nombre, int ano, String autor) {
		super(nombre, ano);
		this.Autor = autor;
	}

	public String getAutor() {
		return Autor;
	}

	public String toString() {
		return "Libro [" + super.toString() + "]";
	}
	
	
}
