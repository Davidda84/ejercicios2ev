package unidad5;

import java.util.ArrayList;
import java.util.List;

public class Mazo {
	protected List<Naipe> naipes = new ArrayList<Naipe>();
	private static String[] palo = { "tréboles", "diamantes", "corazones", "picas" };

	public Mazo() {
		for (String s : palo) {
			for (int i = 2; i < 15; i++) {
				this.naipes.add(new Naipe(String.valueOf(i), s));
			}
		}
	}

	public Mazo(int n) {
		for (int l = 0; l < n; l++) {
			for (String s : palo) {
				for (int i = 2; i < 15; i++) {
					this.naipes.add(new Naipe(String.valueOf(i), s));
				}
			}
		}
	}

	public Naipe getNaipes() {
		List<Naipe> naipesMazo = this.naipes;
		int i = naipesMazo.size();
		Naipe naipeSolo = naipesMazo.get((int) Math.floor(Math.random() * i));
		return naipeSolo;
	}

	public Naipe removeNaipes() {
		List<Naipe> naipesMazo = this.naipes;
		int i = naipesMazo.size();
		int aleatorio = (int) Math.floor(Math.random() * i);
		Naipe naipeSolo = naipesMazo.get(aleatorio);
		this.naipes.remove(aleatorio);
		return naipeSolo;
	}

	public static String addNaipes(Mazo m1,Naipe n) {
		m1.naipes.add(n);
		return "El Naipe se ha añadido correctamente, ahora el mazo tiene " + m1.naipes.size() + "naipes.";
	}

	public static String addMazo(Mazo m1, Mazo m2) {
		List<Naipe> mazonuevo = m1.naipes;
		List<Naipe> mazoviejo = m2.naipes;
		int i = mazoviejo.size();
		for (int l = 0; l < i; l++) {
			mazonuevo.add(mazoviejo.get(l));
			mazoviejo.remove(l);
		}
		m1.naipes = mazonuevo;
		m2.naipes = mazoviejo;
		return "El Mazo se ha añadido correctamente, ahora el mazo tiene " + m1.naipes.size() + "naipes.";
	}

	public int size() {
		List<Naipe> naipesMazo = this.naipes;
		int i = naipesMazo.size();
		return i;
	}

	public String mayorOMenor(Naipe jugador, Naipe maquina) {
		if (jugador.getValor() > maquina.getValor()) {
			return "jugador";
		} else if (jugador.getValor() == maquina.getValor()) {
			return "empate";
		} else {
			return "maquina";
		}
	}

}
