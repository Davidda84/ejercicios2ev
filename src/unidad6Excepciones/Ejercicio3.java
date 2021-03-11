package unidad6Excepciones;

import java.util.Scanner;

public class Ejercicio3 {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		double a = 0;
		double b = 0;
		String entrada = "";
		while (!entrada.equalsIgnoreCase("F")) {
			System.out.println("> ");
			entrada = teclado.nextLine();
			String[] param = entrada.split(" ");
			switch (param[0].toUpperCase()) {
			case "A":
				if (Ejercicio1.isDouble(param[1])) {
					a = Double.parseDouble(param[1]);
				} else {
					System.out.println("Debe introducir un número");
				}
				break;

			case "B":
				if (Ejercicio1.isDouble(param[1])) {
					b = Double.parseDouble(param[1]);
				} else {
					System.out.println("Debe introducir un número");
				}
				break;

			case "C":
				if (a == 0 || b == 0) {
					System.out.println("Comprueba que la longuitud de los catetos sea correcta a = " + a + " b = " + b);
				} else {
					System.out.println("El resultado de la hipotenusa es " + hipotenusa(a, b));
				}
				a = 0;
				b = 0;
				break;

			case "F":
				System.out.println("Fin");
				break;

			default:
				System.out.println("No ha insertado una opción valida");
				break;
			}
		}
	}

	public static double hipotenusa(double a, double b) {
		double c = Math.sqrt((a * a) + (b * b));
		return c;
	}

}
