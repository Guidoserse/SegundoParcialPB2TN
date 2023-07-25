package ar.edu.unlam.pb2.torneo;

public class Tiro {
	protected Double x;
	protected Double y;
	protected Double distanciaAlCentro;
	protected Integer puntaje;

	public Tiro(Double x, Double y) {
		this.x = x;
		this.y = y;
		this.distanciaAlCentro = calcularDistanciaAlCentro();
		this.puntaje = calcularPuntaje();
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	public Double getDistanciaAlCentro() {
		return distanciaAlCentro;
	}

	public int getPuntaje() {
		int puntaje = 0;
		double distanciaAlCentro = calcularDistanciaAlCentro();

		if (distanciaAlCentro <= 10) {
			puntaje = 1000;
		} else if (distanciaAlCentro <= 20) {
			puntaje = 500;
		} else if (distanciaAlCentro <= 30) {
			puntaje = 200;
		} else if (distanciaAlCentro <= 40) {
			puntaje = 100;
		} else if (distanciaAlCentro <= 50) {
			puntaje = 50;
		}

		return puntaje;
	}

	private Double calcularDistanciaAlCentro() {
		distanciaAlCentro = Math.sqrt(x * x + y * y);
		return distanciaAlCentro;
	}

	private Integer calcularPuntaje() {
		if (distanciaAlCentro <= 0.1) {
			puntaje = 1000;
		} else if (distanciaAlCentro <= 0.2) {
			puntaje = 500;
		} else if (distanciaAlCentro <= 0.3) {
			puntaje = 200;
		} else if (distanciaAlCentro <= 0.4) {
			puntaje = 100;
		} else if (distanciaAlCentro <= 0.5) {
			puntaje = 50;
		} else {
			puntaje = 0;
		}
		return puntaje;
	}
}
