package unidad5;

public class PruebaAutor {

	public static void main(String[] args) {
		Autor yo = new Autor("David Díaz Álavarez", "femenino", "educastur@educastur.es");
		System.out.println(yo.getNombre());
		yo.setNombre("David Díaz Álvarez");
		System.out.println(yo.getEmail());
		yo.setEmail("davidda83@educastur.es");
		System.out.println(yo.getGenero());
		yo.setGenero("masculino");
		System.out.println(yo.toString());
	}
}
