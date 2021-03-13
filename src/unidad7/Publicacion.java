package unidad7;

public abstract class Publicacion {
	
	private static int numPublicacion = 0;
	private int Codigo;
	private String Nombre;
	private int Ano;
	
	public Publicacion(String nombre, int ano) {
		super();
		
		Codigo = ++numPublicacion;
		Nombre = nombre;
		Ano = ano;
	}
	
	public int getCodigo() {
		return Codigo;
	}
	
	public String getNombre() {
		return Nombre;
	}

	public int getAno() {
		return Ano;
	}

	public String toString() {
		return Codigo + ", " + Nombre + ", " + Ano;
	}

}
