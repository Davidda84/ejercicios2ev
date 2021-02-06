package unidad5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PruebaNaipeMazo {

	public static void main(String[] args) {
		System.out.println("Bienvenido a Fournier's App");
		List<Mazo> barajas = new ArrayList<Mazo>();
		List<Naipe> cartas = new ArrayList<Naipe>();
		int menu;
		int opcion1;
		Mazo baraja;
		int n;
		int opcion2;
		Naipe carta;
		int opcion;
		int marcadorJugador = 0;
		int marcadorMaquina = 0;
		int jugadas;
		String resultado;
		String repetir;
		Mazo mazoJuego;
		do {
			do {
		
			menu = MenuPrincipal();
			if (menu < 1 || menu > 6){
				System.out.println("Escoja entre las opciones disponibles");		
			}
		}
		while ( menu < 1 || menu > 6);
			switch (menu) {
			case 1:
				do {
					opcion1=Opcion1();
					if (opcion1 < 1 || opcion1 > 2){
						System.out.println("Escoja entre las opciones disponibles");		
					}
				}
				while (opcion1 < 1 || opcion1 > 2);
					switch (opcion1) {					
					case 1:
						baraja = new Mazo();
						barajas.add(baraja);
						break;
					case 2:
						do {
							n = NumeroBarajas();
							if (n < 2) {
								System.out.println("Por favor ingres un número mayor de 2");
							}
						}
						while(n < 2); 
						baraja = new Mazo(n);
						barajas.add(baraja);
						break;
					}
				break;
				
			case 2:
				do {
					opcion2 = Opcion2();
					if (opcion2 < 1 || opcion2 > 2){
						System.out.println("Escoja entre las opciones disponibles");		
					}
				}
					while (opcion2 < 1 || opcion2 > 2); 
					switch (opcion2) {					
					case 1:
						carta = new Naipe();
						cartas.add(carta);
						break;
					case 2:
						carta = CrearNaipe();
						cartas.add(carta);
						break;
					}					
				break;
				
			case 3:
				if(barajas.size() < 2) {
					System.out.println("Primero debe crear mas de una baraja");
				}
				else {
					System.out.println("Se han fusionado dos barajas");
					System.out.println(Mazo.addMazo(barajas.get(0),barajas.get(1)));
					
				}
				break;
				
			case 4:
				if(cartas.size() < 1 && barajas.size() < 1) {
					if(cartas.size() < 1) {
						System.out.println("Primero debe crear una carta");
					}
					if(barajas.size() < 1) {
						System.out.println("Primero debe crear una baraja");
					}
				}
				else {
					System.out.println(Mazo.addNaipes(barajas.get(0),cartas.get(0)));
				}
				break;
				
			case 5:
				
					System.out.println("Jugemos a la carta mas alta");
					System.out.println("¿Con cuantos mazos quieres jugar?");
					n = Integer.parseInt(tecladoST());
					if (n < 2) {
						mazoJuego = new Mazo();
					} else {
						mazoJuego = new Mazo(n);
					}
					System.out.println("¿Como deseas jugar retirando: \r\n" + "1. Retirando las cartas del mazo \r\n"
							+ "2. Volviendo a meter los naipes en el mazo");
					opcion = Integer.parseInt(tecladoST());
					switch (opcion) {

					case 1:
						System.out.println("Numero de jugadas: \r\n" + "1. Determinado \r\n" + "2. Hasta acabar el mazo \r\n"
								+ "3. Hasta que el jugador no quiera seguir jugando \r\n");
						opcion = Integer.parseInt(tecladoST());
						switch (opcion) {

						case 1:
							System.out.println("¿Cuantas jugadas quieres realizar?");
							jugadas = Integer.parseInt(tecladoST());
							System.out.println("De acuerdo jugaremos al mejor de " + jugadas);
							do {
								resultado = juegoRetirando(mazoJuego);
								if (resultado.equals("jugador")) {
									System.out.println("Tu carta es mayor que la mia, has ganado");
									marcadorJugador++;
								} else if (resultado.equals("empate")) {
									System.out.println("Nuestra carta tienen el mismo valor");
								} else {
									System.out.println("Mejor suerte la proxima vez, mi carta es la mas alta");
									marcadorMaquina++;
								}
								System.out.println("El resultado es Jugador " + marcadorJugador + " - Yo " + marcadorMaquina);
								System.out.println("¿Seguimos? (S/N)");
								repetir = tecladoST();
							} while (marcadorJugador != (jugadas / 2) + 1 && marcadorMaquina != (jugadas / 2) + 1
									&& repetir.equals("S") && mazoJuego.size() != 0); {
							System.out.println("Se ha acabado el juego");
							if (marcadorJugador > marcadorMaquina) {
								System.out.println("Enhorabuena por tu victoria Jugador \r\n" + "Jugador " + marcadorJugador
										+ " - Yo " + marcadorMaquina);
							} else if (marcadorJugador == marcadorMaquina) {
								System.out.println("Gran partida, cuando quieras podemos desempatar\r\n" + "Jugador "
										+ marcadorJugador + " - Yo " + marcadorMaquina);
							} else {
								System.out.println("El ser humano jamas podrá superar a un maquina\r\n" + "Jugador "
										+ marcadorJugador + " - Yo " + marcadorMaquina);
							}
						}
							break;
						case 2:
							jugadas = mazoJuego.size() / 2;
							System.out.println("De acuerdo jugaremos al mejor de " + jugadas);
							do {
								resultado = juegoRetirando(mazoJuego);
								if (resultado.equals("jugador")) {
									System.out.println("Tu carta es mayor que la mia, has ganado");
									marcadorJugador++;
								} else if (resultado.equals("empate")) {
									System.out.println("Nuestra carta tienen el mismo valor");
								} else {
									System.out.println("Mejor suerte la proxima vez, mi carta es la mas alta");
									marcadorMaquina++;
								}
								System.out.println("El resultado es Jugador " + marcadorJugador + " - Yo " + marcadorMaquina);
								System.out.println("¿Seguimos? (S/N)");
								repetir = tecladoST();
							} while (marcadorJugador != (jugadas / 2) + 1 && marcadorMaquina != (jugadas / 2) + 1
									&& repetir.equals("S") && mazoJuego.size() != 0); {
							System.out.println("Se ha acabado el juego");
							if (marcadorJugador > marcadorMaquina) {
								System.out.println("Enhorabuena por tu victoria Jugador \r\n" + "Jugador " + marcadorJugador
										+ " - Yo " + marcadorMaquina);
							} else if (marcadorJugador == marcadorMaquina) {
								System.out.println("Gran partida, cuando quieras podemos desempatar\r\n" + "Jugador "
										+ marcadorJugador + " - Yo " + marcadorMaquina);
							} else {
								System.out.println("El ser humano jamas podrá superar a un maquina\r\n" + "Jugador "
										+ marcadorJugador + " - Yo " + marcadorMaquina);
							}
						}
							break;
						case 3:
							System.out.println("De acuerdo jugaremos hasta que te aburras");
							do {
								if (mazoJuego.size() == 0) {
									mazoJuego = new Mazo();
								}
								resultado = juegoRetirando(mazoJuego);
								if (resultado.equals("jugador")) {
									System.out.println("Tu carta es mayor que la mia, has ganado");
									marcadorJugador++;
								} else if (resultado.equals("empate")) {
									System.out.println("Nuestra carta tienen el mismo valor");
								} else {
									System.out.println("Mejor suerte la proxima vez, mi carta es la mas alta");
									marcadorMaquina++;
								}
								System.out.println("El resultado es Jugador " + marcadorJugador + " - Yo " + marcadorMaquina);
								System.out.println("¿Seguimos? (S/N)");
								repetir = tecladoST();
							} while (repetir.equals("S"));
							break;
						}
						break;
					case 2:
						System.out.println("¿Como deseas jugar retirando: \r\n" + "1. Determinado \r\n"
								+ "2. Hasta que el jugador no quiera seguir jugando \r\n");
						opcion = Integer.parseInt(tecladoST());
						switch (opcion) {

						case 1:
							System.out.println("¿Cuantas jugadas quieres realizar?");
							jugadas = Integer.parseInt(tecladoST());
							System.out.println("De acuerdo jugaremos al mejor de " + jugadas);
							do {
								resultado = juego(mazoJuego);
								if (resultado.equals("jugador")) {
									System.out.println("Tu carta es mayor que la mia, has ganado");
									marcadorJugador++;
								} else if (resultado.equals("empate")) {
									System.out.println("Nuestra carta tienen el mismo valor");
								} else {
									System.out.println("Mejor suerte la proxima vez, mi carta es la mas alta");
									marcadorMaquina++;
								}
								System.out.println("El resultado es Jugador " + marcadorJugador + " - Yo " + marcadorMaquina);
								System.out.println("¿Seguimos? (S/N)");
								repetir = tecladoST();
							} while (marcadorJugador == (jugadas / 2) + 1 || marcadorMaquina == (jugadas / 2) + 1
									|| repetir.equals("S"));
							break;
						case 2:
							System.out.println("De acuerdo jugaremos hasta que te aburras");
							do {
								resultado = juego(mazoJuego);
								if (resultado.equals("jugador")) {
									System.out.println("Tu carta es mayor que la mia, has ganado");
									marcadorJugador++;
								} else if (resultado.equals("empate")) {
									System.out.println("Nuestra carta tienen el mismo valor");
								} else {
									System.out.println("Mejor suerte la proxima vez, mi carta es la mas alta");
									marcadorMaquina++;
								}
								System.out.println("El resultado es Jugador " + marcadorJugador + " - Yo " + marcadorMaquina);
								System.out.println("¿Seguimos? (S/N)");
								repetir = tecladoST();
							} while (repetir.equals("S"));
							break;
						}
						break;
					}
				break;
			case 6:
				System.out.println("Hasta la proxima");
				break;
			}
		}
		while(menu != 6);
		}
	
	public static int MenuPrincipal() {
			System.out.println("Menu principal"
					+ "\r\n 1. Crear una baraja"
					+ "\r\n 2. Crear una carta"
					+ "\r\n 3. Fusionar barajas"
					+ "\r\n 4. Añadir una carta a una baraja"
					+ "\r\n 5. Jugar a la carta mas alta"
					+ "\r\n 6. Salir");
			int op = Integer.parseInt(tecladoST());
			return op;
	}
	
	public static int Opcion1() {
			System.out.println("Vamos a crear tu baraja"
					+ "\r\n Elige entre estas opciones:"
					+ "\r\n 1. Baraja inglesa de 52 naipes"
					+ "\r\n 2. Baraja inglesa compuesta de la combinación del numero de barajas de 52 naipes que elijas");
			int op1 = Integer.parseInt(tecladoST());
			return op1;
	}
	
	public static int Opcion2() {
			System.out.println("Vamos a crear tu Carta"
					+ "\r\n Elige entre estas opciones:"
					+ "\r\n 1. Carta de baraja inglesa aleatoria"
					+ "\r\n 2. Carta de baraja inglesa definida por ti");
			int op2 = Integer.parseInt(tecladoST());
			return op2;
	}
	
	public static Naipe CrearNaipe() {
			System.out.print("Primero dime ");
			String palo;
			String valor;
			do {
				System.out.println("el palo (tréboles, diamantes, corazones o picas)");
				palo = tecladoST();
				if (!palo.equalsIgnoreCase("tréboles") || !palo.equalsIgnoreCase("diamantes") || !palo.equalsIgnoreCase("corazones") || !palo.equalsIgnoreCase("picas")) {
					System.out.print("Por favor, elija entre las opciones disponibles \r\n"
							+ "Dime ");
				}
			}
			while (!palo.equalsIgnoreCase("tréboles") || !palo.equalsIgnoreCase("diamantes") || !palo.equalsIgnoreCase("corazones") || !palo.equalsIgnoreCase("picas"));
			System.out.print("Ahora dime ");
			do {
				System.out.println("el valor (2 - 10, Jack, Queen, King, Ace)");
				valor = tecladoST();
				if (!valor.equalsIgnoreCase("Jack") || !valor.equalsIgnoreCase("Queen") || !valor.equalsIgnoreCase("King") || !valor.equalsIgnoreCase("Ace") || Integer.parseInt(valor) < 2 || Integer.parseInt(valor) > 10) {
					System.out.print("Por favor, elija entre las opciones disponibles \r\n"
							+ "Dime ");
				}
			}
			while (!valor.equalsIgnoreCase("Jack") || !valor.equalsIgnoreCase("Queen") || !valor.equalsIgnoreCase("King") || !valor.equalsIgnoreCase("Ace") || Integer.parseInt(valor) < 2 || Integer.parseInt(valor) > 10);
			Naipe naipe = new Naipe(valor,palo);
			return naipe;
	}
	
	public static int NumeroBarajas(){
			System.out.println("¿Cuantas barajas quieres combinar? (>2");
			int op = Integer.parseInt(tecladoST());
			return op;
	}
	
	public static String juegoRetirando(Mazo mazoJuego) {
		Naipe jugador = mazoJuego.removeNaipes();
		System.out.println("Tu carta es el " + jugador.getNaipe());
		Naipe maquina = mazoJuego.removeNaipes();
		System.out.println("Mi carta es el " + maquina.getNaipe());
		String resultado = mazoJuego.mayorOMenor(jugador, maquina);

		return resultado;
	}

	public static String juego(Mazo mazoJuego) {
		Naipe jugador = mazoJuego.getNaipes();
		System.out.println("Tu carta es el " + jugador.getNaipe());
		Naipe maquina = mazoJuego.getNaipes();
		System.out.println("Mi carta es el " + maquina.getNaipe());
		String resultado = mazoJuego.mayorOMenor(jugador, maquina);

		return resultado;
	}
	
	public static String tecladoST () {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
			String st = teclado.next();
			teclado.nextLine();
			return st;
	}
	
	public static int tecladoINT () {
		try (Scanner teclado = new Scanner(System.in)) {
			int in = teclado.nextInt();
			teclado.nextLine();
			return in;
		}
	}
}
