package unidad6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Torneo {
	public static ArrayList<Entrenador> entrenadoresTorneo = new ArrayList<Entrenador>();
	public static Scanner teclado = new Scanner(System.in);
	public static ArrayList<Pokemon> pokemonMuertos = new ArrayList<Pokemon>();

	public static void main(String[] args) throws IOException {
		String entrada = teclado.next();
		while (!entrada.equalsIgnoreCase("torneo")) {
			try {
				Entrenador aspirante = new Entrenador(entrada);
				if (entrenadoresTorneo.contains(aspirante)) {
					entrenadoresTorneo.get(entrenadoresTorneo.indexOf(aspirante)).addPokemon(AnadirPokemon());
				} else {
					entrenadoresTorneo.add(aspirante);
					aspirante.addPokemon(AnadirPokemon());
				}
			} catch (InputMismatchException e) {
				señalarError(teclado);
			} catch (NoSuchElementException e) {
				System.out.println("Datos insuficientes, introdúcelos de nuevo");
			}
			entrada = teclado.next();
		}
		entrada = teclado.next();
		while (!entrada.equalsIgnoreCase("fin")) {
			Elemento elmentoJuego = Elemento.valueOf(entrada.toUpperCase());
			for (Entrenador e : entrenadoresTorneo) {
				boolean tieneElemento = false;
				for (Pokemon p : e.getColeccion()) {
					if (CompruebaElemento(elmentoJuego, p)) {
						tieneElemento = true;
					}
				}
				if (tieneElemento) {
					e.setInsignias();
				} else {
					for (Pokemon p : e.getColeccion()) {
						p.setSalud();
						if (p.getSalud() <= 0) {
							pokemonMuertos.add(p);
						}
					}
				}
				for (Pokemon pr : pokemonMuertos) {
					e.deletePokemon(pr);
				}
			}
			entrada = teclado.next();
		}
		for (Entrenador e : entrenadoresTorneo) {
			System.out.println(e.toString());
		}
	}

	public static Pokemon AnadirPokemon() throws IOException {
		Pokemon poke = null;
		try {
			String nombrePokemon = teclado.next();
			String strElemento = teclado.next().toUpperCase();
			Elemento elmentoPokemon = Elemento.valueOf(strElemento);
			poke = new Pokemon(nombrePokemon, elmentoPokemon, teclado.nextInt());
		} catch (InputMismatchException e) {
			señalarError(teclado);
		} catch (NoSuchElementException e) {
			System.out.println("Datos insuficientes, introdúcelos de nuevo");
		}
		return poke;

	}

	static void señalarError(Scanner teclado) {
		String error = teclado.next();
		int i = teclado.match().start();
		String formato = String.format("%%%ds\n'" + error + "' no es correcto, introduce los datos de nuevo\n", i + 1);
		System.out.printf(formato, "^");
	}

	public static boolean CompruebaElemento(Elemento elementoJuego, Pokemon poke) {
		if (poke.getElemento() == elementoJuego) {
			return true;
		} else {
			return false;
		}
	}
}