package unidad7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import unidad5.Mazo;
import unidad5.Naipe;

public class Blackjack {

	public static Mano juego;
	public static ArrayList<Mano> jugadores = new ArrayList<Mano>();
	public static Mano crupier;
	public static Scanner teclado = new Scanner(System.in);
	public static boolean manoEnCurso = false;
	public static boolean JuegoIniciado = false;
	public static int[] jugadorturno;
	public static int turno;
	public static String[] estadoJugadores;

	public static void main(String[] args) {

		System.out.println("Blackjack>");
		String entrada = teclado.next();

		while (!entrada.equalsIgnoreCase("fin")) {
			switch (entrada) {
			case "repartir":
				JuegoIniciado = true;
				if (manoEnCurso == false) {
					manoEnCurso = true;
					juego = new Mano(6);
					crupier = new Mano(0);
					System.out.println("Numero de jugadores");
					System.out.println("Blackjack>");

					int njugadores = Integer.parseInt(teclado.next());
					jugadorturno = new int[njugadores];

					for (int i = 0; i < njugadores; i++) {
						jugadorturno[i] = i + 1;
						Mano jugador = new Mano(0);
						jugadores.add(jugador);
					}

					estadoJugadores = new String[njugadores];

					for (int l = 0; l < 2; l++) {
						int njugador = 0;
						for (Mano m : jugadores) {
							njugador++;
							Naipe naipe = juego.removeNaipes();
							System.out.println("Jugador " + njugador + " tiene " + naipe.getNaipe());
							Mazo.addNaipes(m, naipe);
						}
						Naipe naipeCrupier = juego.removeNaipes();
						if (l == 0) {
							System.out.println("El Cuprier tiene " + naipeCrupier.getNaipe());
						}
						Mazo.addNaipes(crupier, naipeCrupier);
					}
					turno = 0;
				} else {
					System.out.println("No se puede repartir. Mano en Curso");
				}

				break;

			case "pedir":
				if (estadoJugadores[turno] == null) {
					System.out.println("Jugador " + jugadorturno[turno] + " tiene " + Pedir("j"));
				} else {
					System.out.println(
							"El Jugador " + jugadorturno[turno] + " no puede pedir cartas porque se ha plantado");
				}

				if ((turno + 1) == jugadorturno.length) {
					turno = 0;
				} else {
					turno++;
				}
				break;

			case "plantarse":
				estadoJugadores[turno] = "Se planta";
				if ((turno + 1) == jugadorturno.length) {
					turno = 0;
				} else {
					turno++;
				}
				if (!Arrays.asList(estadoJugadores).contains(null)) {
					System.out.println("No va mas");
					manoEnCurso = false;
					int valorCrupier = JuegoCrupier();
					int n = 1;
					if (valorCrupier > 21) {
						System.out.println("El Crupier se ha pasado");
					} else {
						for (Mano manos : jugadores) {
							int valorjugada = manos.getValor();
							if (valorjugada > 21) {
								System.out.println("El Jugador " + n + " ha perdido");
								n++;
							} else if (manos.getValor() > valorCrupier) {
								System.out.println("El Jugador " + n + " ha ganado");
								n++;
							} else {
								System.out.println("El Jugador " + n + " ha perdido");
								n++;
							}
						}
					}
				}
				break;
			}

			if (JuegoIniciado == true) {
				if (manoEnCurso == true) {
					if (estadoJugadores[turno] != null) {
						if ((turno + 1) == jugadorturno.length) {
							turno = 0;
						} else {
							turno++;
						}
					}
					System.out.println("Tiene el turno el Jugador " + jugadorturno[turno]);
					System.out
							.println("El Jugador " + jugadorturno[turno] + " tiene " + jugadores.get(turno).getValor());
				} else {
					System.out.println("Ha finalizado la Mano, iniciar de nuevo o salir");
				}
			}
			else {
				System.out.println("Aun no se ha iniciado el juego");
			}
				System.out.println("Blackjack>");
				entrada = teclado.next();

		}

	}

	public static int JuegoCrupier() {
		for (Naipe n : crupier.getMano()) {
			System.out.println("El Crupier tiene " + n.getNaipe());
		}
		System.out.println("Su jugada vale " + crupier.getValor());

		while (crupier.getValor() < 17) {
			System.out.println("Crupier pide carta");
			System.out.println("El Crupier tiene " + Pedir("c"));
			System.out.println("Su jugada vale " + crupier.getValor());
		}
		return crupier.getValor();
	}

	public static String Pedir(String tipo) {
		Naipe naipePedido = juego.removeNaipes();
		if (tipo.equalsIgnoreCase("j")) {
			Mazo.addNaipes(jugadores.get(turno), naipePedido);
			if(jugadores.get(turno).getValor() > 21) {
				System.out.println("Jugador " + (turno+1) +" se ha pasado");
				estadoJugadores[turno] = "Se planta";
			}
		} else {
			Mazo.addNaipes(crupier, naipePedido);
		}
		return naipePedido.getNaipe();
	}
}
