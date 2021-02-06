package unidad5;

public class Automovil {
	
	private String Modelo; //
	private float Capacidad; // litros
	private float Cantidad; // litros
	private float MediaConsumo; // litros
	private float Km; // Km
	private float Consumo; // litros
	
		
	public Automovil(String modelo, float capacidad, float cantidad, float mediaConsumo) {
		this.Modelo = modelo;
		this.Capacidad = capacidad;
		this.Cantidad = cantidad;
		this.MediaConsumo = mediaConsumo;
		this.Km = 0;
		this.Consumo = 0;
	}
	
	public Automovil(String modelo, float capacidad, float mediaConsumo) {
		this.Modelo = modelo;
		this.Capacidad = capacidad;
		this.Cantidad = capacidad;
		this.MediaConsumo = mediaConsumo;
		this.Km = 0;
		this.Consumo = 0;
	}

	public void llenoPorFavor() {
		this.Cantidad = this.Capacidad;
	}
	
	public float repostaje(float cantidad) {
		if((this.Cantidad + cantidad) > this.Capacidad) {
			this.Cantidad = this.Capacidad;
			return ((this.Cantidad + cantidad) - this.Capacidad);
		}
		else {
			this.Cantidad = this.Cantidad +cantidad;
			return 0;
		}
	}
	
	public float recorrido(float distancia) {
		if((distancia*this.MediaConsumo) > this.Cantidad){
			return 0;
		}
		else {
			this.Cantidad = this.Cantidad - (distancia*this.MediaConsumo);
			this.Km += distancia;
			this.Consumo += distancia*this.MediaConsumo;
			return (distancia*this.MediaConsumo);
		}
	}
	
	public String getModelo() {
		return Modelo;
	}

	public float nivel() {
		return Cantidad;
	}

	public float getKm() {
		return Km;
	}

	public float getConsumoTotal() {
		return Consumo;
	}

}
