package unidad7;

import java.util.Arrays;

public class Televisores extends Electrodomesticos {

	private int Tamano;
	private String Tipo;
	private String[] Tipos = { "DVB-T", "DVB-T2" };

	public Televisores() {
		super();
		this.Tamano = 20;
		this.Tipo = Tipos[Arrays.asList(Tipos).indexOf("DVB-T")];
	}

	public Televisores(float precioBase, String color, String valorEnergetico, float peso, int tamano, String tipo) {
		super(precioBase, color, valorEnergetico, peso);
		try {
			this.Tamano = tamano;
			this.Tipo = Tipos[Arrays.asList(Tipos).indexOf(tipo)];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Tipo de sintonizador de TV no valido -> " + tipo);
		}
	}

	@Override
	public String toString() {
		return "Televisores [Tamano=" + Tamano + ", Tipo=" + Tipo + ", " + super.toString() + "]";
	}

	public int getTamano() {
		return Tamano;
	}

	public void setTamano(int tamano) {
		Tamano = tamano;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

}
