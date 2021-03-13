package unidad7;

public abstract class Prestamo extends Publicacion {
	
	private boolean prestado;

	public Prestamo(String nombre, int ano) {
		super(nombre, ano);
		this.prestado = false;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado() {
		this.prestado = true;
	}
}
