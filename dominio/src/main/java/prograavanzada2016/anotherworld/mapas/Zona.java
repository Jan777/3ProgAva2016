package prograavanzada2016.anotherworld.mapas;

public abstract class Zona {
	protected String nombre;
	protected int largo;
	protected int ancho;
	protected boolean neutral;
	
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
	
	
}
