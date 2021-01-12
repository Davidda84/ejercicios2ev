package unidad5;

import java.time.LocalDate;

public class Animal {
	// Atributos
		private String nombre;
		private LocalDate fecha;
		
		public Animal (String n, LocalDate f){
			this.nombre = n;
			this.fecha = f;
		}
		
		public Animal (String n){
			this.nombre = n;
			this.fecha = LocalDate.now();
		}
		
		public String getNombre(){
			return this.nombre;
		}
		
		public LocalDate getFecha(){
			return this.fecha;
		}
		
		public void setNombre(String n){
			this.nombre = n;
		}
		
		public void setFecha(LocalDate f){
			this.fecha = f;
		}
		
		public String toString() {
			int edad = LocalDate.now().getYear() - this.fecha.getYear();
			String resultado = "Nombre: " + nombre + " - Edad: " + edad;
			return resultado;
		}		
}
