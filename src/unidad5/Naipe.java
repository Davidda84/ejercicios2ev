package unidad5;

public class Naipe {
	// Atributos
		private int valor;
		private String valorPalo;
		private static String[] palo = {"tréboles","diamantes","corazones","picas"};
		private static String[] figura = {"Ace","Jack","Queen","King"};
		private static int[] valorfigura = { 14, 11, 12, 13 };
		
		public Naipe(String figuraJugador, String palo) {
			if(figuraJugador.equals("Ace") || figuraJugador.equals("Jack") || figuraJugador.equals("Queen") || figuraJugador.equals("King")) {
				for(int i = 0 ; i < figura.length; i++) {
					if(figura[i].equals(figuraJugador)) {
						this.valor = valorfigura[i];
					}
				}
			}
			else {
				this.valor = Integer.parseInt(figuraJugador);
			}
			this.valorPalo = palo;
		}
		
		public Naipe() {
			this.valor = (int) Math.floor(Math.random()*13)+1;
			this.valorPalo = palo[(int) Math.floor(Math.random()*3)];
		}
		
		public String getNaipe() {
			String valorNaipe = null;
			if (this.valor == 14 || this.valor == 11 || this.valor == 12 || this.valor == 13) {
				for(int i = 0 ; i < figura.length; i++) {
					if(valorfigura[i] == this.valor) {
						valorNaipe = figura[i];
					}
				}
			}
			else {
				valorNaipe = String.valueOf(this.valor);
			}
			
			return valorNaipe + " de " + this.valorPalo;
		}
		
		public int getValor() {
			return this.valor;
		}
		
		public String mayorOMenor(int valorJugador, int valorMaquina) {
			if(valorJugador > valorMaquina) {
				return "Tu carta es mayor que la mia, has ganado";
			}
			else if(valorJugador == valorMaquina) {
				return "Nuestra carta tienen el mismo valor";
			}
			else {
				return "Mejor suerte la proxima vez, mi carta es la mas alta";
			}
		}
}
