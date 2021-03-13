package unidad7;

import java.util.ArrayList;

public class Biblioteca {
	
	private static ArrayList<Publicacion> biblioteca = new ArrayList<Publicacion>();

	public static void main(String[] args) {
		Publicacion lib = new Libro("Nombre Libro", 2021, "Autor yo");
		biblioteca.add(lib);
		Publicacion rev = new Revista ("Nombre Revista", 2021, 01, "Marzo", 01);
		biblioteca.add(rev);
		Publicacion lib2 = new Libro("Nombre Libro2", 2021, "Autor tu");
		biblioteca.add(lib2);
		Publicacion rev2 = new Revista ("Nombre Revista2", 2021, 10, "Marzo", 02);
		biblioteca.add(rev2);
		((Prestamo) lib2).setPrestado();
		 for(Publicacion p : biblioteca) {
			 System.out.println(p.toString());
		 }

	}

}