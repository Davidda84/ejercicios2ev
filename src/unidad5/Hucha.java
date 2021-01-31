package unidad5;

public class Hucha {
	// Atributos
	private String nombre;
	private static int[] tiposMoneda = { 50, 20, 10, 5, 2, 1 };
	private int[] monedasHucha = new int[tiposMoneda.length];
	private boolean estado;
	private String contraseña;
	private int totalHucha;

	public Hucha(String nombre, String estado, String contraseña) {
		this.nombre = nombre;
		if (estado == "abierta") {
			this.estado = true;
		} else {
			this.estado = false;
		}
		this.contraseña = contraseña;
		this.monedasHucha[0] = 0;
		this.monedasHucha[1] = 0;
		this.monedasHucha[2] = 0;
		this.monedasHucha[3] = 0;
		this.monedasHucha[4] = 0;
		this.monedasHucha[5] = 0;
		this.totalHucha = 0;
	}

	public Hucha(String nombre, String estado, String contraseña, int moneda1, int moneda2, int billete5, int billete10,
			int billete20, int billete50) {
		this.nombre = nombre;
		if (estado == "abierta") {
			this.estado = true;
		} else {
			this.estado = false;
		}
		this.contraseña = contraseña;
		this.monedasHucha[0] = billete50;
		this.monedasHucha[1] = billete20;
		this.monedasHucha[2] = billete10;
		this.monedasHucha[3] = billete5;
		this.monedasHucha[4] = moneda2;
		this.monedasHucha[5] = moneda1;
		this.totalHucha = moneda1 + moneda2 * 2 + billete5 * 5 + billete10 * 10 + billete20 * 20 + billete50 * 50;
	}

	public Hucha(String nombre, String estado, String contraseña, int total) {
		this.nombre = nombre;
		if (estado == "abierta") {
			this.estado = true;
		} else {
			this.estado = false;
		}
		this.contraseña = contraseña;
		this.totalHucha = total;
		this.monedasHucha[0] = total / 50;
		this.monedasHucha[1] = (total % 50) / 20;
		this.monedasHucha[2] = ((total % 50) % 20) / 10;
		this.monedasHucha[3] = (((total % 50) % 20) % 10) / 5;
		this.monedasHucha[4] = ((((total % 50) % 20) % 10) % 5) / 2;
		this.monedasHucha[5] = ((((total % 50) % 20) % 10) % 5) % 2;
	}

	public String getInfo() {

		String[] info = new String[9];

		info[0] = nombre;
		info[1] = Boolean.toString(estado);
		info[2] = String.valueOf(totalHucha);
		info[3] = String.valueOf(monedasHucha[0]);
		info[4] = String.valueOf(monedasHucha[1]);
		info[5] = String.valueOf(monedasHucha[2]);
		info[6] = String.valueOf(monedasHucha[3]);
		info[7] = String.valueOf(monedasHucha[4]);
		info[8] = String.valueOf(monedasHucha[5]);

		return this.toString("i", info);
	}

	public String getInfo(String tipo, int total) {

		String[] info = new String[10];

		info[0] = nombre;
		info[1] = Boolean.toString(estado);
		info[2] = String.valueOf(totalHucha);
		info[3] = String.valueOf(monedasHucha[0]);
		info[4] = String.valueOf(monedasHucha[1]);
		info[5] = String.valueOf(monedasHucha[2]);
		info[6] = String.valueOf(monedasHucha[3]);
		info[7] = String.valueOf(monedasHucha[4]);
		info[8] = String.valueOf(monedasHucha[5]);
		info[9] = String.valueOf(total);

		return this.toString(tipo, info);
	}

	public String setOpenClose(String pass) {
		String estadoHucha;
		if (pass == contraseña) {
			if (estado == true) {
				this.estado = false;
				estadoHucha = "cerrada";
			} else {
				this.estado = true;
				estadoHucha = "abierta";
			}
		} else {
			estadoHucha = "ERROR";
		}
		return estadoHucha;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (oldPassword == contraseña) {
			this.contraseña = newPassword;
			System.out.println("Ha cambiado la contraseña correctamente");
		} else {
			System.out.println("Ha introduccido su contraseña erroneamente");
		}
	}

	public String ingresoTotal(String pass, int total) {
		if (pass == contraseña) {
			this.totalHucha += total;
			this.monedasHucha[0] += total / 50;
			this.monedasHucha[1] += (total % 50) / 20;
			this.monedasHucha[2] += ((total % 50) % 20) / 10;
			this.monedasHucha[3] += (((total % 50) % 20) % 10) / 5;
			this.monedasHucha[4] += ((((total % 50) % 20) % 10) % 5) / 2;
			this.monedasHucha[5] += ((((total % 50) % 20) % 10) % 5) % 2;
			return this.getInfo("ingreso", total);
		} else {
			return "ERROR";
		}

	}

