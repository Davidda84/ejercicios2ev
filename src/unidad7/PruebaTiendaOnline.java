package unidad7;

public class PruebaTiendaOnline {

	public static void main(String[] args) {
		Electrodomesticos tv1 = new Televisores();
		System.out.println(tv1.toString());
		Electrodomesticos tv2 = new Televisores(1000, "Azul", "A", 50, 55, "DVB-T2");
		System.out.println(tv2.toString());
		Electrodomesticos f1 = new Frigorificos();
		System.out.println(f1.toString());
		Electrodomesticos f2 = new Frigorificos(1000, "Azul", "A", 50,true);
		System.out.println(f2.toString());
		Electrodomesticos l1 = new Lavadoras();
		System.out.println(l1.toString());
		Electrodomesticos l2 = new Lavadoras(1000, "Azul", "A", 50,"10");
		System.out.println(l2.toString());

	}

}
