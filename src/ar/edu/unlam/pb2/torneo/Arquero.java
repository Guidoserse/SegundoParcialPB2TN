package ar.edu.unlam.pb2.torneo;

import java.util.ArrayList;
import java.util.Collections;


public class Arquero implements EsDescalificable {
		private Integer numeroParticipante;
	    private ArrayList<Tiro> tiros;

	    public Arquero(Integer numeroParticipante) {
	        this.numeroParticipante = numeroParticipante;
	        this.tiros = new ArrayList<>();
	    }

	    public Integer getNumeroParticipante() {
	        return numeroParticipante;
	    }

	    public ArrayList<Tiro> getTiros() {
	        return tiros;
	    }

	    public void agregarTiro(Tiro tiro) {
	        tiros.add(tiro);
	    }

	    public ArrayList<Tiro> obtenerMejoresTiros() throws MenosDeCincoTirosValidosException {
	        // Ordenar los tiros por distancia al centro de forma ascendente

	        Collections.sort(tiros, (t1, t2) -> Double.compare(t1.getDistanciaAlCentro(), t2.getDistanciaAlCentro()));

	        // Obtener los 5 primeros tiros válidos
	        ArrayList<Tiro> mejoresTiros = new ArrayList<>();
	        Integer tirosValidos = 0;

	        for (Tiro tiro : tiros) {
	            if (tirosValidos == 5) {
	                break;
	            }

	            if (tiro.getPuntaje() > 0) {
	                mejoresTiros.add(tiro);
	                tirosValidos++;
	            }
	        }

	        // Si el arquero no tiene al menos 5 tiros válidos, lanzar una excepción
	        if (tirosValidos < 5) {
	            throw new MenosDeCincoTirosValidosException("El arquero está descalificado.");
	        }

	        return mejoresTiros;
	    }
	   

	    public int calcularPuntajeTotal() {
	        int puntajeTotal = 0;
	        
	        for (Tiro tiro : tiros) {
	            puntajeTotal += tiro.getPuntaje();
	        }
	        
	        return puntajeTotal;
	    }

	    @Override
	    public Boolean estaDescalificado() {
	        return tiros.size() < 5;
	    }
}