	public String ingresoUnico(String pass, int[] dineroIngreso) {
		if (pass == contraseña) {
			int total = dineroIngreso[0] * 50 + dineroIngreso[1] * 20 + dineroIngreso[2] * 10 + dineroIngreso[3] * 5
					+ dineroIngreso[4] * 2 + dineroIngreso[5];
			this.monedasHucha[0] += dineroIngreso[0];
			this.monedasHucha[1] += dineroIngreso[1];
			this.monedasHucha[2] += dineroIngreso[2];
			this.monedasHucha[3] += dineroIngreso[3];
			this.monedasHucha[4] += dineroIngreso[4];
			this.monedasHucha[5] += dineroIngreso[5];
			this.totalHucha = this.monedasHucha[0] * 50 + this.monedasHucha[1] * 20 + this.monedasHucha[2] * 10
					+ this.monedasHucha[3] * 5 + this.monedasHucha[4] * 2 + this.monedasHucha[5];
			return this.getInfo("ingreso", total);
		} else {
			return "ERROR";
		}
	}

	public String retiradaTotal(String pass, int total) {
		if (pass == contraseña) {
			if (total < this.totalHucha) {
				this.totalHucha -= total;
				int totalR = total;
				for(int i=0; i<this.monedasHucha.length;i++) {
					if (this.monedasHucha[i]!=0) {
						if(total / Hucha.tiposMoneda[i] >= this.monedasHucha[i]) {
							total = total - this.monedasHucha[i]*Hucha.tiposMoneda[i];
							this.monedasHucha[i] = 0;
						}
						else {
							this.monedasHucha[i] -= total / Hucha.tiposMoneda[i];
							total = total - (total / Hucha.tiposMoneda[i])*Hucha.tiposMoneda[i];
						}
					}
				}
				return this.getInfo("retirada", totalR);
			} else {
				return "ERROR";
			}
		} else {
			return "ERROR";
		}
	}

	public String retiradaParcial(int total, int resto) {
		for(int i=0; i<this.monedasHucha.length;i++) {
			if (this.monedasHucha[i]!=0) {
				if(resto / Hucha.tiposMoneda[i] >= this.monedasHucha[i]) {
					resto = resto - this.monedasHucha[i]*Hucha.tiposMoneda[i];
					this.monedasHucha[i] = 0;
				}
				else {
					this.monedasHucha[i] -= resto / Hucha.tiposMoneda[i];
					resto = resto - (resto / Hucha.tiposMoneda[i])*Hucha.tiposMoneda[i];
				}
			}
		}
			return this.getInfo("retirada", total);
	}

	public String retiradaUnica(String pass, int[] dineroRetirada) {
		if (pass == contraseña) {
			int resto = 0;
			int total = 0;
			
			for(int i=0; i<dineroRetirada.length;i++) {
				total += dineroRetirada[i]*Hucha.tiposMoneda[i];
			}

			if (total < this.totalHucha) {
				this.totalHucha -= total;
				for(int i=0; i<this.monedasHucha.length;i++) {
					if (this.monedasHucha[i]!=0) {
						if (dineroRetirada[i] >= this.monedasHucha[i]) {
							resto += (dineroRetirada[i] - this.monedasHucha[i]) * Hucha.tiposMoneda[i];
							this.monedasHucha[i] = 0;
						}
						else {
							this.monedasHucha[i] -= dineroRetirada[i];
						}
					}
				}
				if (resto == 0) {
					return this.getInfo("retirada", total);
				} else {
					return this.retiradaParcial(total, resto);
				}
			} else {
				return "ERROR1";
			}
		} else {
			return "ERROR2";
		}
	}

	public String toString(String tipo, String[] infoHucha) {
		String resultado = null;
		if (tipo == "i") {
			if (infoHucha[1] == "true") {
				resultado = "Nombre Hucha: " + infoHucha[0] + "\r\n" + " - Estado: Abierta \r\n" + " - Total: ";
			} else {
				resultado = "Nombre Hucha: " + infoHucha[0] + "\r\n" + " - Estado: Cerrada \r\n";
			}
		} else if (tipo == "ingreso") {
			resultado = "Ha ingresado " + infoHucha[9] + "€ Su saldo acutal es: ";
		} else if (tipo == "retirada") {
			resultado = "Ha retirado " + infoHucha[9] + "€ Su saldo acutal es: ";
		}
		resultado += infoHucha[2] + "€ \r\n" + " - Desglose: \r\n" + " - Billetes de 50€: " + infoHucha[3] + "\r\n"
				+ " - Billetes de 20€: " + infoHucha[4] + "\r\n" + " - Billetes de 10€: " + infoHucha[5] + "\r\n"
				+ " - Billetes de 5€: " + infoHucha[6] + "\r\n" + " - Monedas de 2€: " + infoHucha[7] + "\r\n"
				+ " - Monedas de 1€: " + infoHucha[8];

		return resultado;
	}
}
