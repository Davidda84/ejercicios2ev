package unidad7;

public class Frigorificos extends Electrodomesticos {
	
	private boolean NoFrost;

	public Frigorificos() {
		super();
		this.NoFrost = false;
	}

	public Frigorificos(float precioBase, String color, String valorEnergetico, float peso, boolean noFrost) {
		super(precioBase, color, valorEnergetico, peso);
		this.NoFrost = noFrost;
	}

	public boolean isNoFrost() {
		return NoFrost;
	}

	public void setNoFrost(boolean noFrost) {
		NoFrost = noFrost;
	}

	@Override
	public String toString() {
		String noFrost;
		if(NoFrost) {
			noFrost = "SI";
		}
		else {
			noFrost = "NO";
		}
		return "Frigorifico [No Frost=" + noFrost + ", " + super.toString() + "]";
	}
	
	

}
