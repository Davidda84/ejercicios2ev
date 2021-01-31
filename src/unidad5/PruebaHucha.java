package unidad5;

public class PruebaHucha {

	public static void main(String[] args) {
		Hucha personal = new Hucha ("Hucha Personal", "cerrada", "12345Ab@");
		Hucha trabajo = new Hucha ("Hucha Trabajo", "abierta", "9874Ab@5", 1,2,3,4,5,6);
		Hucha casa = new Hucha ("Hucha Casa", "abierta", "9564Ab@5", 1388);
		System.out.println(personal.getInfo());
		System.out.println(trabajo.getInfo());
		System.out.println(casa.getInfo());
		if(casa.setOpenClose("9564Ab@5") == "ERROR") {
			System.out.println("Ha introduccido su contraseña erroneamente");
		}
		else {
			System.out.println("La hucha está " + casa.setOpenClose("9564Ab@5"));
		}
		;
		System.out.println(casa.ingresoTotal("9564Ab@5", 1388));
		int [] dineroingreso = {2,5,1,0,0,1};
		System.out.println(trabajo.ingresoUnico("9874Ab@5", dineroingreso));
		System.out.println(casa.retiradaTotal("9564Ab@5", 138));
		System.out.println(casa.ingresoTotal("9564Ab@5", 138));
		int [] dineroretirada = {55,0,0,3,0,1};
		System.out.println(casa.retiradaUnica("9564Ab@5", dineroretirada));
	}

}
