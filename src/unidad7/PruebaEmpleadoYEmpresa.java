package unidad7;

import java.util.ArrayList;

public class PruebaEmpleadoYEmpresa {
	public static ArrayList <Pago> pagos = new ArrayList <Pago>();
	public static ArrayList <SociedadAnonima> sociedadesAnonimas = new ArrayList <SociedadAnonima>();

	public static void main(String[] args) {
		ArrayList <String> trabajos1 = new ArrayList <String>();
		trabajos1.add("trabajo1");
		trabajos1.add("trabajo2");
		trabajos1.add("trabajo3");
		ArrayList <String> trabajos2 = new ArrayList <String>();
		trabajos1.add("trabajo1");
		trabajos1.add("trabajo3");
		//Polimorfismo Estamos creando Objetos Empresa desde otro objeto
		Empresa empresa1 = new SociedadAnonima ("Nombre SA 1", trabajos1);
		Empresa empresa2 = new SociedadAnonima ("Nombre SA 2", trabajos2);
		Empresa empresa3 = new SociedadAnonima ("Nombre SA 3", trabajos1);
		sociedadesAnonimas.add((SociedadAnonima) empresa1);
		sociedadesAnonimas.add((SociedadAnonima) empresa2);
		sociedadesAnonimas.add((SociedadAnonima) empresa3);
		Empresa empresa4 = new EmpresaServicios ("Nombre 1", "trabajo2", "564879135");
		Empresa empresa5 = new EmpresaServicios ("Nombre 2", "trabajo5", "123456789");
		Empleado empleado1 = new Asalariado("Asalariado 1", "apellido1 apellido2", "67489465132");
		Empleado contratista = new Contratista("Contratista 1", "apellido3 apellido4", "456496846549", sociedadesAnonimas);
		pagos.add((Pago) empresa4);
		pagos.add((Pago) empresa5);
		pagos.add(empleado1);
		pagos.add(contratista);
		
		for(Pago p : pagos) {
			if(p instanceof Asalariado) {
				System.out.println(((Asalariado) p).ingresoNomina(1200));
			}
			else if (p instanceof Contratista){
				System.out.println(((Contratista) p).realizarPago(1500,"trabajos1"));
				System.out.println(((Contratista) p).realizarPago(15000,"trabajo1"));
				System.out.println(((Contratista) p).realizarPago(10000,"trabajo3"));
			}
			else {
				System.out.println(((EmpresaServicios)p).realizarPago(1000, "trabajo1"));
			}
		}
	}

}
