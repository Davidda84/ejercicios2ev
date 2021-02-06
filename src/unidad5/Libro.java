package unidad5;

import java.util.List;

public class Libro {
	// Atributos
			private String titulo;
			private List<Autor> autores;
			private float precio;
			private int stock;
	
			public Libro(String titulo, List<Autor> autores, float precio, int stock) {
				this.titulo = titulo;
				this.autores = autores;
				this.precio = precio;
				this.stock = stock;
			}
			
			public Libro(String titulo, List<Autor> autores, float precio) {
				this.titulo = titulo;
				this.autores = autores;
				this.precio = precio;
				this.stock = 100;
			}

			public String getTitulo() {
				return titulo;
			}

			public List<Autor> getAutores() {
				return autores;
			}

			public float getPrecio() {
				return precio;
			}

			public void setPrecio(float precio) {
				this.precio = precio;
			}

			public int getStock() {
				return stock;
			}

			public void setStock(int stock) {
				this.stock = stock;
			}
			
			public String toString() {
				return titulo + " (" + autores + ") " + precio + "€ - " + stock
						+ " unidades en stock";
			}
}
