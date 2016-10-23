package prograavanzada2016.anotherworld.mapas;

import java.util.ArrayList;

import prograavanzada2016.anotherworld.entities.Ente;

public abstract class Mapa {
	protected int larcho;
	protected int ancho;
	
	protected Zona zona1;
	protected Zona zona2;
	protected Zona zona3;
	protected Zona zona4;
		
	public Zona getZonaByEnte(Ente ente){
		int posicionX = ente.getPosicionX();
		int posicionY = ente.getPosicionY();
		
		if(posicionX>=0 && posicionX<200 && posicionY>=0 && posicionY<200){
			return zona1;
		}else if(posicionX>=200 && posicionX<400 && posicionY>=0 && posicionY<200){
			return zona2;
		}else if(posicionX>=0 && posicionX<200 && posicionY>=200 && posicionY<400){
			return zona3;
		}else{// if(posicionX>200 && posicionX<=400 && posicionY>200 && posicionY<=400){
			return zona4;
		}
	}
}
