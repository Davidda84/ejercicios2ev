package unidad5;

import java.util.ArrayList;
import java.util.Scanner;

public class Torneo {
	public static ArrayList<Entrenador> entrenadoresTorneo = new ArrayList<Entrenador>();
	public static ArrayList<Pokemon> pokemonMuertos = new ArrayList<Pokemon>();

	public static void main(String[] args) {
		System.out.println("Bienvenido al torneo Pokemon");

		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		String lineaEntrada = teclado.nextLine();

		while (!lineaEntrada.equalsIgnoreCase("torneo")) {
			String[] arrayEntrada = lineaEntrada.split(" ");
			Entrenador aspirante = new Entrenador(arrayEntrada[0]);

			if (entrenadoresTorneo.contains(aspirante)) {
				entrenadoresTorneo.get(entrenadoresTorneo.indexOf(aspirante))
						.addPokemon(new Pokemon(arrayEntrada[1], arrayEntrada[2], Integer.parseInt(arrayEntrada[3])));
			} else {
				entrenadoresTorneo.add(aspirante);
				aspirante.addPokemon(new Pokemon(arrayEntrada[1], arrayEntrada[2], Integer.parseInt(arrayEntrada[3])));
			}
			lineaEntrada = teclado.nextLine();
		}

		lineaEntrada = teclado.nextLine();

		while (!lineaEntrada.equalsIgnoreCase("fin")) {

			for (Entrenador e : entrenadoresTorneo) {
				boolean tieneElemento = false;
				for (Pokemon p : e.getColeccion()) {
					if(lineaEntrada.equalsIgnoreCase(p.getElemento())) {
						tieneElemento = true;
					}
				}
				if (tieneElemento) {
					e.setInsignias();
				}
				else {
					for (Pokemon p : e.getColeccion()) {
						p.setSalud();
						if(p.getSalud() <= 0) {
							pokemonMuertos.add(p);
						}
					}
				}
				for(Pokemon pr : pokemonMuertos) {
					e.deletePokemon(pr);
				}
			}
			lineaEntrada = teclado.nextLine();
		}
		
		for (Entrenador e : entrenadoresTorneo) {
			System.out.println(e.toString());
		}

	}
}
