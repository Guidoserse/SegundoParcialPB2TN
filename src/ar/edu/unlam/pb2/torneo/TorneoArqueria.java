package ar.edu.unlam.pb2.torneo;

import java.util.ArrayList;
import java.util.Collections;

public class TorneoArqueria {

	private ArrayList<Arquero> arqueros;

	public TorneoArqueria() {
		arqueros = new ArrayList<>();
	}

	public void registrarArquero(Arquero arquero) {
		arqueros.add(arquero);
	}

	public ArrayList<Arquero> obtenerPodio() {
		// Ordenar los arqueros por puntaje total de forma descendente
		Collections.sort(arqueros, (a1, a2) -> Integer.compare(a2.calcularPuntajeTotal(), a1.calcularPuntajeTotal()));

		// Obtener los 3 primeros arqueros del podio
		return new ArrayList<>(arqueros.subList(0, Math.min(arqueros.size(), 3)));
	}

	public ArrayList<Arquero> obtenerArqueros() {
		return arqueros;
	}
}
