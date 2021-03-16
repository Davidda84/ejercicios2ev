package unidad7;

import unidad5.Mazo;
import unidad5.Naipe;

public class Mano extends Mazo {
	
	public Mano(int n) {
		super(n);
	}
	
	public Naipe[] getMano() {
		Naipe[] naipesMano  = new Naipe[this.naipes.size()];
		int i = 0;
		for(Naipe n : this.naipes) {
			naipesMano [i] = n;
			i++;
		}
		return naipesMano;
	}
	
	public int getValor() {
		int valorMano = 0;
		boolean haveAce = false;
		for (Naipe n : this.naipes) {
			int valorNaipe = n.getValor();
			if (valorNaipe > 10 && valorNaipe < 14) {
				valorMano += 10;
			} else if (valorNaipe == 14) {
				valorNaipe = 11;
				haveAce = true;
				if ((valorMano + valorNaipe) > 21) {
					valorMano++;
				} else {
					valorMano += valorNaipe;
				}
			} else {
				valorMano += valorNaipe;
			}
		}
		if (valorMano > 21 && haveAce) {
			valorMano -= 10;
		}
		return valorMano;
	}

}
