package unidad7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import unidad5.Naipe;

public class Blackjack {

	public static ArrayList<ArrayList<Naipe>> jugadores = new ArrayList<ArrayList<Naipe>>();
	public static ArrayList<Naipe> crupier = new ArrayList<Naipe>();
	public static Scanner teclado = new Scanner(System.in);
	public static boolean manoEnCurso = false;
	public static int[] jugadorturno;
	public static int turno;
	public static Mano juego;
	public static String[] estadoJugadores;

	public static void main(String[] args) {

		System.out.println("Blackjack>");
		String entrada = teclado.next();

		while (!entrada.equalsIgnoreCase("fin")) {
			switch (entrada) {
			case "repartir":
				if (manoEnCurso == false) {
					manoEnCurso = true;
					System.out.println("Numero de jugadores");
					System.out.println("Blackjack>");
					int njugadores = Integer.parseInt(teclado.next());
					jugadorturno = new int[njugadores];
					for (int i = 0; i < jugadorturno.length; i++) {
						jugadorturno[i] = i + 1;
						ArrayList<Naipe> jugador = new ArrayList<Naipe>();
						jugadores.add(jugador);
					}
					estadoJugadores = new String[njugadores];
					juego = new Mano(6);
					for (int l = 0; l < 2; l++) {
						int jugador = 0;
						for (ArrayList<Naipe> j : jugadores) {
							jugador++;
							Naipe naipe = juego.removeNaipes();
							System.out.println("Jugador " + jugador + " tiene " + naipe.getNaipe());
							j.add(naipe);
						}
						Naipe naipeCrupier = juego.removeNaipes();
						if (l == 0) {
							System.out.println("El Cuprier tiene " + naipeCrupier.getNaipe());
						}
						crupier.add(naipeCrupier);
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
					if(valorCrupier > 21) {
						System.out.println("El Crupier se ha pasado");
					}
					else {
						for(ArrayList <Naipe> naipes : jugadores) {
							int valorjugada = getValor(naipes);
							if(valorjugada > 21) {
								System.out.println("El Jugador " + n + " ha perdido");
								n++;
							}
							else if(getValor(naipes) > valorCrupier) {
								System.out.println("El Jugador " + n + " ha ganado");
								n++;
							}
							else {
								System.out.println("El Jugador " + n + " ha perdido");
								n++;
							}
						}
					}
				}
				break;
			}
			
			if(manoEnCurso == true) {
				if (estadoJugadores[turno] != null) {
					if ((turno + 1) == jugadorturno.length) {
						turno = 0;
					} else {
						turno++;
					}
				}
				System.out.println("Tiene el turno el Jugador " + jugadorturno[turno]);
				System.out.println("El Jugador " + jugadorturno[turno] + " tiene " + getValor(jugadores.get(turno)));
			}
			else {
				System.out.println("Ha finalizado la Mano");
			}
			System.out.println("Blackjack>");
			entrada = teclado.next();
		}

	}

	public static int getValor(ArrayList<Naipe> mano) {
		int valorMano = 0;
		boolean haveAce = false;
		for (Naipe n : mano) {
			int valorNaipe = n.getValor();
			if (valorNaipe > 10 && valorNaipe < 14) {
				valorMano += 10;
			} else if (valorNaipe == 14) {
				valorNaipe = 11;
				haveAce = true;
				if ((valorMano + valorNaipe) > 21) {
					valorMano++;
				} else {
					valorMano += valorNaipe;
				}
			} else {
				valorMano += valorNaipe;
			}
		}
		if (valorMano > 21 && haveAce) {
			valorMano -= 10;
		}
		return valorMano;
	}
	
	public static int JuegoCrupier() {		
		for (Naipe n : crupier) {
			System.out.println("El Crupier tiene " + n.getNaipe());
		}
		System.out.println("Su jugada vale " + getValor(crupier));
		
		while(getValor(crupier) < 17) {
			System.out.println("Crupier pide carta");
			System.out.println("El Crupier tiene " + Pedir("c"));
			System.out.println("Su jugada vale " + getValor(crupier));
		}
		return getValor(crupier);
	}
	
	public static String Pedir(String tipo) {
		Naipe naipePedido = juego.removeNaipes();
		if(tipo.equalsIgnoreCase("j")) {
			jugadores.get(turno).add(naipePedido);
		}
		else {
			crupier.add(naipePedido);
		}		
		return naipePedido.getNaipe();
	}
}
