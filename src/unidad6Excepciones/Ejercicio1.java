package unidad6Excepciones;

import java.util.Scanner;

public class Ejercicio1 {
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main (String[] args) {
		String n = teclado.next();
		if(isInt(n)) {
			System.out.println("Ha introducido un numero");
		}
		if(isDouble(n)) {
			System.out.println("Ha introducido un numero con decimales");
		}
		else {
			System.out.println("No ha introducido un numero");
		}

	}
	
	public static Boolean isInt(String n) {
		int numInt;
		try {
			numInt = Integer.parseInt(n);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}
	
	public static Boolean isDouble(String n) {
		Double numDouble;
		try {
			numDouble = Double.parseDouble(n);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}

}
