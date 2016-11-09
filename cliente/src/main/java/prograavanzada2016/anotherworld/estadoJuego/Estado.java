package prograavanzada2016.anotherworld.estadoJuego;

import prograavanzada2016.anotherworld.juego.Juego;
import java.awt.Graphics;

public abstract class Estado {
	 
	private static Estado estadoActual = null; // para saber que actualizacion realizar
	protected Juego juego;
	
	public Estado(Juego juego) {
		this.juego = juego;
	}
	public abstract void actualizar();
	public abstract void graficar(Graphics g);
	public static void setEstado(Estado estado) {
		estadoActual = estado;
	}
	public static Estado getEstado() {
		return estadoActual;
	}
}
