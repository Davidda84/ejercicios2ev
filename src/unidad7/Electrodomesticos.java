package unidad7;

import java.util.Arrays;

public class Electrodomesticos {
	private float PrecioBase;
	private ColorElectrodomestico Color;
	private String ValorEnergetico;
	private String[] valoresEnergeticos = {"A","B","C","D","E","F"};
	private float Peso;
	private int[] porcentajeVE = {30,25,20,15,10,5};
	private int[] porcentajePeso = {20,15,10,5};
	protected float PrecioFinal;

	@Override
	public String toString() {
		return "PrecioBase=" + PrecioBase + "€ , Color=" + Color + ", ValorEnergetico="
				+ ValorEnergetico + ", Peso=" + Peso + "Kg, PrecioFinal=" + PrecioFinal + "€";
	}

	@Override
	public boolean equals(Object color) {
		if (this == color) {
			return true;
		}
		if (color == null) {
			return false;
		}
		if (getClass() != color.getClass()) {
			return false;
		}
		Electrodomesticos other = (Electrodomesticos) color;
		if (Color == null) {
			if (other.Color != null) {
				return false;
			}
		} else if (!Color.equals(other.Color)) {
			return false;
		}
		return true;
	}

	public Electrodomesticos() {
		this.PrecioBase = 100;
		this.Color = ColorElectrodomestico.valueOf("BLANCO");
		this.ValorEnergetico = valoresEnergeticos[Arrays.asList(valoresEnergeticos).indexOf("F")];
		this.Peso = 5;
		this.PrecioFinal = precioTotal(ValorEnergetico,Peso);
	}
	
	public Electrodomesticos(float precioBase, String color, String valorEnergetico, float peso) {
		this.PrecioBase = precioBase;
		try {
			this.Color = ColorElectrodomestico.valueOf(color.toUpperCase());
		}
		catch (IllegalArgumentException e){
			System.out.println("Color del Electrodomestico no valido -> " + color);
			this.Color = null;
		}
		try {
			this.ValorEnergetico = valoresEnergeticos[Arrays.asList(valoresEnergeticos).indexOf(valorEnergetico.toUpperCase())];
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Valor Energetico del Electrodomestico no valido -> " + valorEnergetico);
		}
		this.Peso = peso;
		this.PrecioFinal = precioTotal(ValorEnergetico,Peso);
	}
	
	public float precioTotal (String ve, float peso) {
		float precio;
		int[] porcentajes = new int [2];
		try {
			porcentajes[0] = porcentajeVE[Arrays.asList(valoresEnergeticos).indexOf(ve.toUpperCase())];
		}
		catch(NullPointerException e) {
			System.out.println("Precio Final calculado sin incremento por Valor energetico");
			porcentajes[0] = 0;
		}
		
		if(peso < 20) {
			porcentajes[1] = porcentajePeso[3];
		}
		else if(peso >= 20 && peso < 50) {
			porcentajes[1] = porcentajePeso[2];
		}
		else if(peso >= 50 && peso < 79) {
			porcentajes[1] = porcentajePeso[1];
		}
		else if(peso >= 80) {
			porcentajes[1] = porcentajePeso[0];
		}
		precio = this.PrecioBase + ((this.PrecioBase*porcentajes[0]/100)) + ((this.PrecioBase*porcentajes[1]/100));
		
		return precio;
	}

	public float getPrecioBase() {
		return PrecioBase;
	}

	public void setPrecioBase(float precioBase) {
		PrecioBase = precioBase;
	}

	public ColorElectrodomestico getColor() {
		return Color;
	}

	public void setColor(ColorElectrodomestico color) {
		Color = color;
	}

	public String getValorEnergetico() {
		return ValorEnergetico;
	}

	public void setValorEnergetico(String valorEnergetico) {
		ValorEnergetico = valorEnergetico;
	}

	public String[] getValoresEnergeticos() {
		return valoresEnergeticos;
	}

	public void setValoresEnergeticos(String[] valoresEnergeticos) {
		this.valoresEnergeticos = valoresEnergeticos;
	}

	public float getPeso() {
		return Peso;
	}

	public void setPeso(float peso) {
		Peso = peso;
	}

	public float getPrecioFinal() {
		return PrecioFinal;
	}

	public void setPrecioFinal(float precioFinal) {
		PrecioFinal = precioFinal;
	}

}
