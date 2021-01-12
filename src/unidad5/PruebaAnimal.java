package unidad5;

import java.time.LocalDate;

public class PruebaAnimal {

	public static void main(String[] args) {
		Animal gato = new Animal ("gato");
		Animal perro = new Animal ("perro",LocalDate.parse("2018-10-30"));
		System.out.println(gato);
		System.out.println(perro);
		gato.setNombre("Liebre");
		System.out.println(gato);
	}

}
