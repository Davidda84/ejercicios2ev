package unidad5;

import java.util.ArrayList;
import java.util.List;

public class PruebaLibro {

	public static void main(String[] args) {
		Autor yo = new Autor("David Díaz Álvarez", "masculino", "davidda83@educastur.es");
		Autor tu = new Autor("David Álvarez", "masculino", "davidda83@educastur.es");
		List<Autor> la1 = new ArrayList<Autor>();
		List<Autor> la2 = new ArrayList<Autor>();
		la1.add(yo);
		Libro libro1 = new Libro("El Libro",la1,19);
		la2.add(yo);
		la2.add(tu);
		Libro libro2 = new Libro("El Libro",la2,9,10);
		System.out.println(libro1.toString());
		System.out.println(libro1.getTitulo());
		System.out.println(libro1.getAutores());
		System.out.println(libro1.getPrecio());
		libro1.setPrecio(20);
		System.out.println(libro1.getStock());
		libro1.setStock(2);
		System.out.println(libro2.toString());
		System.out.println(libro2.getTitulo());
		System.out.println(libro2.getAutores());
		System.out.println(libro2.getPrecio());
		libro2.setPrecio(18);
		System.out.println(libro2.getStock());
		libro2.setStock(20);
		System.out.println(libro1.toString());
		System.out.println(libro2.toString());

	}

}
