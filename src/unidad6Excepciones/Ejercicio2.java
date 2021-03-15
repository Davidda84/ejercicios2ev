package unidad6Excepciones;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
	public static Scanner teclado = new Scanner(System.in);

	public static void main (String[] args) {
				
		//System.out.println("La solución es " + Arrays.toString(ec2(2, 3, 1)));
		System.out.println("La solución es " + Arrays.toString(ec2(0, 3, 1)));
		//System.out.println("La solución es " + Arrays.toString(ec2(3, 2, 1)));
		
	}

	public static double [] ec2 (double a, double b, double c) {
		double [] respuesta = new double[2];
		if (a == 0) {
			try{
				System.out.println("No es una ecuación de segundo grado porque");
				throw new Coeficiente0("No es una ecuación de segundo grado porque");
			}
			catch(Coeficiente0 e){
				System.out.println("Hola");
			}
			//throw new IllegalArgumentException();
		}

		double contenidoRaiz = b * b - 4 * a * c;
		
		if(contenidoRaiz < 0) {
			System.out.println("La ecuación no tiene una solución real");
			throw new ArithmeticException();
		}
		
		double raiz = Math.sqrt(contenidoRaiz);
		respuesta[0] = (-b + raiz)/(2*a);
		respuesta[1] = (-b - raiz)/(2*a);
		
		return respuesta;
	}

}
