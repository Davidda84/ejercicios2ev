package unidad7;

public abstract class Empresa {
	
	private String Name;

	public Empresa(String nombre) {
		this.Name = nombre;
	}

	public String getName() {
		return Name;
	}

	@Override
	public String toString() {
		return Name;
	}
	
	

}
