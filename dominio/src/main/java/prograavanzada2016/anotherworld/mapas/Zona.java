package prograavanzada2016.anotherworld.mapas;

import java.util.ArrayList;

import prograavanzada2016.anotherworld.entities.Enemigo;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.resources.GeneradorMagico;

public abstract class Zona {
	protected String nombre;
	protected int largo;
	protected int ancho;
	protected int largoMinimo;
	protected int anchoMinimo;
	protected int largoMaximo;
	protected int anchoMaximo;
	protected boolean neutral;
	
	protected ArrayList<Enemigo> enemigos;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getLargo() {
		return largo;
	}
	public void setLargo(int largo) {
		this.largo = largo;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public boolean isNeutral() {
		return neutral;
	}
	public void setNeutral(boolean neutral) {
		this.neutral = neutral;
	}
	public int getLargoMinimo() {
		return largoMinimo;
	}
	public void setLargoMinimo(int largoMinimo) {
		this.largoMinimo = largoMinimo;
	}
	public int getAnchoMinimo() {
		return anchoMinimo;
	}
	public void setAnchoMinimo(int anchoMinimo) {
		this.anchoMinimo = anchoMinimo;
	}
	public int getLargoMaximo() {
		return largoMaximo;
	}
	public void setLargoMaximo(int largoMaximo) {
		this.largoMaximo = largoMaximo;
	}
	public int getAnchoMaximo() {
		return anchoMaximo;
	}
	public void setAnchoMaximo(int anchoMaximo) {
		this.anchoMaximo = anchoMaximo;
	}
	public ArrayList<Enemigo> getEnemigos() {
		return enemigos;
	}
	/*public void setEnemigos(ArrayList<NPC> enemigos) {
		this.enemigos = enemigos;
	}*/
	
	public void spawnear(Enemigo enemigo){
		enemigo.setZona(this);
		this.enemigos.add(enemigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zona other = (Zona) obj;
		if (ancho != other.ancho)
			return false;
		if (anchoMaximo != other.anchoMaximo)
			return false;
		if (anchoMinimo != other.anchoMinimo)
			return false;
		if (largo != other.largo)
			return false;
		if (largoMaximo != other.largoMaximo)
			return false;
		if (largoMinimo != other.largoMinimo)
			return false;
		if (neutral != other.neutral)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public void transportarAlCentroDeLaZona(Personaje personaje) throws Exception{
		personaje.moverse(GeneradorMagico.randInt(this.getAnchoMinimo(), this.getAnchoMaximo()), GeneradorMagico.randInt(this.getLargoMinimo(),this.getLargoMaximo()));
	}
}
