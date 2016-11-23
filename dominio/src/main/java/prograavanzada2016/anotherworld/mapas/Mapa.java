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
		
	public Zona getZonaByEnte(Ente ente) throws Exception{
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
	
	protected void armarMapa() throws Exception{
		this.zona1.setAnchoMinimo(0);
		this.zona1.setAnchoMaximo(199);
		this.zona1.setLargoMinimo(0);
		this.zona1.setLargoMaximo(199);
		
		this.zona2.setAnchoMinimo(200);
		this.zona2.setAnchoMaximo(399);
		this.zona2.setLargoMinimo(0);
		this.zona2.setLargoMaximo(199);
		
		this.zona3.setAnchoMinimo(0);
		this.zona3.setAnchoMaximo(199);
		this.zona3.setLargoMinimo(200);
		this.zona3.setLargoMaximo(399);
		
		this.zona4.setAnchoMinimo(200);
		this.zona4.setAnchoMaximo(399);
		this.zona4.setLargoMinimo(200);
		this.zona4.setLargoMaximo(399);
	}
	
	protected abstract void spawnearEnemigos() throws Exception;

	public Zona getZona1() {
		return zona1;
	}

	public void setZona1(Zona zona1) {
		this.zona1 = zona1;
	}

	public Zona getZona2() {
		return zona2;
	}

	public void setZona2(Zona zona2) {
		this.zona2 = zona2;
	}

	public Zona getZona3() {
		return zona3;
	}

	public void setZona3(Zona zona3) {
		this.zona3 = zona3;
	}

	public Zona getZona4() {
		return zona4;
	}

	public void setZona4(Zona zona4) {
		this.zona4 = zona4;
	}
}
