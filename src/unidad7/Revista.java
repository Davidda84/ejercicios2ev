package unidad7;

public class Revista extends Publicacion {
	
	private int Numero;
	private String Mes;
	private int Dia;

	public Revista(String nombre, int ano, int numero, String mes, int dia) {
		super(nombre, ano);
		this.Numero = numero;
		this.Mes = mes;
		this.Dia = dia;		
	}

	public int getNumero() {
		return Numero;
	}

	public String getMes() {
		return Mes;
	}

	public int getDia() {
		return Dia;
	}

	@Override
	public String toString() {
		return "Revista [" + super.toString() + "]";
	}
	
	

}
