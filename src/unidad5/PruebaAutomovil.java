package unidad5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PruebaAutomovil {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		int n = Integer.parseInt(teclado.nextLine());
		List<Automovil> garaje = new ArrayList<Automovil>();
		System.out.println("--------------------------------");
		for (int i = 0; i < n; i++) {
			String[] auto = teclado.nextLine().split(" ");
			Automovil automovil = new Automovil(auto[0], Float.parseFloat(auto[1]), Float.parseFloat(auto[2]),
					Float.parseFloat(auto[3]));
			garaje.add(automovil);
		}
		String des = desplazar(garaje, teclado.nextLine());
		while (!des.equalsIgnoreCase("fin")) {
			des = desplazar(garaje, teclado.nextLine());
		}
		System.out.println("--------------------------------");
		for (Automovil a : garaje) {
			System.out.println(a.getModelo() + " " + a.nivel() + " " + a.getKm() + " " + a.getConsumoTotal());
		}
	}

	public static String desplazar(List<Automovil> garaje, String entrada) {
		String[] entradaArray = entrada.split(" ");
		if (entradaArray[0].equalsIgnoreCase("desplazar")) {
			String modelo = entradaArray[1];
			float km = Float.parseFloat(entradaArray[2]);
			for (Automovil a : garaje) {
				if (a.getModelo().equalsIgnoreCase(modelo)) {
					float d = a.recorrido(km);
					if (d == 0) {
						System.out.println("Combustible insuficiente para este desplazamiento");
					} else {
						System.out.println(a.getModelo() + " " + a.nivel() + " " + d);
					}
				}
			}
		}
		return entradaArray[0];
	}
}
