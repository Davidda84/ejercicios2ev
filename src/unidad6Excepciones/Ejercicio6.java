package unidad6Excepciones;

import java.io.FileInputStream;
import java.util.Scanner;

public class Ejercicio6 {
	Ejercicio6 e = new Ejercicio6();

	public static void main(String[] args) throws NumberFormatException, Exception {
		Scanner in = new Scanner(System.in);
		String opcion;

		while (!(opcion = in.next()).equalsIgnoreCase("fin")) {
			try {
				lanzarExcepcion(Integer.parseInt(opcion));
			} catch (RuntimeException e) {
				System.out.println("It's UnChecked");
			} catch (Exception e) {
				System.out.println("It's Checked");
			} catch (Error e) {
				System.out.println("Error");
			}
		}
		in.close();

	}

	static void lanzarExcepcion(int opcion) throws Exception {
		switch (opcion) {
		case 1:
			System.out.println(1 / 0);
			break;
		case 2:
			int[] a = new int[10];
			a[a.length] = a.length;
			break;
		case 3:
			FileInputStream in = new FileInputStream("este fichero no existe");
			break;
		case 4:
			Object o = null;
			System.out.println(o.toString());
			break;
		case 5:
			Ejercicio6 e = new Ejercicio6();
			break;
		default:
			Class.forName("UnaClase");
		}
	}
}