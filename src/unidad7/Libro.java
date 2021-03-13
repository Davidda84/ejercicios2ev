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
		String prestado;
		if(this.isPrestado()) {
			prestado ="Ha sido prestado";
		}
		else {
			prestado = "Nunca ha sido prestado";
		}
		return "Libro [" + super.toString() + " , " + prestado+"]";
	}
	
	
}
