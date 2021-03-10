package unidad6;

import java.util.ArrayList;
import java.util.Scanner;

public class PruebaMascota {

	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

	public static void main(String[] args) throws ExcepcionesMascota {
		String respuesta = teclado.nextLine();
		while (!respuesta.equalsIgnoreCase("salir")) {
			Juego(respuesta);
			respuesta = teclado.nextLine();
		}
	}

	private static void Juego(String respuesta) throws ExcepcionesMascota {
		String[] arrayEntrada = respuesta.split(" ");
		if (Existe(arrayEntrada[1])) {
			if (!arrayEntrada[0].equalsIgnoreCase("crear")) {
				if (arrayEntrada[0].equalsIgnoreCase("comer")) {
					Busca(arrayEntrada[1]).come();
				}
				switch (arrayEntrada[0]) {
				case "comer":
					System.out.println("size = " + mascotas.size());
					Busca(arrayEntrada[1]).come();
					break;

				case "ejercicio":
					Busca(arrayEntrada[1]).ejercicio();
					break;

				case "dormir":
					Busca(arrayEntrada[1]).duerme();
					break;

				case "curar":
					Busca(arrayEntrada[1]).curacion();
					break;
				}
				AnimoMuerte(Busca(arrayEntrada[1]));
			} else {
				System.out.println("Ya existe una mascota con ese nombre");
			}
		} else {
			if (!arrayEntrada[0].equalsIgnoreCase("crear")) {
				System.out.println("No existe una mascota con ese nombre");
			} else {
				Mascota creaMascota = new Mascota(arrayEntrada[1]);
				mascotas.add(creaMascota);
			}
		}
	}

	private static boolean Existe(String nombre) {
		for (Mascota m : mascotas) {
			if (m.getNombre().equalsIgnoreCase(nombre)) {
				return true;
			}
		}
		return false;
	}

	private static Mascota Busca(String nombre) {
		for (Mascota m : mascotas) {
			if (m.getNombre().equalsIgnoreCase(nombre)) {
				return m;
			}
		}
		return null;
	}

	public static void AnimoMuerte(Mascota m) {
		if (m.getEstadoAnimo().equalsIgnoreCase("Alegria")) {
			System.out.println("Ronroneo :D");
		} else if (m.getEstadoAnimo().equalsIgnoreCase("Apatia")) {
			System.out.println("Gemido :|");
		} else if (m.getEstadoAnimo().equalsIgnoreCase("Malestar")) {
			System.out.println("Quejido :(");
		}

		if (m.getSalud() > 55 || m.getSalud() < 0) {
			mascotas.remove(m);
			System.out.println("Lamentamos comunicarle que " + m.getNombre() + " ha fallecido :(:(:(:(");
		}
	}

}
