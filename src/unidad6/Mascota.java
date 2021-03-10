package unidad6;

import java.util.Random;

public class Mascota {

	private String Nombre;
	private int Salud;
	private boolean Enfermedad;
	private String EstadoAnimo;
	
	public Mascota(String nombre) {
		Nombre = nombre;
		Salud = 20;
		Enfermedad = false;
		EstadoAnimo = "Alegria";
	}
	
	public void come() {
		Random n = new Random();
		int mal = n.nextInt(10)+1;
		if(Enfermedad) {
			if (Salud > 50) {
				Salud = Salud + 1;
			}
			else {
				Salud = Salud - 1;
			}
			this.evaluarSalud();
		}
		else {
			if(mal == 1||mal == 2|| mal == 3) {
				Salud = 10;
				Enfermedad = true;
				EstadoAnimo = "Malestar";
			}
			else {
				Salud = Salud + 5;
				this.evaluarSalud();
			}
		}
	}
	
	public void duerme() {
		if(Enfermedad) {
			Salud = Salud - 1;
		}
		else {
			Salud = Salud + 2;
		}
		this.evaluarSalud();
	}
	
	public void ejercicio() {
		if(Enfermedad) {
			Salud = Salud - 1;
		}
		else {
			Salud = Salud - 3;
		}
		this.evaluarSalud();
	}
	
	public void curacion() {
		if (Enfermedad) {
			Salud = 20;
			Enfermedad = false;
			EstadoAnimo = "Alegria";
		}
	}
	
	public void evaluarSalud() {
		if(Salud > 50 || Salud < 5) {
			Enfermedad = true;
			EstadoAnimo = "Malestar";
		}
		else if(!Enfermedad && (Salud < 48 || Salud > 7)) {
			EstadoAnimo = "Alegria";
		}
		//else if(!Enfermedad && (Salud >= 48 && Salud <= 50 || Salud <= 7 && Salud >= 5)) {
		else if(!Enfermedad && (Salud >= 48 || Salud <= 7)) {	
			EstadoAnimo = "Apatia";
		}
	}

	public String getNombre() {
		return Nombre;
	}

	public int getSalud() {
		return Salud;
	}

	public boolean isEnfermedad() {
		return Enfermedad;
	}

	public String getEstadoAnimo() {
		return EstadoAnimo;
	}
		


}
