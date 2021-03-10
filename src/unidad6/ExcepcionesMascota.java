package unidad6;

public class ExcepcionesMascota extends Exception {

	public ExcepcionesMascota() {
	}

	public ExcepcionesMascota(String message) {
		super(message);
	}

	public ExcepcionesMascota(Throwable cause) {
		super(cause);
	}

	public ExcepcionesMascota(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionesMascota(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
