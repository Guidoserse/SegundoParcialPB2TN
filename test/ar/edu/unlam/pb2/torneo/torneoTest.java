package ar.edu.unlam.pb2.torneo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class torneoTest {

	@Test
	public void registroDeArquerosParaCompetir() {
		TorneoArqueria torneo = new TorneoArqueria();

		Arquero arquero1 = new Arquero(1);
		Arquero arquero2 = new Arquero(2);
		Arquero arquero3 = new Arquero(3);

		torneo.registrarArquero(arquero1);
		torneo.registrarArquero(arquero2);
		torneo.registrarArquero(arquero3);

		assertEquals(3, torneo.obtenerArqueros().size());
		assertTrue(torneo.obtenerArqueros().contains(arquero1));
		assertTrue(torneo.obtenerArqueros().contains(arquero2));
		assertTrue(torneo.obtenerArqueros().contains(arquero3));
	}

	@Test
	public void testObtenerPodio() {
		TorneoArqueria torneo = new TorneoArqueria();

		Arquero arquero1 = new Arquero(1);
		arquero1.agregarTiro(new Tiro(1.0, 0.0)); // Puntaje: 1000
		torneo.registrarArquero(arquero1);

		Arquero arquero2 = new Arquero(2);
		arquero2.agregarTiro(new Tiro(2.0, 0.15)); // Puntaje: 500
		torneo.registrarArquero(arquero2);

		Arquero arquero3 = new Arquero(3);
		arquero3.agregarTiro(new Tiro(3.0, 0.3)); // Puntaje: 200
		torneo.registrarArquero(arquero3);

		assertEquals(3, torneo.obtenerPodio().size());
		assertEquals(arquero1, torneo.obtenerPodio().get(0));
		assertEquals(arquero2, torneo.obtenerPodio().get(1));
		assertEquals(arquero3, torneo.obtenerPodio().get(2));
	}

	@Test
	public void testParticipantesInsuficientesPodio() {
		TorneoArqueria torneo = new TorneoArqueria();

		Arquero arquero1 = new Arquero(1);
		arquero1.agregarTiro(new Tiro(1.0, 0.0)); // Puntaje: 1000
		torneo.registrarArquero(arquero1);

		List<Arquero> podio = torneo.obtenerPodio();

		assertEquals(1, podio.size());
		assertEquals(arquero1, podio.get(0));
	}

	@Test // creamos un arquero y agregamos tres tiros con puntajes de 1000 cada
			// uno.
			// Verificamos que el puntaje total calculado por el método
			// calcularPuntajeTotal() sea igual a 3000.
	public void testCalculoPuntajeTotalArquero() throws MenosDeCincoTirosValidosException {
		Arquero arquero = new Arquero(1);
		arquero.agregarTiro(new Tiro(1.0, 0.0)); // Puntaje: 1000
		arquero.agregarTiro(new Tiro(2.0, 0.0)); // Puntaje: 1000
		arquero.agregarTiro(new Tiro(3.0, 0.0)); // Puntaje: 1000

		int puntajeEsperado = 3000;
		int puntajeObtenido = arquero.calcularPuntajeTotal();

		assertEquals(puntajeEsperado, puntajeObtenido);
	}

	@Test
	public void testClasificacionPodio() {
		TorneoArqueria torneo = new TorneoArqueria();

		// Crear arqueros con diferentes puntajes
		Arquero arquero1 = new Arquero(1);
		arquero1.agregarTiro(new Tiro(1.0, 0.0)); // Puntaje: 1000
		arquero1.agregarTiro(new Tiro(2.0, 0.0)); // Puntaje: 1000
		arquero1.agregarTiro(new Tiro(3.0, 0.0)); // Puntaje: 1000
		arquero1.agregarTiro(new Tiro(4.0, 0.0)); // Puntaje: 1000
		arquero1.agregarTiro(new Tiro(5.0, 0.0)); // Puntaje: 1000

		Arquero arquero2 = new Arquero(2);
		arquero2.agregarTiro(new Tiro(1.5, 0.0)); // Puntaje: 1500
		arquero2.agregarTiro(new Tiro(2.5, 0.0)); // Puntaje: 1500
		arquero2.agregarTiro(new Tiro(3.5, 0.0)); // Puntaje: 1500
		arquero2.agregarTiro(new Tiro(4.5, 0.0)); // Puntaje: 1500

		Arquero arquero3 = new Arquero(3);
		arquero3.agregarTiro(new Tiro(0.5, 0.0)); // Puntaje: 500
		arquero3.agregarTiro(new Tiro(1.5, 0.0)); // Puntaje: 1500
		arquero3.agregarTiro(new Tiro(2.5, 0.0)); // Puntaje: 2500
		arquero3.agregarTiro(new Tiro(3.5, 0.0)); // Puntaje: 3500
		arquero3.agregarTiro(new Tiro(4.5, 0.0)); // Puntaje: 4500

		// Registrar arqueros en el torneo
		torneo.registrarArquero(arquero1);
		torneo.registrarArquero(arquero2);
		torneo.registrarArquero(arquero3);

		// Obtener el podio
		List<Arquero> podio = torneo.obtenerPodio();

		// Verificar los puntajes de los arqueros en el podio
		assertEquals(5000, podio.get(0).calcularPuntajeTotal());
		assertEquals(5000, podio.get(1).calcularPuntajeTotal());
		assertEquals(4000, podio.get(2).calcularPuntajeTotal());
	}

	@Test(expected = MenosDeCincoTirosValidosException.class)
	public void testObtenerMejoresTiros_Exception() throws MenosDeCincoTirosValidosException {
		Arquero arquero = new Arquero(1);

		// Agrega menos de 5 tiros válidos al arquero
		arquero.agregarTiro(new Tiro(1.0, 2.0));
		arquero.agregarTiro(new Tiro(3.0, 4.0));

		// Aquí debería lanzarse la excepción MenosDeCincoTirosValidosException
		arquero.obtenerMejoresTiros();
	}

}
