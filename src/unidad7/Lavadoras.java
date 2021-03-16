package unidad7;

import java.util.Arrays;

public class Lavadoras extends Electrodomesticos {
	
	private String[] ValoresCarga = {"4","5","6","7","8","10","11","13"};
	private int Carga;

	public Lavadoras() {
		super();
		this.Carga = Integer.parseInt(ValoresCarga[Arrays.asList(ValoresCarga).indexOf("5")]);
		this.setPrecioFinal(this.Carga);
	}

	public Lavadoras(float precioBase, String color, String valorEnergetico, float peso, String carga) {
		super(precioBase, color, valorEnergetico, peso);
		try {
			this.Carga = Integer.parseInt(ValoresCarga[Arrays.asList(ValoresCarga).indexOf(carga)]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Valor de Carga de Lavadora no valido -> " + carga);
		}
		this.setPrecioFinal(Integer.parseInt(carga));
	}
	
	@Override
	public String toString() {
		return "Lavadora [Carga=" + Carga + ", " + super.toString() + "]";
	}

	public int getCarga() {
		return Carga;
	}

	public void setCarga(int carga) {
		Carga = carga;
	}

	public void setPrecioFinal(int carga) {
		if(carga > 8) {
			PrecioFinal += this.getPrecioBase()*0.1;
		}
	}

}
